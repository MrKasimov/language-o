grammar LanguageO;

// Lexer rules
Identifier : [a-zA-Z] [a-zA-Z0-9]* ;

IntegerLiteral : '-'? [1-9] [0-9]* ;

RealLiteral : '-'? IntegerLiteral '.' IntegerLiteral;

BooleanLiteral
	:   'true'
	|	'false' ;

WS : [ \t\r\n\u000C]+ -> skip ;

COMMENT
    :   '/*' .*? '*/' -> skip ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip ;

// Parser rules
program : (classDeclaration)* ;

classDeclaration
    :   'class' className ('extends' className)? 'is'
            (memberDeclaration)*
        'end' ;

className : Identifier ;

memberDeclaration
    :   field
    |   methodDeclaration
    |   constructorDeclaration ;

field
    : 'var' Identifier ':' className ;

variableDeclaration
    :   'var' Identifier ':' expression ;

methodDeclaration
    :   'method' functionDeclaration body ;

functionDeclaration : functionName (parameters)? (':' Identifier)? ;

functionName : Identifier ;

parameters
    :   '(' parameterDeclaration? (',' parameterDeclaration)* ')' ;

parameterDeclaration
    :   Identifier ':' className ;

body
    :   'is'   statement*   'end' ;

constructorDeclaration
    :   'this' (parameters)? body
    |   'this()' body ;

statement
    :   assignment
    |   body
    |   variableDeclaration
    |   whileLoop
    |   ifStatement
    |   returnStatement
    |   functionCall ;

assignment : Identifier ':=' expression ;

whileLoop : 'while' expression 'loop' body ;

ifStatement : 'if' expression 'then' body ('else' body)? 'end' ;

returnStatement : 'return' (expression)? ;

expression
    : literal #ValueExpr
    | variableReference #VarReference
    | classType arguments #ConstructorCall
    | functionCall #FCall
    | classType '()' #ConstructorCall ;

variableReference : Identifier ;

functionCall
    : owner=classType ('.' Identifier (arguments)?)+ ;

arguments : '(' argument (',' a=argument)* ')' ;

argument : expression ;

literal
    :   IntegerLiteral
    |   RealLiteral
    |   BooleanLiteral ;

classType
    :   'this'
    |   className ;
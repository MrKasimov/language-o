// Generated from E:/Projects/Java/LanguageO/src/main/resources\LanguageO.g4 by ANTLR 4.9.2
package org.innopolis.lsd.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageOParser}.
 */
public interface LanguageOListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LanguageOParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LanguageOParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(LanguageOParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(LanguageOParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(LanguageOParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(LanguageOParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(LanguageOParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(LanguageOParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(LanguageOParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(LanguageOParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(LanguageOParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(LanguageOParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(LanguageOParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(LanguageOParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(LanguageOParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(LanguageOParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(LanguageOParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(LanguageOParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(LanguageOParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(LanguageOParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(LanguageOParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(LanguageOParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(LanguageOParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(LanguageOParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(LanguageOParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(LanguageOParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LanguageOParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LanguageOParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LanguageOParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LanguageOParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(LanguageOParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(LanguageOParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LanguageOParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LanguageOParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(LanguageOParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(LanguageOParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(LanguageOParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(LanguageOParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarReference}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarReference(LanguageOParser.VarReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarReference}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarReference(LanguageOParser.VarReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FCall}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFCall(LanguageOParser.FCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FCall}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFCall(LanguageOParser.FCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstructorCall}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstructorCall(LanguageOParser.ConstructorCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstructorCall}
	 * labeled alternative in {@link LanguageOParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstructorCall(LanguageOParser.ConstructorCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#variableReference}.
	 * @param ctx the parse tree
	 */
	void enterVariableReference(LanguageOParser.VariableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#variableReference}.
	 * @param ctx the parse tree
	 */
	void exitVariableReference(LanguageOParser.VariableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(LanguageOParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(LanguageOParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(LanguageOParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(LanguageOParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(LanguageOParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(LanguageOParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(LanguageOParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(LanguageOParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageOParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(LanguageOParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageOParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(LanguageOParser.ClassTypeContext ctx);
}
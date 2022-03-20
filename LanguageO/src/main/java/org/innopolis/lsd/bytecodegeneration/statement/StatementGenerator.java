package org.innopolis.lsd.bytecodegeneration.statement;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.domain.node.expression.*;
import org.innopolis.lsd.domain.node.statement.Assignment;
import org.innopolis.lsd.domain.node.statement.Block;
import org.innopolis.lsd.domain.node.statement.ReturnStatement;
import org.innopolis.lsd.domain.node.statement.VariableDeclaration;
import org.innopolis.lsd.domain.scope.Scope;
import org.objectweb.asm.MethodVisitor;

public class StatementGenerator {
    private final VariableDeclarationStatementGenerator variableDeclarationStatementGenerator;
    private final ReturnStatemenetGenerator returnStatemenetGenerator;
//    private final IfStatementGenerator ifStatementGenerator;
//    private final ForStatementGenerator forStatementGenerator;
    private final BlockStatementGenerator blockStatementGenerator;
    private final AssignmentStatementGenerator assignmentStatementGenerator;
    private final ExpressionGenerator expressionGenerator;

    public StatementGenerator(MethodVisitor methodVisitor, Scope scope) {
        expressionGenerator = new ExpressionGenerator(methodVisitor, scope);
        variableDeclarationStatementGenerator = new VariableDeclarationStatementGenerator(this, expressionGenerator);
//        forStatementGenerator = new ForStatementGenerator(methodVisitor);
//        ifStatementGenerator = new IfStatementGenerator(this, expressionGenerator, methodVisitor);
        returnStatemenetGenerator = new ReturnStatemenetGenerator(expressionGenerator, methodVisitor);
        blockStatementGenerator = new BlockStatementGenerator(methodVisitor);
        assignmentStatementGenerator = new AssignmentStatementGenerator(methodVisitor, expressionGenerator,scope);
    }

    public void generate(VariableDeclaration variableDeclaration) {
        variableDeclarationStatementGenerator.generate(variableDeclaration);
    }

    public void generate(FunctionCall functionCall) {
        functionCall.accept(expressionGenerator);
    }

    public void generate(Block block) {
        blockStatementGenerator.generate(block);
    }

    public void generate(ReturnStatement returnStatement) {
        returnStatemenetGenerator.generate(returnStatement);
    }
//
//    public void generate(IfStatement ifStatement) {
//        ifStatementGenerator.generate(ifStatement);
//    }

//    public void generate(RangedForStatement rangedForStatement) {
//        forStatementGenerator.generate(rangedForStatement);
//    }

    public void generate(Assignment assignment) {
        assignmentStatementGenerator.generate(assignment);
    }

    public void generate(SuperCall superCall) {
        expressionGenerator.generate(superCall);
    }

    public void generate(ConstructorCall constructorCall) {
        expressionGenerator.generate(constructorCall);
    }

    public void generate(Parameter parameter) {
        expressionGenerator.generate(parameter);
    }

//    public void generate(ConditionalExpression conditionalExpression) {
//        expressionGenerator.generate(conditionalExpression);
//    }

    public void generate(Value value) {
        expressionGenerator.generate(value);
    }

    public void generate(EmptyExpression emptyExpression) {
        expressionGenerator.generate(emptyExpression);
    }

    public void generate(LocalVariableReference localVariableReference) {
        expressionGenerator.generate(localVariableReference);
    }

    public void generate(FieldReference fieldReference) {
        expressionGenerator.generate(fieldReference);
    }
}

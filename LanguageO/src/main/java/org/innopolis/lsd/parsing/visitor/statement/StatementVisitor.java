package org.innopolis.lsd.parsing.visitor.statement;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Expression;
import org.innopolis.lsd.domain.node.statement.Statement;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.*;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;

public class StatementVisitor extends LanguageOBaseVisitor<Statement> {

    private final ExpressionVisitor expressionVisitor;
    private final VariableDeclarationStatementVisitor variableDeclarationStatementVisitor;
    //    private final ReturnStatementVisitor returnStatementVisitor;
//    private final IfStatementVisitor ifStatementVisitor;
//    private final ForStatementVisitor forStatementVisitor;
    private final BlockStatementVisitor blockStatementVisitor;
    private final AssignmentStatementVisitor assignmentStatementVisitor;

    public StatementVisitor(Scope scope) {
        expressionVisitor = new ExpressionVisitor(scope);
        variableDeclarationStatementVisitor = new VariableDeclarationStatementVisitor(expressionVisitor, scope);
//        returnStatementVisitor = new ReturnStatementVisitor(expressionVisitor);
//        ifStatementVisitor = new IfStatementVisitor(this,expressionVisitor);
//        forStatementVisitor = new ForStatementVisitor(scope);
        blockStatementVisitor = new BlockStatementVisitor(scope);
        assignmentStatementVisitor = new AssignmentStatementVisitor(expressionVisitor);
    }

    @Override
    public Statement visitVariableDeclaration(@NotNull VariableDeclarationContext ctx) {
        return variableDeclarationStatementVisitor.visitVariableDeclaration(ctx);
    }

    @Override
    public Statement visitBody(@NotNull BodyContext ctx) {
        return blockStatementVisitor.visitBody(ctx);
    }

//    @Override
//    public Statement visitReturnVoid(@NotNull ReturnVoidContext ctx) {
//        return returnStatementVisitor.visitReturnVoid(ctx);
//    }
//
//    @Override
//    public Statement visitReturnWithValue(@NotNull ReturnWithValueContext ctx) {
//        return returnStatementVisitor.visitReturnWithValue(ctx);
//    }

//    @Override
//    public Statement visitIfStatement(@NotNull LanguageOParser.IfStatementContext ctx) {
//        return ifStatementVisitor.visitIfStatement(ctx);
//    }

    @Override
    public Expression visitVarReference(@NotNull VarReferenceContext ctx) {
        return expressionVisitor.visitVarReference(ctx);
    }

//    @Override
//    public Expression visitValue(@NotNull ValueContext ctx) {
//        return expressionVisitor.visitValue(ctx);
//    }

    @Override
    public Expression visitFunctionCall(@NotNull FunctionCallContext ctx) {
        return expressionVisitor.visitFunctionCall(ctx);
    }

    @Override
    public Expression visitConstructorCall(@NotNull ConstructorCallContext ctx) {
        return expressionVisitor.visitConstructorCall(ctx);
    }

//    @Override
//    public Expression visitSupercall(@NotNull SupercallContext ctx) {
//        return expressionVisitor.visitSupercall(ctx);
//    }

//    @Override
//    public ConditionalExpression visitConditionalExpression(@NotNull ConditionalExpressionContext ctx) {
//        return expressionVisitor.visitConditionalExpression(ctx);
//    }
//
//    @Override
//    public Statement visitForStatement(@NotNull EnkelParser.ForStatementContext ctx) {
//        return forStatementVisitor.visitForStatement(ctx);
//    }

    @Override
    public Statement visitAssignment(@NotNull AssignmentContext ctx) {
        return assignmentStatementVisitor.visitAssignment(ctx);
    }
}

package org.innopolis.lsd.parsing.visitor.expression;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Expression;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.ConstructorCallContext;
import org.innopolis.lsd.generated.LanguageOParser.FCallContext;
import org.innopolis.lsd.generated.LanguageOParser.LiteralContext;
import org.innopolis.lsd.generated.LanguageOParser.VarReferenceContext;
import org.innopolis.lsd.parsing.visitor.expression.function.CallExpressionVisitor;

public class ExpressionVisitor extends LanguageOBaseVisitor<Expression> {
    private final VariableReferenceExpressionVisitor variableReferenceExpressionVisitor;
    private final ValueExpressionVisitor valueExpressionVisitor;
    private final CallExpressionVisitor callExpressionVisitor;

    public ExpressionVisitor(Scope scope) {
        variableReferenceExpressionVisitor = new VariableReferenceExpressionVisitor(scope);
        valueExpressionVisitor = new ValueExpressionVisitor();
        callExpressionVisitor = new CallExpressionVisitor(this, scope);
    }

    @Override
    public Expression visitVarReference(@NotNull VarReferenceContext ctx) {
        return variableReferenceExpressionVisitor.visitVarReference(ctx);
    }

    @Override
    public Expression visitLiteral(@NotNull LiteralContext ctx) {
        return valueExpressionVisitor.visitLiteral(ctx);
    }

    @Override
    public Expression visitFCall(@NotNull FCallContext ctx) {
        return callExpressionVisitor.visitFCall(ctx);
    }

    @Override
    public Expression visitConstructorCall(@NotNull ConstructorCallContext ctx) {
        return callExpressionVisitor.visitConstructorCall(ctx);
    }
}

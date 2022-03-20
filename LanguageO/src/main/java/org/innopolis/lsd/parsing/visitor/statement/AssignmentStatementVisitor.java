package org.innopolis.lsd.parsing.visitor.statement;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Expression;
import org.innopolis.lsd.domain.node.statement.Assignment;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.AssignmentContext;
import org.innopolis.lsd.generated.LanguageOParser.ExpressionContext;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;

public class AssignmentStatementVisitor extends LanguageOBaseVisitor<Assignment> {
    private final ExpressionVisitor expressionVisitor;

    public AssignmentStatementVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public Assignment visitAssignment(@NotNull AssignmentContext ctx) {
        ExpressionContext expressionCtx = ctx.expression();
        Expression expression = expressionCtx.accept(expressionVisitor);
        String varName = ctx.Identifier().getText();
        return new Assignment(varName, expression);
    }
}

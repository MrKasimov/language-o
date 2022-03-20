package org.innopolis.lsd.parsing.visitor.expression.function;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Argument;
import org.innopolis.lsd.domain.node.expression.Expression;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.ArgumentContext;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;

import java.util.Optional;

public class ArgumentExpressionVisitor extends LanguageOBaseVisitor<Argument> {

    private final ExpressionVisitor expressionVisitor;

    public ArgumentExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public Argument visitArgument(@NotNull ArgumentContext ctx) {
        Expression value = ctx.expression().accept(expressionVisitor);
        return new Argument(value, Optional.empty());
    }
}

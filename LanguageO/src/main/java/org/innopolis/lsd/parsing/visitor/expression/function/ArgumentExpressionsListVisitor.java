package org.innopolis.lsd.parsing.visitor.expression.function;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Argument;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.ArgumentsContext;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArgumentExpressionsListVisitor extends LanguageOBaseVisitor<List<Argument>> {
    private final ExpressionVisitor expressionVisitor;

    public ArgumentExpressionsListVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public List<Argument> visitArguments(@NotNull ArgumentsContext ctx) {
        ArgumentExpressionVisitor argumentExpressionVisitor = new ArgumentExpressionVisitor(expressionVisitor);
        return ctx.argument().stream()
                .map(a -> a.accept(argumentExpressionVisitor)).collect(toList());
    }
}

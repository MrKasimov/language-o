package org.innopolis.lsd.parsing.visitor.expression;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Value;
import org.innopolis.lsd.domain.type.Type;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.LiteralContext;
import org.innopolis.lsd.util.TypeResolver;

public class ValueExpressionVisitor extends LanguageOBaseVisitor<Value> {
    @Override
    public Value visitLiteral(LiteralContext ctx) {
        String value = ctx.getText(); // get value from ANTLR traversal
        Type type = TypeResolver.getFromValue(ctx); // determine type ourselves
        return new Value(type, value); // return our own AST node
    }
}

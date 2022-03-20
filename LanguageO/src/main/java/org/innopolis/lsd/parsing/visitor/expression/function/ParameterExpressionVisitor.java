package org.innopolis.lsd.parsing.visitor.expression.function;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Expression;
import org.innopolis.lsd.domain.node.expression.Parameter;
import org.innopolis.lsd.domain.type.Type;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser;
import org.innopolis.lsd.generated.LanguageOParser.ParameterDeclarationContext;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;
import org.innopolis.lsd.util.TypeResolver;

import java.util.Optional;

public class ParameterExpressionVisitor extends LanguageOBaseVisitor<Parameter> {

    private final ExpressionVisitor expressionVisitor;

    public ParameterExpressionVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public Parameter visitParameterDeclaration(@NotNull ParameterDeclarationContext ctx) {
        String name = ctx.Identifier().getText();
        Type type = TypeResolver.getFromTypeName(ctx.className().Identifier().getText());
        return new Parameter(name, type, Optional.empty());
    }
}

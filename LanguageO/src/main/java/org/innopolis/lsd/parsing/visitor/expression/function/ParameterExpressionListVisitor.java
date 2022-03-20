package org.innopolis.lsd.parsing.visitor.expression.function;

import com.google.common.collect.Lists;
import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Parameter;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.ParameterDeclarationContext;
import org.innopolis.lsd.generated.LanguageOParser.ParametersContext;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;

import java.util.ArrayList;
import java.util.List;

public class ParameterExpressionListVisitor extends LanguageOBaseVisitor<List<Parameter>> {

    private final ExpressionVisitor expressionVisitor;

    public ParameterExpressionListVisitor(ExpressionVisitor expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public List<Parameter> visitParameters(@NotNull ParametersContext ctx) {
        List<ParameterDeclarationContext> paramsCtx = ctx.parameterDeclaration();
        ParameterExpressionVisitor parameterExpressionVisitor = new ParameterExpressionVisitor(expressionVisitor);
        List<Parameter> parameters = new ArrayList<>();
        if (paramsCtx != null) {
            List<Parameter> params = Lists.transform(paramsCtx, p -> p.accept(parameterExpressionVisitor));
            parameters.addAll(params);
        }
        return parameters;
    }
}

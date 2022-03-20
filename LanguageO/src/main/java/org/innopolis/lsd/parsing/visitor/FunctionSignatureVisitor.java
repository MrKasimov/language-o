package org.innopolis.lsd.parsing.visitor;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Parameter;
import org.innopolis.lsd.domain.scope.FunctionSignature;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.domain.type.BuiltInType;
import org.innopolis.lsd.domain.type.Type;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser;
import org.innopolis.lsd.generated.LanguageOParser.FunctionDeclarationContext;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;
import org.innopolis.lsd.parsing.visitor.expression.function.ParameterExpressionListVisitor;
import org.innopolis.lsd.util.TypeResolver;

import java.util.Collections;
import java.util.List;

public class FunctionSignatureVisitor extends LanguageOBaseVisitor<FunctionSignature> {
    private final ExpressionVisitor expressionVisitor;

    public FunctionSignatureVisitor(Scope scope) {
        this.expressionVisitor = new ExpressionVisitor(scope);
    }

    @Override
    public FunctionSignature visitFunctionDeclaration(@NotNull FunctionDeclarationContext ctx) {
        String functionName = ctx.functionName().getText();
        Type returnType;
        if (ctx.Identifier() != null)
            returnType = TypeResolver.getFromTypeName(ctx.Identifier().getText());
        else
            returnType = BuiltInType.VOID;

        LanguageOParser.ParametersContext parametersCtx = ctx.parameters();
        if (parametersCtx != null) {
            List<Parameter> parameters = parametersCtx.accept(new ParameterExpressionListVisitor(expressionVisitor));
            return new FunctionSignature(functionName, parameters, returnType);
        }
        return new FunctionSignature(functionName, Collections.emptyList(), returnType);
    }
}

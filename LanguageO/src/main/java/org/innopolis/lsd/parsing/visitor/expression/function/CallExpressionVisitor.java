package org.innopolis.lsd.parsing.visitor.expression.function;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.*;
import org.innopolis.lsd.domain.scope.FunctionSignature;
import org.innopolis.lsd.domain.scope.LocalVariable;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.domain.type.ClassType;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser;
import org.innopolis.lsd.generated.LanguageOParser.ArgumentsContext;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CallExpressionVisitor extends LanguageOBaseVisitor<Call> {
    private final ExpressionVisitor expressionVisitor;
    private final Scope scope;

    public CallExpressionVisitor(ExpressionVisitor expressionVisitor, Scope scope) {
        this.expressionVisitor = expressionVisitor;
        this.scope = scope;
    }

    @Override
    public Call visitFCall(@NotNull LanguageOParser.FCallContext ctx) {
        var functions = ctx.functionCall().Identifier();
        String functionName = functions.get(functions.size() - 1).toString();
        if (functionName.equals(scope.getClassName())) {
            throw new RuntimeException("FunctionNameEqualClassException: " + functionName);
        }
        var allWithExtra = ctx.functionCall().arguments();
        List<Argument> arguments = getArgumentsForCall(allWithExtra.get(allWithExtra.size() - 1));
        boolean ownerIsExplicit = ctx.functionCall().owner != null;
        if (ownerIsExplicit) {
            Expression owner = ctx.functionCall().owner.accept(expressionVisitor);
            FunctionSignature signature = scope.getMethodCallSignature(Optional.of(owner.getType()),functionName, arguments);
            return new FunctionCall(signature, arguments, owner);
        }
        ClassType thisType = new ClassType(scope.getClassName());
        FunctionSignature signature = scope.getMethodCallSignature(functionName, arguments);
        LocalVariable thisVariable = new LocalVariable("this",thisType);
        return new FunctionCall(signature, arguments, new LocalVariableReference(thisVariable));
    }

    @Override
    public Call visitConstructorCall(@NotNull LanguageOParser.ConstructorCallContext ctx) {
        String className = ctx.classType().getText();
        List<Argument> arguments = getArgumentsForCall(ctx.arguments());
        return new ConstructorCall(className, arguments);
    }

//    @Override
//    public Call visitSupercall(@NotNull SupercallContext ctx) {
//        List<Argument> arguments = getArgumentsForCall(ctx.argumentList());
//        return new SuperCall(arguments);
//    }

    private List<Argument> getArgumentsForCall(ArgumentsContext argumentsContext) {
        if (argumentsContext != null) {
            ArgumentExpressionsListVisitor visitor = new ArgumentExpressionsListVisitor(expressionVisitor);
            return argumentsContext.accept(visitor);
        }
        return Collections.emptyList();
    }
}

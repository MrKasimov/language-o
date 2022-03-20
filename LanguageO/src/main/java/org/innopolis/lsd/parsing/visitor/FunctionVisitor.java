package org.innopolis.lsd.parsing.visitor;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.Constructor;
import org.innopolis.lsd.domain.Function;
import org.innopolis.lsd.domain.node.statement.Statement;
import org.innopolis.lsd.domain.scope.FunctionSignature;
import org.innopolis.lsd.domain.scope.LocalVariable;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.BodyContext;
import org.innopolis.lsd.generated.LanguageOParser.MethodDeclarationContext;
import org.innopolis.lsd.parsing.visitor.statement.StatementVisitor;

public class FunctionVisitor extends LanguageOBaseVisitor<Function> {

    private final Scope scope;

    public FunctionVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Function visitMethodDeclaration(@NotNull MethodDeclarationContext ctx) {
        FunctionSignature signature = ctx.functionDeclaration().accept(new FunctionSignatureVisitor(scope));
        scope.addLocalVariable(new LocalVariable("this", scope.getClassType()));
        addParametersAsLocalVariables(signature);
        Statement block = getBlock(ctx);
        if (signature.getName().equals(scope.getClassName())) {
            return new Constructor(signature, block);
        }
        return new Function(signature, block);
    }

    private void addParametersAsLocalVariables(FunctionSignature signature) {
        signature.getParameters().stream()
                .forEach(param -> scope.addLocalVariable(new LocalVariable(param.getName(), param.getType())));
    }

    private Statement getBlock(MethodDeclarationContext functionContext) {
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        BodyContext block = functionContext.body();
        return block.accept(statementVisitor);
    }
}

package org.innopolis.lsd.parsing.visitor.statement;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.Expression;
import org.innopolis.lsd.domain.node.statement.VariableDeclaration;
import org.innopolis.lsd.domain.scope.LocalVariable;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser;
import org.innopolis.lsd.generated.LanguageOParser.VariableDeclarationContext;
import org.innopolis.lsd.parsing.visitor.expression.ExpressionVisitor;

public class VariableDeclarationStatementVisitor extends LanguageOBaseVisitor<VariableDeclaration> {
    private final ExpressionVisitor expressionVisitor;
    private final Scope scope;

    public VariableDeclarationStatementVisitor(ExpressionVisitor expressionVisitor, Scope scope) {
        this.expressionVisitor = expressionVisitor;
        this.scope = scope;
    }

    @Override
    public VariableDeclaration visitVariableDeclaration(@NotNull VariableDeclarationContext ctx) {
        String varName = ctx.Identifier().getText();
        LanguageOParser.ExpressionContext expressionCtx = ctx.expression();
        Expression expression = expressionCtx.accept(expressionVisitor);
        scope.addLocalVariable(new LocalVariable(varName, expression.getType()));
        return new VariableDeclaration(varName, expression);
    }
}

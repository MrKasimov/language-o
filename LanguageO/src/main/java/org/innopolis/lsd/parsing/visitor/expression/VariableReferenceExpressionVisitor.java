package org.innopolis.lsd.parsing.visitor.expression;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.expression.FieldReference;
import org.innopolis.lsd.domain.node.expression.LocalVariableReference;
import org.innopolis.lsd.domain.node.expression.Reference;
import org.innopolis.lsd.domain.scope.Field;
import org.innopolis.lsd.domain.scope.LocalVariable;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser;

public class VariableReferenceExpressionVisitor extends LanguageOBaseVisitor<Reference> {
    private final Scope scope;

    public VariableReferenceExpressionVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Reference visitVarReference(@NotNull LanguageOParser.VarReferenceContext ctx) {
        String varName = ctx.getText();
        if(scope.isFieldExists(varName)) {
            Field field = scope.getField(varName);
            return new FieldReference(field);
        }
        LocalVariable variable = scope.getLocalVariable(varName);
        return new LocalVariableReference(variable);
    }
}

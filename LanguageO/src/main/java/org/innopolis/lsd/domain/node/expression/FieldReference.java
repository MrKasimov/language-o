package org.innopolis.lsd.domain.node.expression;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;
import org.innopolis.lsd.domain.scope.Field;
import org.innopolis.lsd.domain.type.Type;

public class FieldReference implements Reference {
    private Field field;

    public FieldReference(Field field) {
        this.field = field;
    }

    @Override
    public String geName() {
        return field.getName();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public Type getType() {
        return field.getType();
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public String getOwnerInternalName() {
        return field.getOwnerInternalName();
    }
}

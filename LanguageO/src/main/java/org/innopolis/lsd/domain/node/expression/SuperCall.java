package org.innopolis.lsd.domain.node.expression;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;
import org.innopolis.lsd.domain.type.BuiltInType;
import org.innopolis.lsd.domain.type.Type;

import java.util.Collections;
import java.util.List;

public class SuperCall implements Call {
    public static final String SUPER_IDETIFIER = "super";
    private final List<Argument> arguments;

    public SuperCall() {
        this(Collections.emptyList());
    }

    public SuperCall(List<Argument> arguments) {
        this.arguments = arguments;
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    @Override
    public String getIdentifier() {
        return SUPER_IDETIFIER;
    }

    @Override
    public Type getType() {
        return BuiltInType.VOID;
    }

    @Override
    public void accept(ExpressionGenerator genrator) {
        genrator.generate(this);
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}

package org.innopolis.lsd.domain.node.expression;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;
import org.innopolis.lsd.domain.type.ClassType;
import org.innopolis.lsd.domain.type.Type;

import java.util.Collections;
import java.util.List;

public class ConstructorCall implements Call {
    private final List<Argument> arguments;
    private final Type type;
    private final String identifier;

    public ConstructorCall(String identifier) {
        this(identifier, Collections.emptyList());
    }

    public ConstructorCall(String className, List<Argument> arguments) {
        this.type = new ClassType(className);
        this.arguments = arguments;
//        this.identifier = type.getName();
        this.identifier = "this";
    }

    @Override
    public void accept(ExpressionGenerator genrator) {
        genrator.generate(this);
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}

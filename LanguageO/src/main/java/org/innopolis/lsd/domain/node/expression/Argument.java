package org.innopolis.lsd.domain.node.expression;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;
import org.innopolis.lsd.domain.type.Type;

import java.util.Optional;

public class Argument implements Expression {

    private final Optional<String> parameterName;
    private final Expression expression;

    public Argument(Expression expression, Optional<String> parameterName) {
        this.parameterName = parameterName;
        this.expression = expression;
    }

    @Override
    public Type getType() {
        return expression.getType();
    }

    @Override
    public void accept(ExpressionGenerator genrator) {
        expression.accept(genrator);
    }

    @Override
    public void accept(StatementGenerator generator) {
        expression.accept(generator);
    }

    public Optional<String> getParameterName() {
        return parameterName;
    }
}
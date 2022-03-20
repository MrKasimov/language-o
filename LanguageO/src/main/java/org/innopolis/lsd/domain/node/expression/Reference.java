package org.innopolis.lsd.domain.node.expression;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;

public interface Reference extends Expression {
    String geName();

    @Override
    void accept(ExpressionGenerator genrator);

    @Override
    void accept(StatementGenerator generator);
}

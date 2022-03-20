package org.innopolis.lsd.domain.node.expression;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;
import org.innopolis.lsd.domain.node.statement.Statement;
import org.innopolis.lsd.domain.type.Type;

public interface Expression extends Statement {
    Type getType();

    void accept(ExpressionGenerator generator);

    @Override
    void accept(StatementGenerator generator);
}
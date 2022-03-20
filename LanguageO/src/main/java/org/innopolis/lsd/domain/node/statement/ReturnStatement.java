package org.innopolis.lsd.domain.node.statement;

import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;
import org.innopolis.lsd.domain.node.expression.Expression;

public class ReturnStatement implements Statement {

    private final Expression expression;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public Expression getExpression() {
        return expression;
    }
}

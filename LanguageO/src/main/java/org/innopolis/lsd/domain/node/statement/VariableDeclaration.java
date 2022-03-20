package org.innopolis.lsd.domain.node.statement;

import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;
import org.innopolis.lsd.domain.node.expression.Expression;

public class VariableDeclaration implements Statement {
    private final String name;
    private final Expression expression;

    public VariableDeclaration(String name, Expression expression) {
        this.expression = expression;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}

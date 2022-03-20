package org.innopolis.lsd.bytecodegeneration.statement;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.domain.node.expression.Expression;
import org.innopolis.lsd.domain.node.statement.Assignment;
import org.innopolis.lsd.domain.node.statement.VariableDeclaration;

public class VariableDeclarationStatementGenerator {
    private final StatementGenerator statementGenerator;
    private final ExpressionGenerator expressionGenerator;

    public VariableDeclarationStatementGenerator(StatementGenerator statementGenerator, ExpressionGenerator expressionGenerator) {
        this.statementGenerator = statementGenerator;
        this.expressionGenerator = expressionGenerator;
    }

    public void generate(VariableDeclaration variableDeclaration) {
        Expression expression = variableDeclaration.getExpression();
        expression.accept(expressionGenerator);
        Assignment assignment = new Assignment(variableDeclaration);
        assignment.accept(statementGenerator);
    }
}

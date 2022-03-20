package org.innopolis.lsd.bytecodegeneration.statement;

import org.innopolis.lsd.bytecodegeneration.expression.ExpressionGenerator;
import org.innopolis.lsd.domain.node.expression.Expression;
import org.innopolis.lsd.domain.node.statement.ReturnStatement;
import org.innopolis.lsd.domain.type.Type;
import org.objectweb.asm.MethodVisitor;

public class ReturnStatemenetGenerator {
    private final ExpressionGenerator expressionGenerator;
    private final MethodVisitor methodVisitor;

    public ReturnStatemenetGenerator(ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(ReturnStatement returnStatement) {
        Expression expression = returnStatement.getExpression();
        Type type = expression.getType();
        expression.accept(expressionGenerator);
        methodVisitor.visitInsn(type.getReturnOpcode());
    }
}

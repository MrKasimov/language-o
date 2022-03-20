package org.innopolis.lsd.bytecodegeneration.expression;

import org.innopolis.lsd.domain.node.expression.Value;
import org.innopolis.lsd.domain.type.Type;
import org.innopolis.lsd.util.TypeResolver;
import org.objectweb.asm.MethodVisitor;

public class ValueExpressionGenerator {
    private final MethodVisitor methodVisitor;

    public ValueExpressionGenerator(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void generate(Value value) {
        Type type = value.getType();
        String stringValue = value.getValue();
        Object transformedValue = TypeResolver.getValueFromString(stringValue, type);
        methodVisitor.visitLdcInsn(transformedValue);
    }
}

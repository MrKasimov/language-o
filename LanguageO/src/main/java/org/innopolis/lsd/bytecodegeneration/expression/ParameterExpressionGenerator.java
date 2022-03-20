package org.innopolis.lsd.bytecodegeneration.expression;

import org.innopolis.lsd.domain.node.expression.Parameter;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.domain.type.Type;
import org.objectweb.asm.MethodVisitor;

public class ParameterExpressionGenerator {
    private final MethodVisitor methodVisitor;
    private final Scope scope;

    public ParameterExpressionGenerator(MethodVisitor methodVisitor, Scope scope) {
        this.methodVisitor = methodVisitor;
        this.scope = scope;
    }

    public void generate(Parameter parameter) {
        Type type = parameter.getType();
        int index = scope.getLocalVariableIndex(parameter.getName());
        methodVisitor.visitVarInsn(type.getLoadVariableOpcode(), index);
    }
}

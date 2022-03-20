package org.innopolis.lsd.bytecodegeneration.expression;

import org.innopolis.lsd.domain.node.expression.*;
import org.innopolis.lsd.domain.scope.Scope;
import org.objectweb.asm.MethodVisitor;

public class ExpressionGenerator {
    private final ReferenceExpressionGenerator referenceExpressionGenerator;
    private final ValueExpressionGenerator valueExpressionGenerator;
    private final CallExpressionGenerator callExpressionGenerator;
//    private final ConditionalExpressionGenerator conditionalExpressionGenerator;
    private final ParameterExpressionGenerator parameterExpressionGenerator;

    public ExpressionGenerator(MethodVisitor methodVisitor, Scope scope) {
        referenceExpressionGenerator = new ReferenceExpressionGenerator(methodVisitor,scope);
        valueExpressionGenerator = new ValueExpressionGenerator(methodVisitor);
        callExpressionGenerator = new CallExpressionGenerator(this, scope, methodVisitor);
//        conditionalExpressionGenerator = new ConditionalExpressionGenerator(this, methodVisitor);
        parameterExpressionGenerator = new ParameterExpressionGenerator(methodVisitor, scope);
    }

    public void generate(FieldReference reference) {
        referenceExpressionGenerator.generate(reference);
    }

    public void generate(LocalVariableReference reference) {
        referenceExpressionGenerator.generate(reference);
    }

    public void generate(Parameter parameter) {
        parameterExpressionGenerator.generate(parameter);
    }

    public void generate(Value value) {
        valueExpressionGenerator.generate(value);
    }

    public void generate(ConstructorCall constructorCall) {
        callExpressionGenerator.generate(constructorCall);
    }

    public void generate(SuperCall superCall) {
        callExpressionGenerator.generate(superCall);
    }

    public void generate(FunctionCall functionCall) {
        callExpressionGenerator.generate(functionCall);
    }

//    public void generate(ConditionalExpression conditionalExpression) {
//        conditionalExpressionGenerator.generate(conditionalExpression);
//    }

    public void generate(EmptyExpression emptyExpression) {}
}

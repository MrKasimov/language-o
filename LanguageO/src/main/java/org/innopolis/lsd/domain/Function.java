package org.innopolis.lsd.domain;

import org.innopolis.lsd.bytecodegeneration.MethodGenerator;
import org.innopolis.lsd.domain.node.expression.Parameter;
import org.innopolis.lsd.domain.node.statement.Statement;
import org.innopolis.lsd.domain.scope.FunctionSignature;
import org.innopolis.lsd.domain.type.Type;

import java.util.Collections;
import java.util.List;

public class Function {
    private final FunctionSignature functionSignature;
    private final Statement rootStatement;

    public Function(FunctionSignature functionSignature, Statement rootStatement) {
        this.functionSignature = functionSignature;
        this.rootStatement = rootStatement;
    }

    public String getName() {
        return functionSignature.getName();
    }

    public List<Parameter> getParameters() {
        return Collections.unmodifiableList(functionSignature.getParameters());
    }

    public Statement getRootStatement() {
        return rootStatement;
    }

    public Type getReturnType() {
        return functionSignature.getReturnType();
    }

    public void accept(MethodGenerator generator) {
        generator.generate(this);
    }
}

package org.innopolis.lsd.domain;

import org.innopolis.lsd.bytecodegeneration.MethodGenerator;
import org.innopolis.lsd.domain.node.statement.Statement;
import org.innopolis.lsd.domain.scope.FunctionSignature;
import org.innopolis.lsd.domain.type.BuiltInType;
import org.innopolis.lsd.domain.type.Type;

public class Constructor extends Function {
    public Constructor(FunctionSignature signature, Statement block) {
        super(signature, block);
    }

    @Override
    public Type getReturnType() {
        return BuiltInType.VOID;
    }

    @Override
    public void accept(MethodGenerator generator) {
        generator.generate(this);
    }
}
package org.innopolis.lsd.bytecodegeneration;

import org.innopolis.lsd.domain.ClassDeclaration;
import org.innopolis.lsd.domain.Program;

public class BytecodeGenerator {
    public byte[] generate(Program program) {
        ClassDeclaration classDeclaration = program.getClassDeclaration();
        ClassGenerator classGenerator = new ClassGenerator();
        return classGenerator.generate(classDeclaration).toByteArray();
    }
}

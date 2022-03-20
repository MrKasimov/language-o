package org.innopolis.lsd;

import org.apache.commons.io.IOUtils;
import org.innopolis.lsd.bytecodegeneration.BytecodeGenerator;
import org.innopolis.lsd.domain.Program;
import org.innopolis.lsd.parsing.Parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

public class Compiler {
    public static void main(String[] args) throws Exception {
        compile(args);
    }

    private static void compile(String[] args) throws Exception {
        if (args.length == 0)
            throw new Exception("Specify source code filename");

        File sourceFile = new File(args[0]);
        String fileAbsolutePath = sourceFile.getAbsolutePath();
        Program program = new Parser().getProgram(fileAbsolutePath);
        saveBytecodeToClassFile(program);
    }

    private static void saveBytecodeToClassFile(Program program) throws IOException {
        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();
        byte[] bytecode = bytecodeGenerator.generate(program);
        String className = program.getClassName();
        String fileName = className + ".class";
        System.out.printf("Compilation over. Bytecode is saved to '%s'", Paths.get(fileName).toAbsolutePath());
        OutputStream os = new FileOutputStream(fileName);
        IOUtils.write(bytecode, os);
        System.out.printf("\nRun compiled file via: 'java %s' in current dir", className);
    }
}

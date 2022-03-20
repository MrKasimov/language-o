package org.innopolis.lsd.parsing.visitor;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.ClassDeclaration;
import org.innopolis.lsd.domain.Program;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.ClassDeclarationContext;
import org.innopolis.lsd.generated.LanguageOParser.ProgramContext;

public class ProgramVisitor extends LanguageOBaseVisitor<Program> {
    @Override
    public Program visitProgram(@NotNull ProgramContext ctx) {
        ClassVisitor classVisitor = new ClassVisitor();
        ClassDeclarationContext classDeclarationContext = ctx.classDeclaration().get(0);
        ClassDeclaration classDeclaration = classDeclarationContext.accept(classVisitor);
        return new Program(classDeclaration);
    }
}

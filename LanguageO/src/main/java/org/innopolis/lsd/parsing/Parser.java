package org.innopolis.lsd.parsing;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.innopolis.lsd.domain.Program;
import org.innopolis.lsd.generated.LanguageOLexer;
import org.innopolis.lsd.generated.LanguageOParser;
import org.innopolis.lsd.parsing.visitor.ProgramVisitor;

import java.io.IOException;

public class Parser {
    public Program getProgram(String fileAbsolutePath) throws IOException {
        CharStream charStream = new ANTLRFileStream(fileAbsolutePath);
        LanguageOLexer lexer = new LanguageOLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        LanguageOParser parser = new LanguageOParser(tokenStream);

        ProgramVisitor programVisitor = new ProgramVisitor();
        return parser.program().accept(programVisitor);
    }
}

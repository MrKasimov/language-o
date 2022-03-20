package org.innopolis.lsd.parsing.visitor.statement;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.node.statement.Block;
import org.innopolis.lsd.domain.node.statement.Statement;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser;
import org.innopolis.lsd.generated.LanguageOParser.BodyContext;

import java.util.List;
import java.util.stream.Collectors;

public class BlockStatementVisitor extends LanguageOBaseVisitor<Block> {
    private final Scope scope;

    public BlockStatementVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Block visitBody(@NotNull BodyContext ctx) {
        List<LanguageOParser.StatementContext> blockstatementsCtx = ctx.statement();
        Scope newScope = new Scope(scope);
        StatementVisitor statementVisitor = new StatementVisitor(newScope);
        List<Statement> statements = blockstatementsCtx.stream().map(smtt -> smtt.accept(statementVisitor)).collect(Collectors.toList());
        return new Block(newScope, statements);
    }
}

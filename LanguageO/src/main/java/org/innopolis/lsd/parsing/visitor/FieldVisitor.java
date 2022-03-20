package org.innopolis.lsd.parsing.visitor;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.scope.Field;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.domain.type.Type;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser;
import org.innopolis.lsd.util.TypeResolver;

public class FieldVisitor extends LanguageOBaseVisitor<Field> {

    private final Scope scope;

    public FieldVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Field visitField(@NotNull LanguageOParser.FieldContext ctx) {
        Type owner = scope.getClassType();
        Type type = TypeResolver.getFromTypeName(ctx.className().Identifier().getText());
        String name = ctx.Identifier().getText();
        return new Field(name, owner, type);
    }
}

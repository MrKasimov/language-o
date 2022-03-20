package org.innopolis.lsd.domain.node.statement;

import org.innopolis.lsd.bytecodegeneration.statement.StatementGenerator;
import org.innopolis.lsd.domain.node.Node;

@FunctionalInterface
public interface Statement extends Node {
    void accept(StatementGenerator generator);
}

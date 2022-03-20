package org.innopolis.lsd.exception;

import org.innopolis.lsd.domain.scope.Scope;

public class LocalVariableNotFoundException extends RuntimeException {
    public LocalVariableNotFoundException(Scope scope, String variableName) {
        super("No local varaible found for name " + variableName + " found in scope" + scope);
    }
}
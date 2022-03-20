package org.innopolis.lsd.exception;

import org.innopolis.lsd.domain.node.expression.Argument;
import org.innopolis.lsd.domain.scope.Scope;

import java.util.List;

public class MethodSignatureNotFoundException extends RuntimeException {
    public MethodSignatureNotFoundException(Scope scope, String methodName, List<Argument> parameterTypes) {
        super("There is no method '" + methodName + "' with parameters " + parameterTypes);
    }
}
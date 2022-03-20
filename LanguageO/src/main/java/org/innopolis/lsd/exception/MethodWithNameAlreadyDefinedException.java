package org.innopolis.lsd.exception;

import org.innopolis.lsd.domain.scope.FunctionSignature;

public class MethodWithNameAlreadyDefinedException extends RuntimeException {
    public MethodWithNameAlreadyDefinedException(FunctionSignature signature) {
        super("Method already defined in scope :" + signature);
    }
}
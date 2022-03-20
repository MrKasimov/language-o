package org.innopolis.lsd.util;

import org.innopolis.lsd.domain.Function;
import org.innopolis.lsd.domain.node.expression.Parameter;
import org.innopolis.lsd.domain.scope.FunctionSignature;
import org.innopolis.lsd.domain.type.Type;

import java.util.Collection;
import java.util.stream.Collectors;

public class DescriptorFactory {
    public static String getMethodDescriptor(Function function) {
        Collection<Parameter> parameters = function.getParameters();
        Type returnType = function.getReturnType();
        return getMethodDescriptor(parameters, returnType);
    }

    public static String getMethodDescriptor(FunctionSignature signature) {
        Collection<Parameter> parameters = signature.getParameters();
        Type returnType = signature.getReturnType();
        return getMethodDescriptor(parameters, returnType);
    }

    private static String getMethodDescriptor(Collection<Parameter> parameters, Type returnType) {
        String parametersDescriptor = parameters.stream()
                .map(parameter -> parameter.getType().getDescriptor())
                .collect(Collectors.joining("", "(", ")"));
        String returnDescriptor = returnType.getDescriptor();
        return parametersDescriptor + returnDescriptor;
    }
}

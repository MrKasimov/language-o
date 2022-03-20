package org.innopolis.lsd.parsing.visitor;

import org.antlr.v4.runtime.misc.NotNull;
import org.innopolis.lsd.domain.ClassDeclaration;
import org.innopolis.lsd.domain.Constructor;
import org.innopolis.lsd.domain.Function;
import org.innopolis.lsd.domain.MetaData;
import org.innopolis.lsd.domain.node.expression.ConstructorCall;
import org.innopolis.lsd.domain.node.expression.FunctionCall;
import org.innopolis.lsd.domain.node.expression.Parameter;
import org.innopolis.lsd.domain.node.statement.Block;
import org.innopolis.lsd.domain.scope.Field;
import org.innopolis.lsd.domain.scope.FunctionSignature;
import org.innopolis.lsd.domain.scope.Scope;
import org.innopolis.lsd.domain.type.BuiltInType;
import org.innopolis.lsd.generated.LanguageOBaseVisitor;
import org.innopolis.lsd.generated.LanguageOParser.ClassDeclarationContext;
import org.innopolis.lsd.generated.LanguageOParser.MethodDeclarationContext;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class ClassVisitor extends LanguageOBaseVisitor<ClassDeclaration> {
    private Scope scope;

    @Override
    public ClassDeclaration visitClassDeclaration(@NotNull ClassDeclarationContext ctx) {
        MetaData metaData = new MetaData(ctx.className().get(0).getText(), "java.lang.Object");
        scope = new Scope(metaData);
        String name = ctx.className().get(0).getText();
        FieldVisitor fieldVisitor = new FieldVisitor(scope);
        FunctionSignatureVisitor functionSignatureVisitor = new FunctionSignatureVisitor(scope);

        List<MethodDeclarationContext> methodsCtx = new ArrayList<>();
        for (var memberDeclaration : ctx.memberDeclaration()) {
            if (memberDeclaration.methodDeclaration() != null)
                methodsCtx.add(memberDeclaration.methodDeclaration());
        }
//        List<Field> fields = ctx.classBody().field().stream()
//                .map(field -> field.accept(fieldVisitor))
//                .peek(scope::addField)
//                .collect(toList());
        List<Field> fields = Collections.emptyList();
        methodsCtx.stream()
                .map(method -> method.functionDeclaration().accept(functionSignatureVisitor))
                .forEach(scope::addSignature);

        boolean defaultConstructorExists = scope.isParameterLessSignatureExists("this");
        addDefaultConstructorSignatureToScope("this", defaultConstructorExists);
        List<Function> methods = methodsCtx.stream()
                .map(method -> method.accept(new FunctionVisitor(scope)))
                .collect(toList());
        if (!defaultConstructorExists) {
            methods.add(getDefaultConstructor());
        }
        //methods.add(getGeneratedMainMethod());
        return new ClassDeclaration(name, fields, methods);
    }

    private void addDefaultConstructorSignatureToScope(String name, boolean defaultConstructorExists) {
        if(!defaultConstructorExists) {
            FunctionSignature constructorSignature = new FunctionSignature(name, Collections.emptyList(), BuiltInType.VOID);
            scope.addSignature(constructorSignature);
        }
    }

    private Constructor getDefaultConstructor() {
//        FunctionSignature signature = scope.getMethodCallSignatureWithoutParameters(scope.getClassName());
        FunctionSignature signature = scope.getMethodCallSignatureWithoutParameters("this");
        return new Constructor(signature, Block.empty(scope));
    }

    private Function getGeneratedMainMethod() {
        Parameter args = new Parameter("args", BuiltInType.STRING_ARR, Optional.empty());
        FunctionSignature functionSignature = new FunctionSignature("main", Collections.singletonList(args), BuiltInType.VOID);
//        ConstructorCall constructorCall = new ConstructorCall(scope.getClassName());
//        ConstructorCall constructorCall = new ConstructorCall("this");
        FunctionSignature startFunSignature = new FunctionSignature("test", Collections.emptyList(), BuiltInType.VOID);
        FunctionCall startFunctionCall = new FunctionCall(startFunSignature, Collections.emptyList(), scope.getClassType());

        Block block = new Block(new Scope(scope), Arrays.asList(startFunctionCall));
        return new Function(functionSignature, block);
    }
}

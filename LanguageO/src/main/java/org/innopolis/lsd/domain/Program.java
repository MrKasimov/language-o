package org.innopolis.lsd.domain;

public class Program {
    private final ClassDeclaration classDeclaration;

    public Program(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    public String getClassName() {
        return classDeclaration.getName();
    }
}

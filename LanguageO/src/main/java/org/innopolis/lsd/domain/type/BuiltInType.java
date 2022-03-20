package org.innopolis.lsd.domain.type;

public enum BuiltInType implements Type {
    VOID("void", void.class,"V", TypeSpecificOpcodes.VOID),
    LONG ("long", long.class,"J", TypeSpecificOpcodes.LONG),
    BOOLEAN("boolean",boolean.class,"Z", TypeSpecificOpcodes.LONG),
    STRING_ARR ("string[]", String[].class,"[Ljava/lang/String;", TypeSpecificOpcodes.OBJECT),
    DOUBLE ("double", double.class,"D", TypeSpecificOpcodes.DOUBLE);

    private final String name;
    private final Class<?> typeClass;
    private final String descriptor;
    private final TypeSpecificOpcodes opcodes;


    BuiltInType(String name, Class<?> typeClass, String descriptor, TypeSpecificOpcodes opcodes) {
        this.name = name;
        this.typeClass = typeClass;
        this.descriptor = descriptor;
        this.opcodes = opcodes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?> getTypeClass() {
        return typeClass;
    }

    @Override
    public String getDescriptor() {
        return descriptor;
    }

    @Override
    public String getInternalName() {
        return getDescriptor();
    }

    @Override
    public int getLoadVariableOpcode() {
        return opcodes.getLoad();
    }

    @Override
    public int getStoreVariableOpcode() {
        return opcodes.getStore();
    }

    @Override
    public int getReturnOpcode() {
        return opcodes.getReturn();
    }

    @Override
    public int getAddOpcode() {
        return opcodes.getAdd();
    }

    @Override
    public int getSubstractOpcode() {
        return  opcodes.getSubstract();
    }

    @Override
    public int getMultiplyOpcode() {
        return opcodes.getMultiply();
    }

    @Override
    public int getDividOpcode() {
        return opcodes.getDivide();
    }
}

package org.innopolis.lsd.util;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;
import org.innopolis.lsd.domain.type.BuiltInType;
import org.innopolis.lsd.domain.type.ClassType;
import org.innopolis.lsd.domain.type.Type;
import org.innopolis.lsd.generated.LanguageOParser.LiteralContext;

import java.util.Arrays;
import java.util.Optional;

public class TypeResolver {
//    public static Type getReturnType(TypeContext typeContext) {
//        if(typeContext == null) return BuiltInType.VOID;
//        return getFromTypeName(typeContext.getText());
//    }

    public static Type getFromTypeName(String typeName) {
        Optional<? extends Type> builtInType = getBuiltInType(typeName);
        if (builtInType.isPresent()) return builtInType.get();
        return new ClassType(typeName);
    }

    public static Type getFromValue(LiteralContext value) {
        String stringValue = value.getText();
        if (StringUtils.isEmpty(stringValue)) return BuiltInType.VOID;
        if (value.IntegerLiteral() != null) {
            return BuiltInType.LONG;
        } else if (value.RealLiteral() != null) {
            return BuiltInType.DOUBLE;
        }
        return BuiltInType.BOOLEAN;
    }

    public static Object getValueFromString(String stringValue, Type type) {
        if (type == BuiltInType.LONG) {
            return Integer.valueOf(stringValue);
        }
        if (type == BuiltInType.DOUBLE) {
            return Double.valueOf(stringValue);
        }
        if (type == BuiltInType.BOOLEAN) {
            return Boolean.valueOf(stringValue);
        }
//        if (type == BuiltInType.STRING) {
//            stringValue = StringUtils.removeStart(stringValue, "\"");
//            stringValue = StringUtils.removeEnd(stringValue, "\"");
//            return stringValue;
//        }
        throw new AssertionError("Objects not yet implemented!");
    }

    private static Optional<BuiltInType> getBuiltInType(String typeName) {
        return Arrays.stream(BuiltInType.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }
}

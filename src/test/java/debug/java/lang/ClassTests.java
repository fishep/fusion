package debug.java.lang;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClassTests {

    @Test
    void typeErasureTest() {
        List<Integer> obj = new ArrayList<>();
        Class<? extends List> clazz = obj.getClass();

        assertNotEquals(List.class, clazz);
        assertEquals(ArrayList.class, clazz);
        assertEquals("java.util.ArrayList", clazz.getTypeName());
        TypeVariable<?>[] typeParameters = clazz.getTypeParameters();
        assertEquals("E", typeParameters[0].getTypeName());

        Type type = clazz.getGenericSuperclass();
        assertInstanceOf(ParameterizedType.class, type);
        ParameterizedType pt = (ParameterizedType) type;

        Type[] actualTypeArguments = pt.getActualTypeArguments();
        Type rawType = pt.getRawType();
        Type ownerType = pt.getOwnerType();

        assertEquals("E", actualTypeArguments[0].getTypeName());
        assertEquals(AbstractList.class, rawType);
        assertNull(ownerType);
    }

}

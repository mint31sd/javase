package any.mint.invoke;


import java.lang.reflect.Method;

public class InvokeTest {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("any.mint.invoke.InvokeTestObj");
        Object o = clz.newInstance();
        Method m = clz.getDeclaredMethod("hello", null);
        m.invoke(o);

        Method m2 = clz.getMethod("hello", String.class);
        m2.invoke(o,"你好!");
    }
}
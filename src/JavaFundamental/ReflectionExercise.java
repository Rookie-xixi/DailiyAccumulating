package JavaFundamental;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
// 动态加载，修改，调用一个类的方法，变量等参数
// 缺点：执行速度慢
public class ReflectionExercise {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> cls = Class.forName("JavaFundamental.ThirdParty.Calculator");
        Object o = cls.newInstance();
        Method method = cls.getMethod("add", int.class, int.class);
        System.out.println(method.invoke(o, 11, 12));

        Field field = cls.getField("name");
        field.set(o,"My Calculator!");
        System.out.println(field.get(o));

        Constructor constructor = cls.getConstructor(String.class);
        Object newObject = constructor.newInstance("New Calculator !");
        System.out.println(newObject);
    }
}

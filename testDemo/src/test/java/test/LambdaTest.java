package test;

import com.Employee;
import org.junit.Test;
import org.springframework.expression.spel.ast.NullLiteral;
import test.entity.MyFun;
import test.entity.People;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {
    List<Employee> list = Arrays.asList(new Employee("yyh", 12, 21l),
            new Employee("yym", 14, 21l), new Employee("fyr", 10, 21l),
            new Employee("yygg", 9, 22l), new Employee("cds", 112, 29l));

    @Test
    public void test1() {
        Collections.sort(list, (x1, x2) -> x2.getAge() - x1.getAge());
        for (Employee e : list) {
            System.out.println(e.getName());
        }
    }

    private static String hasPropertiesNull(Object obj, Class cls) {
        //显示类的结构
        //showClassName(cls);
        //System.out.println("---------------------------------");
        String cname = cls.getName();
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);//使私有属性可以访问
            int modifiers = f.getModifiers();
            if (Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {//常量字段不处理
                continue;
            }
            Object fieldVal;
            try {
                fieldVal = f.get(obj);
                boolean isNull = isEmpty(fieldVal);
                if (isNull) {
                    System.out.println("属性：" + f.getName() + "不可为空");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //当前类不是Object
        if (!cname.equals("java.lang.Object")) {
            hasPropertiesNull(obj, cls.getSuperclass());
        }

        return "";
    }

    private static boolean isEmpty(Object valObj) {
        if (valObj == null) {
            return true;
        } else if (valObj instanceof String && String.valueOf(valObj).equals("")) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test2() throws InterruptedException {
        //Consumer<String> con = (x)-> System.out.println(x);
        Consumer<String> con = System.out::println;
        con.accept("hello,nihao");

    }

    @Test
    public void testSupplier() {
       // Function<String, Employee> fun = (x) -> new Employee(x);
        Function<String,Employee> fun = Employee::new;
        Employee hello = fun.apply("hello");
        System.out.println(hello);
    }

}

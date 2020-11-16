package test;

import org.junit.Test;
import org.springframework.expression.spel.ast.NullLiteral;
import test.entity.People;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class LambdaTest {

    @Test
    public void test1() {
        People p = new People( "12", 12);
        hasPropertiesNull(p,p.getClass());
    }

    private static String hasPropertiesNull(Object obj,Class cls){
        //显示类的结构
        //showClassName(cls);
        //System.out.println("---------------------------------");
        String cname = cls.getName();
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field f : declaredFields){
            f.setAccessible(true);//使私有属性可以访问
            int modifiers = f.getModifiers();
            if(Modifier.isFinal(modifiers)&&Modifier.isStatic(modifiers)){//常量字段不处理
                continue;
            }
            Object fieldVal;
            try{
                fieldVal = f.get(obj);
                boolean isNull = isEmpty(fieldVal);
                if(isNull){
                    System.out.println("属性："+f.getName()+"不可为空");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //当前类不是Object
        if (!cname.equals("java.lang.Object")) {
            hasPropertiesNull(obj,cls.getSuperclass());
        }

        return "";
    }
    private static boolean isEmpty(Object valObj){
        if(valObj == null){
            return true;
        }else if(valObj instanceof String&&String.valueOf(valObj).equals("")){
            return true;
        }else{
           return false;
        }
    }

}

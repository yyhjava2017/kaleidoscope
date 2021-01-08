package test.com.yyh.lambdaFun;

public class LambdaTest {
    public static void getValue(String str,FunOne funOne){
        Character tag = funOne.getFirstCharUpperCase(str);
        System.out.println(tag);
    }
}

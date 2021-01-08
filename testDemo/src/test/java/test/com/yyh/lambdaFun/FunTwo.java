package test.com.yyh.lambdaFun;

@FunctionalInterface
public interface FunTwo<T,R> {
    R getVal(T t);
}

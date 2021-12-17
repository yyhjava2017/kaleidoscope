package test;

import com.pojo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {
    @Test
    public void test(){
        //实现了collection接口的集合，可以用stream()方法获取。
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //Arrays的静态方法stream，需要数组作为参数（数据源）
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);
        //通过Stream类中的of()方法。
        Stream<Employee> employees1 = Stream.of(employees);
        Stream<String> stringStream = Stream.of("12", "323", "232");
        //

    }
}

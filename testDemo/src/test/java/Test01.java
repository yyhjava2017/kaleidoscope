import com.TestApplication;
import com.rabbitmq.service.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class Test01 {
    @Autowired
    private OrderServiceImpl service;

    /**
     * 生产者
     */
    @Test
    public void contestLoads(){
        service.makeOrder("1","1",12);
    }

    /**
     * 消费者
     */

}

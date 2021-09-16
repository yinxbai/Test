import com.yq.rabbitmq.RabbitmqApplication;
import com.yq.rabbitmq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import java.nio.charset.StandardCharsets;

/**
 * @author InRoota
 * @date 2021-06-26  16:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class RabbitmqProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send(){
        for (int i = 0; i < 10; i++) {
            String body = "I AM TIRED:ARE YOU?"+i;
            if (i%2==0){
                rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME,"sms",body.getBytes(StandardCharsets.UTF_8));
            }else {
                rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, "email", body.getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}

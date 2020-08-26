package core.mq.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2019/9/27 13:35
 * @Modified by:
 */

public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";

            for (int i = 0; i < 1000; i++) {

                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            }


            System.out.println(" [x] Sent '" + message + "'");

        }

    }
}

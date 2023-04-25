package jw.hospital.order.receiver;

import jw.hospital.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OrderReceiver {

    @Autowired  // 监听定时任务的消息 即我是定时任务消费者
    private OrderService orderService;


}

package jw.hospital.ronlianyun.receiver;

import com.rabbitmq.client.Channel;
import jw.hospital.rabbitmq.constant.MqConst;
import jw.hospital.ronlianyun.service.RLYService;
import jw.hospital.vo.msm.MsmVo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author JX
 * @date 2021/9/6 - 12:11
 * @content
 */
@Component
public class SmsReceiver {
  @Autowired
  private RLYService rlyService;
  @RabbitListener(bindings = @QueueBinding(
          value = @Queue(value = MqConst.QUEUE_MSM_ITEM, durable = "true"),
          exchange = @Exchange(value = MqConst.EXCHANGE_DIRECT_MSM),
          key = {MqConst.ROUTING_MSM_ITEM}
  ))
  public void send(MsmVo msmVo, Message message, Channel channel) {
    //短信消费者！ 将短信消息取出来，放入send()方法，send方法里面是调用容联运短信功能
    System.out.println("收到"+msmVo);
    rlyService.send(msmVo);
  }

}

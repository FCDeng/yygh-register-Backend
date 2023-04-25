package jw.hospital.msm.receiver;

import jw.hospital.msm.service.MsmService;
import jw.hospital.vo.msm.MsmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsmReceiver {

    @Autowired
    private MsmService smsService;

//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = MqConst.QUEUE_MSM_ITEM, durable = "true"),
//            exchange = @Exchange(value = MqConst.EXCHANGE_DIRECT_MSM),
//            key = {MqConst.ROUTING_MSM_ITEM}
//    ))
    public void send(MsmVo msmVo) {
        smsService.send(msmVo);
    }
}

package jw.hospital.ronlianyun.controller;

import io.swagger.annotations.Api;
import jw.hospital.common.result.Result;
import jw.hospital.ronlianyun.service.RLYService;
import jw.hospital.ronlianyun.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author JX
 * @date 2021/8/29 - 14:32
 * @content
 */
@RestController
@RequestMapping("/api/rly")
@Api("获取验证码接口")
public class RLYController {

  @Autowired
  private RLYService RLYService;

  @Autowired
  private RedisTemplate<String,String> redisTemplate;

  //发送手机验证码
  @GetMapping("send/{phone}")
  public Result sendCode(@PathVariable String phone) {
    //从redis获取验证码，如果获取到，即代表已经发送验证码给用户了，则不重复生成验证码，返回ok
    // key 手机号  value 验证码
    String code = redisTemplate.opsForValue().get(phone);
    if(!StringUtils.isEmpty(code)) {
      return Result.ok();
    }

    //如果从redis获取不到，
    // 生成验证码,验证码的生成调用我们的工具类RandomUtil.getSixBitRandom()
    //验证码还是需要我们自己生成的，容联云只是帮我们发送给用户手机
    code = RandomUtil.getSixBitRandom();
    System.out.println(code);

    //调用service方法，通过整合短信服务进行发送
    boolean isSend = RLYService.send(phone,code);
    //生成验证码放到redis里面，设置有效时间 , 这里设置有效时间是2分钟
    if(isSend) {
      redisTemplate.opsForValue().set(phone,code,2, TimeUnit.MINUTES);
      return Result.ok();
    } else {
      return Result.fail().message("发送短信失败");
    }
  }





}

package jw.hospital.ronlianyun.service;

import jw.hospital.vo.msm.MsmVo;

/**
 * @author JX
 * @date 2021/8/29 - 14:44
 * @content
 */
public interface RLYService {
  //发送手机验证码
  boolean send(String phone, String code);

  boolean send(MsmVo msmVo);

}

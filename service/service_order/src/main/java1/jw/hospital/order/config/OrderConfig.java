package jw.hospital.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@MapperScan("jw.hospital.order.mapper")
public class OrderConfig {

}

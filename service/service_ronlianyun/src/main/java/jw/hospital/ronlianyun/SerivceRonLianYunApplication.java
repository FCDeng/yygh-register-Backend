package jw.hospital.ronlianyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author JX
 * @date 2021/8/29 - 14:26
 * @content
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan(basePackages = {"jw.hospital"})
public class SerivceRonLianYunApplication {
  public static void main(String[] args) {
    SpringApplication.run(SerivceRonLianYunApplication.class,args);
  }
}

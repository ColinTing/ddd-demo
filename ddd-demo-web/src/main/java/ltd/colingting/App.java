package ltd.colingting;

import ltd.colingting.application.config.SwordProto;
import ltd.colingting.application.config.WeaponPrototype;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *  启动类
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties({SwordProto.class, WeaponPrototype.class})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

package com.durp.consul;

import com.durp.consul.config.ConfigProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
//@EnableConfigurationProperties(ConfigProperty.class)
public class ConsulServerApplication {

    @Autowired
    private ConfigProperty configProperty;

    @Value("${server.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(ConsulServerApplication.class, args);
    }

    @RequestMapping("test")
    public String test() {
        return configProperty.getKey() == null ? "null" : configProperty.getKey() + "-" + port;
    }

}

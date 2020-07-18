package com.javatechie.springboot.loadbalancer.userapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@RibbonClient(name ="spring-boot-loadbalancer-chatbook" , configuration = RibbonConfiguration.class)
public class SpringBootLoadbalancerUserappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoadbalancerUserappApplication.class, args);
    }

    @Autowired
    private RestTemplate template;

    @GetMapping("/invoke")
    public String invokeChatBook()
    {
        String url = "http://localhost:8081/chatbook-application/chat";
        template.getForObject("", String.class);
        return "Hi";
    }

    @Bean
    @LoadBalanced
    public RestTemplate template()
    {
        return  new RestTemplate();
    }

}

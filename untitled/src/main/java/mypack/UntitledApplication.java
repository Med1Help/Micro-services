package mypack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UntitledApplication {
    public static void main(String[] args) {
        SpringApplication.run(UntitledApplication.class,args);
        System.out.println("Hello world");
    }
}

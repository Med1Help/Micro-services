package mypack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FraudApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class,args);
        System.out.println("Hello world from Fraud");
    }
}
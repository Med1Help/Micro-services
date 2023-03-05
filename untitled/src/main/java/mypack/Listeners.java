package mypack;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listeners {
    @KafkaListener(
            topics = "mymicrofromspring/*",
            groupId = "mygroup"
    )
    public void listener(String data){
        System.out.println("Data received: "+data+" ");
    }
}

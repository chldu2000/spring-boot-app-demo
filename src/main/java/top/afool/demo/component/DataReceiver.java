package top.afool.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class DataReceiver {

    @Bean
    Consumer<String> inputChannel() {
        return message -> {
            log.info("Received: {}", message);
        };
    }
}
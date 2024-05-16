package top.afool.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StreamService {

    private static final String OUTPUT_BINDING = "outputChannel-out-0";

    @Autowired
    private StreamBridge streamBridge;

    public boolean sendToOutputChannel(String message) {
        log.info("Sending: {}", message);
        return streamBridge.send(OUTPUT_BINDING, message);
    }
}

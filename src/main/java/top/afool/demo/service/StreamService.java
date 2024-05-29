package top.afool.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StreamService<T> {

    /**
     * Here not using Supplier which requires function definition
     * So binding name seems can be without direction and index
     */
    private static final String OUTPUT_BINDING = "outputChannel";

    @Autowired
    private StreamBridge streamBridge;

    public boolean sendToOutputChannel(T message) {
        log.info("Sending: {}", message);
        return streamBridge.send(OUTPUT_BINDING, message); // T message will be wrapped by Message object
    }
}

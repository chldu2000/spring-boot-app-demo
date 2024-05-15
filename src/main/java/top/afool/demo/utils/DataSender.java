package top.afool.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class DataSender<T> {

    @Autowired
    private StreamBridge streamBridge;

    public boolean send(String bindingName, T message) {
        return streamBridge.send(bindingName, message);
    }
}

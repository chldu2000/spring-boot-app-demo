package top.afool.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.afool.demo.utils.DataSender;

@Service
public class StreamService {

    private static final String OUTPUT_BINDING = "output-channel-out-0";

    @Autowired
    private DataSender<String> stringSender;

    public boolean sendToOutputChannel(String message) {
        return stringSender.send(OUTPUT_BINDING, message);
    }
}

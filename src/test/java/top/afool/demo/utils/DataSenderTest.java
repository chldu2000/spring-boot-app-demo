package top.afool.demo.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import top.afool.demo.DemoApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataSenderTest {

    String OUTPUT_BINDING = "output-channel-out-0";

    @Test
    public void testSend() {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(
                TestChannelBinderConfiguration.getCompleteConfiguration(DemoApplication.class)
        ).web(WebApplicationType.NONE).run();

        DataSender dataSender = context.getBean(DataSender.class);
        OutputDestination outputDestination = context.getBean(OutputDestination.class);

        assertTrue(dataSender.send(OUTPUT_BINDING, "test"));

        Message<byte[]> received = outputDestination.receive(1000, OUTPUT_BINDING);
        String payload = new String(received.getPayload());

        assertEquals(payload, "test");
    }
}

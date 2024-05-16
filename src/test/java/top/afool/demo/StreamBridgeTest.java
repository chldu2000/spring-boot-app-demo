package top.afool.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamBridgeTest {

    String OUTPUT_BINDING = "output-channel-out-0";

    @Test
    public void testSend() {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(
                TestChannelBinderConfiguration.getCompleteConfiguration(DemoApplication.class)
        ).web(WebApplicationType.NONE).run();

        StreamBridge streamBridge = context.getBean(StreamBridge.class);
        OutputDestination outputDestination = context.getBean(OutputDestination.class);

        assertTrue(streamBridge.send(OUTPUT_BINDING, "test"));

        Message<byte[]> received = outputDestination.receive(1000, OUTPUT_BINDING);
        String payload = new String(received.getPayload());

        assertEquals(payload, "test");
    }
}

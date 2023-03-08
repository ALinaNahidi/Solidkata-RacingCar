package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.services.ReceiveService;

import java.util.Random;

public class ReceiveTelementryImpl implements ReceiveService {

    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private String diagnosticMessageResult = "";
    private final Random connectionEventsSimulator = new Random(42);


    @Override
    public String receive() {
        StringBuilder message;

        if (diagnosticMessageResult == null || "".equals(diagnosticMessageResult))
        {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = new StringBuilder();
            int messageLength = connectionEventsSimulator.nextInt(50) + 60;
            for(int i = messageLength; i >=0; --i)
            {
                message.append((char) connectionEventsSimulator.nextInt(40) + 86);
            }

        }
        else
        {
            message = new StringBuilder(diagnosticMessageResult);
            diagnosticMessageResult = "";
        }

        return message.toString();
    }

}

package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.services.SendService;

public class SendTelementryImpl implements SendService {

    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private String diagnosticMessageResult = "";

    @Override
    public void send(String message) {
        if (message == null || "".equals(message))
        {
            throw new IllegalArgumentException();
        }

        if (message.equals(DIAGNOSTIC_MESSAGE))
        {
            // simulate a status report
            diagnosticMessageResult =
                    "LAST TX rate................ 100 MBPS\r\n"
                            + "HIGHEST TX rate............. 100 MBPS\r\n"
                            + "LAST RX rate................ 100 MBPS\r\n"
                            + "HIGHEST RX rate............. 100 MBPS\r\n"
                            + "BIT RATE.................... 100000000\r\n"
                            + "WORD LEN.................... 16\r\n"
                            + "WORD/FRAME.................. 511\r\n"
                            + "BITS/FRAME.................. 8192\r\n"
                            + "MODULATION TYPE............. PCM/FM\r\n"
                            + "TX Digital Los.............. 0.75\r\n"
                            + "RX Digital Los.............. 0.10\r\n"
                            + "BEP Test.................... -5\r\n"
                            + "Local Rtrn Count............ 00\r\n"
                            + "Remote Rtrn Count........... 00";

        }

        // here should go the real Send operation (not needed for this exercise)

    }
}

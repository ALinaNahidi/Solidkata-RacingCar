package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.services.TelemetryService;

import java.util.Random;

public class TelemetryClient implements TelemetryService
{
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private boolean onlineStatus;
    private String diagnosticMessageResult = "";

    private final Random connectionEventsSimulator = new Random(42);

    public boolean getOnlineStatus()
    {
        return onlineStatus; 
    }

    public void connect(String telemetryServerConnectionString)
    {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
        {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        onlineStatus = success;
    }

    public void disconnect()
    {
        onlineStatus = false;
    }

}


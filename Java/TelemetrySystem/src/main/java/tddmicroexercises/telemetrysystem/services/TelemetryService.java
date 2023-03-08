package tddmicroexercises.telemetrysystem.services;

public interface TelemetryService {
    void connect(String telemetryServerConnectionString);
    void disconnect();
    boolean getOnlineStatus();
    void send(String message);
    String receive();
}

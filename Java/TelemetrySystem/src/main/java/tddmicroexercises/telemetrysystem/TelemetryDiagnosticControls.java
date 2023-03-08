package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.services.TelemetryDiagnosticControlsService;
import tddmicroexercises.telemetrysystem.services.TelemetryService;

public class TelemetryDiagnosticControls implements TelemetryDiagnosticControlsService
{
    private final String DiagnosticChannelConnectionString = "*111#";
    
    private final TelemetryClient telemetryClient;
    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls(TelemetryService telemetryClient)
        {
            this.telemetryClient = new TelemetryClient();
        }
        
        public String getDiagnosticInfo(){
            return diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            telemetryClient.disconnect();
    
            int retryLeft = 3;
            while (!telemetryClient.getOnlineStatus() && retryLeft > 0)
            {
                telemetryClient.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(!telemetryClient.getOnlineStatus())
            {
                throw new Exception("Unable to connect.");
            }
    
            telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = telemetryClient.receive();
    }
}

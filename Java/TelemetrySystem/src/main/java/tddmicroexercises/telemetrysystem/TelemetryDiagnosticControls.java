package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.services.ReceiveService;
import tddmicroexercises.telemetrysystem.services.SendService;
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

            SendService sendService = new SendTelementryImpl();
            sendService.send(TelemetryClient.DIAGNOSTIC_MESSAGE);

            ReceiveService receiveService = new ReceiveTelementryImpl();
            diagnosticInfo = receiveService.receive();
    }
}

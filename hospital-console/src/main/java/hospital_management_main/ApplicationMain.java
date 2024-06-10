package hospital_management_main;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.StageFactory;
import dashboard.DashBoardScreen;
import javafx.application.Application;
import javafx.stage.Stage;
import login.LoginScreen;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;


public class ApplicationMain extends Application {
	public static void main(String args[]) {
		launch(args);
	}
	@Override
	public void start(Stage stage)throws Exception {

		StageFactory.stage = stage;
		
		//usermanagementScreen.showUserManagementScreen();
		//CaseManagementScreen.showCaseManagementScreen();
		//PatientManagementScreen.showPatientManagementScreen();
		//AppointMentScreen.showAppointmententScreen();
		LoginScreen.showLoginScreen();
		//DashBoardScreen.showDashboardScreen();
	
	}
}

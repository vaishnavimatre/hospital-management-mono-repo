package dashboard;

import add_user.AddUserScreen;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import edit_user.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_management.PatientManagementScreen;
import search_user.SearchUserScreen;
import user_management.usermanagementScreen;

public class DashboardScreenController {

  @FXML private Button Dashboard;

  @FXML private Button Appointments;

  @FXML private Button Cases;

  @FXML private Button Patients;
  
  @FXML private Button Users;
  
  @FXML private Button Logout;

  public void Appointments(ActionEvent event) {
   AppointMentScreen.showAppointmententScreen();
  }

  public void Cases(ActionEvent event) {
   CaseManagementScreen.showCaseManagementScreen();
  }

  public void Users(ActionEvent event) {
   usermanagementScreen.showUserManagementScreen();
  }

  public void Patients(ActionEvent event) {
	  PatientManagementScreen.showPatientManagementScreen();
  }
 public void Dashboard(ActionEvent event) {
	 DashBoardScreen.showDashboardScreen();
  }

public void Logout(ActionEvent event) {
	  
 }
}


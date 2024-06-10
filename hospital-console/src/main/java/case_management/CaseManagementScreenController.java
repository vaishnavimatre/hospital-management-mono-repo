package case_management;
import add_case.AddCaseScreen;
import appointment_management.AppointMentScreen;
import dashboard.DashBoardScreen;
import delete_case.DeleteCaseScreen;
import edit_case.EditCaseScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_management.PatientManagementScreen;
import search_case.SearchCaseScreen;
import user_management.usermanagementScreen;

public class CaseManagementScreenController {

		

		@FXML
		private Button AddCase;
		
		@FXML
		private Button EditCase;
		
		@FXML
		private Button SearchCase;
		
		@FXML
		private Button DeleteCase;
		

		  @FXML private Button Appointments;
		  @FXML private Button Users;
		  @FXML private Button Patients;
		  @FXML private Button Dashboard;
		  @FXML private Button Cases;
		

				
				
				
		
		     public void  AddCase(ActionEvent event) {
		    	 AddCaseScreen.showAddCaseScreen();
		 
		  	}
		     public void  EditCase(ActionEvent event) {
		 	EditCaseScreen.showEditCaseScreen();
		 	}
		     
		     public void  SearchCase(ActionEvent event) {
		    SearchCaseScreen.showSearchCaseScreen();
		    	
			 	}
		     
		     public void  DeleteCase(ActionEvent event) {
			DeleteCaseScreen.showDeleteCaseScreen();
				 	}

		     public void Dashboard(ActionEvent event) {
		       DashBoardScreen.showDashboardScreen();
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
		     

		     public void Appointments(ActionEvent event) {
		       AppointMentScreen.showAppointmententScreen();
		     }
		
		}
	



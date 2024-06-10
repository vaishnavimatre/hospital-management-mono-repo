package user_management;




import add_user.AddUserScreen;
import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import dashboard.DashBoardScreen;
import delete_user.DeleteUser.DeleteUserScreen;
import edit_user.EditUserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_management.PatientManagementScreen;
import search_user.SearchUserScreen;

public class UserManagementScreenController {	
	


	  @FXML private Button Appointments;
	  @FXML private Button Users;
	  @FXML private Button Patients;
	  @FXML private Button Dashboard;
	  @FXML private Button Cases;

		@FXML
		private Button AddUser;
		
		@FXML
		private Button EditUser;
		
		@FXML
		private Button SearchUser;
		
		@FXML
		private Button DeleteUser ;
		

				
				
				
		
		     public void  AddUser(ActionEvent event) {
		    AddUserScreen.showAddUserScreen();	
		  		
		  	}
		     public void  EditUser(ActionEvent event) {
		 		EditUserScreen.showEditUserScreen();
		 	}
		     
		     public void  SearchUser(ActionEvent event) {
		    	 SearchUserScreen.showSearchUserScreen();
		    	
			 	}
		     
		     public void  DeleteUser(ActionEvent event) {
			DeleteUserScreen.showDeleteCaseScreen();
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
	



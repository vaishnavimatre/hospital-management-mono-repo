package add_user;



import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.CaseRequest;
import dto.CaseResponse;
import dto.DirectoryServiceRequest;
import dto.DirectoryServiceResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class AddUserScreenController {

	  @FXML 
	  private Button Save;

	  @FXML 
	  private Button Back;

	  @FXML
	  	private  TextField username;
	  	
	  	@FXML
	  	private TextField email;
	  	
	  	@FXML
	  	private  TextField password;
	  	
	  	@FXML
	  	private TextField confirm;
	  	

	  	@FXML
	  	private  TextField role;
	  	

	  	@FXML
	  	private  TextField mobno;

			
			  public void Save(ActionEvent event) throws IOException, InterruptedException{
					
					DirectoryServiceRequest adduserRequest = new DirectoryServiceRequest();
					
					
					adduserRequest.setUsername(username.getText());
					adduserRequest.setEmail(email.getText());
					adduserRequest.setPassword(password.getText());
					adduserRequest.setRole(role.getText());
					adduserRequest.setMobno(mobno.getText());
					adduserRequest.setConfirm(confirm.getText());
					
					try {
						DirectoryServiceResponse response = RestUtil.sendPostRequest("http://localhost:8081/api/v1/directory/add",DirectoryServiceResponse.class, adduserRequest);
						System.out.println("user  Added Successfully");
					}
					catch(IOException e) {
						e.printStackTrace();
					}
			  }

	  
	  
	  public void Back(ActionEvent event) {
		  usermanagementScreen.showUserManagementScreen();
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



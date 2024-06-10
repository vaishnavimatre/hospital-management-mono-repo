package search_user;




import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.DirectoryServiceRequest;
import dto.DirectoryServiceResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class SearchUserScreenController {

	  @FXML 
	  private Button Back;

	  @FXML 
	  private Button Delete;

	  @FXML 
	  private Button Edit;
	  

	  @FXML private Button Appointments;
	  @FXML private Button Users;
	  @FXML private Button Patients;
	  @FXML private Button Dashboard;
	  @FXML private Button Cases;

	  @FXML 
	  private Button Search;
	  @FXML
	  	private  TextField username;
	  
	  @FXML
	  	private  TextField userid;
	  	
	  	@FXML
	  	private TextField email;
	  	
	  	@FXML
	  	private  TextField password;
	  	
	  	
	  	@FXML
	  	private  TextField role;
	  	

	  	@FXML
	  	private  TextField mobno;
	  	

	  	@FXML
	  	private  TextField confirm;


	  public void Back(ActionEvent event) {
		  usermanagementScreen.showUserManagementScreen();
	  }
	  public void Edit(ActionEvent event) {
		   
	  }
	  public void Search(ActionEvent event) {
		  String userIdText= userid.getText().trim();
		
		 
		    DirectoryServiceResponse response = null;

		    try {
		      if (!userIdText.isEmpty()) {
		    	  Long userId = Long.parseLong(userIdText);
		        response =
		            RestUtil.sendGetRequest(
		                "http://localhost:8081/api/v1/directory/" +userId,  DirectoryServiceResponse.class);
		      } 

		    
				DirectoryServiceRequest adduserRequest = new DirectoryServiceRequest();
				
				
				email.setText(response.getEmail());
				password.setText(response.getPassword());
				username.setText(response.getUsername());
				role.setText(response.getRole());
				mobno.setText(response.getMobno());
				confirm.setText(response.getConfirm());
				
		       
		     
		    } catch (Exception e) {
		      e.printStackTrace();
		     
		    }
		   
	  }
	  
	  public void Delete(ActionEvent event) {
		
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



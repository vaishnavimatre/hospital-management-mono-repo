package add_patient;

import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.AppointmentRequest;
import dto.AppointmentResponse;
import dto.PatientRequest;
import dto.PatientResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class AddPatientScreenController {
	
			  @FXML 
			  private Button Save;

			  @FXML 
			  private Button Back;
			  

			  @FXML private Button Appointments;
			  @FXML private Button Users;
			  @FXML private Button Patients;
			  @FXML private Button Dashboard;
			  @FXML private Button Cases;
			  
			  @FXML
				private  TextField patient_name_english;
				
				@FXML
				private TextField patient_id;
				
				@FXML
				private  TextField patient_name_marathi;
				
				@FXML
				private TextField mobile_number;
				

				@FXML
				private  TextField gender;
				

				@FXML
				private  TextField birth_date;


				@FXML
				private  TextField  first_examination_date;

				@FXML
				private  TextField address;

				
				  public void Save(ActionEvent event) throws IOException, InterruptedException{
						
				    PatientRequest addpatientRequest = new PatientRequest();
						
				    addpatientRequest.setPatient_name_marathi( patient_name_marathi.getText());
				    addpatientRequest.setPatient_name_english( patient_name_english.getText()); 
				    addpatientRequest.setMobile_number( mobile_number.getText());
				    addpatientRequest.setGender(gender.getText()); 
				    addpatientRequest.setFirst_examination_date( first_examination_date.getText());
				    addpatientRequest.setBirth_date(birth_date.getText()); 
				    addpatientRequest.setAddress(address.getText());
				    
						
						try {
							PatientResponse response = RestUtil.sendPostRequest("http://localhost:8082/api/v1/patient/add",PatientResponse.class, addpatientRequest);
							System.out.println("patient  Added Successfully");
						}
						catch(IOException e) {
							e.printStackTrace();
						}
				  }
			  public void Back(ActionEvent event) {
				  PatientManagementScreen.showPatientManagementScreen();
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







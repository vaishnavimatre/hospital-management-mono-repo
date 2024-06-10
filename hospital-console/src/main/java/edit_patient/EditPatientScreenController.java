package edit_patient;



import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.DirectoryServiceRequest;
import dto.PatientRequest;
import dto.PatientResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;
public class EditPatientScreenController {
	


		
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
			  private Button Edit;
			  
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

				


			  public void Edit(ActionEvent event) {
				  String patientidText= patient_id.getText().trim();
					
					 
				    PatientResponse response = null;

				    try {
				      if (!patientidText.isEmpty()) {
				    	  Long patientIds = Long.parseLong(patientidText);
				        response =
				            RestUtil.sendGetRequest(
				                "http://localhost:8082/api/v1/patient/" +patientIds, PatientResponse.class);
				      } 

				    
						DirectoryServiceRequest adduserRequest = new DirectoryServiceRequest();
						
					patient_name_english.setText(response.getPatient_name_english());
						patient_name_marathi.setText(response.getPatient_name_marathi());
						mobile_number.setText(response.getMobile_number());
						gender.setText(response.getGender());
						birth_date.setText(response.getBirth_date());
						first_examination_date.setText(response.getFirst_examination_date());
						address.setText(response.getAddress());
				
				    } catch (Exception e) {
				      e.printStackTrace();
				     
				    }
			   
			  }
			


			  
			  public void Save(ActionEvent event) throws IOException,  InterruptedException {
					
				    PatientRequest updatepatientRequest = new PatientRequest();
						
				    updatepatientRequest.setPatient_name_marathi( patient_name_marathi.getText());
				    updatepatientRequest.setPatient_name_english( patient_name_english.getText()); 
				    updatepatientRequest.setMobile_number( mobile_number.getText());
				    updatepatientRequest.setGender(gender.getText()); 
				    updatepatientRequest.setFirst_examination_date( first_examination_date.getText());
				    updatepatientRequest.setBirth_date(birth_date.getText()); 
				    updatepatientRequest.setAddress(address.getText());
				    String patientidText= patient_id.getText().trim();
					
					 
				    PatientResponse response = null;
				    try {
					      if (!patientidText.isEmpty()) {
					    	  Long patientid = Long.parseLong(patientidText);
					        response =
					        		 RestUtil.sendPostRequest( "http://localhost:8082/api/v1/patient/" +patientid,PatientResponse.class, updatepatientRequest);
					        System.out.println("patient updated");
					      } 
				    }
					      catch (Exception e) {
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







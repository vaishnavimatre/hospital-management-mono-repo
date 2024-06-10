package search_appointment;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.AppointmentRequest;
import dto.AppointmentResponse;
import dto.DirectoryServiceRequest;
import dto.PatientResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;


public class SearchAppointmentScreenController {
	
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
					  private Button Search;
					  

					
						@FXML
						private  TextField patient_name;
						
						@FXML
						private TextField patient_id;
						
						@FXML
						private TextField appointment_ids;
						
						@FXML
						private  TextField appointment_id;
						
						@FXML
						private TextField appointment_time;
						

						@FXML
						private  TextField examination_date;

					  public void Save(ActionEvent event) {
					   
					  }
					  public void Search(ActionEvent event) {
						  String appointmentIdText=appointment_id.getText().trim();
							
							 
						  AppointmentResponse response = null;

						    try {
						      if (!appointmentIdText.isEmpty()) {
						    	  Long appointmentId = Long.parseLong(appointmentIdText);
						        response =
						            RestUtil.sendGetRequest(
						                "http://localhost:8083/api/v1/appointment/" +appointmentId ,  AppointmentResponse.class);
						      } 

						    
								AppointmentRequest adduserRequest = new AppointmentRequest();
								
							
								patient_name.setText(response.getPatient_name());
								patient_id.setText(response.getPatientid());
								examination_date.setText(response.getExamination_date());
								appointment_time.setText(response.getAppointment_time());
						
						    } catch (Exception e) {
						      e.printStackTrace();
						     
						    }
					   
					  }
					  
					  public void Back(ActionEvent event) {
						  AppointMentScreen.showAppointmententScreen();
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










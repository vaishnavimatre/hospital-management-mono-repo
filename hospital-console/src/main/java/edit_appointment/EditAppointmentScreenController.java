package edit_appointment;

import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.AppointmentRequest;
import dto.AppointmentResponse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;


public class EditAppointmentScreenController {
	
	@FXML
	private  TextField patient_name;
	
	@FXML
	private TextField patient_ids;
	
	@FXML
	private TextField patient_id;
	
	@FXML
	private  TextField appointment_id;
	
	@FXML
	private TextField appointment_time;
	

	  @FXML private Button Appointments;
	  @FXML private Button Users;
	  @FXML private Button Patients;
	  @FXML private Button Dashboard;
	  @FXML private Button Cases;
	

	@FXML
	private  TextField examination_date;
	
					  @FXML 
					  private Button Save;

					  @FXML 
					  private Button Back;

					  @FXML 
					  private Button Edit;

					  public void Save(ActionEvent event) throws IOException, InterruptedException {
						  String patientIdStr = patient_id.getText();
			
						  
					       
					        
					        
						  AppointmentRequest addappointmentRequest = new AppointmentRequest();
							
							addappointmentRequest.setAppointment_time( appointment_time.getText());
							addappointmentRequest.setAppointment_id(Integer.parseInt(appointment_id.getText())); 
							addappointmentRequest.setExamination_date(examination_date.getText());
							addappointmentRequest.setPatient_name(patient_name.getText());
							
							
							try {

					            long patientid = Integer.parseInt(patientIdStr);
								AppointmentResponse response = RestUtil.sendPostRequest("http://localhost:8083/api/v1/appointment/" + patientid ,AppointmentResponse.class, addappointmentRequest);
								System.out.println("Appointment  updated Successfully");
							}
							catch(IOException e) {
								e.printStackTrace();
							}

					  }
					  
					  
					  public void Edit(ActionEvent event) {
						  String appointmentIdText=appointment_id.getText().trim();
							
							 
						  AppointmentResponse response = null;

						    try {
						      if (!appointmentIdText.isEmpty()) {
						    	  long appointmentId =  Integer.parseInt(appointmentIdText);
						        response =
						            RestUtil.sendGetRequest(
						                "http://localhost:8083/api/v1/appointment/"+appointmentId ,  AppointmentResponse.class);
						      } 

						    
			
								
							
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











package add_case;


import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.AppointmentResponse;
import dto.CaseRequest;
import dto.CaseResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class AddCaseScreenController {
	
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
		  	private  TextField patientNameInEnglish;
		  	
		  	@FXML
		  	private TextField patient_id;
		  	
		  	@FXML
		  	private  TextField caseNumber;
		  	
		  	@FXML
		  	private TextField examinationDate;
		  	

		  	@FXML
		  	private  TextArea symptoms;
		  	
			@FXML
		  	private  TextArea prescription;
		  
		  
			  
			  				
			  				  public void Save(ActionEvent event) throws IOException, InterruptedException{
			  						
			  						CaseRequest addcaseRequest = new CaseRequest();
			  						
			  						
			  						 addcaseRequest.setCaseNumber(caseNumber.getText()); 
			  						 addcaseRequest.setPatientNameInEnglish(patientNameInEnglish.getText());
			  						 addcaseRequest.setPatient_id(patient_id.getText());
			  						addcaseRequest.setExaminationDate(examinationDate.getText());
			  						 addcaseRequest.setPrescription(prescription.getText());
			  						 addcaseRequest.setSymptoms( symptoms.getText());
			  						
			  						
			  						try {
			  							CaseResponse response = RestUtil.sendPostRequest("http://localhost:8084/api/v1/case/add",CaseResponse.class, addcaseRequest);
			  							System.out.println("Case  Added Successfully");
			  						}
			  						catch(IOException e) {
			  							e.printStackTrace();
			  						}
			  				  }

			  
		  
		  public void Back(ActionEvent event) {
			  CaseManagementScreen.showCaseManagementScreen();
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





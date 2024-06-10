package edit_case;
import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.CaseRequest;
import dto.CaseResponse;
import dto.DirectoryServiceResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;
public class EditCaseScreenController {



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
		  	private  TextField patient_name;
		  	
		
		  	
		  	@FXML
		  	private TextField patient_id;
		  	
			@FXML
		  	private TextField case_id;
		  	
		  	
		  	
		  	@FXML
		  	private  TextField caseNumber;
		  	
		  	@FXML
		  	private TextField prescription;
		  	

		  	@FXML
		  	private  TextField symptoms;
		  

				  public void Save(ActionEvent event) throws IOException, InterruptedException{
						
						CaseRequest updatecaseRequest = new CaseRequest();
						
						
						updatecaseRequest.setCaseNumber(caseNumber.getText()); 
						updatecaseRequest.setPatientNameInEnglish(patient_name.getText());
						updatecaseRequest.setPatient_id(patient_id.getText());
						updatecaseRequest.setPrescription(prescription.getText());
						updatecaseRequest.setSymptoms( symptoms.getText());
						
						CaseResponse response
					    = null;
					    String caseIdText= case_id.getText().trim();

					    try {
						      if (!caseIdText.isEmpty()) {
						    	  Long caseid = Long.parseLong(caseIdText);
						    	  response = RestUtil.sendPostRequest("http://localhost:8084/api/v1/case/"+caseid,CaseResponse.class, updatecaseRequest);
									System.out.println("Case  upded Successfully");
						      } 
					    }
						
		
						catch(IOException e) {
							e.printStackTrace();
						}
				  }

		

		  public void Edit(ActionEvent event) {
							  String CaseidText=  case_id.getText().trim();
				
				 
				    CaseResponse response = null;

				    try {
				      if (!CaseidText.isEmpty()) {
				    	  Long caseId = Long.parseLong(CaseidText);
				        response =
				            RestUtil.sendGetRequest(
				                "http://localhost:8084/api/v1/case/" + caseId,  CaseResponse.class);
				        System.out.println("Case  searched Successfully");
				      } 

				    
						//CaseRequest addcaseRequest = new CaseRequest();
						
						patient_id.setText(response.getPatient_id());
						patient_name.setText(response.getPatientNameInEnglish());
						prescription.setText(response.getExaminationDate());
						 symptoms.setText(response.getPrescription());
						 caseNumber.setText(response.getCaseNumber());
				       
				     
				    } catch (Exception e) {
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






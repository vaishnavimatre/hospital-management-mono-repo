package search_case;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.CaseResponse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class SearchCaseScreenController {
	
			  @FXML 
			  private Button Save;

			  @FXML 
			  private Button Back;

			  
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
			  	private  TextField patient_id;
			  	
			  	@FXML
			  	private TextField case_id;
			  	
			  	@FXML
			  	private  TextField caseNumber;
			  	
			  	
			  	@FXML
			  	private  TextField symptoms;
			  	
			  	@FXML
			  	private  TextField  patient_name;
			  	
			  	
			 	@FXML
			  	private  TextField prescription;
			  
			
			  public void Search(ActionEvent event) {
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
				    
			  public void Edit(ActionEvent event) {
			   
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







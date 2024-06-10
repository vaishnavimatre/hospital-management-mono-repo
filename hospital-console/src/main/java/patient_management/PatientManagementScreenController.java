package patient_management;

import add_patient.AddPatientScreen;
import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import dashboard.DashBoardScreen;
import delete_patient.DeletePatientScreen;
import edit_patient.EditPatientScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_patient.SearchPatientScreen;
import user_management.usermanagementScreen;
public class PatientManagementScreenController {
	
				  @FXML 
				  private Button AddPatient;

				  @FXML 
				  private Button EditPatient;
				  
				  @FXML 
				  private Button  SearchPatient;

				  @FXML private Button Appointments;
				  @FXML private Button Users;
				  @FXML private Button Patients;
				  @FXML private Button Dashboard;
				  @FXML private Button Cases;
				  @FXML 
				  private Button DeletePatient;

				  public void AddPatient(ActionEvent event) {
				   AddPatientScreen.showAddPatientScreen();
				  }
				  
				  public void  EditPatient(ActionEvent event) {
					  EditPatientScreen.showEditPatientScreen();
					  
					  		  }
				  public void SearchPatient(ActionEvent event) {
					   SearchPatientScreen.showSearchPatientScreen();
				  }
				  
				  public void  DeletePatient(ActionEvent event) {
					  DeletePatientScreen.showDeletePatientScreen();
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








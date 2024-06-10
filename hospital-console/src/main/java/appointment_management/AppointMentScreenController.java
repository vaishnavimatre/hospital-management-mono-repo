package appointment_management;

import add_appointment.AddAppointmentScreen;
import case_management.CaseManagementScreen;
import dashboard.DashBoardScreen;
import delete_appointment.DeleteAppointmentScreen;
import edit_appointment.EditAppointmentScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_management.PatientManagementScreen;
import search_appointment.SearchAppointmentScreen;
import user_management.usermanagementScreen;
public class AppointMentScreenController {

					  @FXML 
					  private Button AddAppointment;

					  @FXML 
					  private Button EditAppointment;
					  
					  @FXML 
					  private Button  SearchAppointment;

					  @FXML 
					  private Button DeleteAppointment;


					  @FXML private Button Appointments;
					  @FXML private Button Users;
					  @FXML private Button Patients;
					  @FXML private Button Dashboard;
					  @FXML private Button Cases;
					  public void AddAppointment(ActionEvent event) {
					   AddAppointmentScreen.showAddAppointmentScreen();
					  }
					  
					  public void  EditAppointment(ActionEvent event) {
						 EditAppointmentScreen.showEditAppointmentScreen();
						  
						  		  }
					  public void SearchAppointment(ActionEvent event) {
						  SearchAppointmentScreen.showSearchAppointmentScreen();
					  }
					  
					  public void  DeleteAppointment(ActionEvent event) {
						  DeleteAppointmentScreen.showDeleteAppointmentScreen();
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









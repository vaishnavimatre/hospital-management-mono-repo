package delete_appointment;

import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.AppointmentResponse;
import dto.CaseResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class DeleteAppointmentScreenController {

	  @FXML private Button Appointments;
	  @FXML private Button Users;
	  @FXML private Button Patients;
	  @FXML private Button Dashboard;
	  @FXML private Button Cases;
	  
	  @FXML private Button Delete;
	  @FXML private Button Search;

	  @FXML private TextField patientid;
	  @FXML private TextField patientIds;

	  @FXML private TextField appointment_id;

	  @FXML private TextField appointment_time;

	  @FXML private TextField examination_date;
	  
	  @FXML private TextField patient_name;

	  
	  public void Delete(ActionEvent event) throws IOException, InterruptedException {
		    String appointmentId = appointment_id.getText().trim();

		    try {
		      AppointmentResponse response =
		          RestUtil.sendDeleteRequest(
		              "http://localhost:8083/api/v1/appointment/" + appointmentId, AppointmentResponse.class);

		      System.out.println("Success\", \"Appointment deleted\", \"Appointment has been deleted successfully.\");");
		      patientIds.clear();
		      appointment_id.clear();
		      appointment_time.clear();
		      examination_date.clear();
		      patient_name.clear();
		      

		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }

		  public void Search(ActionEvent event) {
		    String patientId = patientid.getText().trim();
		  String appointmentId=appointment_id.getText().trim();
		  AppointmentResponse  response = null;
		    try {
		      if (!patientId.isEmpty()) {
		        response =
		            RestUtil.sendGetRequest(
		                "http://localhost:8083/api/v1/appointment/" + patientId, AppointmentResponse .class);
		      } else if (!appointmentId.isEmpty()) {

		    	long  appointmentid = Integer.parseInt(appointmentId);
		        response =
		            RestUtil.sendGetRequest(
		                "http://localhost:8083/api/v1/case/appointment/" + appointmentid, AppointmentResponse .class);
		      }
		      patientIds.setText(response.getPatientid());
		     // appointment_id.setText(response.);
		      appointment_time.setText(response.getAppointment_time());
		      examination_date.setText(response.getExamination_date());
		      patient_name.setText(response.getPatient_name());
		      
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		   
		  }
		  }

		  public void Cancel(ActionEvent event) throws IOException, InterruptedException {
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

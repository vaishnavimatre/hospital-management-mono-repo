package add_appointment;

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

public class AddAppointmentScreenController {

  @FXML private TextField patient_name;

  @FXML private Button Appointments;
  @FXML private Button Users;
  @FXML private Button Patients;
  @FXML private Button Dashboard;
  @FXML private Button Cases;

  @FXML private TextField patient_id;

  @FXML private TextField appointment_time;

  @FXML private TextField examination_date;

  @FXML private Button Save;

  @FXML private Button Back;

  public void Back(ActionEvent event) {
    AppointMentScreen.showAppointmententScreen();
  }

  public void Save(ActionEvent event) throws IOException, InterruptedException {

    AppointmentRequest addappointmentRequest = new AppointmentRequest();

    addappointmentRequest .setPatientid(patient_id.getText());
    addappointmentRequest.setAppointment_time(appointment_time.getText());
    addappointmentRequest.setExamination_date(examination_date.getText());
    addappointmentRequest.setPatient_name(patient_name.getText());

    try {
      AppointmentResponse response =
          RestUtil.sendPostRequest(
              "http://localhost:8083/api/v1/appointment/add",
              AppointmentResponse.class,
              addappointmentRequest);
      System.out.println("Appointment  Added Successfully");
    } catch (IOException e) {
      e.printStackTrace();
    }
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

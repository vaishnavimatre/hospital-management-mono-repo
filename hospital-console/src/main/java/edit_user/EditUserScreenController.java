package edit_user;

import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.DirectoryServiceRequest;
import dto.DirectoryServiceResponse;
import dto.PatientResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class EditUserScreenController {

  @FXML private Button Save;

  @FXML private Button Back;

  @FXML private Button Edit;

  @FXML private Button Appointments;
  @FXML private Button Users;
  @FXML private Button Patients;
  @FXML private Button Dashboard;
  @FXML private Button Cases;

  @FXML private TextField username;

  @FXML private TextField userid;

  @FXML private TextField email;

  @FXML private TextField password;

  @FXML private TextField confirm;

  @FXML private TextField role;

  @FXML private TextField mobno;

  public void Save(ActionEvent event) throws IOException, InterruptedException {

    DirectoryServiceRequest updateuserRequest = new DirectoryServiceRequest();

    updateuserRequest.setUsername(username.getText());
    updateuserRequest.setEmail(email.getText());
    updateuserRequest.setPassword(password.getText());
    updateuserRequest.setRole(role.getText());
    updateuserRequest.setMobno(mobno.getText());
    updateuserRequest.setConfirm(confirm.getText());

    long userId = Integer.parseInt(userid.getText());
    DirectoryServiceResponse response = null;
    String userIdText = userid.getText().trim();

    try {
      if (!userIdText.isEmpty()) {
        Long userid = Long.parseLong(userIdText);
        response =
            RestUtil.sendPostRequest(
                "http://localhost:8081/api/v1/directory/" + userid,
                DirectoryServiceResponse.class,
                updateuserRequest);
        System.out.println("user updated");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void Edit(ActionEvent event) {
    String userIdText = userid.getText().trim();

    DirectoryServiceResponse response = null;

    try {
      if (!userIdText.isEmpty()) {
        Long userIds = Long.parseLong(userIdText);
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8081/api/v1/directory/" + userIds,
                DirectoryServiceResponse.class);
      }

      DirectoryServiceRequest adduserRequest = new DirectoryServiceRequest();

      email.setText(response.getEmail());
      password.setText(response.getPassword());
      username.setText(response.getUsername());
      role.setText(response.getRole());
      mobno.setText(response.getMobno());
      confirm.setText(response.getConfirm());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void Back(ActionEvent event) {
    usermanagementScreen.showUserManagementScreen();
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

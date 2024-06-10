package delete_user;

import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.CaseResponse;
import dto.DirectoryServiceResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class DeleteUserController {

  @FXML private Button Appointments;
  @FXML private Button Users;
  @FXML private Button Patients;
  @FXML private Button Dashboard;
  @FXML private Button Cases;

  @FXML private Button Back;

  @FXML private Button Search;

  @FXML private Button Delete;

  @FXML private TextField username;

  @FXML private TextField email;

  @FXML private TextField userid;

  @FXML private TextField password;

  @FXML private TextField confirm;

  @FXML private TextField role;

  @FXML private TextField mobno;

  public void Delete(ActionEvent event) throws IOException, InterruptedException {
    String userId = userid.getText().trim();

    try {
      DirectoryServiceResponse response =
          RestUtil.sendDeleteRequest(
              "http://localhost:8081/api/v1/directory/" + userId, DirectoryServiceResponse.class);

      System.out.println("Success\", \"user deleted\", \"user has been deleted successfully.\");");
      userid.clear();
      username.clear();
      mobno.clear();
      password.clear();
      role.clear();
      confirm.clear();
      email.clear();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void Search(ActionEvent event) {
    String UserId = userid.getText().trim();
    DirectoryServiceResponse response = null;
    try {
      if (!UserId.isEmpty()) {
        long userid = Integer.parseInt(UserId);
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8081/api/v1/directory/" + userid, DirectoryServiceResponse.class);
      }

      username.setText(response.getUsername());
      mobno.setText(response.getMobno());
      password.setText(response.getPassword());
      confirm.setText(response.getConfirm());
      role.setText(response.getRole());
      email.setText(response.getEmail());

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

package delete_patient;

import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.CaseResponse;
import dto.PatientResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class DeletePatientScreenController {
  @FXML private Button Save;

  @FXML private Button Cancel;

  @FXML private Button Appointments;
  @FXML private Button Users;
  @FXML private Button Patients;
  @FXML private Button Dashboard;
  @FXML private Button Cases;

  @FXML private TextField patient_name;

  @FXML private TextField patient_id;

  @FXML private TextField patient_name_marathi;

  @FXML private TextField mobile_number;

  @FXML private TextField gender;

  @FXML private TextField birth_date;

  @FXML private TextField first_examination_date;

  @FXML private TextArea address;

  public void Delete(ActionEvent event) throws IOException, InterruptedException {
    String patient_Id = patient_id.getText().trim();

    try {
      long patientid = Integer.parseInt(patient_Id);
      PatientResponse response =
          RestUtil.sendDeleteRequest(
              "http://localhost:8082/api/v1/patient/" + patientid, PatientResponse.class);

      System.out.println("Success\", \"Case deleted\", \"Case has been deleted successfully.\");");
      patient_id.clear();
      patient_name_marathi.clear();
      mobile_number.clear();
      first_examination_date.clear();
      gender.clear();
      birth_date.clear();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void Search(ActionEvent event) {
    String patientId = patient_id.getText().trim();
    String patientname = patient_name.getText().trim();
    PatientResponse response = null;
    try {
      if (!patientId.isEmpty()) {
        long patientid = Integer.parseInt(patientId);
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8082/api/v1/patient/" + patientid, PatientResponse.class);
      } else if (!patientname.isEmpty()) {

        response =
            RestUtil.sendGetRequest(
                "http://localhost:8082/api/v1/case/patient/" + patientname, PatientResponse.class);
      }
      patient_name.setText(response.getPatient_name_english());
      address.setText(response.getAddress());
      patient_name_marathi.setText(response.getPatient_name_marathi());
      mobile_number.setText(response.getMobile_number());
      first_examination_date.setText(response.getFirst_examination_date());
      gender.setText(response.getGender());
      birth_date.setText(response.getBirth_date());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void Cancel(ActionEvent event) {
    PatientManagementScreen.showPatientManagementScreen();
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

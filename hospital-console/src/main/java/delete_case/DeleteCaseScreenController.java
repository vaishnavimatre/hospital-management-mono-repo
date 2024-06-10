package delete_case;

import java.io.IOException;

import appointment_management.AppointMentScreen;
import case_management.CaseManagementScreen;
import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.CaseResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import patient_management.PatientManagementScreen;
import user_management.usermanagementScreen;

public class DeleteCaseScreenController {

  @FXML private Button Cancel;

  @FXML private Button Search;

  @FXML private Button Delete;
  

  @FXML private Button Appointments;
  @FXML private Button Users;
  @FXML private Button Patients;
  @FXML private Button Dashboard;
  @FXML private Button Cases;

  @FXML private TextField case_id;

  @FXML private TextField patient_ids;
  @FXML private TextField patient_id;

  @FXML private TextField caseNumber;

  @FXML private TextField examination_date;

  @FXML private TextArea symptoms;

  @FXML private TextArea prescription;

  @FXML private TextField patient_name;

  public void Delete(ActionEvent event) throws IOException, InterruptedException {
    String caseId = case_id.getText().trim();

    try {
      CaseResponse response =
          RestUtil.sendDeleteRequest(
              "http://localhost:8084/api/v1/case/" + caseId, CaseResponse.class);

      System.out.println("Success\", \"Case deleted\", \"Case has been deleted successfully.\");");
      patient_ids.clear();
      caseNumber.clear();
      examination_date.clear();
      prescription.clear();
      symptoms.clear();
      patient_name.clear();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void Search(ActionEvent event) {
    String patientId = patient_id.getText().trim();
  String caseId=case_id.getText().trim();
    CaseResponse response = null;
    try {
      if (!patientId.isEmpty()) {
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8084/api/v1/case/" + patientId, CaseResponse.class);
      } else if (!caseId.isEmpty()) {

    	long  caseid = Integer.parseInt(caseId);
        response =
            RestUtil.sendGetRequest(
                "http://localhost:8084/api/v1/case/patient/" + caseid, CaseResponse.class);
      }
      
        patient_name.setText(response.getPatientNameInEnglish());
        patient_ids.setText(response.getPatient_id());
       caseNumber.setText(response.getCaseNumber());
       examination_date.setText(response.getExaminationDate());
        symptoms.setText(response.getSymptoms());
        prescription.setText(response.getPrescription());

      
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

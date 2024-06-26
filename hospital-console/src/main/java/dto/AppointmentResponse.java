package dto;

import org.springframework.stereotype.Component;

@Component
public class AppointmentResponse {

  private String status;
  private String message;
  private String patient_name;
  private String patientid;
  private long appointment_id;
  private String examination_date;
  private String appointment_time;

 
  public String getPatientid() {
return patientid;}

public void setPatientid(String patientid) {
this.patientid = patientid;}

public long getAppointment_id() {
    return appointment_id;
  }

  public void setAppointment_id(long appointment_id) {
    this.appointment_id = appointment_id;
  }

  public String getExamination_date() {
    return examination_date;
  }

  public void setExamination_date(String examination_date) {
    this.examination_date = examination_date;
  }

  public String getPatient_name() {
    return patient_name;
  }

  public void setPatient_name(String patient_name) {
    this.patient_name = patient_name;
  }

  public String getAppointment_time() {
    return appointment_time;
  }

  public void setAppointment_time(String appointment_time) {
    this.appointment_time = appointment_time;
  }

  public static AppointmentResponse getInstance() {
    return new AppointmentResponse();
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  private String timestamp;

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}

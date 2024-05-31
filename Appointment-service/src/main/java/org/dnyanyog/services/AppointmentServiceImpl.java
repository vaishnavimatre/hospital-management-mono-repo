package org.dnyanyog.services;





import java.util.Optional;

import org.dnyanyog.Enum.ResponseCode;
import org.dnyanyog.Repo.AppointmentRepository;
import org.dnyanyog.dto.AppointmentRequest;
import org.dnyanyog.dto.AppointmentResponse;
import org.dnyanyog.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl {

  @Autowired private AppointmentRepository appointmentrepo;

  @Autowired private AppointmentResponse response;

  public AppointmentResponse addAppointment(AppointmentRequest request) throws Exception {
    AppointmentResponse appointmentresponse = AppointmentResponse.getInstance();

    Appointment appointmentTable = new Appointment();
    appointmentTable.setPatient_id(request.getPatient_id());
    appointmentTable.setPatient_name(request.getPatient_name());
    appointmentTable.setExamination_date(request.getExamination_date());
    appointmentTable.setAppointment_time(request.getAppointment_time());
    appointmentTable.setAppointment_id(request.getAppointment_id());
    try {
      appointmentTable = appointmentrepo.save(appointmentTable);
      
      appointmentresponse.setPatient_id( appointmentTable.getPatient_id());
      appointmentresponse.setPatient_name(appointmentTable.getPatient_name());
      appointmentresponse.setExamination_date(appointmentTable.getExamination_date());
      appointmentresponse.setAppointment_id(appointmentTable.getAppointment_id());
      appointmentresponse.setAppointment_time(appointmentTable.getAppointment_time());

      appointmentresponse.setMessage(ResponseCode.Add_Appointment_Success.getMessage());
      appointmentresponse.setStatus(ResponseCode.Add_Appointment_Success.getStatus());
      
    } catch (Exception e) {
      appointmentresponse.setStatus(ResponseCode.Add_Appointment_Fail.getStatus());
      appointmentresponse.setMessage(ResponseCode.Add_Appointment_Fail.getMessage());
    }

    return appointmentresponse;
  }

  public AppointmentResponse DeleteAppointment(Long patient_id) {
    Optional<Appointment> receiveData = appointmentrepo.findById(patient_id);
    if (receiveData.isPresent()) {
      appointmentrepo.deleteById(patient_id);
      response .setAppointment_id(patient_id);
          response.setMessage(ResponseCode.Delete_Appointment_Success.getMessage());
          response.setStatus(ResponseCode.Delete_Appointment_Success.getStatus());
    }
    return response;
  }

  public AppointmentResponse Updateappointment(Long patient_id, AppointmentRequest request) {
    Optional<Appointment> receiveData = appointmentrepo.findById(patient_id);
    if (receiveData.isEmpty()) {
      response .setMessage(ResponseCode.Update_Appointment_Fail.getMessage());
          response.setStatus(ResponseCode.Update_Appointment_Fail.getStatus());

    } else {
      Appointment appointmentTable = receiveData.get();
      response   .setMessage(ResponseCode.Update_Appointment_Success.getMessage());
          response.setStatus(ResponseCode.Update_Appointment_Success.getStatus());
          response .setPatient_name(appointmentTable.getPatient_name());
          response .setExamination_date(appointmentTable.getExamination_date());
          response.setPatient_id(appointmentTable.getPatient_id());
          response.setAppointment_id(appointmentTable.getAppointment_id());
          response .setAppointment_time(appointmentTable.getAppointment_time());
    }
    return response;
  }

  public AppointmentResponse getSingleappointment(Long patient_id) {
    Optional<Appointment> receiveData = appointmentrepo.findById(patient_id);
    if (receiveData.isEmpty()) {
      response  .setMessage(ResponseCode.Search_Appointment_Fail.getMessage());
      response .setStatus(ResponseCode.Search_Appointment_Fail.getStatus());

    } else {
      Appointment appointment = receiveData.get();

      response.setMessage(ResponseCode.Search_Appointment_Success.getMessage());
      response  .setStatus(ResponseCode.Search_Appointment_Success.getStatus());
      response .setPatient_name(appointment.getPatient_name());
      response .setPatient_name(appointment.getPatient_name());
      response .setExamination_date(appointment.getExamination_date());
      response .setPatient_id(appointment.getPatient_id());
      response   .setAppointment_id(appointment.getAppointment_id());
      response   .setAppointment_time(appointment.getAppointment_time());
    }
    return response;
  }
}

package org.dnyanyog.service;

import jakarta.validation.Valid;

import java.util.Optional;
import org.dnyanyog.Enum.ResponseCode;
import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.dto.PatientResponse;
import org.dnyanyog.entity.Patient;
import org.dnyanyog.repo.PatientServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl {

  @Autowired private PatientServiceRepository patientRepo;
  private PatientResponse response;

  public PatientResponse AddPatient(@Valid PatientRequest request) throws Exception {

    PatientResponse patientResponse = PatientResponse.getInstance();

    Patient patient = new Patient();

    patient.setAddress(request.getAddress());
    patient.setBirth_date(request.getBirth_date());
    patient.setFirst_examination_date(request.getFirst_examination_date());
    patient.setGender(request.getGender());
    patient.setMobile_number(request.getMobile_number());
    patient.setPatient_name_english(request.getPatient_name_english());
    patient.setPatient_name_marathi(request.getPatient_name_marathi());

    try {
      patient = patientRepo.save(patient);
      response.setAddress(patient.getAddress());
      response.setBirth_date(patient.getBirth_date());
      response.setFirst_examination_date(patient.getFirst_examination_date());
      response.setGender(patient.getGender());
      response.setMobile_number(patient.getMobile_number());
      response.setPatient_name_english(patient.getPatient_name_english());
      response.setPatient_name_marathi(patient.getPatient_name_marathi());
     
      patientResponse.setStatus(ResponseCode.ADD_PATIENT.getStatus());
      patientResponse.setMessage(ResponseCode.ADD_PATIENT.getMessage());

    } catch (Exception e) {
      patientResponse.setStatus(ResponseCode.ADD_PATIENT_FAILED.getStatus());
      patientResponse.setMessage(ResponseCode.ADD_PATIENT_FAILED.getMessage());
    }

    return patientResponse;
  }

 

  public PatientResponse UpdatePatient(long patient_id, PatientRequest request) {
    Optional<Patient> optionalPatient = patientRepo.findById(patient_id);

    PatientResponse response = PatientResponse.getInstance();
    if (optionalPatient.isEmpty()) {
      response.setStatus(ResponseCode.UPDATE_PATIENT_FAILED.getStatus());
      response.setMessage(ResponseCode.UPDATE_PATIENT_FAILED.getMessage());
    } else {
      Patient patient = optionalPatient.get();

      patient.setAddress(request.getAddress());
      patient.setMobile_number(request.getMobile_number());
      patient.setBirth_date(request.getBirth_date());
      patient.setFirst_examination_date(request.getFirst_examination_date());
      patient.setGender(request.getGender());
      patient.setPatient_name_english(request.getPatient_name_english());
      patient.setPatient_name_marathi(request.getPatient_name_marathi());

      patientRepo.save(patient);

      response.setAddress(patient.getAddress());
      response.setBirth_date(patient.getBirth_date());
      response.setFirst_examination_date(patient.getFirst_examination_date());
      response.setGender(patient.getGender());
      response.setMobile_number(patient.getMobile_number());
      response.setPatient_name_english(patient.getPatient_name_english());
      response.setPatient_name_marathi(patient.getPatient_name_marathi());

      response.setMessage(ResponseCode.UPDATE_PATIENT.getMessage());
      response.setStatus(ResponseCode.UPDATE_PATIENT.getStatus());
    }

    return response;
  }

  public PatientResponse SearchPatient(long patient_id) {
    Optional<Patient> optionalPatient = patientRepo.findById(patient_id);

    PatientResponse response = PatientResponse.getInstance();
    if (optionalPatient.isEmpty()) {
      response.setMessage(ResponseCode.SEARCH_PATIENT_FAILED.getMessage());
      response.setStatus(ResponseCode.SEARCH_PATIENT_FAILED.getStatus());
    } else {
      Patient patient = optionalPatient.get();
      response.setAddress(patient.getAddress());
      response.setBirth_date(patient.getBirth_date());
      response.setFirst_examination_date(patient.getFirst_examination_date());
      response.setGender(patient.getGender());
      response.setMobile_number(patient.getMobile_number());
      response.setPatient_name_english(patient.getPatient_name_english());
      response.setPatient_name_marathi(patient.getPatient_name_marathi());
      response.setMessage(ResponseCode.SEARCH_PATIENT.getMessage());
      response.setStatus(ResponseCode.SEARCH_PATIENT.getStatus());
    }
    return response;
  }

  public PatientResponse DeletePatient(long patient_id) {

    Optional<Patient> optionalPatient = patientRepo.findById(patient_id);

    if (optionalPatient.isEmpty()) {
      response.setMessage(ResponseCode.DELETE_PATIENT_FAILED.getMessage());
      response.setStatus(ResponseCode.DELETE_PATIENT_FAILED.getStatus());
    } else {

      Patient patients = optionalPatient.get();
      patientRepo.delete(patients);

      response.setMessage(ResponseCode.DELETE_PATIENT.getMessage());
      response.setStatus(ResponseCode.DELETE_PATIENT.getStatus());
      response.setAddress(patients.getAddress());
      response.setBirth_date(patients.getBirth_date());
      response.setGender(patients.getGender());
      response.setFirst_examination_date(patients.getFirst_examination_date());
      response.setMobile_number(patients.getMobile_number());
      response.setPatient_name_english(patients.getPatient_name_english());
      response.setPatient_name_marathi(patients.getPatient_name_marathi());
    }
    return response;
  }
}

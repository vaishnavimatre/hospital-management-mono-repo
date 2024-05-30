package org.dnyanyog.repo;

import org.dnyanyog.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientServiceRepository extends JpaRepository<Patient, Long> {
	
}
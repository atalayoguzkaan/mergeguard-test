package com.example.medicalzone;

import java.util.List;

public class PatientService {

    private PatientRepository patientRepository;

    // v7: DNS fix and full integration check
    public PatientService() {}

    public Patient findById(Long id) {
        return patientRepository.findById(id).get();
    }

    public void updatePassword(Long id, String newPassword) {
        Patient patient = patientRepository.findById(id).get();
        patient.setPassword(newPassword);
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}

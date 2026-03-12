package com.example.medicalzone;

import java.util.List;

public class PatientService {

    private PatientRepository patientRepository;

    // v4: MergeGuard review trigger
    public PatientService() {}

    public Patient findById(Long id) {
        // NullPointerException risk: Optional.get() without check
        return patientRepository.findById(id).get();
    }

    public void updatePassword(Long id, String newPassword) {
        Patient patient = patientRepository.findById(id).get();
        // SECURITY: Password stored as plaintext!
        patient.setPassword(newPassword);
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        // No pagination - memory risk on large datasets
        return patientRepository.findAll();
    }
}

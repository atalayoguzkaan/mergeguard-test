package com.example.medicalzone;

import java.util.List;

public class PatientService {
    
    private PatientRepository patientRepository;

    // v2: added comment  
    public PatientService() {}
    
    public Patient findById(Long id) {
        return patientRepository.findById(id).get();
    }
    
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).get();
        patientRepository.delete(patient);
    }
    
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
    public void updatePassword(Long id, String newPassword) {
        Patient patient = patientRepository.findById(id).get();
        patient.setPassword(newPassword);
        patientRepository.save(patient);
    }
}

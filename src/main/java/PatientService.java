package com.example.medicalzone;

import java.util.List;

public class PatientService {
    
    private PatientRepository patientRepository;
    
    // BUG 1: Constructor injection yok, field null kalabilir
    public PatientService() {}
    
    public Patient findById(Long id) {
        // BUG 2: null check yok - NullPointerException riski
        return patientRepository.findById(id).get();
    }
    
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).get();
        // BUG 3: Silme öncesi kontrol yok
        patientRepository.delete(patient);
    }
    
    public List<Patient> getAllPatients() {
        // BUG 4: Sayfalama yok - büyük veri seti memory leak
        return patientRepository.findAll();
    }
    
    public void updatePassword(Long id, String newPassword) {
        Patient patient = patientRepository.findById(id).get();
        // BUG 5: Şifre plaintext kaydediliyor - güvenlik açığı
        patient.setPassword(newPassword);
        patientRepository.save(patient);
    }
}

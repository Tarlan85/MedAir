package az.tarlan.medair.patients.patientDAO;


import az.tarlan.medair.patients.entity.Vite;

public interface PatientDAO {

    void saveThePatientVite(Vite thePatientVita);
    int getPatientId();
    Vite findById(int theId);
    void deleteById(int theId);
}
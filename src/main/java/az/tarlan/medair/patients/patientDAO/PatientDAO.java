package az.tarlan.medair.patients.patientDAO;


import az.tarlan.medair.patients.entity.Vite;

import java.util.List;

public interface PatientDAO {

    public void saveThePatientVite(Vite thePatientVita);
    public int getPatientId();
    public Vite findById(int theId);
    public void deleteById(int theId);
}
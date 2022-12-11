package az.tarlan.medair.patients.service;

import az.tarlan.medair.patients.entity.*;
import az.tarlan.medair.visits.entity.VisitTable;

import java.util.List;

public interface PatientService {

    public List<VisitTable> findAllVisits(String visDate);

    public Vite findById(int theId);

//    public List<PatientVisits> findByName(PatientVisits patient);

//    public void save(PatientVisits thePatient);

    public void saveThePatientVita(Vite thePatientVite);

    public void deleteById(int theId);



//    void savePatientVisits(PatientVisits patientVisits);

    int getPatientId();


}
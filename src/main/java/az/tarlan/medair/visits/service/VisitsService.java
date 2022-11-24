package az.tarlan.medair.visits.service;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;

import java.util.List;

public interface VisitsService {

    List<VisitTable> findAllVisits(String visDate);
    void savePatientVisits(PatientVisits patientVisits);
    public PatientVisits findById(int id);
    public void deleteById(int theId);
    void saveVisitTable(VisitTable visitTable);
}
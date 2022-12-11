package az.tarlan.medair.visits.service;

import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;
import az.tarlan.medair.visits.entity.VisitsRegBody;

import java.util.List;

public interface VisitsService {

    List<VisitTable> findAllVisits(String visDate);
    void savePatientVisits(VisitsRegBody visitsRegBody);
    public PatientVisits findById(int id);
    public void deleteById(int theId);
    void saveVisitTable(VisitTable visitTable);

    List<PatientVisits> findPatientVisits(int patientId);
}
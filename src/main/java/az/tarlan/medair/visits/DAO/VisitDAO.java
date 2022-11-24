package az.tarlan.medair.visits.DAO;


import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;

import java.util.List;

public interface VisitDAO {
    public List<VisitTable> findAllVisits(String visDate);
    public void savePatientVisits(PatientVisits patientVisits);
    void saveVisitTable(VisitTable visitTable);
    public PatientVisits findById(int id);
    public void deleteById(int id);
}

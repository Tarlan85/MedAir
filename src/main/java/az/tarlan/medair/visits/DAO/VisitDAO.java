package az.tarlan.medair.visits.DAO;


import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;
import az.tarlan.medair.visits.entity.VisitsRegBody;

import java.util.List;

public interface VisitDAO {
    public List<VisitTable> findAllVisits(String visDate);
    public void savePatientVisits(VisitsRegBody visitsRegBody);
    public void addPatientVisitsFromCalendar(VisitsRegBody visitsRegBody);
    void saveVisitTable(VisitTable visitTable);
    public PatientVisits findById(int id);
    public VisitTable findByIdFromVT(int id);
    public void deleteById(int id);

    List<PatientVisits> findPatientVisits(int patientId);
}

package az.tarlan.medair.visits.service;

import az.tarlan.medair.visits.DAO.VisitDAO;
import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;
import az.tarlan.medair.visits.entity.VisitsRegBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitisServiceImpl implements VisitsService {
    private VisitDAO visitDAO;

    @Autowired
    public VisitisServiceImpl(VisitDAO theVisitDAO) {
        visitDAO = theVisitDAO;
    }

    @Override
    @Transactional
    public List<VisitTable> findAllVisits(String visDate) {
        return visitDAO.findAllVisits(visDate);
    }

    @Override
    @Transactional
    public void savePatientVisits(VisitsRegBody patientVisits) {
        visitDAO.savePatientVisits(patientVisits);
    }

    @Override
    @Transactional
    public void addPatientVisitsFromCalendar(VisitsRegBody patientVisits) {
        visitDAO.addPatientVisitsFromCalendar(patientVisits);
    }

    @Override
    @Transactional
    public void saveVisitTable(VisitTable visitTable) {
        visitDAO.saveVisitTable(visitTable);
    }

    @Override
    @Transactional
    public List<PatientVisits> findPatientVisits(int patientId) {
        return visitDAO.findPatientVisits(patientId);
    }

    @Override
    @Transactional
    public PatientVisits findById(int id) {
        return visitDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        visitDAO.deleteById(id);
    }
}
package az.tarlan.medair.patients.service;

import az.tarlan.medair.patients.patientDAO.PatientDAO;
import az.tarlan.medair.patients.entity.*;
import az.tarlan.medair.visits.DAO.VisitDAO;
import az.tarlan.medair.visits.entity.VisitTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    private PatientDAO patientDAO;
    private VisitDAO  visitDAO;


    @Autowired
    //public PatientServiceImpl(@Qualifier("PatientDAO") PatientDAO thePatientDAO)
    public PatientServiceImpl(PatientDAO thePatientDAO,VisitDAO  theVisitDAO){
        patientDAO = thePatientDAO;visitDAO=theVisitDAO;
    }
    @Override
    @Transactional
    public List<VisitTable> findAllVisits(String visDate) {
        return visitDAO.findAllVisits(visDate);
    }

    @Override
    @Transactional
    public Vite findById(int theId) {
        return patientDAO.findById (theId);
    }

//    @Transactional
//    public List<PatientVisits> findByName(PatientVisits patient) {
//            return patientDAO.findByFirstName(patient);
//    }

//    @Override
//    @Transactional
//    public void save(PatientVisits thePatient) {
//        patientDAO.save(thePatient);
//    }


    @Override
    @Transactional
    public void saveThePatientVita(Vite thePatientVite) {
        patientDAO.saveThePatientVite(thePatientVite);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        patientDAO.deleteById(theId);
    }

//    @Override
//    @Transactional
//    public void savePatientVisits(VisitsRegBody visitsRegBody) {
//        visitDAO.savePatientVisits(visitsRegBody);
//    }

    @Override
    @Transactional
    public int getPatientId() {
        return patientDAO.getPatientId();
    }

    }

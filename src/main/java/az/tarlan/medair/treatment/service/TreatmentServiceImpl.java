package az.tarlan.medair.treatment.service;

import az.tarlan.medair.treatment.DAO.TreatmentDAO;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TreatmentServiceImpl implements TreatmentService {
    private TreatmentDAO treatmentDAO;
    @Autowired
    public TreatmentServiceImpl(TreatmentDAO treatmentDAO) {
        this.treatmentDAO=treatmentDAO;
    }

    @Override
    @Transactional
    public void saveTreatment(TreatmentReqBody treatmentRB) {
      treatmentDAO.saveTreatment(treatmentRB);
    }

    @Override
    @Transactional
    public TreatmentReqBody findTreatmentAnalyses(int patientId) {
        return treatmentDAO.findTreatmentAnalyses(patientId);
    }
//
//    @Override
//    @Transactional
//    public void saveCureTabs(CureTabs cureTabs) {
//        managerDAO.saveCureTabs(cureTabs);
//    }
//
//    @Override
//    @Transactional
//    public int deleteByIdCureTabs(int cureTabsId) {
//        managerDAO.deleteByIdCureTabs(cureTabsId);
//        return cureTabsId;
//    }
//    @Override
//    @Transactional
//    public List<CureTabs> getAllTabs() {
//        return managerDAO.getAllTabs();
//    }
//
//    @Override
//    @Transactional
//    public List<VisitPlaces> getAllPlaces() {
//        return managerDAO.getAllPlaces();
//    }
//
//    @Override
//    @Transactional
//    public void saveVisitPlace(VisitPlaces visitPlaces) {
//        managerDAO.saveVisitPlaces(visitPlaces);
//    }
//
//    @Override
//    @Transactional
//    public CureTabs findById(int cureTabId) {
//        return managerDAO.findById(cureTabId);
//    }

}

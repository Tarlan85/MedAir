package az.tarlan.medair.treatment.service;

import az.tarlan.medair.treatment.entity.TreatmentReqBody;

public interface TreatmentService {
    void saveTreatment(TreatmentReqBody treatmentRB);

    TreatmentReqBody findTreatmentAnalyses(int patientId);

//
//    public int deleteByIdCureTabs(int cureTabsId);
//    public void saveCureTabs(CureTabs cureTabs);
//    List<CureTabs> getAllTabs();
//
//    List<VisitPlaces> getAllPlaces();
//
//    void saveVisitPlace(VisitPlaces visitPlaces);
//
//    public CureTabs findById(int cureTabId);
}

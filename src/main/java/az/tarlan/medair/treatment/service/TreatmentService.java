package az.tarlan.medair.treatment.service;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.VisitPlaces;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;

import java.util.List;

public interface TreatmentService {
    void saveTreatment(TreatmentReqBody treatmentRB);

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

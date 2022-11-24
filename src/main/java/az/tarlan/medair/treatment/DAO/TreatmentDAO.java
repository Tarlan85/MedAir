package az.tarlan.medair.treatment.DAO;


import az.tarlan.medair.treatment.entity.TreatmentReqBody;


public interface TreatmentDAO {
//    public CureTabs findById(int cureTabsId);
    public void saveTreatment(TreatmentReqBody treatmentRB);
//
//    List<CureTabs> getAllTabs();
//
//    List<VisitPlaces> getAllPlaces();
//
//    void saveVisitPlaces(VisitPlaces visitPlaces);
//
//    void deleteByIdCureTabs(int cureTabsId);
}

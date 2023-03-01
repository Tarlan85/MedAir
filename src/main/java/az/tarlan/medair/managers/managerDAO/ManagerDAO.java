package az.tarlan.medair.managers.managerDAO;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.VisitPlaces;

import java.util.List;

public interface ManagerDAO {
    public CureTabs findById(int cureTabsId);

    public void saveCureTabs(CureTabs cureTabs);

    List<CureTabs> getAllTabs();

    void deleteByIdCureTabs(int cureTabsId);

    public VisitPlaces findVisitPlacesById(int visitPlacesId);
    List<VisitPlaces> getAllPlaces();

    void saveVisitPlaces(VisitPlaces visitPlaces);


    void deleteVisitPlacesById(int visitPlacesId);
}

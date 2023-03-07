package az.tarlan.medair.managers.managerDAO;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.PathologistsList;
import az.tarlan.medair.managers.entity.VisitPlaces;

import java.util.List;

public interface ManagerDAO {
    //manager CureTab
    public CureTabs findCureTabById(int cureTabsId);

    public void saveCureTabs(CureTabs cureTabs);

    List<CureTabs> getAllTabs();

    void deleteByIdCureTabs(int cureTabsId);
    
    //manager Visit Place
    public VisitPlaces findVisitPlacesById(int visitPlacesId);

    List<VisitPlaces> getAllPlaces();

    void saveVisitPlaces(VisitPlaces visitPlaces);

    void deleteVisitPlacesById(int visitPlacesId);

    //manager Pathologists
    List<PathologistsList> getAllPathologists();

    void savePathologistsList(PathologistsList pathologistsList);

    PathologistsList findPathologistById(int pathologistsId);

    void deletePathologistById(int pathologistsId);
}

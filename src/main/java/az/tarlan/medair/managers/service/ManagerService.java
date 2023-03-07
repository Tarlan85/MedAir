package az.tarlan.medair.managers.service;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.PathologistsList;
import az.tarlan.medair.managers.entity.VisitPlaces;

import java.util.List;

public interface ManagerService {

    List<CureTabs> getAllTabs();
    List<VisitPlaces> getAllPlaces();
    List<PathologistsList> getAllPathologists();

    public void saveCureTabs(CureTabs cureTabs);
    void saveVisitPlace(VisitPlaces visitPlaces);
    void savePathologistsList(PathologistsList pathologistsList);


    public int deleteByIdCureTabs(int cureTabsId);
    public int deleteVisitPlacesById(int visitPlacesId);
    public int deletePathologistById(int pathologistsId);


    public CureTabs findCureTabById(int cureTabId);
    public VisitPlaces findVisitPlacesById(int visitPlacesId);
    public PathologistsList findPathologistById(int pathologistsId);
}

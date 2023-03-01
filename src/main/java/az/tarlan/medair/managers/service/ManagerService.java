package az.tarlan.medair.managers.service;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.VisitPlaces;

import java.util.List;

public interface ManagerService {


    public int deleteByIdCureTabs(int cureTabsId);
    public int deleteVisitPlacesById(int visitPlacesId);
    public void saveCureTabs(CureTabs cureTabs);
    List<CureTabs> getAllTabs();

    List<VisitPlaces> getAllPlaces();

    void saveVisitPlace(VisitPlaces visitPlaces);

    public CureTabs findById(int cureTabId);
    public VisitPlaces findVisitPlacesById(int visitPlacesId);
}

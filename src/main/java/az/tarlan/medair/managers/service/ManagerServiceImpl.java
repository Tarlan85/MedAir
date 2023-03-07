package az.tarlan.medair.managers.service;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.PathologistsList;
import az.tarlan.medair.managers.entity.VisitPlaces;
import az.tarlan.medair.managers.managerDAO.ManagerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    private ManagerDAO managerDAO;

    @Autowired
    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }


    @Override
    @Transactional
    public List<CureTabs> getAllTabs() {
        return managerDAO.getAllTabs();
    }

    @Override
    @Transactional
    public List<VisitPlaces> getAllPlaces() {
        return managerDAO.getAllPlaces();
    }

    @Override
    public List<PathologistsList> getAllPathologists() {
        return managerDAO.getAllPathologists();
    }

    @Override
    @Transactional
    public void saveCureTabs(CureTabs cureTabs) {
        managerDAO.saveCureTabs(cureTabs);
    }

    @Override
    @Transactional
    public void saveVisitPlace(VisitPlaces visitPlaces) {
        managerDAO.saveVisitPlaces(visitPlaces);
    }

    @Override
    public void savePathologistsList(PathologistsList pathologistsList) {
        managerDAO.savePathologistsList(pathologistsList);
    }

    @Override
    @Transactional
    public CureTabs findCureTabById(int cureTabId) {
        return managerDAO.findCureTabById(cureTabId);
    }

    @Override
    @Transactional
    public VisitPlaces findVisitPlacesById(int visitPlacesId) {
        return managerDAO.findVisitPlacesById(visitPlacesId);
    }

    @Override
    public PathologistsList findPathologistById(int pathologistsId) {
        return managerDAO.findPathologistById( pathologistsId);
    }

    @Override
    @Transactional
    public int deleteByIdCureTabs(int cureTabsId) {
        managerDAO.deleteByIdCureTabs(cureTabsId);
        return cureTabsId;
    }

    @Override
    @Transactional
    public int deleteVisitPlacesById(int visitPlacesId) {
        managerDAO.deleteVisitPlacesById(visitPlacesId);
        return visitPlacesId;
    }

    @Override
    public int deletePathologistById(int pathologistsId) {
        managerDAO.deletePathologistById(pathologistsId);
        return pathologistsId;
    }
}

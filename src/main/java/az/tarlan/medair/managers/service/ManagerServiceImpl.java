package az.tarlan.medair.managers.service;

import az.tarlan.medair.managers.entity.CureTabs;
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
    public void saveCureTabs(CureTabs cureTabs) {
        managerDAO.saveCureTabs(cureTabs);
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
    @Transactional
    public void saveVisitPlace(VisitPlaces visitPlaces) {
        managerDAO.saveVisitPlaces(visitPlaces);
    }

    @Override
    @Transactional
    public CureTabs findById(int cureTabId) {
        return managerDAO.findById(cureTabId);
    }

    @Override
    public VisitPlaces findVisitPlacesById(int visitPlacesId) {
        return managerDAO.findVisitPlacesById(visitPlacesId);
    }

}

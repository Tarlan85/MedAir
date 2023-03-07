package az.tarlan.medair.managers.managerDAO;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.PathologistsList;
import az.tarlan.medair.managers.entity.VisitPlaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

    private EntityManager entityManager;

    @Autowired
    public ManagerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CureTabs> getAllTabs() {
        System.out.println("getAllTabs");
        Query theQuery = entityManager.createQuery("From CureTabs");
        List<CureTabs> dbCureTabs = theQuery.getResultList();
        System.out.println(dbCureTabs.toString());
        return dbCureTabs;
//        return (List<CureTabs>) dbCureTabs;
    }

    @Override
    public List<VisitPlaces> getAllPlaces() {
        System.out.println("getAllPlaces");
        Query theQuery = entityManager.createQuery("From VisitPlaces");
        List<VisitPlaces> dbVisitPlaces = theQuery.getResultList();
        System.out.println(dbVisitPlaces.toString());
        return dbVisitPlaces;
    }
    @Override
    public List<PathologistsList> getAllPathologists() {
        System.out.println("getAllPathologists");
        Query theQuery = entityManager.createQuery("From PathologistsList");
        List<PathologistsList> dbPathologistsLists = theQuery.getResultList();
        System.out.println(dbPathologistsLists.toString());
        return dbPathologistsLists;
    }

    @Override
    public CureTabs findCureTabById(int cureTabsId) {
        CureTabs cureTabs = entityManager.find(CureTabs.class, cureTabsId);
        return cureTabs;
    }

    @Override
    public VisitPlaces findVisitPlacesById(int visitPlacesId) {
        VisitPlaces visitPlaces = entityManager.find(VisitPlaces.class, visitPlacesId);
        return visitPlaces;
    }
    @Override
    public PathologistsList findPathologistById(int pathologistsId) {
        PathologistsList pathologistsList = entityManager.find(PathologistsList.class, pathologistsId);
        return pathologistsList;
    }

    @Override
    public void saveCureTabs(CureTabs cureTabs) {
        System.out.println("saveCureTabs");
        CureTabs dbCureTabs = entityManager.merge(cureTabs);
        //update  with id in db ... so we can get generation id for save / insert
        cureTabs.setCureTabId(dbCureTabs.getCureTabId());

    }


    @Override
    public void saveVisitPlaces(VisitPlaces visitPlaces) {
        System.out.println("saveVisitPlaces");
        VisitPlaces dbVisitPlaces = entityManager.merge(visitPlaces);
        //update  with id in db ... so we can get generation id for save / insert
        visitPlaces.setVisitPlaceId(dbVisitPlaces.getVisitPlaceId());
    }

    @Override
    public void savePathologistsList(PathologistsList pathologistsList) {
        System.out.println("savePathologistsList");
        PathologistsList dbPathologistsList = entityManager.merge(pathologistsList);
        //update  with id in db ... so we can get generation id for save / insert
        pathologistsList.setPathologistId(dbPathologistsList.getPathologistId());
    }

    @Override
    public void deleteByIdCureTabs(int cureTabsId) {
        //delete  object with primary key
        Query theQuery = entityManager.createQuery("delete from CureTabs where id=:cureTabId");
        theQuery.setParameter("cureTabId", cureTabsId);
        theQuery.executeUpdate();
    }

    @Override
    public void deleteVisitPlacesById(int visitPlacesId) {
        //delete  object with primary key
        System.out.println("deleteVisitPlacesById==" + visitPlacesId);
        Query theQuery = entityManager.createQuery("delete from VisitPlaces where id=:visitPlacesId");
        theQuery.setParameter("visitPlacesId", visitPlacesId);
        theQuery.executeUpdate();
    }





    @Override
    public void deletePathologistById(int pathologistsId) {
        //delete  object with primary key
        System.out.println("deletePathologistById==" + pathologistsId);
        Query theQuery = entityManager.createQuery("delete from PathologistsList where id=:pathologistsId");
        theQuery.setParameter("pathologistsId", pathologistsId);
        theQuery.executeUpdate();

    }
}

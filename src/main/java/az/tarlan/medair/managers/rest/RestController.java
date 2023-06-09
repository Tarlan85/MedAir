package az.tarlan.medair.managers.rest;

import az.tarlan.medair.deseaseHistory.DAO.DeseaseHistoryDAOImpl;
import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.PathologistsList;
import az.tarlan.medair.managers.entity.VisitPlaces;

import az.tarlan.medair.managers.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
@Component
public class RestController {
    private ManagerService managerService;
    private static final Logger logger= LoggerFactory.getLogger(DeseaseHistoryDAOImpl.class);
    @Autowired
    public RestController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/managers/tabs")
    public List<CureTabs> loadTabsManager() {
        return managerService.getAllTabs();
    }

    @GetMapping("/managers/places")
    public List<VisitPlaces> loadPlacesManager() {
        //System.out.println("loadPlacesManager");
        logger.info("loadPlacesManager");
        return managerService.getAllPlaces();
    }

    @GetMapping("/managers/pathologists")
    public List<PathologistsList> loadPathologistsManager() {
        //System.out.println("loadPathologistsManager");
        logger.info("loadPathologistsManager");
        return managerService.getAllPathologists();
    }

    @PostMapping("/managers/tabs")
    public CureTabs addCureTab(@RequestBody CureTabs cureTabs) {
        logger.info("addCureTab");
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        if (cureTabs.getCureTabId() > 0) System.out.println(cureTabs.toString());
        else
            cureTabs.setCureTabId(0);
        //System.out.println(cureTabs.toString());
        managerService.saveCureTabs(cureTabs);
        return cureTabs;
    }

    @PostMapping("/managers/places")
    public VisitPlaces addPlaces(@RequestBody VisitPlaces visitPlaces) {
        logger.info("addPlaces");
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        if (visitPlaces.getVisitPlaceId() > 0) System.out.println(visitPlaces.toString());
        else
            visitPlaces.setVisitPlaceId(0);
        //System.out.println(visitPlaces.toString());
        managerService.saveVisitPlace(visitPlaces);
        return visitPlaces;
    }
    @PostMapping("/managers/pathologists")
    public PathologistsList addPathologists(@RequestBody PathologistsList pathologistsList) {
        logger.info("addPathologists");
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        if (pathologistsList.getPathologistId() > 0) System.out.println(pathologistsList.toString());
        else
            pathologistsList.setPathologistId(0);
        //System.out.println(pathologistsList.toString());
        managerService.savePathologistsList(pathologistsList);
        return pathologistsList;
    }

    @DeleteMapping("/managers/tabs/{cureTabId}")
    public String deleteCureTab(@PathVariable String cureTabId) {
        logger.info("deleteCureTab");
        //System.out.println("Integer.parseInt(cureTabId) = " + Integer.parseInt(cureTabId));
        CureTabs tempPatient = managerService.findCureTabById(Integer.parseInt(cureTabId));
        //throw  exception if null
        if (tempPatient == null)
            throw new RuntimeException("unsuccessful");
        managerService.deleteByIdCureTabs(Integer.parseInt(cureTabId));
        return "success";
    }

    @DeleteMapping("/managers/places/{visitPlacesId}")
    public String deleteVisitPlaces(@PathVariable String visitPlacesId) {
        logger.info("deleteVisitPlaces");
        //System.out.println("Integer.parseInt(cureTabId) = " + Integer.parseInt(visitPlacesId));
        VisitPlaces visitPlaces = managerService.findVisitPlacesById(Integer.parseInt(visitPlacesId));
        //throw  exception if null
        if (visitPlaces == null)
            throw new RuntimeException("unsuccessful");

        managerService.deleteVisitPlacesById(Integer.parseInt(visitPlacesId));
        return "success";
    }

    @DeleteMapping("/managers/pathologists/{pathologistsId}")
    public String deletePathologist(@PathVariable String pathologistsId) {
        logger.info("deletePathologist");
        //System.out.println("Integer.parseInt(pathologistsId) = " + Integer.parseInt(pathologistsId));
        PathologistsList pathologistsList = managerService.findPathologistById(Integer.parseInt(pathologistsId));
        //throw  exception if null
        if (pathologistsList == null)
            throw new RuntimeException("unsuccessful");

        managerService.deletePathologistById(Integer.parseInt(pathologistsId));
        return "success";
    }
}

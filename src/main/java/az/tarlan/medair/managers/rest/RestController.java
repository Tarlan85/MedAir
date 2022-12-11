package az.tarlan.medair.managers.rest;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.VisitPlaces;

import az.tarlan.medair.managers.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class RestController {
    private ManagerService managerService;
    @Autowired
    public RestController(ManagerService managerService) {
        this.managerService=managerService;
    }

    @GetMapping("/managers/tabs")
    public List<CureTabs> loadTabsManager(){
        return managerService.getAllTabs();
    }
    @PostMapping("/managers/tabs")
    public CureTabs addCureTab(@RequestBody CureTabs cureTabs){
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        if (cureTabs.getCureTabId()>0)System.out.println(cureTabs.toString());
        else
            cureTabs.setCureTabId(0);
        System.out.println(cureTabs.toString());
        managerService.saveCureTabs(cureTabs);
        return cureTabs;
    }
    @GetMapping("/managers/places")
    public List<VisitPlaces> loadPlacesManager(){
        System.out.println("loadPlacesManager");
        return managerService.getAllPlaces();
    }
    @PostMapping("/managers/places")
    public VisitPlaces addPlaces(@RequestBody VisitPlaces visitPlaces){
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        if (visitPlaces.getVisitPlaceId()>0)System.out.println(visitPlaces.toString());
        else
            visitPlaces.setVisitPlaceId(0);
        System.out.println(visitPlaces.toString());
        managerService.saveVisitPlace(visitPlaces);
        return visitPlaces;
    }

    @DeleteMapping("/managers/tabs/{cureTabId}")
    public String deletePatient(@PathVariable String cureTabId){
        System.out.println("Integer.parseInt(cureTabId) = "+Integer.parseInt(cureTabId));
        CureTabs tempPatient = managerService.findById(Integer.parseInt(cureTabId));
        //throw  exception if null
        if(tempPatient ==null)
            throw new RuntimeException("Patient Id not found - "+cureTabId);
        managerService.deleteByIdCureTabs(Integer.parseInt(cureTabId));
        return "Delete patient id - "+cureTabId;
    }
}

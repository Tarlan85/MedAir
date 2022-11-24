package az.tarlan.medair.visits.rest;

import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;
import az.tarlan.medair.visits.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "localhost:3000"}, allowedHeaders={"Accept"})
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class VisitsRestController {
    private VisitsService visitsService;
    //quick and dirty:inject employee dao(use constructor injection )
    @Autowired
    public VisitsRestController(VisitsService theVisitsService){
        visitsService = theVisitsService;
    }

    @GetMapping("/visits/{moment}")
    public List<VisitTable> findAllVisits(@PathVariable String moment){
        System.out.println(" findAll ==="+moment);
        System.out.println(visitsService.findAllVisits(moment));
        System.out.println(" findAll === end");
        return visitsService.findAllVisits(moment);
    }

    @PostMapping("/visits")
    public PatientVisits addPatientVisit(@RequestBody PatientVisits patientVisits){
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        if (patientVisits.getVisitId()<1)
        patientVisits.setVisitId(0);
        System.out.println("patientVisitId()====="+patientVisits.getVisitId());
        System.out.println(patientVisits.toString());
        visitsService.savePatientVisits(patientVisits);
        return patientVisits;
    }

    @PostMapping("/visittable")
    public VisitTable updateVisitTable(@RequestBody VisitTable visitTable){
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update

        System.out.println("visitTable()====="+visitTable.getId());
        System.out.println(visitTable.toString());
        visitsService.saveVisitTable(visitTable);
        return visitTable;
    }
    @DeleteMapping("/visits/{id}")
    public String deletePatient(@PathVariable int id){
        PatientVisits patientVisit = visitsService.findById(id);
        //throw  exception if null
        if(patientVisit ==null)
            throw new RuntimeException("Visit Id not found - "+id);
        visitsService.deleteById(id);
        return "Delete Visit id - "+id;
    }
}

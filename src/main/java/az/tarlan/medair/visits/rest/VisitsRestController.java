package az.tarlan.medair.visits.rest;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.patients.service.PatientService;
import az.tarlan.medair.visits.DAO.VisitDAOImpl;
import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;
import az.tarlan.medair.visits.entity.VisitTableCopy;
import az.tarlan.medair.visits.entity.VisitsRegBody;
import az.tarlan.medair.visits.service.VisitsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "localhost:3000"}, allowedHeaders={"Accept"})
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
@Component
public class VisitsRestController {
    private static final Logger logger= LoggerFactory.getLogger(VisitsRestController.class);
    private VisitsService visitsService;

    //quick and dirty:inject employee dao(use constructor injection )
    @Autowired
    public VisitsRestController(VisitsService theVisitsService) {
        visitsService = theVisitsService;
    }

    @GetMapping("/visits/{moment}")
    public List<VisitTable> findAllVisits(@PathVariable String moment) {
        logger.info("findAllVisits");
        //System.out.println(" findAll ===" + moment);
        //System.out.println(visitsService.findAllVisits(moment).toString());
//        //System.out.println(" findAll === end");
        return visitsService.findAllVisits(moment);
    }

    @GetMapping("/visits/patientId/{patientId}")
    public List<PatientVisits> findPatientVisits(@PathVariable int patientId) {
        logger.info("findPatientVisits");
        //System.out.println("1. findPatientVisits \n patientId===" + patientId);
        return visitsService.findPatientVisits(patientId);
    }

    @PostMapping("/visits")
    public VisitsRegBody addPatientVisit(@RequestBody VisitsRegBody visitsRegBody) {
        logger.info("addPatientVisit");
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
//        if (patientVisits.getVisitId()<1)
//        patientVisits.setVisitId(0);
//        //System.out.println("patientVisitId()====="+patientVisits.getVisitId());
//        //System.out.println(patientVisits.toString());
        //System.out.println("addPatientVisit");
        //System.out.println(visitsRegBody.toString());
        if (visitsRegBody.getPatientVisitsList() != null) {
            //System.out.println("VISITDATE");
            //System.out.println(visitsRegBody.getPatientVisitsList().get(0).getVisitDate());
            visitsService.savePatientVisits(visitsRegBody);
        }
        return visitsRegBody;
    }

    @PostMapping("/visitsformcalendar")
    public VisitsRegBody addPatientVisitsFromCalendar(@RequestBody VisitsRegBody visitsRegBody) {
        logger.info("addPatientVisitsFromCalendar");
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        //System.out.println("addPatientVisit");
        //System.out.println(visitsRegBody.toString());
        if (visitsRegBody.getPatientVisitsList() != null) {
            //System.out.println(visitsRegBody.getPatientVisitsList().get(0).getVisitDate());
            //System.out.println(visitsRegBody.getPatientVisitsList().get(0).getPatientId());
            //System.out.println(visitsRegBody.getPatientId());
            visitsService.addPatientVisitsFromCalendar(visitsRegBody);
        }
        return visitsRegBody;
    }

    @PostMapping("/visittable")
    public VisitTable updateVisitTable(@RequestBody VisitTable visitTable) {
        logger.info("updateVisitTable");
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update

        //System.out.println("visitTable()=====" + visitTable.getId());
        //System.out.println(visitTable.toString());
        visitsService.saveVisitTable(visitTable);
        return visitTable;
    }

    @DeleteMapping("/visits/{id}")
    public String deletePatient(@PathVariable int id) {
        logger.info("deletePatient");
        VisitTable visitTable = visitsService.findByIdFromVT(id);
        //throw  exception if null
        if (visitTable == null)
            throw new RuntimeException("Visit Id not found - " + id);
        visitsService.deleteById(id);
        return "Delete Visit id - " + id;
    }
}

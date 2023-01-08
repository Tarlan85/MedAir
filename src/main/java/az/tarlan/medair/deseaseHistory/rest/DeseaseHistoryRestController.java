package az.tarlan.medair.deseaseHistory.rest;

import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;
import az.tarlan.medair.deseaseHistory.service.DeseaseHistoryService;
import az.tarlan.medair.visits.entity.PatientVisits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class DeseaseHistoryRestController {
    private DeseaseHistoryService deseaseHistoryService;
    @Autowired
    public DeseaseHistoryRestController(DeseaseHistoryService deseaseHistoryService) {
        this.deseaseHistoryService = deseaseHistoryService;
    }


    @PostMapping("/morby")
    public DeseaseReqBody addTreatment(@RequestBody DeseaseReqBody deseaseReqBody){
        System.out.println(">>>>>>>>MORBY<<<<<<<<<");
        System.out.println(deseaseReqBody.toString());
        deseaseHistoryService.saveDeseaseHistory(deseaseReqBody);
        return null;
    }
    @GetMapping("/morby/{patientId}")
    public DeseaseReqBody findDeseaseHistoryByPatientId(@PathVariable int patientId){
        System.out.println("1. findDeseaseHistoryByPatientId \n patientId==="+patientId);
        return deseaseHistoryService.findDeseaseHistoryByPatientId(patientId);
    }
}

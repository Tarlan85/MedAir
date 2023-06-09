package az.tarlan.medair.deseaseHistory.rest;

import az.tarlan.medair.deseaseHistory.DAO.DeseaseHistoryDAOImpl;
import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;
import az.tarlan.medair.deseaseHistory.service.DeseaseHistoryService;
import az.tarlan.medair.visits.entity.PatientVisits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class DeseaseHistoryRestController {
    private static final Logger logger= LoggerFactory.getLogger(DeseaseHistoryRestController.class);
    private DeseaseHistoryService deseaseHistoryService;
    @Autowired
    public DeseaseHistoryRestController(DeseaseHistoryService deseaseHistoryService) {
        this.deseaseHistoryService = deseaseHistoryService;
    }


    @PostMapping("/morby")
    public DeseaseReqBody addTreatment(@RequestBody DeseaseReqBody deseaseReqBody){
        System.out.println(">>>>>>>>MORBY<<<<<<<<<");
        logger.info("addTreatment");
        System.out.println(deseaseReqBody.toString());
        return deseaseHistoryService.saveDeseaseHistory(deseaseReqBody);

    }
    @GetMapping("/morby/{patientId}")
    public DeseaseReqBody findDeseaseHistoryByPatientId(@PathVariable int patientId){
        logger.info("findDeseaseHistoryByPatientId");
        System.out.println("1. findDeseaseHistoryByPatientId \n patientId==="+patientId);
        return deseaseHistoryService.findDeseaseHistoryByPatientId(patientId);
    }
}

package az.tarlan.medair.treatment.rest;
import az.tarlan.medair.treatment.DAO.TreatmentDAOImpl;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import az.tarlan.medair.treatment.service.TreatmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
@Component
public class TreatmentRestController {
    private TreatmentService treatmentService;
    private static final Logger logger= LoggerFactory.getLogger(TreatmentRestController.class);
    @Autowired
    public TreatmentRestController(TreatmentService treatmentService) {
        this.treatmentService=treatmentService;
    }


    @PostMapping("/treatment")
    public TreatmentReqBody addTreatment(@RequestBody TreatmentReqBody treatmentRB){
        logger.info("TreatmentReqBody");
        //System.out.println(">>>>>>>>TREATMENT<<<<<<<<<");
        if (treatmentRB.getTreatmentStatic().getTreatmentId()>0)
            System.out.println("");
//            System.out.println(treatmentRB.toString());
        else
            treatmentRB.getTreatmentStatic().setTreatmentId(0);
        //System.out.println(treatmentRB.toString());
        treatmentService.saveTreatment(treatmentRB);
        return null;
    }
    @GetMapping("/treatment/{patientId}")
    public TreatmentReqBody findTreatmentByPatientId(@PathVariable int patientId){
        logger.info("findTreatmentByPatientId");
        //System.out.println("1. findTreatmentByPatientId \n patientId==="+patientId);
        return treatmentService.findTreatmentAnalyses(patientId);
    }

}

package az.tarlan.medair.treatment.rest;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import az.tarlan.medair.treatment.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class TreatmentRestController {
    private TreatmentService treatmentService;
    @Autowired
    public TreatmentRestController(TreatmentService treatmentService) {
        this.treatmentService=treatmentService;
    }


    @PostMapping("/treatment")
    public TreatmentReqBody addTreatment(@RequestBody TreatmentReqBody treatmentRB){
        System.out.println(">>>>>>>>TREATMENT<<<<<<<<<");
        if (treatmentRB.getTreatmentId()>0)System.out.println(treatmentRB.toString());
        else
            treatmentRB.setTreatmentId(0);
        System.out.println(treatmentRB.toString());
        treatmentService.saveTreatment(treatmentRB);
        return null;
    }
    @GetMapping("/treatment/{patientId}")
    public TreatmentReqBody findTreatmentByPatientId(@PathVariable int patientId){
        System.out.println("1. findTreatmentByPatientId \n patientId==="+patientId);
        return treatmentService.findTreatmentAnalyses(patientId);
    }

}

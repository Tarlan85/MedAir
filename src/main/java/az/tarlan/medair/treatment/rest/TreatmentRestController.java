package az.tarlan.medair.treatment.rest;
import az.tarlan.medair.Upload;
import az.tarlan.medair.treatment.DAO.TreatmentDAOImpl;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import az.tarlan.medair.treatment.service.TreatmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
@Component
public class TreatmentRestController {
    private TreatmentService treatmentService;
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${server.ip}")
    private String serverIp;
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
    @PostMapping("/treatmentImage")
    public String addTreatmentImage(@RequestParam("file") MultipartFile file) throws IOException {
        logger.info("addTreatmentImage");
        System.out.println("addTreatmentImage = ");
        System.out.println("upload = "+uploadPath);
        System.out.println("serverIp = "+serverIp);
        Upload upload= new Upload();
        return upload.UploadImage(file,uploadPath,serverIp);
    }

}

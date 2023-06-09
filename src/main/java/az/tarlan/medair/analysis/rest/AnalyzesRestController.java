package az.tarlan.medair.analysis.rest;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.analysis.service.AnalyzesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
@Component
public class AnalyzesRestController {
    private AnalyzesService analyzesService;
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${server.ip}")
    private String serverIp;
    private static final Logger logger= LoggerFactory.getLogger(AnalyzesRestController.class);
    @Autowired
    public AnalyzesRestController(AnalyzesService analyzesService) {
        this.analyzesService = analyzesService;
    }

    @GetMapping("/analysid")
    public int getAnalysesId(){

        int newAnalysId = analyzesService.getAnalysId();
        logger.info("getPatientId : \n newAnalysId = "+newAnalysId);
        return newAnalysId ;
    }
    @PostMapping("/analyses")
    public AnalyzesReqBody addAnalyses(@RequestBody AnalyzesReqBody analizList) throws IOException {
        logger.info("AnalyzesReqBody");
        //System.out.println("addAnalyses");
        //System.out.println(analizList.toString());
        analyzesService.saveAnalyzes(analizList);
        return analizList;
    }

    @PostMapping("/analysesImage")
    public String addAnalyzesImage(@RequestParam("file") MultipartFile file) throws IOException {
        logger.info("addAnalyzesImage");
        //System.out.println("addAnalyzesImage");
        String result = "";
        //System.out.println("analyzesContentName = " + file.getOriginalFilename());
        //System.out.println(file.getSize());

        if (file != null) {
            //System.out.println(uploadPath);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                //System.out.println("dont");
                uploadDir.mkdir();
            }
            System.currentTimeMillis();
            String uuidFile = UUID.randomUUID().toString();

            String resultFileName = System.currentTimeMillis()+"." + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")+1,file.getOriginalFilename().length());
            result = serverIp + "/" + resultFileName;
            //System.out.println("analyzesContentUrl = " + result);
            file.transferTo(new File(uploadPath + "/" + resultFileName));
        }
        return result;
    }

    @GetMapping("/analyses/{patientId}")
    public List<AnalyzesMedia> findAnalysesByPatientId(@PathVariable int patientId) {
        logger.info("findAnalysesByPatientId");
        //System.out.println("1. findAnalysesByPatientId \n patientId===" + patientId);
        //System.out.println(analyzesService.findPatientAnalyses(patientId));
        return analyzesService.findPatientAnalyses(patientId);
    }

}

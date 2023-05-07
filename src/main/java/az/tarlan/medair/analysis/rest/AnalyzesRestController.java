package az.tarlan.medair.analysis.rest;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.analysis.service.AnalyzesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class AnalyzesRestController {
    private AnalyzesService analyzesService;
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${server.ip}")
    private String serverIp;

    @Autowired
    public AnalyzesRestController(AnalyzesService analyzesService) {
        this.analyzesService = analyzesService;
    }

    @GetMapping("/analysid")
    public int getPatientId(){
        int newAnalysId = analyzesService.getAnalysId();
        return newAnalysId ;
    }
    @PostMapping("/analyses")
    public AnalyzesReqBody addAnalyses(@RequestBody AnalyzesReqBody analizList) throws IOException {
        //System.out.println("addAnalyses");
        //System.out.println(analizList.toString());
        analyzesService.saveAnalyzes(analizList);
        return analizList;
    }

    @PostMapping("/analysesImage")
    public String addAnalyzesImage(@RequestParam("file") MultipartFile file) throws IOException {
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
        //System.out.println("1. findAnalysesByPatientId \n patientId===" + patientId);
        //System.out.println(analyzesService.findPatientAnalyses(patientId));
        return analyzesService.findPatientAnalyses(patientId);
    }

}

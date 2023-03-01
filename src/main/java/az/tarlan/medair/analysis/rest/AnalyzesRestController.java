package az.tarlan.medair.analysis.rest;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.analysis.service.AnalyzesService;
import az.tarlan.medair.deseaseHistory.service.DeseaseHistoryService;
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

    @Autowired
    public AnalyzesRestController(AnalyzesService analyzesService) {
        this.analyzesService = analyzesService;
    }

    @PostMapping("/analyses")
    public AnalyzesReqBody addAnalyses(@RequestBody AnalyzesReqBody analizList) throws IOException {
        System.out.println("addAnalyses");
        System.out.println(analizList.toString());
        analyzesService.saveAnalyzes(analizList);
        return analizList;
    }

    @PostMapping("/analysesImage")
    public String addAnalyzesImage(@RequestParam("file") MultipartFile file) throws IOException {
        String result="";
        System.out.println(file.toString());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getBytes());

//        System.out.println("src/main/resources/"+file.getOriginalFilename());
//        File file1 = new File("src/main/resources/"+file.getOriginalFilename());
//        file.transferTo(file1);
        if (file != null) {
            System.out.println(uploadPath);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                System.out.println("dont");
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
             result=uploadPath + "/" + resultFileName;
            System.out.println(result);
            file.transferTo(new File("/" + resultFileName));

        }
        file:///C:/uploads/4336621f-6395-4d2a-a32d-b37b380cea0f.rrrr.jpg
        return result;
    }

    @GetMapping("/analyses/{patientId}")
    public List<AnalyzesMedia> findAnalysesByPatientId(@PathVariable int patientId) {
        System.out.println("1. findAnalysesByPatientId \n patientId===" + patientId);
        return analyzesService.findPatientAnalyses(patientId);
    }

}

package az.tarlan.medair.analysis.rest;

import az.tarlan.medair.Upload;
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

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
@Component
public class AnalyzesRestController {

    private final AnalyzesService analyzesService;
    private final Upload upload;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${server.ip}")
    private String serverIp;

    private static final Logger logger = LoggerFactory.getLogger(AnalyzesRestController.class);
    private static final String LOG_ANALYZE_REQ_BODY = "AnalyzesReqBody";

    @Autowired
    public AnalyzesRestController(AnalyzesService analyzesService, Upload upload) {
        this.analyzesService = analyzesService;
        this.upload = upload;
    }

    @GetMapping("/analysid")
    public int getAnalysesId(){
        int newAnalysisId = analyzesService.getAnalysId();
        logger.info("getAnalysesId : newAnalysisId = {}", newAnalysisId);
        return newAnalysisId;
    }

    @PostMapping("/analyses")
    public AnalyzesReqBody addAnalyses(@RequestBody AnalyzesReqBody analysisRequestBody) throws IOException {
        logger.info(LOG_ANALYZE_REQ_BODY);
        analyzesService.saveAnalyzes(analysisRequestBody);
        return analysisRequestBody;
    }

    @PostMapping("/analyses/image")
    public String addAnalysesImage(@RequestParam("file") MultipartFile file) throws IOException {
        logger.info("addAnalysesImage");
        return uploadImage(file);
    }

    @GetMapping("/analyses/{patientId}")
    public List<AnalyzesMedia> findAnalysesByPatientId(@PathVariable int patientId) {
        logger.info("findAnalysesByPatientId");
        return analyzesService.findPatientAnalyses(patientId);
    }

    private String uploadImage(MultipartFile file) throws IOException {
        return upload.UploadImage(file, uploadPath, serverIp);
    }
}
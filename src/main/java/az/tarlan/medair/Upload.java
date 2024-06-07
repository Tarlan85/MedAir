
package az.tarlan.medair;

import az.tarlan.medair.analysis.rest.AnalyzesRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.UUID;

@Component
public class Upload {
//    @Value("${upload.path}")
//    private String uploadPath;
//    @Value("${server.ip}")
//    private String serverIp;
    private static final Logger logger = LoggerFactory.getLogger(Upload.class);

    public String UploadImage(MultipartFile file,String uploadPath,String serverIp) {
        logger.info("UploadImage");
        String result = "";
        if (file != null && !file.isEmpty()) {
            try {
                System.out.println("uploadPath = "+uploadPath);
                Path uploadDir = Paths.get(uploadPath);

                Files.createDirectories(uploadDir);

                String uuidFile = UUID.randomUUID().toString().substring(0,6);
                String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String resultFileName = System.currentTimeMillis() + uuidFile + fileExtension;
                result = serverIp + "/" + resultFileName;

                Path filePath = uploadDir.resolve(resultFileName);
                Files.copy(file.getInputStream(), filePath);

                logger.info("ContentUrl = {}", result);
            } catch (IOException e) {
                logger.error("Failed to upload file", e);
                return ""; // Пустая строка возвращается в случае ошибки
            }
        }
        System.out.println("result = "+result);
        return result;
    }
}

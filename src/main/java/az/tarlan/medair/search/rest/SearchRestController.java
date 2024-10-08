package az.tarlan.medair.search.rest;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.search.entity.SearchForVite;
import az.tarlan.medair.search.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class SearchRestController {
    private static final Logger logger = LoggerFactory.getLogger(SearchRestController.class);
    private final SearchService searchService;

    @Autowired
    public SearchRestController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public List<Vite> getPatient(@RequestBody(required = false) SearchForVite searchBody) {
        logger.info("Поиск пациента с критериями: {}", searchBody);

        if (searchBody == null || isEmptySearchCriteria(searchBody)) {
            logger.info("Критерии поиска пусты, возвращаем всех пациентов.");
            return searchService.findAll();
        }

        List<Vite> patients = searchService.find(searchBody);
        return patients.isEmpty() ? List.of() : patients;  // Возвращаем пустой список вместо null
    }

    private boolean isEmptySearchCriteria(SearchForVite searchBody) {
        return searchBody.getPatientId() == 0 &&
                isNullOrEmpty(searchBody.getPatientName()) &&
                isNullOrEmpty(searchBody.getPatientSurName()) &&
                isNullOrEmpty(searchBody.getPhoneNumber());
    }
    public static boolean isNullOrEmpty(String str) {
       // return str == null || str.isEmpty();
        return Optional.ofNullable(str).map(String::isEmpty).orElse(true);
    }
}

package az.tarlan.medair.search.rest;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.patients.rest.PatientRestController;
import az.tarlan.medair.patients.service.PatientService;
import az.tarlan.medair.search.entity.SearchForVite;
import az.tarlan.medair.search.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "localhost:3000"}, allowedHeaders={"Accept"})
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
@Component
public class SearchRestController {
    //    private PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(SearchRestController.class);
    private SearchService searchService;

    //quick and dirty:inject employee dao(use constructor injection )
    @Autowired
    public SearchRestController(SearchService searchService) {
        this.searchService = searchService;
    }


    //    @GetMapping("/search/{patientId}")
//    public Vite getPatientById(@PathVariable int patientId){
//        Vite thePatient = patientService.findById(patientId);
//        if(thePatient ==null){
//            throw new RuntimeException("Patient id not found - "+patientId);
//        }
//    return thePatient;
//    }
    @PostMapping("/search")
    public List<Vite> getPatient(@RequestBody(required = false) SearchForVite searchBody) {
        logger.info("getPatient");
        System.out.println("================");
        System.out.println(searchBody.toString());
        //System.out.println("getPatient");
        if (searchBody.toString() == null) return null;
        if (searchBody.getPatientId() == 0 &&
                (searchBody.getPatientName() == null || searchBody.getPatientName().equals("")) &&
                (searchBody.getPatientSurName() == null || searchBody.getPatientSurName().equals(""))
                && (searchBody.getPhoneNumber() == null || searchBody.getPhoneNumber().equals(""))) {
            System.out.println("1.");
            List<Vite> thePatient = searchService.findAll();
            return thePatient;
        }
        //System.out.println(searchBody.toString());
        List<Vite> thePatient = searchService.find(searchBody);
//        Vite thePatient = patientService.findById(patientVite.getPatientId());
        if (thePatient == null) {

//            throw new RuntimeException("Patient id not found - "+searchBody.getPatientId());
//            return thePatient;
        }
        return thePatient;
    }
}

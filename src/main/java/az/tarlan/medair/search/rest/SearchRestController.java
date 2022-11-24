package az.tarlan.medair.search.rest;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.patients.service.PatientService;
import az.tarlan.medair.search.entity.SearchForVite;
import az.tarlan.medair.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "localhost:3000"}, allowedHeaders={"Accept"})
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class SearchRestController {
//    private PatientService patientService;
    private SearchService searchService;
    //quick and dirty:inject employee dao(use constructor injection )
    @Autowired
    public SearchRestController(SearchService searchService){
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
    public List<Vite> getPatient(@RequestBody(required = false) SearchForVite searchBody){
        System.out.println("getPatient");
        if (searchBody.toString()==null) return null;
        System.out.println(searchBody.toString());
        List<Vite> thePatient = searchService.find(searchBody);
//        Vite thePatient = patientService.findById(patientVite.getPatientId());
        if(thePatient ==null){

//            throw new RuntimeException("Patient id not found - "+searchBody.getPatientId());
//            return thePatient;
        }
        return thePatient;
    }
}

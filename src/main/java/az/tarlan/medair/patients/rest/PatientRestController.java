package az.tarlan.medair.patients.rest;

import az.tarlan.medair.patients.entity.*;
import az.tarlan.medair.patients.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = { "localhost:3000"}, allowedHeaders={"Accept"})
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class PatientRestController {
    private PatientService patientService;
    //dsdsds
    //quick and dirty:inject employee dao(use constructor injection )
    @Autowired
    public PatientRestController(PatientService thePatientService){
        patientService = thePatientService;
    }


    @GetMapping("/patients/{patientId}")
    public Vite getPatientIdBy(@PathVariable int patientId){
        Vite thePatient = patientService.findById(patientId);
        if(thePatient ==null){
//            throw new RuntimeException("Patient id not found - "+patientId);
//            thePatient.setPatientName("Patient id not found - "+patientId);
        }
    return thePatient;
    }
    @GetMapping("/vite/{patientId}")
    public Vite getPatientById(@PathVariable int patientId){
        Vite thePatient = patientService.findById(patientId);
        if(thePatient ==null){
//            throw new RuntimeException("Patient id not found - "+patientId);
//            thePatient.setPatientName("Patient id not found - "+patientId);
        }
        return thePatient;
    }
    //
    @GetMapping("/patientid")
    public int getPatientId(){
        int thePatient = patientService.getPatientId();
                return thePatient;
    }

//    @GetMapping("/patients/search")

//    public List<PatientVisits> getPatientByName(@RequestBody PatientVisits patient){
//
//        if(patientService.findByName(patient) ==null){
//            throw new RuntimeException("Patient  not found - "+patient.toString());
//        }
//        return patientService.findByName(patient);
//    }

    @PostMapping("/vite")
    public Vite addPatient(@RequestBody Vite thePatientVite){
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        if (thePatientVite.getPatientId()<1)
        thePatientVite.setPatientId(0);
        //System.out.println("============vite=============");
        //System.out.println(thePatientVite.toString());
        //System.out.println("=============vite============");
        patientService.saveThePatientVita(thePatientVite);
        return thePatientVite;
    }



    @DeleteMapping("/vite/{patientId}")
    public String deletePatient(@PathVariable int patientId){
        Vite tempPatient = patientService.findById(patientId);
        //throw  exception if null
        if(tempPatient ==null)
            throw new RuntimeException("Patient Id not found - "+patientId);
        patientService.deleteById(patientId);
        return "Delete patient id - "+patientId;
    }
}

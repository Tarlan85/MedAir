package az.tarlan.medair.morby.rest;

import az.tarlan.medair.morby.entity.MorbyReqBody;
import az.tarlan.medair.morby.service.MorbyService;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import az.tarlan.medair.treatment.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class MorbyRestController {
    private MorbyService morbyService;
    @Autowired
    public MorbyRestController(MorbyService morbyService) {
        this.morbyService=morbyService;
    }


//    @PostMapping("/morby")
//    public TreatmentReqBody addTreatment(@RequestBody MorbyReqBody morbyReqBody){
//        System.out.println(">>>>>>>>MORBY<<<<<<<<<");
//        if (morbyReqBody.getPatientsComplaintsId()>0)System.out.println(morbyReqBody.toString());
//        else{
//            morbyReqBody.setPatientsComplaintsId(0);
//        System.out.println(morbyReqBody.toString());}
//        morbyService.saveMorby(morbyReqBody);
//        return null;
//    }

}

package az.tarlan.medair.deseaseHistory.rest;

import az.tarlan.medair.deseaseHistory.service.DeseaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class DeseaseHistoryRestController {
    private DeseaseHistoryService deseaseHistoryService;
    @Autowired
    public DeseaseHistoryRestController(DeseaseHistoryService deseaseHistoryService) {
        this.deseaseHistoryService = deseaseHistoryService;
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

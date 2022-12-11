package az.tarlan.medair.deseaseHistory.rest;

import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;
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


    @PostMapping("/morby")
    public DeseaseReqBody addTreatment(@RequestBody DeseaseReqBody deseaseReqBody){
        System.out.println(">>>>>>>>MORBY<<<<<<<<<");
       System.out.println(deseaseReqBody.toString());
        deseaseHistoryService.saveDeseaseHistory(deseaseReqBody);
        return null;
    }

}

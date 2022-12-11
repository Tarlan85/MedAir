package az.tarlan.medair.analysis.rest;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.analysis.service.AnalyzesService;
import az.tarlan.medair.deseaseHistory.service.DeseaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class AnalyzesRestController {
    private AnalyzesService analyzesService;
    @Autowired
    public AnalyzesRestController(AnalyzesService analyzesService) {
        this.analyzesService = analyzesService;
    }

    @PostMapping("/analyses")
    public AnalyzesReqBody addAnalyses(@RequestBody AnalyzesReqBody analizList){
        System.out.println("addAnalyses");
        System.out.println(analizList.toString());
//        for(int i=0;1>analyzesReqBody.getAnalyzesMediaList().size();i++)
//        System.out.println("i = "+analyzesReqBody.getAnalyzesMediaList().get(i).toString() );
        //also, just  in case  the pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
//        if (breastAnalyzes.getAnalyzId()>0)System.out.println(breastAnalyzes.toString());
//        else
//            breastAnalyzes.setAnalyzId(0);
//        patientService.saveBreastAnalyzes(breastAnalyzes);
        analyzesService.saveAnalyzes(analizList);

        return analizList;
    }
    @GetMapping("/analyses/{patientId}")
    public List<AnalyzesMedia> findAnalysesByPatientId(@PathVariable int patientId){
        System.out.println("1. findAnalysesByPatientId \n patientId==="+patientId);
        return analyzesService.findPatientAnalyses(patientId);
    }

}

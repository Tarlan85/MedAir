package az.tarlan.medair.analysis.DAO;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.visits.entity.PatientVisits;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AnalyzDAOImpl implements AnalyzDAO{
    private EntityManager entityManager;

    public AnalyzDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveAnalyzes(AnalyzesReqBody analyzesReqBody) {
        System.out.println("saveAnalyzes");
        AnalyzesMedia dbAnalyzesMedia;
        if (analyzesReqBody.getAnalyzesMediaList().size()>0){
            Query theQuery=entityManager.createQuery("delete from AnalyzesMedia where  patientId=:patientId");
            theQuery.setParameter("patientId",analyzesReqBody.getPatientId());
            theQuery.executeUpdate();
        }
        for(int i=0;i<analyzesReqBody.getAnalyzesMediaList().size();i++){
        dbAnalyzesMedia =entityManager.merge(analyzesReqBody.getAnalyzesMediaList().get(i));
        if(analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesId()==0)
        dbAnalyzesMedia.setAnalyzesId(dbAnalyzesMedia.getAnalyzesId());
                dbAnalyzesMedia.setPatientId(analyzesReqBody.getPatientId());
        }
        //update  with id in db ... so we can get generation id for save / insert
//        dbBreastAnalyzes.setAnalyzId(dbBreastAnalyzes.getAnalyzId());
    }
    @Override
    public List<AnalyzesMedia> findPatientAnalyses(int patientId) {
        System.out.println("2. findPatientAnalyses");
        Query theQuery=entityManager.createQuery("From AnalyzesMedia where patientId = "+patientId);
        List<AnalyzesMedia> analyzesMedia = theQuery.getResultList();
        System.out.println("3. "+analyzesMedia.toString());
        return analyzesMedia;
    }
}

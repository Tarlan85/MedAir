package az.tarlan.medair.analysis.DAO;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.visits.entity.PatientVisits;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

@Repository
public class AnalyzDAOImpl implements AnalyzDAO {
    private EntityManager entityManager;

    public AnalyzDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public int getAnalysId() {
        Query theQuery = entityManager.createQuery(" Select max(analyzesId) from AnalyzesMedia ");
        List list = theQuery.getResultList();
        if (list.get(0) == null) return 1;
        int analysId = (int) list.get(0);
        analysId = analysId + 1;
        return analysId;
    }

    @Override
    public void saveAnalyzes(AnalyzesReqBody analyzesReqBody) throws IOException {
        int analyzId = 0;
        System.out.println("saveAnalyzes");
        AnalyzesMedia dbAnalyzesMedia = new AnalyzesMedia();
        if (analyzesReqBody.getAnalyzesMediaList().size() > 0) {
            Query theQuery = entityManager.createQuery("delete from AnalyzesMedia where  patientId=:patientId");
            theQuery.setParameter("patientId", analyzesReqBody.getPatientId());
            theQuery.executeUpdate();
        }
        for (int i = 0; i < analyzesReqBody.getAnalyzesMediaList().size(); i++) {
            System.out.println("in for");
            dbAnalyzesMedia.setPatientId(analyzesReqBody.getPatientId());
            dbAnalyzesMedia.setAnalyzesDesc(analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesDesc());
            dbAnalyzesMedia.setAnalyzesType(analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesType());
            dbAnalyzesMedia.setAnalyzesContentName(analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesContentName());
            dbAnalyzesMedia.setAnalyzesSubeType(analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesSubeType());
            dbAnalyzesMedia.setDate(analyzesReqBody.getAnalyzesMediaList().get(i).getDate());
            dbAnalyzesMedia.setAnalyzesContentUrl(analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesContentUrl());
            System.out.println(dbAnalyzesMedia.toString());
           AnalyzesMedia analyzesMedia = entityManager.merge(dbAnalyzesMedia);
            if (analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesId() == 0)
                dbAnalyzesMedia.setAnalyzesId(analyzesMedia.getAnalyzesId());
//           n     dbAnalyzesMedia.setAnalyzesId(analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesId());
//
        }
        System.out.println("out for");
        //update  with id in db ... so we can get generation id for save / insert
//        dbBreastAnalyzes.setAnalyzId(dbBreastAnalyzes.getAnalyzId());

    }

    //    @Override
//    public void saveAnalyzes(AnalyzesReqBody analyzesReqBody) throws IOException {
//        //System.out.println("saveAnalyzes");
//        AnalyzesMedia dbAnalyzesMedia=new AnalyzesMedia();
//        if (analyzesReqBody.getAnalyzesMediaList().size()>0){
//            Query theQuery=entityManager.createQuery("delete from AnalyzesMedia where  patientId=:patientId");
//            theQuery.setParameter("patientId",analyzesReqBody.getPatientId());
//            theQuery.executeUpdate();
//        }
//        for(int i=0;i<analyzesReqBody.getAnalyzesMediaList().size();i++){
////            dbAnalyzesMedia.setAnalyzesContentByte(analyzesReqBody.getAnalyzesMediaList().get(i).getBytes());
////            dbAnalyzesMedia.setAnalyzesContentName(analyzesReqBody.getAnalyzesMediaList().get(i).getName());
////            dbAnalyzesMedia.setAnalyzesContentOriginalFileName(analyzesReqBody.getAnalyzesMediaList().get(i).getOriginalFilename());
////            dbAnalyzesMedia.setAnalyzesContentType(analyzesReqBody.getAnalyzesMediaList().get(i).getContentType());
////            dbAnalyzesMedia.setAnalyzesContentSize(analyzesReqBody.getAnalyzesMediaList().get(i).getSize());
//
////        dbAnalyzesMedia =entityManager.merge(analyzesReqBody.getAnalyzesMediaList().get(i));
//        dbAnalyzesMedia =entityManager.merge(dbAnalyzesMedia);
//        if(analyzesReqBody.getAnalyzesMediaList().get(i).getAnalyzesId()==0)
//        dbAnalyzesMedia.setAnalyzesId(dbAnalyzesMedia.getAnalyzesId());
//                dbAnalyzesMedia.setPatientId(analyzesReqBody.getPatientId());
//        }
//        //update  with id in db ... so we can get generation id for save / insert
////        dbBreastAnalyzes.setAnalyzId(dbBreastAnalyzes.getAnalyzId());
//    }
    @Override
    public List<AnalyzesMedia> findPatientAnalyses(int patientId) {
        //System.out.println("2. findPatientAnalyses");
        Query theQuery = entityManager.createQuery("From AnalyzesMedia where patientId = " + patientId);
        List<AnalyzesMedia> analyzesMedia = null;
        try {
            analyzesMedia = theQuery.getResultList();
        } catch (Exception e) {
            //System.out.println("err");
        }

//        //System.out.println("3. "+analyzesMedia.toString());
        return analyzesMedia;
    }
}

package az.tarlan.medair.treatment.DAO;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.search.DAO.SearchDAOJPAImpl;
import az.tarlan.medair.treatment.DAO.TreatmentDAO;
import az.tarlan.medair.treatment.entity.Recipe;
import az.tarlan.medair.treatment.entity.TreatmentDynamic;
import az.tarlan.medair.treatment.entity.TreatmentStatic;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Component
public class TreatmentDAOImpl implements TreatmentDAO {

    private EntityManager entityManager;
    private static final Logger logger= LoggerFactory.getLogger(TreatmentDAOImpl.class);
    @Autowired
    public TreatmentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveTreatment(TreatmentReqBody treatmentRB) {
        logger.info("saveTreatment");
        //System.out.println(">>>>>saveTreatment<<<<<");
        //delet all for patient
        Query theQuery=entityManager.createQuery("delete from TreatmentStatic where  patientId=:patientId");
        theQuery.setParameter("patientId",treatmentRB.getPatientId());
        theQuery.executeUpdate();
        TreatmentStatic dbTreatmentStatic = treatmentRB.getTreatmentStatic();
        dbTreatmentStatic.setPatientId(treatmentRB.getPatientId());

        TreatmentStatic treatmentStatic = entityManager.merge(dbTreatmentStatic);
        dbTreatmentStatic.setTreatmentId(treatmentStatic.getTreatmentId());
        //System.out.println(treatmentStatic.toString());

        List<Recipe> recipeList=treatmentRB.getRecipeList();
        Recipe recipe=new Recipe();
        if (recipeList.size()>0){
         theQuery=entityManager.createQuery("delete from Recipe where  patientId=:patientId");
        theQuery.setParameter("patientId",treatmentRB.getPatientId());
        theQuery.executeUpdate();}
        for (int i=0;i<recipeList.size();i++){
            recipeList.get(i).setPatientId(treatmentRB.getPatientId());
            recipe=  entityManager.merge(recipeList.get(i));
            recipeList.get(i).setRecipeId(recipe.getRecipeId());
            //System.out.println(recipe.toString());
        }
        List<TreatmentDynamic> treatmentDynamicsList=treatmentRB.getTreatmentDynamics();
        TreatmentDynamic treatmentDynamic=new TreatmentDynamic();
        if (treatmentDynamicsList.size()>0){
            theQuery=entityManager.createQuery("delete from TreatmentDynamic where  patientId=:patientId");
            theQuery.setParameter("patientId",treatmentRB.getPatientId());
            theQuery.executeUpdate();}
        for (int i=0;i<treatmentDynamicsList.size();i++){
            treatmentDynamicsList.get(i).setPatientId(treatmentRB.getPatientId());
            treatmentDynamic=  entityManager.merge(treatmentDynamicsList.get(i));
            treatmentDynamicsList.get(i).setTreatmentId(treatmentDynamic.getTreatmentId());
            //System.out.println(treatmentDynamic.toString());
        }

    }

    @Override
    public TreatmentReqBody findTreatmentAnalyses(int patientId) {
        logger.info("TreatmentReqBody");
        //System.out.println("2. findTreatmentAnalyses");
        TreatmentReqBody treatmentReqBody=new TreatmentReqBody();
        //System.out.println("From TreatmentStatic where patientId = "+patientId);
        Query theQuery=entityManager.createQuery("From TreatmentStatic where patientId = "+patientId);
        List<TreatmentStatic> treatmentStatic = theQuery.getResultList();
        //System.out.println("3.treatmentStatic =  "+treatmentStatic.toString());
        if (treatmentStatic.size()>0) {
            System.out.println(treatmentStatic.get(0));
            treatmentReqBody.setTreatmentStatic(treatmentStatic.get(0));
//            treatmentReqBody.setrecommendation(treatmentStatic.get(0).getrecommendation());
//            treatmentReqBody.setTreatmentId(treatmentStatic.get(0).getTreatmentId());
//            treatmentReqBody.setTreatmentDesc(treatmentStatic.get(0).getTreatmentDesc());
//            treatmentReqBody.setMenapause(treatmentStatic.get(0).getMenapause());
//            treatmentReqBody.setPreMenapause(treatmentStatic.get(0).getPreMenapause());
        }
        theQuery=entityManager.createQuery("From TreatmentDynamic where patientId = "+patientId);
        List<TreatmentDynamic> treatmentDynamics = theQuery.getResultList();
        //System.out.println("3. "+treatmentDynamics.toString());
        treatmentReqBody.setTreatmentDynamics(treatmentDynamics);
        theQuery=entityManager.createQuery("From Recipe where patientId = "+patientId);
        List<Recipe> recipeList = theQuery.getResultList();
        //System.out.println("3. "+recipeList.toString());
        treatmentReqBody.setRecipeList(recipeList);
        return treatmentReqBody;
    }
}
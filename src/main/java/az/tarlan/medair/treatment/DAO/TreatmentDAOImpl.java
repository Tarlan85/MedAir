package az.tarlan.medair.treatment.DAO;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.treatment.entity.Recipe;
import az.tarlan.medair.treatment.entity.TreatmentDynamic;
import az.tarlan.medair.treatment.entity.TreatmentStatic;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {

    private EntityManager entityManager;

    @Autowired
    public TreatmentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveTreatment(TreatmentReqBody treatmentRB) {
        System.out.println(">>>>>saveTreatment<<<<<");
        TreatmentStatic dbTreatmentStatic = new TreatmentStatic();
        dbTreatmentStatic.setPatientId(treatmentRB.getPatientId());
        dbTreatmentStatic.setTreatmentDesc(treatmentRB.getTreatmentDesc());
        dbTreatmentStatic.setMenapause(treatmentRB.getMenapause());
        dbTreatmentStatic.setPreMenapause(treatmentRB.getPreMenapause());
        dbTreatmentStatic.setrecommendation(treatmentRB.getrecommendation());

        TreatmentStatic treatmentStatic = entityManager.merge(dbTreatmentStatic);
        dbTreatmentStatic.setTreatmentId(treatmentStatic.getTreatmentId());
        System.out.println(treatmentStatic.toString());

        List<Recipe> recipeList=treatmentRB.getRecipeList();
        Recipe recipe=new Recipe();
        for (int i=0;i<recipeList.size();i++){
            recipeList.get(i).setPatientId(treatmentRB.getPatientId());
        recipe=  entityManager.merge(recipeList.get(i));
        recipeList.get(i).setRecipeId(recipe.getRecipeId());
            System.out.println(recipe.toString());
        }
        List<TreatmentDynamic> treatmentDynamicsList=treatmentRB.getTreatmentDynamics();
       TreatmentDynamic treatmentDynamic=new TreatmentDynamic();
        for (int i=0;i<treatmentDynamicsList.size();i++){
            treatmentDynamicsList.get(i).setPatientId(treatmentRB.getPatientId());
            treatmentDynamic=  entityManager.merge(treatmentDynamicsList.get(i));
            treatmentDynamicsList.get(i).setTreatmentId(treatmentDynamic.getTreatmentId());
            System.out.println(treatmentDynamic.toString());
        }

    }

    @Override
    public TreatmentReqBody findTreatmentAnalyses(int patientId) {
        System.out.println("2. findTreatmentAnalyses");
        TreatmentReqBody treatmentReqBody=new TreatmentReqBody();
        Query theQuery=entityManager.createQuery("From TreatmentStatic where patientId = "+patientId);
        List<TreatmentStatic> treatmentStatic = theQuery.getResultList();
        System.out.println("3. "+treatmentStatic.toString());
        treatmentReqBody.setrecommendation(treatmentStatic.get(0).getrecommendation());
        treatmentReqBody.setTreatmentId(treatmentStatic.get(0).getTreatmentId());
        treatmentReqBody.setTreatmentDesc(treatmentStatic.get(0).getTreatmentDesc());
        treatmentReqBody.setMenapause(treatmentStatic.get(0).getMenapause());
        treatmentReqBody.setPreMenapause(treatmentStatic.get(0).getPreMenapause());

        theQuery=entityManager.createQuery("From TreatmentDynamic where patientId = "+patientId);
        List<TreatmentDynamic> treatmentDynamics = theQuery.getResultList();
        System.out.println("3. "+treatmentDynamics.toString());
        treatmentReqBody.setTreatmentDynamics(treatmentDynamics);
        theQuery=entityManager.createQuery("From Recipe where patientId = "+patientId);
        List<Recipe> recipeList = theQuery.getResultList();
        System.out.println("3. "+recipeList.toString());
        treatmentReqBody.setRecipeList(recipeList);
        return treatmentReqBody;
    }
}
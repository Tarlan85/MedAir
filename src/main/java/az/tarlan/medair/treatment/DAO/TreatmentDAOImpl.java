package az.tarlan.medair.treatment.DAO;

import az.tarlan.medair.managers.entity.CureTabs;
import az.tarlan.medair.managers.entity.VisitPlaces;
import az.tarlan.medair.managers.managerDAO.ManagerDAO;
import az.tarlan.medair.treatment.entity.Recipe;
import az.tarlan.medair.treatment.entity.Treatment;
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
        Treatment dbTreatment = new Treatment();
//        dbTreatment.setTreatmentId(treatmentRB.getTreatmentId());
        dbTreatment.setPatientId(treatmentRB.getPatientId());
        dbTreatment.setTreatmentDate(treatmentRB.getTreatmentDate());
        dbTreatment.setTreatmentDesc(treatmentRB.getTreatmentDesc());
        dbTreatment.setBreastType(treatmentRB.getBreastType());
        dbTreatment.setAdvice(treatmentRB.getAdvice());
        dbTreatment.setMenapause(treatmentRB.getMenapause());
        dbTreatment.setPreMenapause(treatmentRB.getPreMenapause());

        Treatment treatment = entityManager.merge(dbTreatment);
        dbTreatment.setTreatmentId(treatment.getTreatmentId());
        System.out.println(treatment.toString());

//        Recipe dbRecipe=new Recipe();
//        dbRecipe.setCureTabId(treatmentRB.getCureTabId());
//        dbRecipe.setCureTabDose(treatmentRB.getCureTabDose());
//        dbRecipe.setDate(treatmentRB.getDate());
//        dbRecipe.setCureTabUsing(treatmentRB.getCureTabUsing());
//        dbRecipe.setPatientID(treatmentRB.getPatientId());
        List<Recipe> recipeList=treatmentRB.getListRecipe();
        Recipe recipe=new Recipe();
        for (int i=0;i<recipeList.size();i++){
            recipeList.get(i).setPatientId(treatmentRB.getPatientId());
        recipe=  entityManager.merge(recipeList.get(i));
        recipeList.get(i).setRecipeId(recipe.getRecipeId());
            System.out.println(recipe.toString());
        }
    }
}
package az.tarlan.medair.analysis.DAO;

import az.tarlan.medair.analysis.entity.BreastAnalyzes;

import javax.persistence.EntityManager;

public class AnalyzDAOImpl implements AnalyzDAO{
    private EntityManager entityManager;

    public AnalyzDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveBreastAnalyzes(BreastAnalyzes breastAnalyzes) {
        System.out.println("saveAnalyzes");
        BreastAnalyzes dbBreastAnalyzes =entityManager.merge(breastAnalyzes);
        //update  with id in db ... so we can get generation id for save / insert
        dbBreastAnalyzes.setAnalyzId(dbBreastAnalyzes.getAnalyzId());
    }
}

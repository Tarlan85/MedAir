package az.tarlan.medair.analysis.DAO;

import az.tarlan.medair.analysis.entity.BreastAnalyzes;

public interface AnalyzDAO {
//    public List<VisitTable> findAllVisits(String visDate);
    public void saveBreastAnalyzes(BreastAnalyzes breastAnalyzes);
}

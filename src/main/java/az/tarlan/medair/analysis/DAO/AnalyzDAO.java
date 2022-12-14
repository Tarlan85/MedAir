package az.tarlan.medair.analysis.DAO;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;

import java.util.List;

public interface AnalyzDAO {
    public List<AnalyzesMedia> findPatientAnalyses(int patientId);
    public void saveAnalyzes(AnalyzesReqBody analyzesReqBody);
}

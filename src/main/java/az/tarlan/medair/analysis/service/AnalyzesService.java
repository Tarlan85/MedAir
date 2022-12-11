package az.tarlan.medair.analysis.service;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;

import java.util.List;


public interface AnalyzesService {
    void saveAnalyzes(AnalyzesReqBody analyzesReqBody);
    public List<AnalyzesMedia> findPatientAnalyses(int patientId);
}

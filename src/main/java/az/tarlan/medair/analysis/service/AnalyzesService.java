package az.tarlan.medair.analysis.service;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;

import java.io.IOException;
import java.util.List;


public interface AnalyzesService {
    void saveAnalyzes(AnalyzesReqBody analyzesReqBody) throws IOException;

    public List<AnalyzesMedia> findPatientAnalyses(int patientId);

    int getAnalysId();
}

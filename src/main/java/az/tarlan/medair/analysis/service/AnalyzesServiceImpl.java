package az.tarlan.medair.analysis.service;

import az.tarlan.medair.analysis.DAO.AnalyzDAO;
import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import az.tarlan.medair.deseaseHistory.DAO.DeseaseHistoryDAO;
import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;
import az.tarlan.medair.deseaseHistory.service.DeseaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AnalyzesServiceImpl implements AnalyzesService {
    private AnalyzDAO analyzDAO;
    @Autowired
    public AnalyzesServiceImpl(AnalyzDAO analyzDAO) {
        this.analyzDAO = analyzDAO;
    }

    @Override
    @Transactional
    public void saveAnalyzes(AnalyzesReqBody analyzesReqBody) {
        analyzDAO.saveAnalyzes(analyzesReqBody);
    }

    @Override
    @Transactional
    public List<AnalyzesMedia> findPatientAnalyses(int patientId){
        return analyzDAO.findPatientAnalyses(patientId);
    }
}

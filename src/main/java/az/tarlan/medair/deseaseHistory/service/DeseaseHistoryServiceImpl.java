package az.tarlan.medair.deseaseHistory.service;

import az.tarlan.medair.deseaseHistory.DAO.DeseaseHistoryDAO;
import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DeseaseHistoryServiceImpl implements DeseaseHistoryService {
    private DeseaseHistoryDAO deseaseHistoryDAO;
    @Autowired
    public DeseaseHistoryServiceImpl(DeseaseHistoryDAO deseaseHistoryDAO) {
        this.deseaseHistoryDAO = deseaseHistoryDAO;
    }

    @Override
    @Transactional
    public void saveDeseaseHistory(DeseaseReqBody deseaseReqBody) {
      deseaseHistoryDAO.saveDeseaseHistory(deseaseReqBody);
    }

    @Override
    @Transactional
    public DeseaseReqBody findDeseaseHistoryByPatientId(int patientId) {
        return deseaseHistoryDAO.findDeseaseHistoryByPatientId(patientId);
    }

}

package az.tarlan.medair.deseaseHistory.service;

import az.tarlan.medair.deseaseHistory.DAO.DeseaseHistoryDAO;
import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DeseaseHistoryServiceImpl implements DeseaseHistoryService {
    private DeseaseHistoryDAO deseaseHistoryDAO;
    @Autowired
    public DeseaseHistoryServiceImpl(DeseaseHistoryDAO deseaseHistoryDAO) {
        this.deseaseHistoryDAO = deseaseHistoryDAO;
    }

    @Override
    @Transactional
    public DeseaseReqBody saveDeseaseHistory(DeseaseReqBody deseaseReqBody) {
      deseaseHistoryDAO.saveDeseaseHistory(deseaseReqBody);
        return deseaseReqBody;
    }

    @Override
    @Transactional
    public DeseaseReqBody findDeseaseHistoryByPatientId(int patientId) {
        return deseaseHistoryDAO.findDeseaseHistoryByPatientId(patientId);
    }

}

package az.tarlan.medair.deseaseHistory.DAO;


import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;

import java.util.List;

public interface DeseaseHistoryDAO {
    public void saveDeseaseHistory(DeseaseReqBody deseaseReqBody);

   DeseaseReqBody findDeseaseHistoryByPatientId(int patientId);
}

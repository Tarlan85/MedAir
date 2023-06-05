package az.tarlan.medair.deseaseHistory.service;

import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;


public interface DeseaseHistoryService {
        DeseaseReqBody saveDeseaseHistory(DeseaseReqBody deseaseReqBody);

    DeseaseReqBody findDeseaseHistoryByPatientId(int patientId);
}
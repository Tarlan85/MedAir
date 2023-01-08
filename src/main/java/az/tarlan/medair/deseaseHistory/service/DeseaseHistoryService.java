package az.tarlan.medair.deseaseHistory.service;

import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;

import java.util.List;


public interface DeseaseHistoryService {
        void saveDeseaseHistory(DeseaseReqBody deseaseReqBody);

    DeseaseReqBody findDeseaseHistoryByPatientId(int patientId);
}
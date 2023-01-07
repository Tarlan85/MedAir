package az.tarlan.medair.deseaseHistory.service;

import az.tarlan.medair.deseaseHistory.entity.DeseaseReqBody;

import org.springframework.transaction.annotation.Transactional;


public interface DeseaseHistoryService {
        void saveDeseaseHistory(DeseaseReqBody deseaseReqBody);
}
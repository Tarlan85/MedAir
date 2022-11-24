package az.tarlan.medair.morby.service;

import az.tarlan.medair.morby.DAO.MorbyDAO;
import az.tarlan.medair.morby.entity.MorbyReqBody;
import az.tarlan.medair.treatment.DAO.TreatmentDAO;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import az.tarlan.medair.treatment.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MorbyServiceImpl implements MorbyService {
    private MorbyDAO morbyDAO;
    @Autowired
    public MorbyServiceImpl(MorbyDAO morbyDAO) {
        this.morbyDAO=morbyDAO;
    }

    @Override
    @Transactional
    public void saveMorby(MorbyReqBody morbyReqBody) {
      morbyDAO.saveMorby(morbyReqBody);
    }

}

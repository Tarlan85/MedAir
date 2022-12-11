package az.tarlan.medair.search.service;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.patients.patientDAO.PatientDAO;
import az.tarlan.medair.search.DAO.SearchDAO;
import az.tarlan.medair.search.entity.SearchForVite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    PatientDAO patientDAO;
    SearchDAO searchDAO;
    @Autowired
    public SearchServiceImpl(PatientDAO patientDAO,SearchDAO searchDAO){
    this.patientDAO=patientDAO;
    this.searchDAO=searchDAO;
    }

    @Override
    @Transactional
    public Vite findById(int theId) {
        return patientDAO.findById(theId);
    }

    @Override
    @Transactional
    public List<Vite> find(SearchForVite searchForVite){return searchDAO.find(searchForVite);};
    }

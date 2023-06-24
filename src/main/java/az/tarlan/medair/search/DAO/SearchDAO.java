package az.tarlan.medair.search.DAO;


import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.search.entity.SearchForVite;

import java.util.List;

public interface SearchDAO {
    public List<Vite> find(SearchForVite searchForVite);
    public List<Vite> findAll();

}
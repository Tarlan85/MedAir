package az.tarlan.medair.search.service;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.search.entity.SearchForVite;

import java.util.List;

public interface SearchService {

    public Vite findById(int theId);
    public List<Vite> find(SearchForVite searchForVite);
}
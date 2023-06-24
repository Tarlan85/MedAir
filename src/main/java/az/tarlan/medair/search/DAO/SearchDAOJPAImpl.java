package az.tarlan.medair.search.DAO;


import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.patients.patientDAO.PatientDAO;
import az.tarlan.medair.search.entity.SearchForVite;
import az.tarlan.medair.search.rest.SearchRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Component
public class SearchDAOJPAImpl implements SearchDAO {
    int k=0;
    private EntityManager entityManager;
    private int patientID;
    private static final Logger logger= LoggerFactory.getLogger(SearchDAOJPAImpl.class);
    @Autowired
    public SearchDAOJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    private String sql_concat(String tableName,String param){
        String sql="";

        if (param!=null){
            if( !param.equals("") & !param.equals("0") )
            if (k == 0){
                sql=sql+ tableName+" LIKE '%"+param+"%'";
                k++;}
            else    sql=sql+" and "+tableName+" LIKE '%"+param+"%'";
        }
        return sql;
    }
    @Override
    public List<Vite> find(SearchForVite searchForVite) {
        logger.info("find");
        //System.out.println("find====k="+k);
        k=0;
        //System.out.println("find==1==k="+k);
        String sql="";

        sql=sql_concat("patientId",String.valueOf(searchForVite.getPatientId()));
        sql=sql+sql_concat("patientName", searchForVite.getPatientName());
        sql=sql+sql_concat("phoneNumber", searchForVite.getPhoneNumber());
        sql=sql+sql_concat("patientSurName", searchForVite.getPatientSurName());

        //System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("sql==FROM Vite where "+sql);
        Query theQuery=entityManager.createQuery("FROM Vite where "+sql);
        List<Vite> patients =theQuery.getResultList();
        //System.out.println(patients.toString());
        //execute query and get result list
            if (patients.toString().equals("[]")) patients= null;
        k=0;
        return patients;
    }

    @Override
    public List<Vite> findAll() {
        logger.info("findAll");
        Query theQuery=entityManager.createQuery("FROM Vite  ORDER BY patientId DESC");
        List<Vite> patients =theQuery.getResultList();
        return patients;
    }
}
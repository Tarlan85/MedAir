package az.tarlan.medair.search.DAO;


import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.patients.patientDAO.PatientDAO;
import az.tarlan.medair.search.entity.SearchForVite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SearchDAOJPAImpl implements SearchDAO {
    int k=0;
    private EntityManager entityManager;
    private int patientID;

    @Autowired
    public SearchDAOJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    private String sql_concat(String tableName,String param){
        String sql="";

        if (param!=null){
            if( !param.equals("") & !param.equals("0") )
            if (k == 0){
                sql=sql+ tableName+"='"+param+"'";
                k++;}
            else    sql=sql+" and "+tableName+"='"+param+"'";
        }
        return sql;
    }
    @Override
    public List<Vite> find(SearchForVite searchForVite) {
        //System.out.println("find====k="+k);
        k=0;
        //System.out.println("find==1==k="+k);
        String sql="";

        sql=sql_concat("patientId",String.valueOf(searchForVite.getPatientId()));
        sql=sql+sql_concat("patientName", searchForVite.getPatientName());
        sql=sql+sql_concat("phoneNumber", searchForVite.getPhoneNumber());
        sql=sql+sql_concat("patientSurName", searchForVite.getPatientSurName());

        //System.out.println("+++++++++++++++++++++++++++++");
        //System.out.println("sql==FROM Vite where "+sql);
        Query theQuery=entityManager.createQuery("FROM Vite where "+sql);
        List<Vite> patients =theQuery.getResultList();
        //System.out.println(patients.toString());
        //execute query and get result list
            if (patients.toString().equals("[]")) patients= null;
        k=0;
        return patients;
    }
}
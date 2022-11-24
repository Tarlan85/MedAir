package az.tarlan.medair.patients.patientDAO;


import az.tarlan.medair.patients.entity.Vite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
public class PatientDAOJPAImpl implements PatientDAO {
    int k=0;
    private EntityManager entityManager;
    private int patientID;

    @Autowired
    public PatientDAOJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Vite findById(int theId) {
        //get patient
        Vite thePatient =entityManager.find(Vite.class,theId);
        //return result
        return thePatient;
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
//    @Override
//    public List<PatientVisits> findByFirstName(PatientVisits patientVisits) {
//        System.out.println("findByFirstName====k="+k);
//        k=0;
//        System.out.println("findByFirstName==1==k="+k);
//        String sql="";
//
//        sql=sql_concat("visit_id",String.valueOf(patientVisits.getVisitId()));
//        sql=sql+sql_concat("patient_id", String.valueOf(patientVisits.getPatientId()));
//        sql=sql+sql_concat("visit_date", patientVisits.getVisitDate().toString());
//        sql=sql+sql_concat("visit_reason", patientVisits.getVisitReason());
////        sql=sql+sql_concat("place_name", String.valueOf(patientVisits.getPatientVisits()));
//        sql=sql+sql_concat("recommendation_person", patientVisits.getRecommendationPerson());
//        sql=sql+sql_concat("visit_type", patientVisits.getVisitType());
//        sql=sql+sql_concat("visit_desc", patientVisits.getVisitDesc());
//        sql=sql+sql_concat("preliminary_diagnosis", patientVisits.getPreliminaryDiagnosis());
//
//        System.out.println("+++++++++++++++++++++++++++++");
//        System.out.println("sql==FROM Patient where "+sql);
//        Query theQuery=entityManager.createQuery("FROM Patient where "+sql);
//        List<PatientVisits> patients =theQuery.getResultList();
//        System.out.println(patients.toString());
//        //execute query and get result list
//            if (patients.toString().equals("[]")) patients= null;
//        k=0;
//        return patients;
//    }

    @Override
    public void saveThePatientVite(Vite thePatientVite) {
        System.out.println("1==="+patientID);
        Vite dbPatient =entityManager.merge(thePatientVite);
        //update  with id in db ... so we can get generation id for save / insert
        patientID=dbPatient.getPatientID();
        thePatientVite.setPatientID(patientID);
        System.out.println("PatientVite==="+thePatientVite.toString());
    }

    @Override
    public int getPatientId() {
        Query theQuery=entityManager.createQuery(" Select max(patientId) from Vite ");
        System.out.println(theQuery.getResultList());
        List list=theQuery.getResultList();
        if(list.get(0) == null) return 1;
        patientID= (int) list.get(0);
        patientID=patientID+1;
        System.out.println("return for front=="+patientID);
        return patientID;
    }

    @Override
    public void deleteById(int theId) {
        //delete  object with primary key
        Query theQuery=entityManager.createQuery("delete from Patient where id=:patientId");
        theQuery.setParameter("patientId",theId);
        theQuery.executeUpdate();
    }


}
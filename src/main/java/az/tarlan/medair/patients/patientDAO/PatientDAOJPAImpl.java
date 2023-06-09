package az.tarlan.medair.patients.patientDAO;


import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.patients.rest.PatientRestController;
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
public class PatientDAOJPAImpl implements PatientDAO {
    int k=0;
    private EntityManager entityManager;
    private int patientID;
    private static final Logger logger= LoggerFactory.getLogger(PatientRestController.class);
    @Autowired
    public PatientDAOJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Vite findById(int theId) {
        logger.info("findById");
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
//        //System.out.println("findByFirstName====k="+k);
//        k=0;
//        //System.out.println("findByFirstName==1==k="+k);
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
//        //System.out.println("+++++++++++++++++++++++++++++");
//        //System.out.println("sql==FROM Patient where "+sql);
//        Query theQuery=entityManager.createQuery("FROM Patient where "+sql);
//        List<PatientVisits> patients =theQuery.getResultList();
//        //System.out.println(patients.toString());
//        //execute query and get result list
//            if (patients.toString().equals("[]")) patients= null;
//        k=0;
//        return patients;
//    }

    @Override
    public void saveThePatientVite(Vite thePatientVite) {
        logger.info("saveThePatientVite");
        //System.out.println("1==="+patientID);
        Vite dbPatient =entityManager.merge(thePatientVite);
        //update  with id in db ... so we can get generation id for save / insert
        patientID=dbPatient.getPatientId();
        thePatientVite.setPatientId(patientID);
        //System.out.println("PatientVite==="+thePatientVite.toString());
//        Query query1 = entityManager.createNativeQuery("SET SQL_SAFE_UPDATES = 0;");
//        query1.executeUpdate();
//
//        Query query2 = entityManager.createNativeQuery("UPDATE visit_table " +
//                "JOIN patient_vite ON visit_table.patient_id = patient_vite.patient_id " +
//                "SET visit_table.patient_name = patient_vite.patient_name, " +
//                "visit_table.patient_surname = patient_vite.patient_surname, " +
//                "visit_table.patient_patronymic = patient_vite.patient_patronymic, " +
//                "visit_table.birth_date = patient_vite.birth_date, " +
//                "visit_table.recommendation_person = patient_vite.recommendation_person, " +
//                "visit_table.phone_number = patient_vite.phone_number " +
//                "WHERE visit_table.patient_id =patient_vite.patient_id;");
//        query2.executeUpdate();
////
//        Query query3 = entityManager.createNativeQuery("SET SQL_SAFE_UPDATES = 1;");
//        query3.executeUpdate();

    }

    @Override
    public int getPatientId() {
        logger.info("getPatientId");
        Query theQuery=entityManager.createQuery(" Select max(patientId) from Vite ");
        //System.out.println(theQuery.getResultList());
        List list=theQuery.getResultList();
        if(list.get(0) == null) return 1;
        patientID= (int) list.get(0);
        patientID=patientID+1;
        //System.out.println("return for front=="+patientID);
        return patientID;
    }

    @Override
    public void deleteById(int theId) {
        logger.info("deleteById");
        //delete  object with primary key
        Query theQuery=entityManager.createQuery("delete from Patient where id=:patientId");
        theQuery.setParameter("patientId",theId);
        theQuery.executeUpdate();
    }


}
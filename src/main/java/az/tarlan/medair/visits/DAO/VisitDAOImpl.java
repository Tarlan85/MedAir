package az.tarlan.medair.visits.DAO;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
public class VisitDAOImpl implements VisitDAO{
    private EntityManager entityManager;
    private int patientID;

    public VisitDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<VisitTable> findAllVisits(String visDate) {
//        Query theQuery=entityManager.createQuery("From VisitTable where visitDate>=now() ");
        System.out.println("========== "+visDate);
        Query theQuery=entityManager.createQuery("From VisitTable where date(visitDate) >= date('"+visDate+"')");

        System.out.println("==JOIN==");
        List<VisitTable> patients =theQuery.getResultList();

        return patients;
    }
    @Override
    public void saveVisitTable(VisitTable visitTable) {
        System.out.println("VisitID == "+visitTable.getId());
//        if (patientVisits.getVisitId()==0){
//            System.out.println("THEN");
//        VisitTable dbVisitTable=entityManager.merge(visitTable);
//        visitTable.setId(dbVisitTable.getId());
        System.out.println("UPDATE VisitTable SET status = '"+visitTable.getStatus()+"'" +
                " WHERE id='"+visitTable.getId()+"'");
        Query theQuery=entityManager.createQuery("UPDATE VisitTable SET status = '"+visitTable.getStatus()+"'" +
                " WHERE id='"+visitTable.getId()+"'");
        theQuery.executeUpdate();
    }

    @Override
    public void savePatientVisits(PatientVisits patientVisits) {
//        System.out.println("VisitID == "+patientVisits.getVisitId());
//        if (patientVisits.getVisitId()==0){
//            System.out.println("THEN");
        PatientVisits dbPatientVisits=entityManager.merge(patientVisits);
        patientVisits.setVisitId(dbPatientVisits.getVisitId());


        System.out.println("22222=="+dbPatientVisits.toString());
        Query theQuery=entityManager.createQuery("insert into VisitTable (visitDate,patientId,patientName,patientSurName,patientFather," +
                "birthDate,visitReason,placeName,recommendationPerson,phoneNumber,status)" +
                " SELECT patientVisits.visitDate,vite.patientId, vite.patientName,vite.patientSurName," +
                "vite.patientFather,vite.birthDate,patientVisits.visitReason,patientVisits.placeName," +
                "patientVisits.recommendationPerson,vite.phoneNumber,patientVisits.status FROM PatientVisits patientVisits" +
                " INNER JOIN Vite vite  ON patientVisits.patientId=vite.patientId where patientVisits.patientId=:patientId");
        theQuery.setParameter("patientId",dbPatientVisits.getPatientId());theQuery.executeUpdate();
//    }
//        else {
//            System.out.println("Else");
//            PatientVisits dbPatientVisits=entityManager.merge(patientVisits);
//            patientVisits.setVisitId(dbPatientVisits.getVisitId());
//        }
    }
    @Override
    public PatientVisits findById(int id) {
        //get patient
        PatientVisits patientVisit =entityManager.find(PatientVisits.class,id);
        //return result
        return patientVisit;
    }
    @Override
    public void deleteById(int id) {
        //delete  object with primary key
        Query theQuery=entityManager.createQuery("delete from VisitTable where id=:id");
        theQuery.setParameter("id",id);
        theQuery.executeUpdate();
    }
}

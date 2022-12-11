package az.tarlan.medair.visits.DAO;

import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;
import az.tarlan.medair.visits.entity.VisitsRegBody;
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

//        Query theQuery=  entityManager.createQuery(
//                " SELECT patientVisits.visitDate,vite.patientId, vite.patientName,vite.patientSurName," +
//                        "vite.patientPatronymic,vite.birthDate,patientVisits.visitReason,patientVisits.placeName," +
//                        "vite.recommendationPerson,vite.phoneNumber,patientVisits.status FROM PatientVisits patientVisits " +
//                        " INNER JOIN Vite vite  ON patientVisits.patientId=vite.patientId "+
//                        "where date(patientVisits.visitDate) >= date('"+visDate+"')");

        List<VisitTable> patients = theQuery.getResultList();
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
    public void savePatientVisits(VisitsRegBody visitsRegBody) {
//        System.out.println("VisitID == "+patientVisits.getVisitId());
//        if (patientVisits.getVisitId()==0){
//            System.out.println("THEN");
        System.out.println("savePatientVisits");
        System.out.println(visitsRegBody.getPatientId());
        PatientVisits dbPatientVisits;
        int patientId=0;

        for(int i=0;i<visitsRegBody.getPatientVisitsList().size();i++) {
            patientId = visitsRegBody.getPatientId() == 0 ? visitsRegBody.getPatientVisitsList().get(i).getPatientId() : visitsRegBody.getPatientId();
            dbPatientVisits = entityManager.merge(visitsRegBody.getPatientVisitsList().get(i));
            if (visitsRegBody.getPatientVisitsList().get(i).getVisitId() == 0)
                dbPatientVisits.setVisitId(dbPatientVisits.getVisitId());
//            dbPatientVisits.setPatientId(visitsRegBody.getPatientId() == 0 ? visitsRegBody.getPatientVisitsList().get(i).getPatientId() : visitsRegBody.getPatientId());
            dbPatientVisits.setPatientId(patientId);
            System.out.println("22222==" + dbPatientVisits.toString());

        }
//        PatientVisits dbPatientVisits=entityManager.merge(patientVisits);
//        patientVisits.setVisitId(dbPatientVisits.getVisitId());



        Query theQuery=entityManager.createQuery("insert into VisitTable (visitDate,patientId,patientName,patientSurName,patientPatronymic," +
                "birthDate,visitReason,placeName,recommendationPerson,phoneNumber,status)" +
                " SELECT patientVisits.visitDate,vite.patientId, vite.patientName,vite.patientSurName," +
                "vite.patientPatronymic,vite.birthDate,patientVisits.visitReason,patientVisits.placeName," +
                "vite.recommendationPerson,vite.phoneNumber,patientVisits.status FROM PatientVisits patientVisits" +
                " INNER JOIN Vite vite  ON patientVisits.patientId=vite.patientId where patientVisits.patientId=:patientId and patientVisits.visitTableStatus=0");
        theQuery.setParameter("patientId",patientId);
        theQuery.executeUpdate();
        theQuery=entityManager.createQuery("UPDATE PatientVisits SET visitTableStatus=1 WHERE visitTableStatus=0");
        theQuery.executeUpdate();
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

    @Override
    public List<PatientVisits> findPatientVisits(int patientId) {
        System.out.println("2. findPatientVisits");
        Query theQuery=entityManager.createQuery("From PatientVisits where patientId = "+patientId);
//        theQuery.setParameter("id",patientId);
//        theQuery.executeUpdate();
        List<PatientVisits> visitTable = theQuery.getResultList();
        System.out.println("3. "+visitTable.toString());
        return visitTable;
    }
}

package az.tarlan.medair.visits.DAO;

import az.tarlan.medair.treatment.rest.TreatmentRestController;
import az.tarlan.medair.visits.entity.PatientVisits;
import az.tarlan.medair.visits.entity.VisitTable;
import az.tarlan.medair.visits.entity.VisitsRegBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VisitDAOImpl implements VisitDAO {
    private EntityManager entityManager;
    private int patientID;
    private static final Logger logger= LoggerFactory.getLogger(VisitDAOImpl.class);
    public VisitDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<VisitTable> findAllVisits(String visDate) {
        logger.info("findAllVisits");
        Query theQuery = entityManager.createQuery("FROM VisitTable WHERE date(visitDate) >= date(:visDate) ORDER BY visitDate ASC");
        theQuery.setParameter("visDate", visDate);
        List<VisitTable> patients = theQuery.getResultList();
        return patients;
    }
    //        Query theQuery=  entityManager.createQuery(
//                " SELECT patientVisits.visitDate,vite.patientId, vite.patientName,vite.patientSurName," +
//                        "vite.patientPatronymic,vite.birthDate,patientVisits.visitReason,patientVisits.placeName," +
//                        "vite.recommendationPerson,vite.phoneNumber,patientVisits.status FROM PatientVisits patientVisits " +
//                        " INNER JOIN Vite vite  ON patientVisits.patientId=vite.patientId "+
//                        "where date(patientVisits.visitDate) >= date('"+visDate+"')");

    @Override
    public void saveVisitTable(VisitTable visitTable) {
        logger.info("saveVisitTable");
        //System.out.println("VisitID == " + visitTable.getId());
        //System.out.println("UPDATE VisitTable SET status = '" + visitTable.getStatus() + "'" +
//                " WHERE id='" + visitTable.getId() + "'");
        Query theQuery = entityManager.createQuery("UPDATE VisitTable SET status = '" + visitTable.getStatus() + "'" +
                " WHERE id='" + visitTable.getId() + "'");
        theQuery.executeUpdate();
        String date = entityManager.createQuery("Select visitDate from VisitTable where id='" + visitTable.getId() + "'").getResultList().get(0).toString();
        //System.out.println("UPDATE PatientVisits SET status = '" + visitTable.getStatus() + "'" +
//                " WHERE visitDate='" + date + "'");
        theQuery = entityManager.createQuery("UPDATE PatientVisits SET status = '" + visitTable.getStatus() + "'" +
                " WHERE date(visitDate)=date('" + date + "')");
        theQuery.executeUpdate();

    }

    @Override
    public void savePatientVisits(VisitsRegBody visitsRegBody) {
        logger.info("savePatientVisits");
//        //System.out.println("VisitID == "+patientVisits.getVisitId());
//        if (patientVisits.getVisitId()==0){
//            //System.out.println("THEN");
        //System.out.println("savePatientVisits");
        //System.out.println(visitsRegBody.getPatientId());
        PatientVisits dbPatientVisits;
        int patientId = 0;
        if (visitsRegBody.getPatientVisitsList().size() > 0) {
            patientId = visitsRegBody.getPatientId() == 0 ? visitsRegBody.getPatientVisitsList().get(0).getPatientId() : visitsRegBody.getPatientId();
            Query theQuery = entityManager.createQuery("delete from VisitTable where patientId=:patientId");
            theQuery.setParameter("patientId", patientId);
            theQuery.executeUpdate();
            theQuery = entityManager.createQuery("delete from PatientVisits where  patientId=:patientId");
            theQuery.setParameter("patientId", patientId);
            theQuery.executeUpdate();
        }

        for (int i = 0; i < visitsRegBody.getPatientVisitsList().size(); i++) {
//            patientId = visitsRegBody.getPatientId() == 0 ? visitsRegBody.getPatientVisitsList().get(i).getPatientId() : visitsRegBody.getPatientId();
            dbPatientVisits = entityManager.merge(visitsRegBody.getPatientVisitsList().get(i));
            dbPatientVisits.setVisitTableStatus(0);
            if (visitsRegBody.getPatientVisitsList().get(i).getVisitId() == 0)
                dbPatientVisits.setVisitId(dbPatientVisits.getVisitId());
//            dbPatientVisits.setPatientId(visitsRegBody.getPatientId() == 0 ? visitsRegBody.getPatientVisitsList().get(i).getPatientId() : visitsRegBody.getPatientId());
            dbPatientVisits.setPatientId(patientId);
            //System.out.println("22222==" + dbPatientVisits.toString());

        }
//        PatientVisits dbPatientVisits=entityManager.merge(patientVisits);
//        patientVisits.setVisitId(dbPatientVisits.getVisitId());

        Query theQuery = entityManager.createQuery("insert into VisitTable (visitDate,patientId,patientName,patientSurName,patientPatronymic," +
                "birthDate,visitReason,placeName,recommendationPerson,phoneNumber,status)" +
                " SELECT patientVisits.visitDate,vite.patientId, vite.patientName,vite.patientSurName," +
                "vite.patientPatronymic,vite.birthDate,patientVisits.visitReason,patientVisits.placeName," +
                "vite.recommendationPerson,vite.phoneNumber,patientVisits.status FROM PatientVisits patientVisits" +

                " INNER JOIN Vite vite  ON patientVisits.patientId=vite.patientId where patientVisits.patientId=:patientId and patientVisits.visitTableStatus=0");
//        " INNER JOIN Vite vite  ON patientVisits.patientId=vite.patientId where patientVisits.patientId=:patientId");

        theQuery.setParameter("patientId", patientId);
        theQuery.executeUpdate();
        //System.out.println("INSEER");
        theQuery = entityManager.createQuery("UPDATE PatientVisits SET visitTableStatus=1 WHERE visitTableStatus=0");
        theQuery.executeUpdate();


//        theQuery.setParameter("patientId",dbPatientVisits.getPatientId());theQuery.executeUpdate();

//    }
//        else {
//            //System.out.println("Else");
//            PatientVisits dbPatientVisits=entityManager.merge(patientVisits);
//            patientVisits.setVisitId(dbPatientVisits.getVisitId());
//        }
    }

    @Override
    public PatientVisits findById(int id) {
        logger.info("findById");
        //get patient
        PatientVisits patientVisit = entityManager.find(PatientVisits.class, id);
        //return result
        return patientVisit;
    }
    @Override
    public VisitTable findByIdFromVT(int id) {
        logger.info("findByIdFromVT");
        //get patient
        VisitTable visitTable = entityManager.find(VisitTable.class, id);
        //return result
        return visitTable;
    }

    @Override
    public void deleteById(int id) {
        logger.info("deleteById");
        //delete  object with primary key
        Query theQuery = entityManager.createQuery("delete from VisitTable where id=:id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();
    }

    @Override
    public List<PatientVisits> findPatientVisits(int patientId) {
        logger.info("findPatientVisits");
        //System.out.println("2. findPatientVisits");
        Query theQuery = entityManager.createQuery("From PatientVisits where patientId = " + patientId);
//        theQuery.setParameter("id",patientId);
//        theQuery.executeUpdate();
        List<PatientVisits> visitTable = theQuery.getResultList();
        //System.out.println("3. " + visitTable.toString());
        return visitTable;
    }

    @Override
    public void addPatientVisitsFromCalendar(VisitsRegBody visitsRegBody) {
        logger.info("addPatientVisitsFromCalendar");

        //System.out.println("addPatientVisitsFromCalendar");
        //System.out.println(visitsRegBody.getPatientId());
        PatientVisits dbPatientVisits;
        int patientId = 0;

        for (int i = 0; i < visitsRegBody.getPatientVisitsList().size(); i++) {
            patientId = visitsRegBody.getPatientId() == 0 ? visitsRegBody.getPatientVisitsList().get(0).getPatientId() : visitsRegBody.getPatientId();
            dbPatientVisits = entityManager.merge(visitsRegBody.getPatientVisitsList().get(i));
            dbPatientVisits.setVisitTableStatus(0);
            if (visitsRegBody.getPatientVisitsList().get(i).getVisitId() == 0)
                dbPatientVisits.setVisitId(dbPatientVisits.getVisitId());
            dbPatientVisits.setPatientId(patientId);
            //System.out.println("add==" + dbPatientVisits.toString());

        }

        Query theQuery = entityManager.createQuery("insert into VisitTable (visitDate,patientId," +
                "patientName,patientSurName,patientPatronymic," +
                "birthDate,visitReason,placeName,recommendationPerson,phoneNumber,status)" +
                " SELECT patientVisits.visitDate,vite.patientId, vite.patientName,vite.patientSurName," +
                "vite.patientPatronymic,vite.birthDate,patientVisits.visitReason,patientVisits.placeName," +
                "vite.recommendationPerson,vite.phoneNumber,patientVisits.status FROM PatientVisits patientVisits" +

                " INNER JOIN Vite vite  ON patientVisits.patientId=vite.patientId where patientVisits.patientId=:patientId and patientVisits.visitTableStatus=0");
        theQuery.setParameter("patientId", patientId);
        theQuery.executeUpdate();
        //System.out.println("INSEER");
        theQuery = entityManager.createQuery("UPDATE PatientVisits SET visitTableStatus=1 WHERE visitTableStatus=0");
        theQuery.executeUpdate();
    }
}

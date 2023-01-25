package az.tarlan.medair.deseaseHistory.DAO;

import az.tarlan.medair.deseaseHistory.entity.*;
import az.tarlan.medair.treatment.entity.Recipe;
import az.tarlan.medair.treatment.entity.TreatmentDynamic;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import az.tarlan.medair.treatment.entity.TreatmentStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DeseaseHistoryDAOImpl implements DeseaseHistoryDAO {

    private EntityManager entityManager;

    @Autowired
    public DeseaseHistoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveDeseaseHistory(DeseaseReqBody deseaseReqBody) {
        System.out.println(">>>>saveMorby<<<");
        //Insert in Desease History Static
        DeseaseHistoryStatic dbDeseaseHistoryStatic = new DeseaseHistoryStatic();
        dbDeseaseHistoryStatic.setPatientId(deseaseReqBody.getPatientId());
        dbDeseaseHistoryStatic.setBenign(deseaseReqBody.getBeniqen());
        dbDeseaseHistoryStatic.setAllergyAvailability(deseaseReqBody.getAllergyAvailability());
        dbDeseaseHistoryStatic.setMaligant(deseaseReqBody.getMaliqan());
        dbDeseaseHistoryStatic.setOwnInjuryReason(deseaseReqBody.getOwnInjuryReason());
        dbDeseaseHistoryStatic.setMaligantQuestion(deseaseReqBody.getMaliqanQuestion());
        dbDeseaseHistoryStatic.setPreliminaryDiagnosis(deseaseReqBody.getPreliminaryDiagnosis());
        dbDeseaseHistoryStatic.setMedicationTaken(deseaseReqBody.getMedicationTaken());
        DeseaseHistoryStatic deseaseHistoryStatic = entityManager.merge(dbDeseaseHistoryStatic);
        System.out.println(deseaseHistoryStatic.toString());

        //insert in Operations
//        List<Operations> operationsList = deseaseReqBody.getOperationsList();
//        Operations dbOperations = new Operations();
//        if (operationsList != null)
//        for (int i = 0; i < operationsList.size(); i++) {
//            operationsList.get(i).setPatientId(deseaseReqBody.getPatientId());
//            dbOperations = entityManager.merge(operationsList.get(i));
//            operationsList.get(i).setIssueId(dbOperations.getIssueId());
//            System.out.println(dbOperations.toString());
//        }
//        else System.out.println("Operation is empty");
        //desease image list
        DeseaseImage deseaseImagesList = deseaseReqBody.getDeseaseImagesList();
        deseaseImagesList.setPatientId(deseaseReqBody.getPatientId());
        DeseaseImage         dbDeseaseImage = entityManager.merge(deseaseImagesList);
                deseaseImagesList.setId(dbDeseaseImage.getId());
                System.out.println(dbDeseaseImage.toString());
//        if (deseaseImagesList != null)
//            for (int i = 0; i < deseaseImagesList.size(); i++) {
//                deseaseImagesList.get(i).setPatientId(deseaseReqBody.getPatientId());
//                dbDeseaseImage = entityManager.merge(deseaseImagesList.get(i));
//                deseaseImagesList.get(i).setId(dbDeseaseImage.getId());
//                System.out.println(dbDeseaseImage.toString());
//            }
//        else System.out.println("Image is empty");
        //Insert in FamilyMembers
        List<FamilyMembers> familyMembersList = deseaseReqBody.getFamilyMembersList();
        FamilyMembers dbFamilyMembers = new FamilyMembers();
        if (familyMembersList!=null)
        for (int i = 0; i < familyMembersList.size(); i++) {
            familyMembersList.get(i).setPatientId(deseaseReqBody.getPatientId());
            dbFamilyMembers = entityManager.merge(familyMembersList.get(i));
            familyMembersList.get(i).setFamilyMembersId(dbFamilyMembers.getFamilyMembersId());
            System.out.println(dbFamilyMembers.toString());
        }else System.out.println("Family Members  is empty");
        //Insert in DeseaseHistoryDynamic
        List<DeseaseHistoryDynamic> deseaseHistoryDynamicsList = deseaseReqBody.getDeseaseHistoryDynamicsList();
        DeseaseHistoryDynamic dbDeseaseHistoryDynamics = new DeseaseHistoryDynamic();
        if (deseaseHistoryDynamicsList!=null)
            for (int i = 0; i < deseaseHistoryDynamicsList.size(); i++) {
                deseaseHistoryDynamicsList.get(i).setPatientId(deseaseReqBody.getPatientId());
                dbDeseaseHistoryDynamics = entityManager.merge(deseaseHistoryDynamicsList.get(i));
                deseaseHistoryDynamicsList.get(i).setPatientsComplaintsId(dbDeseaseHistoryDynamics.getPatientsComplaintsId());
                System.out.println(dbDeseaseHistoryDynamics.toString());
            }else System.out.println("Desease History Dynamic  is empty");

        }

    @Override
    public DeseaseReqBody findDeseaseHistoryByPatientId(int patientId) {
        System.out.println("2. findDeseaseHistoryByPatientId");
        DeseaseReqBody deseaseReqBody=new DeseaseReqBody();
        System.out.println("From DeseaseHistoryStatic where patientId = "+patientId);
        Query theQuery=entityManager.createQuery("From DeseaseHistoryStatic where patientId = "+patientId);
        List<DeseaseHistoryStatic> deseaseHistoryStatics = theQuery.getResultList();
        System.out.println("3.deseaseHistoryStatics =  "+deseaseHistoryStatics.toString());
        deseaseReqBody.setAllergyAvailability(deseaseHistoryStatics.get(0).getAllergyAvailability());
        deseaseReqBody.setBeniqen(deseaseHistoryStatics.get(0).getBenign());
        deseaseReqBody.setMaliqan(deseaseHistoryStatics.get(0).getMaligant());
        deseaseReqBody.setMaliqanQuestion(deseaseHistoryStatics.get(0).getMaligantQuestion());
        deseaseReqBody.setMedicationTaken(deseaseHistoryStatics.get(0).getMedicationTaken());
        deseaseReqBody.setOwnInjuryReason(deseaseHistoryStatics.get(0).getOwnInjuryReason());
        deseaseReqBody.setPreliminaryDiagnosis(deseaseHistoryStatics.get(0).getPreliminaryDiagnosis());

        theQuery=entityManager.createQuery("From DeseaseHistoryDynamic where patientId = "+patientId);
        List<DeseaseHistoryDynamic> deseaseHistoryDynamics = theQuery.getResultList();
        System.out.println("3. deseaseHistoryDynamics= "+deseaseHistoryDynamics.toString());
        deseaseReqBody.setDeseaseHistoryDynamicsList(deseaseHistoryDynamics);

        theQuery=entityManager.createQuery("From DeseaseImage where patientId = "+patientId);
        List<DeseaseImage> deseaseImages = theQuery.getResultList();
        if (deseaseImages.size()>0)
        deseaseReqBody.setDeseaseImagesList(deseaseImages.get(0));
        System.out.println("3.deseaseImages = "+deseaseImages.toString());

        theQuery=entityManager.createQuery("From FamilyMembers where patientId = "+patientId);
        List<FamilyMembers> familyMembersList = theQuery.getResultList();
        deseaseReqBody.setFamilyMembersList(familyMembersList);
        System.out.println("3.familyMembersList = "+familyMembersList.toString());

        return deseaseReqBody;
    }


    }
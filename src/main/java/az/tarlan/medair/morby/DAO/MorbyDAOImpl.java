package az.tarlan.medair.morby.DAO;

import az.tarlan.medair.morby.entity.FamilyMembers;
import az.tarlan.medair.morby.entity.MorbyReqBody;
import az.tarlan.medair.morby.entity.Operations;
import az.tarlan.medair.morby.entity.PatientsComplaints;
import az.tarlan.medair.treatment.DAO.TreatmentDAO;
import az.tarlan.medair.treatment.entity.Recipe;
import az.tarlan.medair.treatment.entity.Treatment;
import az.tarlan.medair.treatment.entity.TreatmentReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MorbyDAOImpl implements MorbyDAO {

    private EntityManager entityManager;

    @Autowired
    public MorbyDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveMorby(MorbyReqBody morbyReqBody) {
        System.out.println(">>>>saveMorby<<<");
        //Insert in PatientsComplaints
        PatientsComplaints dbPatientsComplaints = new PatientsComplaints();
        dbPatientsComplaints.setPatientId(morbyReqBody.getPatientId());
        dbPatientsComplaints.setComplaintPeriod(morbyReqBody.getComplaintPeriod());
        dbPatientsComplaints.setBeniqen(morbyReqBody.getBeniqen());
        dbPatientsComplaints.setComplaintBreastType(morbyReqBody.getComplaintBreastType());
        dbPatientsComplaints.setComplaintDescription(morbyReqBody.getComplaintDescription());
        dbPatientsComplaints.setAllergyAvailability(morbyReqBody.getAllergyAvailability());
        dbPatientsComplaints.setCancerType(morbyReqBody.getCancerType());
        dbPatientsComplaints.setIhkEr(morbyReqBody.getIhkEr());
        dbPatientsComplaints.setIhkHer2(morbyReqBody.getIhkHer2());
        dbPatientsComplaints.setIhkK67(morbyReqBody.getIhkK67());
        dbPatientsComplaints.setMaliqan(morbyReqBody.getMaliqan());
        dbPatientsComplaints.setIhkPr(morbyReqBody.getIhkPr());
        dbPatientsComplaints.setTF(morbyReqBody.getTF());
        dbPatientsComplaints.setOwnInjuryReason(morbyReqBody.getOwnInjuryReason());
        dbPatientsComplaints.setMaliqanQuestion(morbyReqBody.getMaliqanQuestion());
        dbPatientsComplaints.setReceivedTreatment(morbyReqBody.getReceivedTreatment());
//        dbPatientsComplaints.setOperationTypeId(morbyReqBody.getOperationTypeId());
        PatientsComplaints patientsComplaints = entityManager.merge(dbPatientsComplaints);
        dbPatientsComplaints.setPatientsComplaintsId(patientsComplaints.getPatientsComplaintsId());
        System.out.println(patientsComplaints.toString());

        //insert in Operations
        List<Operations> operationsList = morbyReqBody.getOperationsList();
        Operations dbOperations = new Operations();
        if (operationsList != null)
        for (int i = 0; i < operationsList.size(); i++) {
            operationsList.get(i).setPatientId(morbyReqBody.getPatientId());
            dbOperations = entityManager.merge(operationsList.get(i));
            operationsList.get(i).setIssueId(dbOperations.getIssueId());
            System.out.println(dbOperations.toString());
        }
        else System.out.println("Operation is empty");
        //Insert in FamilyMembers
        List<FamilyMembers> familyMembersList = morbyReqBody.getFamilyMembersList();
        FamilyMembers dbFamilyMembers = new FamilyMembers();
        if (familyMembersList!=null)
        for (int i = 0; i < familyMembersList.size(); i++) {
            familyMembersList.get(i).setPatientId(morbyReqBody.getPatientId());
            dbFamilyMembers = entityManager.merge(familyMembersList.get(i));
            familyMembersList.get(i).setFamilyMembersId(dbFamilyMembers.getFamilyMembersId());
            System.out.println(dbFamilyMembers.toString());
        }else System.out.println("Family Members  is empty");

    }
}
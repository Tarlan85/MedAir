package az.tarlan.medair.deseaseHistory.DAO;

import az.tarlan.medair.deseaseHistory.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
        dbDeseaseHistoryStatic.setBeniqen(deseaseReqBody.getBeniqen());
        dbDeseaseHistoryStatic.setAllergyAvailability(deseaseReqBody.getAllergyAvailability());
        dbDeseaseHistoryStatic.setMaliqan(deseaseReqBody.getMaliqan());
        dbDeseaseHistoryStatic.setOwnInjuryReason(deseaseReqBody.getOwnInjuryReason());
        dbDeseaseHistoryStatic.setMaliqanQuestion(deseaseReqBody.getMaliqanQuestion());
        DeseaseHistoryStatic deseaseHistoryStatic = entityManager.merge(dbDeseaseHistoryStatic);
        System.out.println(deseaseHistoryStatic.toString());

        //insert in Operations
        List<Operations> operationsList = deseaseReqBody.getOperationsList();
        Operations dbOperations = new Operations();
        if (operationsList != null)
        for (int i = 0; i < operationsList.size(); i++) {
            operationsList.get(i).setPatientId(deseaseReqBody.getPatientId());
            dbOperations = entityManager.merge(operationsList.get(i));
            operationsList.get(i).setIssueId(dbOperations.getIssueId());
            System.out.println(dbOperations.toString());
        }
        else System.out.println("Operation is empty");
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
                deseaseHistoryDynamicsList.get(i).setId(dbDeseaseHistoryDynamics.getId());
                System.out.println(dbDeseaseHistoryDynamics.toString());
            }else System.out.println("Desease History Dynamic  is empty");

        }
    }
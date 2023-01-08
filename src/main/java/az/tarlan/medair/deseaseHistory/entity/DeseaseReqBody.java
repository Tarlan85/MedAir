package az.tarlan.medair.deseaseHistory.entity;

import java.util.List;

public class DeseaseReqBody {

    List<FamilyMembers> familyMembersList;
    List<Operations> operationsList;
    DeseaseImage deseaseImagesList;
    List<DeseaseHistoryDynamic> deseaseHistoryDynamicsList;

    //DeseaseHistoryStatic
    private int patientId;
    private String allergyAvailability;
    private String ownInjuryReason;
    private String maliqan;
    private String beniqen;
    private String maliqanQuestion;
    private String preliminaryDiagnosis;
    private String medicationTaken;

    public DeseaseReqBody( ){

    }

    public DeseaseReqBody(List<FamilyMembers> familyMembersList,
                          List<Operations> operationsList,
                          DeseaseImage deseaseImagesList,
                          List<DeseaseHistoryDynamic> deseaseHistoryDynamicsList,
                          int patientId,
                          String allergyAvailability,
                          String ownInjuryReason,
                          String maliqan,
                          String beniqen,
                          String maliqanQuestion,
                          String preliminaryDiagnosis,
                          String medicationTaken) {
        this.familyMembersList = familyMembersList;
        this.operationsList = operationsList;
        this.deseaseHistoryDynamicsList = deseaseHistoryDynamicsList;
        this.patientId = patientId;
        this.allergyAvailability = allergyAvailability;
        this.ownInjuryReason = ownInjuryReason;
        this.maliqan = maliqan;
        this.beniqen = beniqen;
        this.maliqanQuestion = maliqanQuestion;
        this.preliminaryDiagnosis = preliminaryDiagnosis;
        this.medicationTaken = medicationTaken;
        this.deseaseImagesList=deseaseImagesList;
    }

    public List<FamilyMembers> getFamilyMembersList() {
        return familyMembersList;
    }

    public void setFamilyMembersList(List<FamilyMembers> familyMembersList) {
        this.familyMembersList = familyMembersList;
    }

    public List<Operations> getOperationsList() {
        return operationsList;
    }

    public void setOperationsList(List<Operations> operationsList) {
        this.operationsList = operationsList;
    }

    public List<DeseaseHistoryDynamic> getDeseaseHistoryDynamicsList() {
        return deseaseHistoryDynamicsList;
    }

    public void setDeseaseHistoryDynamicsList(List<DeseaseHistoryDynamic> deseaseHistoryDynamics) {
        this.deseaseHistoryDynamicsList = deseaseHistoryDynamics;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAllergyAvailability() {
        return allergyAvailability;
    }

    public DeseaseImage getDeseaseImagesList() {
        return deseaseImagesList;
    }

    public void setDeseaseImagesList(DeseaseImage deseaseImagesList) {
        this.deseaseImagesList = deseaseImagesList;
    }

    public void setAllergyAvailability(String allergyAvailability) {
        this.allergyAvailability = allergyAvailability;
    }

    public String getOwnInjuryReason() {
        return ownInjuryReason;
    }

    public void setOwnInjuryReason(String ownInjuryReason) {
        this.ownInjuryReason = ownInjuryReason;
    }

    public String getMaliqan() {
        return maliqan;
    }

    public void setMaliqan(String maliqan) {
        this.maliqan = maliqan;
    }

    public String getBeniqen() {
        return beniqen;
    }

    public void setBeniqen(String beniqen) {
        this.beniqen = beniqen;
    }

    public String getMaliqanQuestion() {
        return maliqanQuestion;
    }

    public void setMaliqanQuestion(String maliqanQuestion) {
        this.maliqanQuestion = maliqanQuestion;
    }

    public String getPreliminaryDiagnosis() {
        return preliminaryDiagnosis;
    }

    public void setPreliminaryDiagnosis(String preliminaryDiagnosis) {
        this.preliminaryDiagnosis = preliminaryDiagnosis;
    }

    public String getMedicationTaken() {
        return medicationTaken;
    }

    public void setMedicationTaken(String medicationTaken) {
        this.medicationTaken = medicationTaken;
        }
    @Override
    public String toString() {
        return "DeseaseReqBody{" +
                "familyMembersList=" + familyMembersList +"\n"+
                ", operationsList=" + operationsList +"\n"+
                ", deseaseHistoryDynamicsList=" + deseaseHistoryDynamicsList +"\n"+
                ", patientId=" + patientId +"\n"+
                ", allergyAvailability='" + allergyAvailability + '\'' +"\n"+
                ", ownInjuryReason='" + ownInjuryReason + '\'' +"\n"+
                ", maliqan='" + maliqan + '\'' +"\n"+
                ", beniqen='" + beniqen + '\'' +"\n"+
                ", maliqanQuestion='" + maliqanQuestion + '\'' +"\n"+
                ", preliminaryDiagnosis='" + preliminaryDiagnosis + '\'' +"\n"+
                ", medicationTaken='" + medicationTaken + '\'' +"\n"+
                ", deseaseImagesList='" + deseaseImagesList + '\'' +
                '}';
    }
}

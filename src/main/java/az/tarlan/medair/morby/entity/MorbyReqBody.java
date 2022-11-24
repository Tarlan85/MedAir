package az.tarlan.medair.morby.entity;

import javax.persistence.Column;
import java.util.List;

public class MorbyReqBody {
    //FamilyMembers
//    private int familyMembersId;

//    private String familyMember;
//    private String familyMemberInjury;
//    private String familyMemberDied;
//    private String familyMemberCurrentCancer;
    List<FamilyMembers> familyMembersList;

    //Operations
        //    private int issueId;
        //    private int issueDesc;
        //    private int pointType;
        //    private int pointX;
        //    private int pointY;
        //    private int imageId;
    List<Operations> operationsList;

    //PatientsComplaints
        private int patientId;
    private int patientsComplaintsId;
    private String complaintBreastType;
    private String complaintPeriod;
    private String complaintDescription;
    private String allergyAvailability;
    private String ownInjuryReason;
    private String receivedTreatment;
    private String cancerType;
    private int operationTypeId;
    private String maliqan;
    private String beniqen;
    private String maliqanQuestion;
    private String ihkEr;
    private String ihkPr;
    private String TF;
    private int ihkHer2;
    private int ihkK67;

    public MorbyReqBody( ){

    }

    public MorbyReqBody(List<FamilyMembers> familyMembersList, List<Operations> operationsList, int patientsComplaintsId,int patientId,
                        String complaintBreastType, String complaintPeriod, String complaintDescription,String TF,
                        String allergyAvailability, String ownInjuryReason, String receivedTreatment, String cancerType,
                        int operationTypeId, String maliqan, String beniqen, String maliqanQuestion, String ihkEr,
                        String ihkPr, int ihkHer2, int ihkK67) {
        this.patientId=patientId;
        this.familyMembersList = familyMembersList;
        this.operationsList = operationsList;
        this.patientsComplaintsId = patientsComplaintsId;
        this.complaintBreastType = complaintBreastType;
        this.complaintPeriod = complaintPeriod;
        this.complaintDescription = complaintDescription;
        this.allergyAvailability = allergyAvailability;
        this.ownInjuryReason = ownInjuryReason;
        this.receivedTreatment = receivedTreatment;
        this.cancerType = cancerType;
        this.operationTypeId = operationTypeId;
        this.maliqan = maliqan;
        this.beniqen = beniqen;
        this.maliqanQuestion = maliqanQuestion;
        this.ihkEr = ihkEr;
        this.ihkPr = ihkPr;
        this.ihkHer2 = ihkHer2;
        this.ihkK67 = ihkK67;
        this.TF = TF;
    }

    public String getTF() {
        return TF;
    }

    public void setTF(String TF) {
        this.TF = TF;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public int getPatientsComplaintsId() {
        return patientsComplaintsId;
    }

    public void setPatientsComplaintsId(int patientsComplaintsId) {
        this.patientsComplaintsId = patientsComplaintsId;
    }

    public String getComplaintBreastType() {
        return complaintBreastType;
    }

    public void setComplaintBreastType(String complaintBreastType) {
        this.complaintBreastType = complaintBreastType;
    }

    public String getComplaintPeriod() {
        return complaintPeriod;
    }

    public void setComplaintPeriod(String complaintPeriod) {
        this.complaintPeriod = complaintPeriod;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getAllergyAvailability() {
        return allergyAvailability;
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

    public String getReceivedTreatment() {
        return receivedTreatment;
    }

    public void setReceivedTreatment(String receivedTreatment) {
        this.receivedTreatment = receivedTreatment;
    }

    public String getCancerType() {
        return cancerType;
    }

    public void setCancerType(String cancerType) {
        this.cancerType = cancerType;
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(int operationTypeId) {
        this.operationTypeId = operationTypeId;
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

    public String getIhkEr() {
        return ihkEr;
    }

    public void setIhkEr(String ihkEr) {
        this.ihkEr = ihkEr;
    }

    public String getIhkPr() {
        return ihkPr;
    }

    public void setIhkPr(String ihkPr) {
        this.ihkPr = ihkPr;
    }

    public int getIhkHer2() {
        return ihkHer2;
    }

    public void setIhkHer2(int ihkHer2) {
        this.ihkHer2 = ihkHer2;
    }

    public int getIhkK67() {
        return ihkK67;
    }

    public void setIhkK67(int ihkK67) {
        this.ihkK67 = ihkK67;
    }

    @Override
    public String toString() {
        return "MorbyReqBody{" +
                "familyMembersList=" + familyMembersList +"\n" +
                ", operationsList=" + operationsList +
                ", patientId=" + patientId +
                ", patientsComplaintsId=" + patientsComplaintsId +
                ", complaintBreastType='" + complaintBreastType + "\n" +
                ", complaintPeriod='" + complaintPeriod + '\'' +
                ", complaintDescription='" + complaintDescription + '\'' +
                ", allergyAvailability='" + allergyAvailability + "\n" +
                ", ownInjuryReason='" + ownInjuryReason + '\'' +
                ", receivedTreatment='" + receivedTreatment + '\'' +
                ", cancerType='" + cancerType + "\n" +
                ", operationTypeId=" + operationTypeId +
                ", maliqan='" + maliqan + '\'' +
                ", beniqen='" + beniqen + "\n" +
                ", maliqanQuestion='" + maliqanQuestion + '\'' +
                ", ihkEr='" + ihkEr + '\'' +
                ", ihkPr='" + ihkPr + "\n" +
                ", ihkHer2=" + ihkHer2 +
                ", ihkK67=" + ihkK67 +
                ", TF=" + TF +
                '}';
    }
}

package az.tarlan.medair.morby.entity;


import javax.persistence.*;

@Entity
@Table(name = "patients_complaints")

public class PatientsComplaints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patients_complaints_id") //foreign key
    private int patientsComplaintsId;

    @Column(name = "patient_id") //foreign key
    private int patientId;

    @Column(name = "complaint_breast_type")
    private String complaintBreastType;

    @Column(name = "complaint_period")
    private String complaintPeriod;

    @Column(name = "complaint_description")
    private String complaintDescription;

    @Column(name = "allergy_availability")
    private String allergyAvailability;

    @Column(name = "own_injury_reason")
    private String ownInjuryReason;

    @Column(name = "received_treatment")
    private String receivedTreatment;

    @Column(name = "cancer_type")
    private String cancerType;

    @Column(name = "operation_type_id") //foreign key
    private int operationTypeId;

    @Column(name = "maliqan")
    private String maliqan;

    @Column(name = "beniqen")
    private String beniqen;

    @Column(name = "maliqan_question")
    private String maliqanQuestion;

    @Column(name = "IHK_ER")
    private String ihkEr;

    @Column(name = "IHK_PR")
    private String ihkPr;

    @Column(name = "IHK_HER2")
    private int ihkHer2;

    @Column(name = "IHK_K67")
    private int ihkK67;

    @Column(name = "TF")
    private String TF;

    public PatientsComplaints() {}

    public PatientsComplaints(int patientsComplaintsId, int patientId, String complaintBreastType, String complaintPeriod,
                              String complaintDescription, String allergyAvailability, String ownInjuryReason,
                              String receivedTreatment, String cancerType, int operationTypeId, String maliqan, String TF,
                              String beniqen, String maliqanQuestion, String ihkEr, String ihkPr, int ihkHer2, int ihkK67) {
        this.patientsComplaintsId = patientsComplaintsId;
        this.patientId = patientId;
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
        this.TF=TF;
    }

    public String getTF() {
        return TF;
    }

    public void setTF(String TF) {
        this.TF = TF;
    }

    public int getPatientsComplaintsId() {
        return patientsComplaintsId;
    }

    public void setPatientsComplaintsId(int patientsComplaintsId) {
        this.patientsComplaintsId = patientsComplaintsId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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
        return "PatientsComplaints = {" +
                "patientsComplaintsId=" + patientsComplaintsId +
                ", patientId=" + patientId +
                ", complaintBreastType='" + complaintBreastType + "\n" +
                ", complaintPeriod='" + complaintPeriod + '\'' +
                ", complaintDescription='" + complaintDescription + '\'' +
                ", allergyAvailability='" + allergyAvailability + "\n" +
                ", ownInjuryReason='" + ownInjuryReason + '\'' +
                ", receivedTreatment='" + receivedTreatment + '\'' +
                ", cancerType='" + cancerType + "\n" +
                ", operationTypeId=" + operationTypeId +
                ", maliqan='" + maliqan + '\'' +
                ", beniqen='" + beniqen + '\'' +
                ", maliqanQuestion='" + maliqanQuestion + "\n" +
                ", ihkEr='" + ihkEr + '\'' +
                ", ihkPr='" + ihkPr + '\'' +
                ", ihkHer2=" + ihkHer2 +
                ", ihkK67=" + ihkK67 +"\n" +
                ", TF=" + TF +
                '}';
    }
}

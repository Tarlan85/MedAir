package az.tarlan.medair.deseaseHistory.entity;


import javax.persistence.*;

@Entity
@Table(name = "desease_history_dynamic")

public class DeseaseHistoryDynamic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //foreign key
    private int patientsComplaintsId;

    @Column(name = "patient_id") //foreign key
    private int patientId;

    @Column(name = "complaint_breast_type")
    private String complaintBreastType;

    @Column(name = "duration_of_illness")
    private String durationOfIllness;
    @Column(name = "complaint_description")
    private String complaintDescription;


    @Column(name = "received_treatment")
    private String receivedTreatment;


    @Column(name = "ER_N")
    private String erN;

    @Column(name = "PR_N")
    private String prN;

    @Column(name = "HER2")
    private int her2;
    @Column(name = "HER2_FT")
    private String her2FT;

    @Column(name = "K67")
    private int k67;


    public DeseaseHistoryDynamic() {}

    public DeseaseHistoryDynamic(int patientsComplaintsId, int patientId, String complaintBreastType, String durationOfIllness, String complaintDescription, String receivedTreatment, String erN, String prN, int her2, String her2FT, int k67) {
        this.patientsComplaintsId = patientsComplaintsId;
        this.patientId = patientId;
        this.complaintBreastType = complaintBreastType;
        this.durationOfIllness = durationOfIllness;
        this.complaintDescription = complaintDescription;
        this.receivedTreatment = receivedTreatment;
        this.erN = erN;
        this.prN = prN;
        this.her2 = her2;
        this.her2FT = her2FT;
        this.k67 = k67;
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

    public String getDurationOfIllness() {
        return durationOfIllness;
    }

    public void setDurationOfIllness(String durationOfIllness) {
        this.durationOfIllness = durationOfIllness;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getReceivedTreatment() {
        return receivedTreatment;
    }

    public void setReceivedTreatment(String receivedTreatment) {
        this.receivedTreatment = receivedTreatment;
    }

    public String getErN() {
        return erN;
    }

    public void setErN(String erN) {
        this.erN = erN;
    }

    public String getPrN() {
        return prN;
    }

    public void setPrN(String prN) {
        this.prN = prN;
    }

    public int getHer2() {
        return her2;
    }

    public void setHer2(int her2) {
        this.her2 = her2;
    }

    public String getHer2FT() {
        return her2FT;
    }

    public void setHer2FT(String her2FT) {
        this.her2FT = her2FT;
    }

    public int getK67() {
        return k67;
    }

    public void setK67(int k67) {
        this.k67 = k67;
    }

    @Override
    public String toString() {
        return "DeseaseHistoryDynamic{" +
                "patientsComplaintsId=" + patientsComplaintsId +"\n"+
                "complaintDescription=" + complaintDescription +"\n"+
                ", patientId=" + patientId +"\n"+
                ", complaintBreastType='" + complaintBreastType + '\'' +"\n"+
                ", durationOfIllness='" + durationOfIllness + '\'' +"\n"+
                ", receivedTreatment='" + receivedTreatment + '\'' +"\n"+
                ", erN='" + erN + '\'' +"\n"+
                ", prN='" + prN + '\'' +"\n"+
                ", her2=" + her2 +"\n"+
                ", her2FT='" + her2FT + '\'' +"\n"+
                ", k67=" + k67 +
                '}';
    }
}

package az.tarlan.medair.deseaseHistory.entity;


import javax.persistence.*;

@Entity
@Table(name = "patients_complaints")

public class DeseaseHistoryStatic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //foreign key
    private int id;

    @Column(name = "patient_id") //foreign key
    private int patientId;

    @Column(name = "allergy_availability")
    private String allergyAvailability;

    @Column(name = "own_injury_reason")
    private String ownInjuryReason;

    @Column(name = "maliqan")
    private String maliqan;

    @Column(name = "beniqen")
    private String beniqen;

    @Column(name = "maliqan_question")
    private String maliqanQuestion;



    @Column(name = "preliminary_diagnosis")
    private String preliminaryDiagnosis;

    @Column(name = "medication_taken")
    private String medicationTaken;



    public DeseaseHistoryStatic() {}

    public DeseaseHistoryStatic(int id, int patientId, String allergyAvailability, String ownInjuryReason, String maliqan, String beniqen, String maliqanQuestion, String preliminaryDiagnosis, String medicationTaken) {
        this.id = id;
        this.patientId = patientId;
        this.allergyAvailability = allergyAvailability;
        this.ownInjuryReason = ownInjuryReason;
        this.maliqan = maliqan;
        this.beniqen = beniqen;
        this.maliqanQuestion = maliqanQuestion;
        this.preliminaryDiagnosis = preliminaryDiagnosis;
        this.medicationTaken = medicationTaken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "DeseaseHistoryStatic{" +
                "id=" + id +"\n"+
                ", patientId=" + patientId +"\n"+
                ", allergyAvailability='" + allergyAvailability + '\'' +"\n"+
                ", ownInjuryReason='" + ownInjuryReason + '\'' +"\n"+
                ", maliqan='" + maliqan + '\'' +"\n"+
                ", beniqen='" + beniqen + '\'' +"\n"+
                ", maliqanQuestion='" + maliqanQuestion + '\'' +"\n"+
                ", preliminaryDiagnosis='" + preliminaryDiagnosis + '\'' +"\n"+
                ", medicationTaken='" + medicationTaken + '\'' +
                '}';
    }
}

package az.tarlan.medair.deseaseHistory.entity;


import javax.persistence.*;

@Entity
@Table(name = "desease_history_static")

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

    @Column(name = "maligant")
    private String maligant;

    @Column(name = "benign")
    private String benign;

    @Column(name = "maligant_question")
    private String maligantQuestion;



    @Column(name = "preliminary_diagnosis")
    private String preliminaryDiagnosis;
    
    @Column(name = "medication_taken")
    private String medicationTaken;



    public DeseaseHistoryStatic() {}

    public DeseaseHistoryStatic(int id, int patientId, String allergyAvailability, String ownInjuryReason, String maligant, String benign, String maligantQuestion, String preliminaryDiagnosis, String medicationTaken) {
        this.id = id;
        this.patientId = patientId;
        this.allergyAvailability = allergyAvailability;
        this.ownInjuryReason = ownInjuryReason;
        this.maligant = maligant;
        this.benign = benign;
        this.maligantQuestion = maligantQuestion;
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

    public String getMaligant() {
        return maligant;
    }

    public void setMaligant(String maligant) {
        this.maligant = maligant;
    }

    public String getBenign() {
        return benign;
    }

    public void setBenign(String benign) {
        this.benign = benign;
    }

    public String getMaligantQuestion() {
        return maligantQuestion;
    }

    public void setMaligantQuestion(String maligantQuestion) {
        this.maligantQuestion = maligantQuestion;
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
                "id=" + id +
                ", patientId=" + patientId +
                ", allergyAvailability='" + allergyAvailability + '\'' +
                ", ownInjuryReason='" + ownInjuryReason + '\'' +
                ", maligant='" + maligant + '\'' +
                ", benign='" + benign + '\'' +
                ", maligantQuestion='" + maligantQuestion + '\'' +
                ", preliminaryDiagnosis='" + preliminaryDiagnosis + '\'' +
                ", medicationTaken='" + medicationTaken + '\'' +
                '}';
    }
}

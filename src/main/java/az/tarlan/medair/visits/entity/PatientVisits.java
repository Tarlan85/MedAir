package az.tarlan.medair.visits.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="patient_visits")

public class PatientVisits {
    //define field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="visit_id")
    private int visitId;

    @Column(name="patient_id") //foreign key
    private int patientId;

    @Column(name="visit_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Timestamp  visitDate;

    @Column(name="visit_reason")
    private String visitReason;

    @Column(name="status")
    private String status;

    @Column(name="place_name") //foreign key
    private String placeName;

    @Column(name="recommendation_person")
    private String recommendationPerson;

    @Column(name="visit_type")
    private String visitType;
    @Column(name="visit_desc")
    private String visitDesc;

    @Column(name="preliminary_diagnosis")
    private String preliminaryDiagnosis;

    //define constructor
    public PatientVisits() {}

    public PatientVisits(int visitId, int patientId, Timestamp visitDate, String visitReason, String status, String placeName, String recommendationPerson, String visitType, String visitDesc, String preliminaryDiagnosis) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.visitDate = visitDate;
        this.visitReason = visitReason;
        this.status = status;
        this.placeName = placeName;
        this.recommendationPerson = recommendationPerson;
        this.visitType = visitType;
        this.visitDesc = visitDesc;
        this.preliminaryDiagnosis = preliminaryDiagnosis;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getRecommendationPerson() {
        return recommendationPerson;
    }

    public void setRecommendationPerson(String recomendationPerson) {
        this.recommendationPerson = recomendationPerson;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getVisitDesc() {
        return visitDesc;
    }

    public void setVisitDesc(String visitDesc) {
        this.visitDesc = visitDesc;
    }

    public String getPreliminaryDiagnosis() {
        return preliminaryDiagnosis;
    }

    public void setPreliminaryDiagnosis(String preliminaryDyagnosis) {
        this.preliminaryDiagnosis = preliminaryDyagnosis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PatientVisits{" +
                "visitId=" + visitId +
                ", patientId=" + patientId +
                ", visitDate=" + visitDate +
                ", visitReason='" + visitReason + '\'' +
                ", status='" + status + '\'' +
                ", placeName='" + placeName + '\'' +
                ", recommendationPerson='" + recommendationPerson + '\'' +
                ", visitType='" + visitType + '\'' +
                ", visitDesc='" + visitDesc + '\'' +
                ", preliminaryDiagnosis='" + preliminaryDiagnosis + '\'' +
                '}';
    }
}

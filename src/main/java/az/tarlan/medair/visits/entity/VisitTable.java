package az.tarlan.medair.visits.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "visit_table")
public class VisitTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="visit_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Timestamp visitDate;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name="status")
    private String status;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_surname")
    private String patientSurName;

    @Column(name = "patient_father")
    private String patientFather;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name="visit_reason")
    private String visitReason;

    @Column(name="place_name") //foreign key
    private String placeName;

    @Column(name="recommendation_person")
    private String recommendationPerson;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Override
    public String toString() {
        return "VisitTable{" +
                "id=" + id +
                ", visitDate=" + visitDate +
                ", patientId=" + patientId +
                ", status='" + status + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientSurName='" + patientSurName + '\'' +
                ", patientFather='" + patientFather + '\'' +
                ", birthDate=" + birthDate +
                ", visitReason='" + visitReason + '\'' +
                ", placeName='" + placeName + '\'' +
                ", recommendationPerson='" + recommendationPerson + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurName() {
        return patientSurName;
    }

    public void setPatientSurName(String patientSurName) {
        this.patientSurName = patientSurName;
    }

    public String getPatientFather() {
        return patientFather;
    }

    public void setPatientFather(String patientFather) {
        this.patientFather = patientFather;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public void setRecommendationPerson(String recommendationPerson) {
        this.recommendationPerson = recommendationPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public VisitTable() {

    }

    public VisitTable(int id, Timestamp visitDate, int patientId, String status, String patientName, String patientSurName, String patientFather, Date birthDate, String visitReason, String placeName, String recommendationPerson, String phoneNumber) {
        this.id = id;
        this.visitDate = visitDate;
        this.patientId = patientId;
        this.status = status;
        this.patientName = patientName;
        this.patientSurName = patientSurName;
        this.patientFather = patientFather;
        this.birthDate = birthDate;
        this.visitReason = visitReason;
        this.placeName = placeName;
        this.recommendationPerson = recommendationPerson;
        this.phoneNumber = phoneNumber;
    }
}

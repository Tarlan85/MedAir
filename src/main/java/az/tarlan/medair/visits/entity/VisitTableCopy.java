package az.tarlan.medair.visits.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public class VisitTableCopy {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Timestamp visitDate;
    private int patientId;
    private String status;
    private String patientName;
    private String patientSurName;
    private String patientPatronymic;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    private String visitReason;
    private String placeName;
    private String recommendationPerson;
    private String phoneNumber;

    @Override
    public String toString() {
        return "VisitTableCopy{" +
                " visitDate=" + visitDate +
                ", patientId=" + patientId +
                ", status='" + status + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientSurName='" + patientSurName + '\'' +
                ", patientFather='" + patientPatronymic + '\'' +
                ", birthDate=" + birthDate +
                ", visitReason='" + visitReason + '\'' +
                ", placeName='" + placeName + '\'' +
                ", recommendationPerson='" + recommendationPerson + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
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

    public String getPatientPatronymic() {
        return patientPatronymic;
    }

    public void setPatientPatronymic(String patientFather) {
        this.patientPatronymic = patientFather;
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

    public VisitTableCopy() {

    }

    public VisitTableCopy( Timestamp visitDate, int patientId, String status, String patientName, String patientSurName, String patientPatronymic, Date birthDate, String visitReason, String placeName, String recommendationPerson, String phoneNumber) {
        this.visitDate = visitDate;
        this.patientId = patientId;
        this.status = status;
        this.patientName = patientName;
        this.patientSurName = patientSurName;
        this.patientPatronymic = patientPatronymic;
        this.birthDate = birthDate;
        this.visitReason = visitReason;
        this.placeName = placeName;
        this.recommendationPerson = recommendationPerson;
        this.phoneNumber = phoneNumber;
    }
}

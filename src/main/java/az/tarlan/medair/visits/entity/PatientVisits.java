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
    @Column(name="visit_table_status")
    private int visitTableStatus;

    @Column(name="patient_id") //foreign key
    private int patientId;

    @Column(name="visit_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Timestamp  visitDate;

    @Column(name="visit_reason")
    private String visitReason;

    @Column(name="visit_status")
    private String status;

    @Column(name="visit_place_name") //foreign key
    private String placeName;



    @Column(name="visit_type")
    private String visitType;
    @Column(name="visit_desc")
    private String visitDesc;

    @Column(name="blood_description")
    private String bloodDescription;

    @Column(name="lungs_description")
    private String lungsDescription;
    @Column(name="usm_description")
    private String usmDescription;

    @Column(name="maligant_reason_description")
    private String reasonDescription;


    //define constructor
    public PatientVisits() {}

    public PatientVisits(int visitId,
                         int visitTableStatus,
                         int patientId,
                         Timestamp visitDate,
                         String visitReason,
                         String status,
                         String placeName,
                         String visitType,
                         String visitDesc,
                         String bloodDescription,
                         String lungsDescription,
                         String usmDescription,
                         String reasonDescription) {
        this.visitId = visitId;
        this.visitTableStatus = visitTableStatus;
        this.patientId = patientId;
        this.visitDate = visitDate;
        this.visitReason = visitReason;
        this.status = status;
        this.placeName = placeName;
        this.visitType = visitType;
        this.visitDesc = visitDesc;
        this.bloodDescription = bloodDescription;
        this.lungsDescription = lungsDescription;
        this.usmDescription = usmDescription;
        this.reasonDescription = reasonDescription;
    }

    public int getVisitTableStatus() {
        return visitTableStatus;
    }

    public void setVisitTableStatus(int visitTableStatus) {
        this.visitTableStatus = visitTableStatus;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
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

    public String getBloodDescription() {
        return bloodDescription;
    }

    public void setBloodDescription(String bloodDescription) {
        this.bloodDescription = bloodDescription;
    }

    public String getLungsDescription() {
        return lungsDescription;
    }

    public void setLungsDescription(String lungsDescription) {
        this.lungsDescription = lungsDescription;
    }

    public String getUsmDescription() {
        return usmDescription;
    }

    public void setUsmDescription(String usmDescription) {
        this.usmDescription = usmDescription;
    }

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }


    @Override
    public String toString() {
        return "PatientVisits{" +
                "visitId=" + visitId +"\n"+
                "visitTableStatus=" + visitTableStatus +"\n"+
                ", patientId=" + patientId +"\n"+
                ", visitDate=" + visitDate +"\n"+
                ", visitReason='" + visitReason + '\'' +"\n"+
                ", status='" + status + '\'' +"\n"+
                ", placeName='" + placeName + '\'' +"\n"+
                ", visitType='" + visitType + '\'' +"\n"+
                ", visitDesc='" + visitDesc + '\'' +"\n"+
                ", bloodDescription='" + bloodDescription + '\'' +"\n"+
                ", lungsDescription='" + lungsDescription + '\'' +"\n"+
                ", usmDescription='" + usmDescription + '\'' +"\n"+
                ", reasonDescription='" + reasonDescription + '\'' +
                '}';
    }
}



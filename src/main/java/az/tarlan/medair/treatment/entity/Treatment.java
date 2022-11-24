package az.tarlan.medair.treatment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "treatment")

public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private int treatmentId;

    @Column(name = "patient_id")
    private int patientId;
    @JsonFormat(pattern="YYYY-MM-DD HH:mm:ss")
    @Column(name = "treatment_date")
    private Date treatmentDate;

    @Column(name = "treatment_desc")
    private String treatmentDesc;

    @Column(name = "breast_type")
    private String breastType;

    @Column(name = "pre_menapause")
    private String preMenapause;

    @Column(name = "menapause")
    private String menapause;

    @Column(name = "advice")
    private String advice;

    public Treatment() {}

    public Treatment(int treatmentId, int patientId, Date treatmentDate, String treatmentDesc, String breastType, String preMenapause, String menapause, String advice) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.treatmentDate = treatmentDate;
        this.treatmentDesc = treatmentDesc;
        this.breastType = breastType;
        this.preMenapause = preMenapause;
        this.menapause = menapause;
        this.advice = advice;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Date getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public String getTreatmentDesc() {
        return treatmentDesc;
    }

    public void setTreatmentDesc(String treatmentDesc) {
        this.treatmentDesc = treatmentDesc;
    }

    public String getBreastType() {
        return breastType;
    }

    public void setBreastType(String breastType) {
        this.breastType = breastType;
    }

    public String getPreMenapause() {
        return preMenapause;
    }

    public void setPreMenapause(String preMenapause) {
        this.preMenapause = preMenapause;
    }

    public String getMenapause() {
        return menapause;
    }

    public void setMenapause(String menapause) {
        this.menapause = menapause;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return "Treatment = {" +
                "treatmentId=" + treatmentId +"\n"+
                ", patientId=" + patientId +"\n"+
                ", treatmentDate=" + treatmentDate +"\n"+
                ", treatmentDesc='" + treatmentDesc + '\'' +"\n"+
                ", breastType='" + breastType + '\'' +"\n"+
                ", preMenapause='" + preMenapause + '\'' +"\n"+
                ", menapause='" + menapause + '\'' +"\n"+
                ", advice='" + advice + '\'' +
                '}';
    }
}

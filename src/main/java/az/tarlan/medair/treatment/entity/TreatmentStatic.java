package az.tarlan.medair.treatment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "treatment_static")

public class TreatmentStatic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private int treatmentId;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "treatment_desc")
    private String treatmentDesc;

//    @Column(name = "breast_type")
//    private String breastType;

    @Column(name = "pre_menapause")
    private String preMenapause;

    @Column(name = "menapause")
    private String menapause;

    @Column(name = "recommendation")
    private String recommendation;

    public TreatmentStatic() {}

    public TreatmentStatic(int treatmentId, int patientId, String treatmentDesc, String preMenapause, String menapause, String recommendation) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.treatmentDesc = treatmentDesc;
        this.preMenapause = preMenapause;
        this.menapause = menapause;
        this.recommendation = recommendation;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTreatmentDesc() {
        return treatmentDesc;
    }

    public void setTreatmentDesc(String treatmentDesc) {
        this.treatmentDesc = treatmentDesc;
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

    public String getrecommendation() {
        return recommendation;
    }

    public void setrecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "treatmentId=" + treatmentId +"\n"+
                ", patientId=" + patientId +"\n"+
                ", treatmentDesc='" + treatmentDesc + '\'' +"\n"+
                ", preMenapause='" + preMenapause + '\'' +"\n"+
                ", menapause='" + menapause + '\'' +"\n"+
                ", recommendation='" + recommendation + '\'' +
                '}';
    }
}

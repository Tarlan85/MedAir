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

    @Column(name = "advise")
    private String advise;

    @Column(name = "url_after")
    private String imageAfterUrl;

    @Column(name = "url_during")
    private String imageDuringUrl;

    @Column(name = "url_before")
    private String imageBeforeUrl;

    @Column(name = "image_name_after")
    private String imageAfterName;

    @Column(name = "image_name_during")
    private String imageDuringName;

    @Column(name = "image_name_before")
    private String imageBeforeName;

    public TreatmentStatic() {}


    public TreatmentStatic(int treatmentId, int patientId, String treatmentDesc, String preMenapause, String menapause, String recommendation, String advise, String imageAfterUrl, String imageDuringUrl, String imageBeforeUrl, String imageAfterName, String imageDuringName, String imageBeforeName) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.treatmentDesc = treatmentDesc;
        this.preMenapause = preMenapause;
        this.menapause = menapause;
        this.recommendation = recommendation;
        this.advise = advise;
        this.imageAfterUrl = imageAfterUrl;
        this.imageDuringUrl = imageDuringUrl;
        this.imageBeforeUrl = imageBeforeUrl;
        this.imageAfterName = imageAfterName;
        this.imageDuringName = imageDuringName;
        this.imageBeforeName = imageBeforeName;
    }

    public String getImageAfterUrl() {
        return imageAfterUrl;
    }

    public void setImageAfterUrl(String imageAfterUrl) {
        this.imageAfterUrl = imageAfterUrl;
    }

    public String getImageDuringUrl() {
        return imageDuringUrl;
    }

    public void setImageDuringUrl(String imageDuringUrl) {
        this.imageDuringUrl = imageDuringUrl;
    }

    public String getImageBeforeUrl() {
        return imageBeforeUrl;
    }

    public void setImageBeforeUrl(String imageBeforeUrl) {
        this.imageBeforeUrl = imageBeforeUrl;
    }

    public String getImageAfterName() {
        return imageAfterName;
    }

    public void setImageAfterName(String imageAfterName) {
        this.imageAfterName = imageAfterName;
    }

    public String getImageDuringName() {
        return imageDuringName;
    }

    public void setImageDuringName(String imageDuringName) {
        this.imageDuringName = imageDuringName;
    }

    public String getImageBeforeName() {
        return imageBeforeName;
    }

    public void setImageBeforeName(String imageBeforeName) {
        this.imageBeforeName = imageBeforeName;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
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

    @Override
    public String toString() {
        return "Treatment{" +
                "treatmentId=" + treatmentId +"\n"+
                ", patientId=" + patientId +"\n"+
                ", treatmentDesc='" + treatmentDesc + '\'' +"\n"+
                ", preMenapause='" + preMenapause + '\'' +"\n"+
                ", menapause='" + menapause + '\'' +"\n"+
                ", recommendation='" + recommendation + '\''+"\n"+
                ", advise='" + advise + '\'' +
                ", urlAfter='" + imageAfterUrl + '\'' +
                ", urlBefore='" + imageBeforeUrl + '\'' +
                ", urlDuring='" + imageDuringUrl + '\'' +
                ", nameAfter='" + imageAfterName + '\'' +
                ", nameBefore='" + imageBeforeName + '\'' +
                ", nameDuring='" + imageDuringName + '\'' +
                '}';
    }
}

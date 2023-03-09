package az.tarlan.medair.treatment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "treatment_dynamic")

public class TreatmentDynamic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private int treatmentId;


    @Column(name = "patient_id")
    private int patientId;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm")

    @Column(name = "treatment_date")
    private Date treatmentDate;

    @Column(name = "treatment_type_name")
    private String treatmentTypeName;

    @Column(name = "treatment_sub_type")
    private String treatmentSubType;

    @Column(name = "treatment_sub_sub_type")
    private String treatmentSubSubType;

    @Column(name = "treatment_type_desc")
    private String treatmentTypeDesc;

    @Column(name = "breast_type")
    private String breastType;

    @Column(name = "histology_urgent")
    private String histologyUrgent;

    @Column(name = "histology_final")
    private String histologyFinal;

    @Column(name = "SLNB_reactive")
    private int slnbReactive;

    @Column(name = "SLNB_mts")
    private int slnbMts;

    @Column(name = "axilla_desection_reactive")
    private int axillaDesectionReactive;

    @Column(name = "axilla_desection_mts")
    private int axillaDesectionMts;

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

    @Column(name = "pathologist")
    private String pathologist;


    public TreatmentDynamic() {}

    public TreatmentDynamic(int treatmentId,
                            int patientId,
                            Date treatmentDate,
                            String treatmentTypeName,
                            String treatmentSubType,
                            String treatmentSubSubType,
                            String treatmentTypeDesc,
                            String breastType,
                            String histologyUrgent,
                            String histologyFinal,
                            int slnbReactive,
                            int slnbMts,
                            int axillaDesectionReactive,
                            int axillaDesectionMts,
                            String erN,
                            String prN,
                            int her2,
                            String her2FT,
                            int k67,
                            String pathologist) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.treatmentDate = treatmentDate;
        this.treatmentTypeName = treatmentTypeName;
        this.treatmentSubType = treatmentSubType;
        this.treatmentSubSubType = treatmentSubSubType;
        this.treatmentTypeDesc = treatmentTypeDesc;
        this.breastType = breastType;
        this.histologyUrgent = histologyUrgent;
        this.histologyFinal = histologyFinal;
        this.slnbReactive = slnbReactive;
        this.slnbMts = slnbMts;
        this.axillaDesectionReactive = axillaDesectionReactive;
        this.axillaDesectionMts = axillaDesectionMts;
        this.erN = erN;
        this.prN = prN;
        this.her2 = her2;
        this.her2FT = her2FT;
        this.k67 = k67;
        this.pathologist = pathologist;
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

    public String getPathologist() {
        return pathologist;
    }

    public void setPathologist(String pathologist) {
        this.pathologist = pathologist;
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

    public String getTreatmentTypeName() {
        return treatmentTypeName;
    }

    public void setTreatmentTypeName(String treatmentTypeName) {
        this.treatmentTypeName = treatmentTypeName;
    }

    public String getTreatmentSubType() {
        return treatmentSubType;
    }

    public void setTreatmentSubType(String treatmentSubType) {
        this.treatmentSubType = treatmentSubType;
    }

    public String getTreatmentSubSubType() {
        return treatmentSubSubType;
    }

    public void setTreatmentSubSubType(String treatmentSubSubType) {
        this.treatmentSubSubType = treatmentSubSubType;
    }

    public String getTreatmentTypeDesc() {
        return treatmentTypeDesc;
    }

    public void setTreatmentTypeDesc(String treatmentTypeDesc) {
        this.treatmentTypeDesc = treatmentTypeDesc;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getBreastType() {
        return breastType;
    }

    public void setBreastType(String breastType) {
        this.breastType = breastType;
    }

    public String getHistologyUrgent() {
        return histologyUrgent;
    }

    public void setHistologyUrgent(String histologyUrgent) {
        this.histologyUrgent = histologyUrgent;
    }

    public String getHistologyFinal() {
        return histologyFinal;
    }

    public void setHistologyFinal(String histologyFinal) {
        this.histologyFinal = histologyFinal;
    }

    public int getSlnbReactive() {
        return slnbReactive;
    }

    public void setSlnbReactive(int slnbReactive) {
        this.slnbReactive = slnbReactive;
    }

    public int getSlnbMts() {
        return slnbMts;
    }

    public void setSlnbMts(int slnbMts) {
        this.slnbMts = slnbMts;
    }

    public int getAxillaDesectionReactive() {
        return axillaDesectionReactive;
    }

    public void setAxillaDesectionReactive(int axillaDesectionReactive) {
        this.axillaDesectionReactive = axillaDesectionReactive;
    }

    public int getAxillaDesectionMts() {
        return axillaDesectionMts;
    }

    public void setAxillaDesectionMts(int axillaDesectionMts) {
        this.axillaDesectionMts = axillaDesectionMts;
    }

    @Override
    public String toString() {
        return "TreatmentDynamic{" +
                "treatmentId=" + treatmentId +'\n' +
                ", patientId=" + patientId +'\n' +
                ", treatmentDate=" + treatmentDate +'\n' +
                ", treatmentTypeName='" + treatmentTypeName + '\'' +'\n' +
                ", treatmentSubType='" + treatmentSubType + '\'' +'\n' +
                ", treatmentSubSubType='" + treatmentSubSubType + '\'' +'\n' +
                ", treatmentTypeDesc='" + treatmentTypeDesc + '\'' +'\n' +
                ", breastType='" + breastType + '\'' +'\n' +
                ", histologyUrgent='" + histologyUrgent + '\'' +'\n' +
                ", histologyFinal='" + histologyFinal + '\'' +'\n' +
                ", slnbReactive=" + slnbReactive +'\n' +
                ", slnbMts=" + slnbMts +'\n' +
                ", axillaDesectionReactive=" + axillaDesectionReactive +'\n' +
                ", axillaDesectionMts=" + axillaDesectionMts +'\n' +
                ", erN='" + erN + '\'' +"\n"+
                ", prN='" + prN + '\'' +"\n"+
                ", her2=" + her2 +"\n"+
                ", her2FT='" + her2FT + '\'' +"\n"+
                ", k67=" + k67 +'\'' +"\n"+
                ", pathologist='" + pathologist +
                '}';
    }
}

package az.tarlan.medair.treatment.entity;

import javax.persistence.*;

@Entity
@Table(name = "treatment_types")

public class TreatmentTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private int treatmentId;

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

    @Column(name = "histology_result")
    private String histologyResult;

    @Column(name = "SLNB_reactive")
    private int slnbReactive;

    @Column(name = "SLNB_mts")
    private int slnbMts;

    @Column(name = "axilla_deseksiya_active")
    private int axillaDeseksiyaActive;

    @Column(name = "axilla_deseksiya_mts")
    private int axillaDeseksiyaMts;

    public TreatmentTypes() {}

    public TreatmentTypes(int treatmentId, String treatmentTypeName, String treatmentSubType, String treatmentSubSubType, String treatmentTypeDesc, String breastType, String histologyUrgent, String histologyResult, int slnbReactive, int slnbMts, int axillaDeseksiyaActive, int axillaDeseksiyaMts) {
        this.treatmentId = treatmentId;
        this.treatmentTypeName = treatmentTypeName;
        this.treatmentSubType = treatmentSubType;
        this.treatmentSubSubType = treatmentSubSubType;
        this.treatmentTypeDesc = treatmentTypeDesc;
        this.breastType = breastType;
        this.histologyUrgent = histologyUrgent;
        this.histologyResult = histologyResult;
        this.slnbReactive = slnbReactive;
        this.slnbMts = slnbMts;
        this.axillaDeseksiyaActive = axillaDeseksiyaActive;
        this.axillaDeseksiyaMts = axillaDeseksiyaMts;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
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

    public String getHistologyResult() {
        return histologyResult;
    }

    public void setHistologyResult(String histologyResult) {
        this.histologyResult = histologyResult;
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

    public int getAxillaDeseksiyaActive() {
        return axillaDeseksiyaActive;
    }

    public void setAxillaDeseksiyaActive(int axillaDeseksiyaActive) {
        this.axillaDeseksiyaActive = axillaDeseksiyaActive;
    }

    public int getAxillaDeseksiyaMts() {
        return axillaDeseksiyaMts;
    }

    public void setAxillaDeseksiyaMts(int axillaDeseksiyaMts) {
        this.axillaDeseksiyaMts = axillaDeseksiyaMts;
    }

    @Override
    public String toString() {
        return "treatmentTypes{" +
                "treatmentId=" + treatmentId +
                ", treatmentTypeName='" + treatmentTypeName + '\'' +
                ", treatmentSubType='" + treatmentSubType + '\'' +
                ", treatmentSubSubType='" + treatmentSubSubType + '\'' +
                ", treatmentTypeDesc='" + treatmentTypeDesc + '\'' +
                ", breastType='" + breastType + '\'' +
                ", histologyUrgent='" + histologyUrgent + '\'' +
                ", histologyResult='" + histologyResult + '\'' +
                ", slnbReactive=" + slnbReactive +
                ", slnbMts=" + slnbMts +
                ", axillaDeseksiyaActive=" + axillaDeseksiyaActive +
                ", axillaDeseksiyaMts=" + axillaDeseksiyaMts +
                '}';
    }
}

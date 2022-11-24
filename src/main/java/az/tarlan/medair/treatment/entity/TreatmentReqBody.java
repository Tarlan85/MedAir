package az.tarlan.medair.treatment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class TreatmentReqBody  {
        private int patientId;
    private int treatmentId;
    @JsonFormat(pattern="YYYY-MM-DD HH:mm:ss")
    private Date treatmentDate;
    private String treatmentDesc;
    private String breastType;
    private String preMenapause;
    private String menapause;
    private String advice;

    private String treatmentTypeName;
    private String treatmentSubType;
    private String treatmentSubSubType;
    private String treatmentTypeDesc;
    private String histologyUrgent;
    private String histologyResult;
    private int slnbReactive;
    private int slnbMts;
    private int axillaDeseksiyaActive;
    private int axillaDeseksiyaMts;

    private List<Recipe> listRecipe;

//    private int recipeId;
//    private Date date;
//    private int cureTabId;
//    private String cureTabDose;
//    private String cureTabUsing;

    public TreatmentReqBody() {}

    public TreatmentReqBody(int patientId, int treatmentId, Date treatmentDate, String treatmentDesc, String breastType, String preMenapause, String menapause, String advice, String treatmentTypeName, String treatmentSubType, String treatmentSubSubType, String treatmentTypeDesc, String histologyUrgent, String histologyResult, int slnbReactive, int slnbMts, int axillaDeseksiyaActive, int axillaDeseksiyaMts, List<Recipe> listRecipe) {
        this.patientId = patientId;
        this.treatmentId = treatmentId;
        this.treatmentDate = treatmentDate;
        this.treatmentDesc = treatmentDesc;
        this.breastType = breastType;
        this.preMenapause = preMenapause;
        this.menapause = menapause;
        this.advice = advice;
        this.treatmentTypeName = treatmentTypeName;
        this.treatmentSubType = treatmentSubType;
        this.treatmentSubSubType = treatmentSubSubType;
        this.treatmentTypeDesc = treatmentTypeDesc;
        this.histologyUrgent = histologyUrgent;
        this.histologyResult = histologyResult;
        this.slnbReactive = slnbReactive;
        this.slnbMts = slnbMts;
        this.axillaDeseksiyaActive = axillaDeseksiyaActive;
        this.axillaDeseksiyaMts = axillaDeseksiyaMts;
        this.listRecipe = listRecipe;
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

    public List<Recipe> getListRecipe() {
        return listRecipe;
    }

    public void setListRecipe(List<Recipe> listRecipe) {
        this.listRecipe = listRecipe;
    }

    @Override
    public String toString() {
        return "TreatmentReqBody = {" +
                "patientId=" + patientId +
                ", treatmentId=" + treatmentId +
                ", treatmentDate=" + treatmentDate +
                ", treatmentDesc='" + treatmentDesc + '\'' +
                ", breastType='" + breastType + '\'' +
                ", preMenapause='" + preMenapause + '\'' +
                ", menapause='" + menapause + '\'' +
                ", advice='" + advice + '\'' +
                ", treatmentTypeName='" + treatmentTypeName + '\'' +
                ", treatmentSubType='" + treatmentSubType + '\'' +
                ", treatmentSubSubType='" + treatmentSubSubType + '\'' +
                ", treatmentTypeDesc='" + treatmentTypeDesc + '\'' +
                ", histologyUrgent='" + histologyUrgent + '\'' +
                ", histologyResult='" + histologyResult + '\'' +
                ", slnbReactive=" + slnbReactive +
                ", slnbMts=" + slnbMts +
                ", axillaDeseksiyaActive=" + axillaDeseksiyaActive +
                ", axillaDeseksiyaMts=" + axillaDeseksiyaMts +
                ", listRecipe=" + listRecipe +
                '}';
    }
}

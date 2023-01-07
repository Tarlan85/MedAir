package az.tarlan.medair.treatment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class TreatmentReqBody  {
    //Treatment Static
    private int treatmentId;
    private int patientId;
    private String treatmentDesc;
    private String preMenapause;
    private String menapause;
    private String recommendation;

    //Treatment Dynamic
    List<TreatmentDynamic> treatmentDynamics;
    //Recipe
    List<Recipe> recipeList;

    public TreatmentReqBody() {
    }

    public TreatmentReqBody(int treatmentId, int patientId, String treatmentDesc, String preMenapause, String menapause, String recommendation, List<TreatmentDynamic> treatmentDynamics, List<Recipe> recipeList) {

        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.treatmentDesc = treatmentDesc;
        this.preMenapause = preMenapause;
        this.menapause = menapause;
        this.recommendation = recommendation;
        this.treatmentDynamics = treatmentDynamics;
        this.recipeList = recipeList;
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
        this.recommendation = recommendation;}

    public String getRecomendation() {
        return recommendation;
    }

    public List<TreatmentDynamic> getTreatmentDynamics() {
        return treatmentDynamics;
    }

    public void setTreatmentDynamics(List<TreatmentDynamic> treatmentDynamics) {
        this.treatmentDynamics = treatmentDynamics;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public String toString() {
        return "TreatmentReqBody{" +
                "treatmentId=" + treatmentId +'\n' +
                ", patientId=" + patientId +'\n' +
                ", treatmentDesc='" + treatmentDesc + '\'' +'\n' +
                ", preMenapause='" + preMenapause + '\'' +'\n' +
                ", menapause='" + menapause + '\'' +'\n' +

                ", recommendation='" + recommendation + '\'' +'\n' +
                ", treatmentDynamics=" + treatmentDynamics +'\n' +
                ", recipeList=" + recipeList +
                '}';
    }
}

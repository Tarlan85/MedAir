package az.tarlan.medair.treatment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class TreatmentReqBody  {
    //Treatment Static
//    private int treatmentId;
    private int patientId;
//    private String treatmentDesc;
//    private String preMenapause;
//    private String menapause;
//    private String recommendation;
    TreatmentStatic treatmentStatic;
    //Treatment Dynamic
    List<TreatmentDynamic> treatmentDynamics;
    //Recipe
    List<Recipe> recipeList;

    public TreatmentReqBody() {
    }

    public TreatmentReqBody(int patientId, TreatmentStatic treatmentStatic, List<TreatmentDynamic> treatmentDynamics, List<Recipe> recipeList) {
        this.patientId = patientId;
        this.treatmentStatic = treatmentStatic;
        this.treatmentDynamics = treatmentDynamics;
        this.recipeList = recipeList;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public TreatmentStatic getTreatmentStatic() {
        return treatmentStatic;
    }

    public void setTreatmentStatic(TreatmentStatic treatmentStatic) {
        this.treatmentStatic = treatmentStatic;
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
                "patientId=" + patientId +'\n' +
                "treatmentStatic=" + treatmentStatic +'\n' +
                ", treatmentDynamics=" + treatmentDynamics +'\n' +
                ", recipeList=" + recipeList +
                '}';
    }
}

package az.tarlan.medair.treatment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recipe")

public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int recipeId;


    @Column(name = "patient_id")
    private int patientId;


    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date")
    private Date date;

    @Column(name = "cure_tab_name")
    private String cureTabName;

    @Column(name = "cure_tab_dose")
    private String cureTabDose;

    @Column(name = "cure_tab_using")
    private String cureTabUsing;


    @Column(name = "cur_tab_type")
    private String cureTabType;

    public Recipe() {}

    public Recipe(int recipeId, int patientId, Date date, String cureTabName, String cureTabDose, String cureTabUsing, String cureTabType) {
        this.recipeId = recipeId;
        this.patientId = patientId;
        this.date = date;
        this.cureTabName = cureTabName;
        this.cureTabDose = cureTabDose;
        this.cureTabUsing = cureTabUsing;
        this.cureTabType = cureTabType;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCureTabName() {
        return cureTabName;
    }

    public void setCureTabName(String cureTabName) {
        this.cureTabName = cureTabName;
    }

    public String getCureTabDose() {
        return cureTabDose;
    }

    public void setCureTabDose(String cureTabDose) {
        this.cureTabDose = cureTabDose;
    }

    public String getCureTabUsing() {
        return cureTabUsing;
    }

    public void setCureTabUsing(String cureTabUsing) {
        this.cureTabUsing = cureTabUsing;
    }

    public String getCureTabType() {
        return cureTabType;
    }

    public void setCureTabType(String cureTabType) {
        this.cureTabType = cureTabType;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +"\n"+
                ", patientId=" + patientId +"\n"+
                ", date=" + date +"\n"+
                ", cureTabName='" + cureTabName + '\'' +"\n"+
                ", cureTabDose='" + cureTabDose + '\'' +"\n"+
                ", cureTabUsing='" + cureTabUsing + '\'' +"\n"+
                ", cureTabType='" + cureTabType + '\'' +
                '}';
    }
}

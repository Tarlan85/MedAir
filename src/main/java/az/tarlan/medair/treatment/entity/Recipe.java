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

    @Column(name = "cure_tab_id")
    private String cureTabId;

    @Column(name = "cure_tab_dose")
    private String cureTabDose;

    @Column(name = "cure_tab_using")
    private String cureTabUsing;


    @Column(name = "cur_tab_type")
    private String cureTabType;

    public Recipe() {}

    public Recipe( int patientId, int recipeId, Date date, String cureTabId, String cureTabDose, String cureTabUsing, String cureTabType) {

        this.patientId = patientId;
        this.recipeId = recipeId;
        this.date = date;
        this.cureTabId = cureTabId;
        this.cureTabDose = cureTabDose;
        this.cureTabUsing = cureTabUsing;
        this.cureTabType = cureTabType;
    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCureTabId() {
        return cureTabId;
    }

    public void setCureTabId(String cureTabId) {
        this.cureTabId = cureTabId;
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
        return "Recipe = {" +

                " patientId=" + patientId +
                ", recipeId=" + recipeId +
                ", date=" + date +
                ", cureTabId='" + cureTabId + '\'' +
                ", cureTabDose='" + cureTabDose + '\'' +
                ", cureTabUsing='" + cureTabUsing + '\'' +
                ", cureTabType='" + cureTabType + '\'' +
                '}';
    }
}

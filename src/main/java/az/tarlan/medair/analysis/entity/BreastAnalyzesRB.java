package az.tarlan.medair.analysis.entity;

import java.sql.Blob;
import java.util.ArrayList;

public class BreastAnalyzesRB {

    private int analyzId;
    private int patientId;
    private ArrayList<Blob> usmMedia;



    private String usmDesc;
    private ArrayList<Blob> mamagrafiyaMedia;

    public BreastAnalyzesRB() {
    }

    public BreastAnalyzesRB(int analyzId, int patientId, ArrayList<Blob> usmMedia, String usmDesc, ArrayList<Blob> mamagrafiyaMedia) {
        this.analyzId = analyzId;
        this.patientId = patientId;
        this.usmMedia = usmMedia;
        this.usmDesc = usmDesc;
        this.mamagrafiyaMedia = mamagrafiyaMedia;
    }

    public int getAnalyzId() {
        return analyzId;
    }

    public void setAnalyzId(int analyzId) {
        this.analyzId = analyzId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public ArrayList<Blob> getUsmMedia() {
        return usmMedia;
    }

    public void setUsmMedia(ArrayList<Blob> usmMedia) {
        this.usmMedia = usmMedia;
    }

    public String getUsmDesc() {
        return usmDesc;
    }

    public void setUsmDesc(String usmDesc) {
        this.usmDesc = usmDesc;
    }

    public ArrayList<Blob> getMamagrafiyaMedia() {
        return mamagrafiyaMedia;
    }

    public void setMamagrafiyaMedia(ArrayList<Blob> mamagrafiyaMedia) {
        this.mamagrafiyaMedia = mamagrafiyaMedia;
    }

    @Override
    public String toString() {
        return "BreastAnalyzesRB = {" +
                "analyzId=" + analyzId +
                ", patientId=" + patientId +
                ", usmMedia=" + usmMedia +
                ", usmDesc='" + usmDesc + '\'' +
                ", mamagrafiyaMedia=" + mamagrafiyaMedia +
                '}';
    }
    //    private String mamagrafiyaDesc;
//    private String tomosintezMedia;
//    private String tomosintezDesc;
//    private String mrtMedia;
//    private String mrtDesc;
//    private String ktMedia;
//    private String ktDesc;
//    private String biopsiyaMedia;
//    private String boipsiyaDesc;
//    private String klipsMedia;
//    private String klipsDesc;

}

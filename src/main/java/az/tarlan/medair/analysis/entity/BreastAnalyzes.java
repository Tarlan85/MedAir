package az.tarlan.medair.analysis.entity;

import javax.persistence.*;

@Entity
@Table(name = "breast_analyzes")

public class BreastAnalyzes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analyz_id")
    private int analyzId;



    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "usm_media")
    private String usmMedia;

    @Column(name = "usm_desc")
    private String usmDesc;

    @Column(name = "mamagrafiya_media")
    private String mamagrafiyaMedia;

    @Column(name = "mamagrafiya_desc")
    private String mamagrafiyaDesc;

    @Column(name = "tomosintez_media")
    private String tomosintezMedia;

    @Column(name = "tomosintez_desc")
    private String tomosintezDesc;

    @Column(name = "mrt_media")
    private String mrtMedia;

    @Column(name = "mrt_desc")
    private String mrtDesc;

    @Column(name = "kt_media")
    private String ktMedia;

    @Column(name = "kt_desc")
    private String ktDesc;

    @Column(name = "biopsiya_media")
    private String biopsiyaMedia;

    @Column(name = "boipsiya_desc")
    private String boipsiyaDesc;

    @Column(name = "klips_media")
    private String klipsMedia;

    @Column(name = "klips_desc")
    private String klipsDesc;

    public BreastAnalyzes() {}

    public BreastAnalyzes(int analyzId, int patientId, String usmMedia, String usmDesc, String mamagrafiyaMedia, String mamagrafiyaDesc, String tomosintezMedia, String tomosintezDesc, String mrtMedia, String mrtDesc, String ktMedia, String ktDesc, String biopsiyaMedia, String boipsiyaDesc, String klipsMedia, String klipsDesc) {
        this.analyzId = analyzId;
        this.patientId = patientId;
        this.usmMedia = usmMedia;
        this.usmDesc = usmDesc;
        this.mamagrafiyaMedia = mamagrafiyaMedia;
        this.mamagrafiyaDesc = mamagrafiyaDesc;
        this.tomosintezMedia = tomosintezMedia;
        this.tomosintezDesc = tomosintezDesc;
        this.mrtMedia = mrtMedia;
        this.mrtDesc = mrtDesc;
        this.ktMedia = ktMedia;
        this.ktDesc = ktDesc;
        this.biopsiyaMedia = biopsiyaMedia;
        this.boipsiyaDesc = boipsiyaDesc;
        this.klipsMedia = klipsMedia;
        this.klipsDesc = klipsDesc;
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

    public String getUsmMedia() {
        return usmMedia;
    }

    public void setUsmMedia(String usmMedia) {
        this.usmMedia = usmMedia;
    }

    public String getUsmDesc() {
        return usmDesc;
    }

    public void setUsmDesc(String usmDesc) {
        this.usmDesc = usmDesc;
    }

    public String getMamagrafiyaMedia() {
        return mamagrafiyaMedia;
    }

    public void setMamagrafiyaMedia(String mamagrafiyaMedia) {
        this.mamagrafiyaMedia = mamagrafiyaMedia;
    }

    public String getMamagrafiyaDesc() {
        return mamagrafiyaDesc;
    }

    public void setMamagrafiyaDesc(String mamagrafiyaDesc) {
        this.mamagrafiyaDesc = mamagrafiyaDesc;
    }

    public String getTomosintezMedia() {
        return tomosintezMedia;
    }

    public void setTomosintezMedia(String tomosintezMedia) {
        this.tomosintezMedia = tomosintezMedia;
    }

    public String getTomosintezDesc() {
        return tomosintezDesc;
    }

    public void setTomosintezDesc(String tomosintezDesc) {
        this.tomosintezDesc = tomosintezDesc;
    }

    public String getMrtMedia() {
        return mrtMedia;
    }

    public void setMrtMedia(String mrtMedia) {
        this.mrtMedia = mrtMedia;
    }

    public String getMrtDesc() {
        return mrtDesc;
    }

    public void setMrtDesc(String mrtDesc) {
        this.mrtDesc = mrtDesc;
    }

    public String getKtMedia() {
        return ktMedia;
    }

    public void setKtMedia(String ktMedia) {
        this.ktMedia = ktMedia;
    }

    public String getKtDesc() {
        return ktDesc;
    }

    public void setKtDesc(String ktDesc) {
        this.ktDesc = ktDesc;
    }

    public String getBiopsiyaMedia() {
        return biopsiyaMedia;
    }

    public void setBiopsiyaMedia(String biopsiyaMedia) {
        this.biopsiyaMedia = biopsiyaMedia;
    }

    public String getBoipsiyaDesc() {
        return boipsiyaDesc;
    }

    public void setBoipsiyaDesc(String boipsiyaDesc) {
        this.boipsiyaDesc = boipsiyaDesc;
    }

    public String getKlipsMedia() {
        return klipsMedia;
    }

    public void setKlipsMedia(String klipsMedia) {
        this.klipsMedia = klipsMedia;
    }

    public String getKlipsDesc() {
        return klipsDesc;
    }

    public void setKlipsDesc(String klipsDesc) {
        this.klipsDesc = klipsDesc;
    }

    @Override
    public String toString() {
        return "BreastAnalyzes{" +
                "patientId=" + patientId +
                ", usmMedia='" + usmMedia + '\'' +
                ", usmDesc='" + usmDesc + '\'' +
                ", mamagrafiyaMedia='" + mamagrafiyaMedia + '\'' +
                ", mamagrafiyaDesc='" + mamagrafiyaDesc + '\'' +
                ", tomosintezMedia='" + tomosintezMedia + '\'' +
                ", tomosintezDesc='" + tomosintezDesc + '\'' +
                ", mrtMedia='" + mrtMedia + '\'' +
                ", mrtDesc='" + mrtDesc + '\'' +
                ", ktMedia='" + ktMedia + '\'' +
                ", ktDesc='" + ktDesc + '\'' +
                ", biopsiyaMedia='" + biopsiyaMedia + '\'' +
                ", boipsiyaDesc='" + boipsiyaDesc + '\'' +
                ", klipsMedia='" + klipsMedia + '\'' +
                ", klipsDesc='" + klipsDesc + '\'' +
                '}';
    }
}

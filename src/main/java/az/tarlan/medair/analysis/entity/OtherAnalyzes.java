package az.tarlan.medair.analysis.entity;


import javax.persistence.*;

@Entity
@Table(name = "other_analyzes")

public class OtherAnalyzes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "blood_media")
    private String bloodMedia;

    @Column(name = "blood_desc")
    private String bloodDesc;

    @Column(name = "usm_media")
    private String usmMedia;

    @Column(name = "usm_desc")
    private String usmВesc;

    @Column(name = "rentgen_media")
    private String rentgenMedia;

    @Column(name = "rentgen_desc")
    private String rentgenDesc;

    @Column(name = "sumuk_osten_media")
    private String sumukOstenMedia;

    @Column(name = "sumuk_ostes_desc")
    private String sumukOstesDesc;

    @Column(name = "sumuk_naf_media")
    private String sumukNafMedia;

    @Column(name = "sumuk_naf-pet")
    private String sumukNafPet;

    @Column(name = "kt_media")
    private String ktMedia;

    @Column(name = "kt_desc")
    private String ktDesc;

    @Column(name = "pet_media")
    private String petMedia;

    @Column(name = "pet_desc")
    private String petDesc;

    @Column(name = "exo_media")
    private String exoMedia;

    @Column(name = "exo_desc")
    private String exoDesc;

    @Column(name = "ekq_media")
    private String ekqMedia;

    @Column(name = "ekq_desc")
    private String ekqDesc;

    @Column(name = "pet_ct_media")
    private String petCtMedia;

    @Column(name = "pet_ct_desc")
    private String petCtDesc;

    @Column(name = "pet_mr_media")
    private String petMrMedia;

    @Column(name = "pet_mr_desc")
    private String petMrDesc;

    public OtherAnalyzes() {}

    public OtherAnalyzes(int patientId, String bloodMedia, String bloodDesc, String usmMedia, String usmВesc, String rentgenMedia, String rentgenDesc, String sumukOstenMedia, String sumukOstesDesc, String sumukNafMedia, String sumukNafPet, String ktMedia, String ktDesc, String petMedia, String petDesc, String exoMedia, String exoDesc, String ekqMedia, String ekqDesc, String petCtMedia, String petCtDesc, String petMrMedia, String petMrDesc) {
        this.patientId = patientId;
        this.bloodMedia = bloodMedia;
        this.bloodDesc = bloodDesc;
        this.usmMedia = usmMedia;
        this.usmВesc = usmВesc;
        this.rentgenMedia = rentgenMedia;
        this.rentgenDesc = rentgenDesc;
        this.sumukOstenMedia = sumukOstenMedia;
        this.sumukOstesDesc = sumukOstesDesc;
        this.sumukNafMedia = sumukNafMedia;
        this.sumukNafPet = sumukNafPet;
        this.ktMedia = ktMedia;
        this.ktDesc = ktDesc;
        this.petMedia = petMedia;
        this.petDesc = petDesc;
        this.exoMedia = exoMedia;
        this.exoDesc = exoDesc;
        this.ekqMedia = ekqMedia;
        this.ekqDesc = ekqDesc;
        this.petCtMedia = petCtMedia;
        this.petCtDesc = petCtDesc;
        this.petMrMedia = petMrMedia;
        this.petMrDesc = petMrDesc;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getBloodMedia() {
        return bloodMedia;
    }

    public void setBloodMedia(String bloodMedia) {
        this.bloodMedia = bloodMedia;
    }

    public String getBloodDesc() {
        return bloodDesc;
    }

    public void setBloodDesc(String bloodDesc) {
        this.bloodDesc = bloodDesc;
    }

    public String getUsmMedia() {
        return usmMedia;
    }

    public void setUsmMedia(String usmMedia) {
        this.usmMedia = usmMedia;
    }

    public String getUsmВesc() {
        return usmВesc;
    }

    public void setUsmВesc(String usmВesc) {
        this.usmВesc = usmВesc;
    }

    public String getRentgenMedia() {
        return rentgenMedia;
    }

    public void setRentgenMedia(String rentgenMedia) {
        this.rentgenMedia = rentgenMedia;
    }

    public String getRentgenDesc() {
        return rentgenDesc;
    }

    public void setRentgenDesc(String rentgenDesc) {
        this.rentgenDesc = rentgenDesc;
    }

    public String getSumukOstenMedia() {
        return sumukOstenMedia;
    }

    public void setSumukOstenMedia(String sumukOstenMedia) {
        this.sumukOstenMedia = sumukOstenMedia;
    }

    public String getSumukOstesDesc() {
        return sumukOstesDesc;
    }

    public void setSumukOstesDesc(String sumukOstesDesc) {
        this.sumukOstesDesc = sumukOstesDesc;
    }

    public String getSumukNafMedia() {
        return sumukNafMedia;
    }

    public void setSumukNafMedia(String sumukNafMedia) {
        this.sumukNafMedia = sumukNafMedia;
    }

    public String getSumukNafPet() {
        return sumukNafPet;
    }

    public void setSumukNafPet(String sumukNafPet) {
        this.sumukNafPet = sumukNafPet;
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

    public String getPetMedia() {
        return petMedia;
    }

    public void setPetMedia(String petMedia) {
        this.petMedia = petMedia;
    }

    public String getPetDesc() {
        return petDesc;
    }

    public void setPetDesc(String petDesc) {
        this.petDesc = petDesc;
    }

    public String getExoMedia() {
        return exoMedia;
    }

    public void setExoMedia(String exoMedia) {
        this.exoMedia = exoMedia;
    }

    public String getExoDesc() {
        return exoDesc;
    }

    public void setExoDesc(String exoDesc) {
        this.exoDesc = exoDesc;
    }

    public String getEkqMedia() {
        return ekqMedia;
    }

    public void setEkqMedia(String ekqMedia) {
        this.ekqMedia = ekqMedia;
    }

    public String getEkqDesc() {
        return ekqDesc;
    }

    public void setEkqDesc(String ekqDesc) {
        this.ekqDesc = ekqDesc;
    }

    public String getPetCtMedia() {
        return petCtMedia;
    }

    public void setPetCtMedia(String petCtMedia) {
        this.petCtMedia = petCtMedia;
    }

    public String getPetCtDesc() {
        return petCtDesc;
    }

    public void setPetCtDesc(String petCtDesc) {
        this.petCtDesc = petCtDesc;
    }

    public String getPetMrMedia() {
        return petMrMedia;
    }

    public void setPetMrMedia(String petMrMedia) {
        this.petMrMedia = petMrMedia;
    }

    public String getPetMrDesc() {
        return petMrDesc;
    }

    public void setPetMrDesc(String petMrDesc) {
        this.petMrDesc = petMrDesc;
    }

    @Override
    public String toString() {
        return "OtherAnalyzes{" +
                "patientId=" + patientId +
                ", bloodMedia='" + bloodMedia + '\'' +
                ", bloodDesc='" + bloodDesc + '\'' +
                ", usmMedia='" + usmMedia + '\'' +
                ", usmВesc='" + usmВesc + '\'' +
                ", rentgenMedia='" + rentgenMedia + '\'' +
                ", rentgenDesc='" + rentgenDesc + '\'' +
                ", sumukOstenMedia='" + sumukOstenMedia + '\'' +
                ", sumukOstesDesc='" + sumukOstesDesc + '\'' +
                ", sumukNafMedia='" + sumukNafMedia + '\'' +
                ", sumukNafPet='" + sumukNafPet + '\'' +
                ", ktMedia='" + ktMedia + '\'' +
                ", ktDesc='" + ktDesc + '\'' +
                ", petMedia='" + petMedia + '\'' +
                ", petDesc='" + petDesc + '\'' +
                ", exoMedia='" + exoMedia + '\'' +
                ", exoDesc='" + exoDesc + '\'' +
                ", ekqMedia='" + ekqMedia + '\'' +
                ", ekqDesc='" + ekqDesc + '\'' +
                ", petCtMedia='" + petCtMedia + '\'' +
                ", petCtDesc='" + petCtDesc + '\'' +
                ", petMrMedia='" + petMrMedia + '\'' +
                ", petMrDesc='" + petMrDesc + '\'' +
                '}';
    }
}

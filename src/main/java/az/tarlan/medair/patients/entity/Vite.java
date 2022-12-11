package az.tarlan.medair.patients.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient_vite")

public class Vite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_surname")
    private String patientSurName;

    @Column(name = "patient_patronymic")
    private String patientPatronymic;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "birth_place")
    private String birthPlace;


    @Column(name = "gender")
    private String gender;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "sex_status")
    private String sexStatus;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "imt")
    private double imt;

    @Column(name = "smoke")
    private int smoke;

    @Column(name = "alchogol")
    private int alkogol;

    @Column(name = "raiting")
    private int raiting;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "cure_for_infertility")
    private String cureForInfertility;

    @Column(name = "menopause")
    private String menopause;

    @Column(name = "menarxe")
    private String menarxe;

    @Column(name = "first_childbirth")
    private int firstChildbirth;

    @Column(name = "last_childbirth")
    private int lastChildbirth;

    @Column(name = "abort_count")
    private int abortCount;

    @Column(name = "lactation_period")
    private String lactationPeriod;

    @Column(name = "artificial_insemination_count")
    private int artificialInseminationCount;

    @Column(name="recommendation_person")
    private String recommendationPerson;

    public Vite() {
    }

    public Vite(int patientId, String patientName, String patientSurName, String patientPatronymic, Date birthDate, String birthPlace, String gender, String maritalStatus, String sexStatus, double height, double weight, double imt, int smoke, int alkogol, int raiting, String phoneNumber, String cureForInfertility, String menopause, String menarxe, int firstChildbirth, int lastChildbirth, int abortCount, String lactationPeriod, int artificialInseminationCount, String recommendationPerson) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurName = patientSurName;
        this.patientPatronymic = patientPatronymic;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.sexStatus = sexStatus;
        this.height = height;
        this.weight = weight;
        this.imt = imt;
        this.smoke = smoke;
        this.alkogol = alkogol;
        this.raiting = raiting;
        this.phoneNumber = phoneNumber;
        this.cureForInfertility = cureForInfertility;
        this.menopause = menopause;
        this.menarxe = menarxe;
        this.firstChildbirth = firstChildbirth;
        this.lastChildbirth = lastChildbirth;
        this.abortCount = abortCount;
        this.lactationPeriod = lactationPeriod;
        this.artificialInseminationCount = artificialInseminationCount;
        this.recommendationPerson = recommendationPerson;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurName() {
        return patientSurName;
    }

    public void setPatientSurName(String patientSurName) {
        this.patientSurName = patientSurName;
    }

    public String getPatientPatronymic() {
        return patientPatronymic;
    }

    public void setPatientPatronymic(String patientPatronymic) {
        this.patientPatronymic = patientPatronymic;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSexStatus() {
        return sexStatus;
    }

    public void setSexStatus(String sexStatus) {
        this.sexStatus = sexStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getImt() {
        return imt;
    }

    public void setImt(double imt) {
        this.imt = imt;
    }

    public int getSmoke() {
        return smoke;
    }

    public void setSmoke(int smoke) {
        this.smoke = smoke;
    }

    public int getAlkogol() {
        return alkogol;
    }

    public void setAlkogol(int alkogol) {
        this.alkogol = alkogol;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCureForInfertility() {
        return cureForInfertility;
    }

    public void setCureForInfertility(String cureForInfertility) {
        this.cureForInfertility = cureForInfertility;
    }

    public String getMenopause() {
        return menopause;
    }

    public void setMenopause(String menopause) {
        this.menopause = menopause;
    }

    public String getMenarxe() {
        return menarxe;
    }

    public void setMenarxe(String menarxe) {
        this.menarxe = menarxe;
    }

    public int getFirstChildbirth() {
        return firstChildbirth;
    }

    public void setFirstChildbirth(int firstChildbirth) {
        this.firstChildbirth = firstChildbirth;
    }

    public int getLastChildbirth() {
        return lastChildbirth;
    }

    public void setLastChildbirth(int lastChildbirth) {
        this.lastChildbirth = lastChildbirth;
    }

    public int getAbortCount() {
        return abortCount;
    }

    public void setAbortCount(int abortCount) {
        this.abortCount = abortCount;
    }

    public String getLactationPeriod() {
        return lactationPeriod;
    }

    public void setLactationPeriod(String lactationPeriod) {
        this.lactationPeriod = lactationPeriod;
    }

    public int getArtificialInseminationCount() {
        return artificialInseminationCount;
    }

    public void setArtificialInseminationCount(int artificialInseminationCount) {
        this.artificialInseminationCount = artificialInseminationCount;
    }

    public String getRecommendationPerson() {
        return recommendationPerson;
    }

    public void setRecommendationPerson(String recommendationPerson) {
        this.recommendationPerson = recommendationPerson;
    }

    @Override
    public String toString() {
        return "Vite{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientSurName='" + patientSurName + '\'' +"\n" +
                ", patientPatronymic='" + patientPatronymic + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +"\n" +
                ", gender='" + gender + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", sexStatus='" + sexStatus + '\'' +"\n" +
                ", height=" + height +
                ", weight=" + weight +
                ", imt=" + imt +"\n" +
                ", smoke=" + smoke +
                ", alkogol=" + alkogol +
                ", raiting=" + raiting +"\n" +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cureForInfertility='" + cureForInfertility + '\'' +"\n" +
                ", menopause='" + menopause + '\'' +
                ", menarxe='" + menarxe + '\'' +"\n" +
                ", firstChildbirth=" + firstChildbirth +
                ", lastChildbirth=" + lastChildbirth +"\n" +
                ", abortCount=" + abortCount +
                ", lactationPeriod='" + lactationPeriod + '\'' +
                ", artificialInseminationCount=" + artificialInseminationCount +"\n" +
                ", recommendationPerson='" + recommendationPerson + '\'' +
                '}';
    }
}

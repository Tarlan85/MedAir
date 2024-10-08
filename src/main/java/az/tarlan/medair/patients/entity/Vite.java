package az.tarlan.medair.patients.entity;

import javax.persistence.*;
import java.time.LocalDate;

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
    private String patientSurname; // Изменено

    @Column(name = "patient_patronymic")
    private String patientPatronymic;

    @Column(name = "birth_date")
    private LocalDate birthDate; // Изменено

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
    private boolean smoke; // Изменено

    @Column(name = "alcohol") // Исправлено
    private boolean alcohol; // Изменено

    @Column(name = "rating") // Исправлено
    private int rating; // Исправлено

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "cure_for_infertility")
    private String cureForInfertility;

    @Column(name = "menopause")
    private String menopause;

    @Column(name = "menarxe")
    private String menarche;

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

    // Геттеры и сеттеры...

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }



    @Override
    public String toString() {
        return "Vite{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientSurname='" + patientSurname + '\'' +
                ", patientPatronymic='" + patientPatronymic + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", gender='" + gender + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", sexStatus='" + sexStatus + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", imt=" + imt +
                ", smoke=" + smoke +
                ", alcohol=" + alcohol +
                ", rating=" + rating +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cureForInfertility='" + cureForInfertility + '\'' +
                ", menopause='" + menopause + '\'' +
                ", menarxe='" + menarche + '\'' +
                ", firstChildbirth=" + firstChildbirth +
                ", lastChildbirth=" + lastChildbirth +
                ", abortCount=" + abortCount +
                ", lactationPeriod='" + lactationPeriod + '\'' +
                ", artificialInseminationCount=" + artificialInseminationCount +
                ", recommendationPerson='" + recommendationPerson + '\'' +
                '}';
    }
}

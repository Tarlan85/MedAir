package az.tarlan.medair.analysis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "analyzes")

public class AnalyzesMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analyzes_id")
    private int analyzesId;
    @Column(name = "patient_id")
    private int patientId;
    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Timestamp date;
    @Column(name = "analyzes_type")
    private String analyzesType;
    @Column(name = "analyzes_subtype")
    private String analyzesSubType;

    @Column(name = "analyzes_desc")
    private String analyzesDesc;

    @Column(name = "analyzes_content_name")
    private String analyzesContentName;

    @Column(name = "analyzes_content_url")
    private String analyzesContentUrl;

    public AnalyzesMedia() {
    }

    public AnalyzesMedia(int analyzesId,
                         int patientId,
                         Timestamp date,
                         String analyzesType,
                         String analyzesSubType,
                         String analyzesDesc,
                         String analyzesContentName,
                         String analyzesContentUrl) {
        this.analyzesId = analyzesId;
        this.patientId = patientId;
        this.date = date;
        this.analyzesType = analyzesType;
        this.analyzesSubType = analyzesSubType;
        this.analyzesDesc = analyzesDesc;
        this.analyzesContentName = analyzesContentName;
        this.analyzesContentUrl = analyzesContentUrl;
    }

    public String getAnalyzesContentUrl() {
        return analyzesContentUrl;
    }

    public void setAnalyzesContentUrl(String analyzesContentUrl) {
        this.analyzesContentUrl = analyzesContentUrl;
    }

    public int getAnalyzesId() {
        return analyzesId;
    }

    public void setAnalyzesId(int analyzesId) {
        this.analyzesId = analyzesId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAnalyzesType() {
        return analyzesType;
    }

    public void setAnalyzesType(String analyzesType) {
        this.analyzesType = analyzesType;
    }

    public String getAnalyzesSubType() {
        return analyzesSubType;
    }

    public void setAnalyzesSubType(String analyzesSubType) {
        this.analyzesSubType = analyzesSubType;
    }


    public String getAnalyzesDesc() {
        return analyzesDesc;
    }

    public void setAnalyzesDesc(String analyzesDesc) {
        this.analyzesDesc = analyzesDesc;
    }

    public String getAnalyzesContentName() {
        return analyzesContentName;
    }

    public void setAnalyzesContentName(String analyzesContentName) {
        this.analyzesContentName = analyzesContentName;
    }

    @Override
    public String toString() {
        return "AnalyzesMedia{" +
                "analyzesId=" + analyzesId + "\n" +
                ", patientId=" + patientId + "\n" +
                ", date=" + date + "\n" +
                ", analyzesType='" + analyzesType + '\'' + "\n" +
                ", analyzesSubType='" + analyzesSubType + '\'' + "\n" +
                ", analyzesDesc='" + analyzesDesc + '\'' + "\n" +
                ", analyzesContentName='" + analyzesContentName + '\'' + "\n" +
                ", analyzesContentUrl='" + analyzesContentUrl + '\'' +
                '}';
    }
}

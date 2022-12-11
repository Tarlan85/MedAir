package az.tarlan.medair.analysis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Table(name = "analyzes")

public class AnalyzesMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analyzes_id")
    private int analyzesId;
    @Column(name = "patient_id")
    private int patientId;
    @Column(name="date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Timestamp date;
    @Column(name = "analyzes_type")
    private String analyzesType;
    @Column(name = "analyzes_subtype")
    private String analyzesSubeType;
    @Column(name = "analyzes_content")
    private Blob analyzesContent;
    @Column(name = "analyzes_desc")
    private String analyzesDesc;

    public AnalyzesMedia() {}

    public AnalyzesMedia(int analyzesId, int patientId, Timestamp date, String analyzesType, String analyzesSubeType, Blob analyzesContent, String analyzesDesc) {
        this.analyzesId = analyzesId;
        this.patientId = patientId;
        this.date = date;
        this.analyzesType = analyzesType;
        this.analyzesSubeType = analyzesSubeType;
        this.analyzesContent = analyzesContent;
        this.analyzesDesc = analyzesDesc;
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

    public String getAnalyzesSubeType() {
        return analyzesSubeType;
    }

    public void setAnalyzesSubeType(String analyzesSubeType) {
        this.analyzesSubeType = analyzesSubeType;
    }

    public Blob getAnalyzesContent() {
        return analyzesContent;
    }

    public void setAnalyzesContent(Blob analyzesContent) {
        this.analyzesContent = analyzesContent;
    }

    public String getAnalyzesDesc() {
        return analyzesDesc;
    }

    public void setAnalyzesDesc(String analyzesDesc) {
        this.analyzesDesc = analyzesDesc;
    }

    @Override
    public String toString() {
        return "AnalyzesMedia{" +
                "analyzesId='" + analyzesId + '\'' +"\n"+
                ", patientId='" + patientId + '\'' +"\n"+
                ", date=" + date +"\n"+
                ", analyzesType='" + analyzesType + '\'' +"\n"+
                ", analyzesSubeType='" + analyzesSubeType + '\'' +"\n"+
                ", analyzesContent=" + analyzesContent +"\n"+
                ", analyzesDesc='" + analyzesDesc + '\'' +"\n"+
                '}';
    }
}

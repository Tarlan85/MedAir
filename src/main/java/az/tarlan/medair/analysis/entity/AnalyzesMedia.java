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
    private String analyzesSubeType;

    @Column(name = "analyzes_desc")
    private String analyzesDesc;

    @Column(name = "analyzes_content_name")
    private String analyzesContentName;
//    @Column(name = "analyzes_content_original_file_name")
//    private String analyzesContentOriginalFileName;
//    @Column(name = "analyzes_content_size")
//    private long analyzesContentSize;
//    @Lob
//    @Column(name = "analyzes_content_byte")
//    private byte[] analyzesContentByte;
//    @Column(name = "analyzes_content_type")
//    private String analyzesContentType;

    public AnalyzesMedia() {
    }

    public AnalyzesMedia(int analyzesId,
                         int patientId,
                         Timestamp date,
                         String analyzesType,
                         String analyzesSubeType,
                         String analyzesDesc,
                         String analyzesContentName,
                         String analyzesContentOriginalFileName,
                         int analyzes_content_size,
                         byte[] analyzesContentByte,
                         String analyzesContentType) {
        this.analyzesId = analyzesId;
        this.patientId = patientId;
        this.date = date;
        this.analyzesType = analyzesType;
        this.analyzesSubeType = analyzesSubeType;
        this.analyzesDesc = analyzesDesc;
        this.analyzesContentName = analyzesContentName;
//        this.analyzesContentOriginalFileName = analyzesContentOriginalFileName;
//        this.analyzesContentSize = analyzes_content_size;
//        this.analyzesContentByte = analyzesContentByte;
//        this.analyzesContentType = analyzesContentType;
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

//    public String getAnalyzesContentOriginalFileName() {
//        return analyzesContentOriginalFileName;
//    }
//
//    public void setAnalyzesContentOriginalFileName(String analyzesContentOriginalFileName) {
//        this.analyzesContentOriginalFileName = analyzesContentOriginalFileName;
//    }
//
//    public long getAnalyzes_content_size() {
//        return analyzesContentSize;
//    }
//
//    public void setAnalyzesContentSize(long analyzesContentSize) {
//        this.analyzesContentSize = analyzesContentSize;
//    }
//
//    public byte[] getAnalyzesContentByte() {
//        return analyzesContentByte;
//    }
//
//    public void setAnalyzesContentByte(byte[] analyzesContentByte) {
//        this.analyzesContentByte = analyzesContentByte;
//    }
//
//    public String getAnalyzesContentType() {
//        return analyzesContentType;
//    }
//
//    public void setAnalyzesContentType(String analyzesContentType) {
//        this.analyzesContentType = analyzesContentType;
//    }

    @Override
    public String toString() {
        return "AnalyzesMedia{" +
                "analyzesId=" + analyzesId +"\n" +
                ", patientId=" + patientId +"\n" +
                ", date=" + date +"\n" +
                ", analyzesType='" + analyzesType + '\'' +"\n" +
                ", analyzesSubeType='" + analyzesSubeType + '\'' +"\n" +
                ", analyzesDesc='" + analyzesDesc + '\'' +"\n" +
                ", analyzesContentName='" + analyzesContentName + '\'' +"\n" +
//                ", analyzesContentOriginalFileName='" + analyzesContentOriginalFileName + '\'' +"\n" +
//                ", analyzesContentSize=" + analyzesContentSize +"\n" +
//                ", analyzesContentByte=" + Arrays.toString(analyzesContentByte) +"\n" +
//                ", analyzesContentType='" + analyzesContentType + '\'' +
                '}';
    }
}

package az.tarlan.medair.analysis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;


public class AnalyzesReqBody {
    List<AnalyzesMedia> analyzesMediaList;
    private int patientId;

    public AnalyzesReqBody() {
    }

    public AnalyzesReqBody(List<AnalyzesMedia> analyzesMediaList, int patientId) {
        this.analyzesMediaList = analyzesMediaList;
        this.patientId = patientId;
    }

    public List<AnalyzesMedia> getAnalyzesMediaList() {
        return analyzesMediaList;
    }

    public void setAnalyzesMediaList(List<AnalyzesMedia> analyzesMediaList) {
        this.analyzesMediaList = analyzesMediaList;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "AnalyzesReqBody{" +
                "analyzesMediaList=" + analyzesMediaList + "\n" +
                ", patientId=" + patientId +
                '}';
    }
}

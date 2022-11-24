package az.tarlan.medair.visits.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

public class VisitsRegBody {

    private int visitId;
    private int patientId;
    private String initialDiagnosis;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Timestamp visitDate;
    private String visitReason;
    private String status;
    private String placeName;
    private String recommendationPerson;
    private String visitType;
    private String visitDesc;
    private String preliminaryDiagnosis;

}

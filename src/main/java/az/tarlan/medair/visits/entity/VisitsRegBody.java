package az.tarlan.medair.visits.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.List;

public class VisitsRegBody {
    List<PatientVisits> patientVisits;

//    private int visitId;
//    private int patientId;
//    private String initialDiagnosis;
//
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
//    private Timestamp visitDate;
//    private String visitReason;
//    private String status;
//    private String placeName;
//    private String recommendationPerson;
//    private String visitType;
//    private String visitDesc;
//    private String preliminaryDiagnosis;


    public VisitsRegBody(List<PatientVisits> patientVisits) {
        this.patientVisits = patientVisits;
    }

    public List<PatientVisits> getPatientVisits() {
        return patientVisits;
    }

    public void setPatientVisits(List<PatientVisits> patientVisits) {
        this.patientVisits = patientVisits;
    }

    @Override
    public String toString() {
        return "VisitsRegBody{" +
                "patientVisits=" + patientVisits +
                '}';
    }
}

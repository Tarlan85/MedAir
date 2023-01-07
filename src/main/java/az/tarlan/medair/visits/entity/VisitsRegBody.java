package az.tarlan.medair.visits.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.List;

public class VisitsRegBody {

    List<PatientVisits> patientVisitsList;

//    private int visitId;
    private int patientId;

//    List<PatientVisits> patientVisits;

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



    public VisitsRegBody(List<PatientVisits> patientVisitsList, int patientId) {
        this.patientVisitsList = patientVisitsList;
        this.patientId = patientId;
    }

    public VisitsRegBody() {
    }

    public List<PatientVisits> getPatientVisitsList() {
        return patientVisitsList;
    }

    public void setPatientVisitsList(List<PatientVisits> patientVisitsList) {
        this.patientVisitsList = patientVisitsList;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    //    public VisitsRegBody(List<PatientVisits> patientVisits) {
//        this.patientVisits = patientVisits;
//    }
//
//    public List<PatientVisits> getPatientVisits() {
//        return patientVisits;
//    }



    @Override
    public String toString() {
        return "VisitsRegBody{" +

                "patientVisitsList=" + patientVisitsList +
                ", patientId=" + patientId +
                '}';
    }
}

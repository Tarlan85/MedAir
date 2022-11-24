package az.tarlan.medair.search.entity;

import javax.persistence.*;
import java.util.Date;


public class SearchForVite {
    private int patientId;


    private String patientName;

    private String patientSurName;

    private String phoneNumber;

    public SearchForVite() {
    }

    public SearchForVite(int patientId, String patientName, String patientSurName, String phoneNumber) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurName = patientSurName;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "SearchForVite{" +'\n' +
                "patientId=" + patientId +'\n' +
                "patientName=" + patientName + '\n' +
                "patientSurName=" + patientSurName + '\n' +
                "phoneNumber=" + phoneNumber + '\n' +
                '}';
    }
}

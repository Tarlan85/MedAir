package az.tarlan.medair.patients.entity;


import javax.persistence.*;

@Entity
@Table(name = "doctor_info")


public class DoctorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    public DoctorInfo() {}

    public DoctorInfo(int doctorId, String name, String surname, String login, String pass) {
        this.doctorId = doctorId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.pass = pass;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "DoctorInfo{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}

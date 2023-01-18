package az.tarlan.medair.login.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Table(name = "users")

public class LogIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pass")
    private String userPass;


    public LogIn() {}

    public LogIn(int id, String userName, String userPass) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "LogIn{" +
                "id=" + id +"\n"+
                ", userName='" + userName + '\'' +"\n"+
                ", userPass='" + userPass + '\'' +"\n"+
                '}';
    }
}

package az.tarlan.medair.login.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Table(name = "tokens")

public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "token")
    private String token;

    @Column(name="token_create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Timestamp tokenCreateTime;

    public Token() {
    }

    public Token(int id, String token, Timestamp tokenCreateTime) {
        this.id = id;
        this.token = token;
        this.tokenCreateTime = tokenCreateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(Timestamp tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +"\n"+
                ", token='" + token + '\'' +"\n"+
                ", tokenCreateTime=" + tokenCreateTime +"\n"+
                '}';
    }
}

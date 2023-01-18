package az.tarlan.medair.login.entity;

import javax.persistence.*;


public class LogInReqBody {

    private String token;
    private LogIn logIn;

    public LogInReqBody() {}

    public LogInReqBody(String token, LogIn logIn) {
        this.token = token;
        this.logIn = logIn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LogIn getLogIn() {
        return logIn;
    }

    public void setLogIn(LogIn logIn) {
        this.logIn = logIn;
    }

    @Override
    public String toString() {
        return "LogInReqBody{" +

                " LogIn='" + logIn + '\'' +"\n"+
                ", token='" + token + '\'' +"\n"+
                '}';
    }
}

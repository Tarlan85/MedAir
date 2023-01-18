package az.tarlan.medair.login.service;

import az.tarlan.medair.login.entity.LogIn;
import az.tarlan.medair.login.entity.LogInReqBody;


public interface LogInService {
    String checkToken(String token);

    LogInReqBody checkLogIn(LogIn logIn);
}

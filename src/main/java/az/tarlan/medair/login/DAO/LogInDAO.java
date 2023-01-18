package az.tarlan.medair.login.DAO;

import az.tarlan.medair.login.entity.LogIn;
import az.tarlan.medair.login.entity.LogInReqBody;

public interface LogInDAO {


    String checkToken(String token);

    LogInReqBody checkLogIn(LogIn logIn);
}

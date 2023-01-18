package az.tarlan.medair.login.service;

import az.tarlan.medair.login.DAO.LogInDAO;
import az.tarlan.medair.login.entity.LogIn;
import az.tarlan.medair.login.entity.LogInReqBody;
import az.tarlan.medair.login.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class LogInServiceImpl implements LogInService {
    private LogInDAO logInDAO;
    @Autowired
    public LogInServiceImpl(LogInDAO logInDAO) {
        this.logInDAO = logInDAO;
    }

    @Override
    @Transactional
    public String checkToken(String token) {
       return logInDAO.checkToken(token);
    }

    @Override
    @Transactional
    public LogInReqBody checkLogIn(LogIn logIn){
        return logInDAO.checkLogIn(logIn);
    }
}

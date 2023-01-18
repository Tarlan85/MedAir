package az.tarlan.medair.login.DAO;

import az.tarlan.medair.login.entity.LogIn;
import az.tarlan.medair.login.entity.LogInReqBody;
import az.tarlan.medair.login.entity.Token;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.UUID;

@Repository
public class LogInDAOImpl implements LogInDAO {
    private EntityManager entityManager;

    public LogInDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public String checkToken(String token) {
        System.out.println("checkToken");
        Query theQuery=entityManager.createQuery("delete from Token where (now()-tokenCreateTime)>40000");
        theQuery.executeUpdate();
         theQuery=entityManager.createQuery("From Token where token = '"+token+"' and  " +
                "(now()-tokenCreateTime)<40000");
        System.out.println(theQuery.getResultList());
        if (theQuery.getResultList().size()<1){
            System.out.println("Token not fount");
            return null;
        }
        Token dbToken=(Token) theQuery.getResultList().get(0);
        theQuery=entityManager.createQuery("UPDATE Token SET tokenCreateTime=now() WHERE token='"+token+"'");
        theQuery.executeUpdate();

       return dbToken.getToken();
    }
    @Override
    public LogInReqBody checkLogIn(LogIn logIn) {
        System.out.println("2. checkLogIn");
        Query theQuery=entityManager.createQuery("From LogIn where userName = '"+logIn.getUserName()+"' and userPass='"+logIn.getUserPass()+"'");
        System.out.println(theQuery.getResultList());
        if (theQuery.getResultList().size()<1){
            System.out.println("User not fount");
            return null;
        }
        LogInReqBody logInReqBody  = new LogInReqBody();
        logInReqBody.setLogIn((LogIn)theQuery.getResultList().get(0));
        System.out.println("3. "+logInReqBody.getLogIn().toString());
        String token= String.valueOf(UUID.randomUUID());
        System.out.println("token = "+token);
//        theQuery=entityManager.createQuery("INsert into Token (token,tokenCreateTime) values('"+token+"',now())");
        theQuery=entityManager.createNativeQuery(
                "INsert into tokens (token,token_create_time) values('"+token+"',now())");
        theQuery.executeUpdate();
            logInReqBody.setToken(token);
        return logInReqBody;
    }
}

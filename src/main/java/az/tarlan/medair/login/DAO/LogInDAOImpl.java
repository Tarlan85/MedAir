package az.tarlan.medair.login.DAO;

import az.tarlan.medair.login.entity.LogIn;
import az.tarlan.medair.login.entity.LogInReqBody;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public class LogInDAOImpl implements LogInDAO {
    private final EntityManager entityManager;

    public LogInDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public String checkToken(String token) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expirationThreshold = now.minusHours(4);

        // Clean up expired tokens
        executeUpdate("DELETE FROM Token t WHERE t.tokenCreateTime < :expirationThreshold", expirationThreshold, "expirationThreshold");

        // Check if token is valid and not expired
        if (isTokenInvalid(token, expirationThreshold)) {
            return "no";
        }

        // Update tokenCreateTime
        executeUpdate("UPDATE Token t SET t.tokenCreateTime = :now WHERE t.token = :token", now, token);

        return "ok";
    }

    @Override
    public LogInReqBody checkLogIn(LogIn logIn) {
        LogInReqBody logInReqBody = new LogInReqBody();

        // Check if user exists
        if (isUserInvalid(logIn)) {
            return logInReqBody;
        }

        // Set the user information in response
        logInReqBody.setLogIn(logIn);

        // Generate a new token
        String token = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();

        // Insert the token into the database
        executeUpdate("INSERT INTO Token (token, tokenCreateTime) VALUES (:token, :now)", token, now);

        // Set the token in response
        logInReqBody.setToken(token);

        return logInReqBody;
    }

    private boolean isTokenInvalid(String token, LocalDateTime expirationThreshold) {
        String selectQueryStr = "FROM Token t WHERE t.token = :token AND t.tokenCreateTime >= :expirationThreshold";
        Query query = entityManager.createQuery(selectQueryStr);
        query.setParameter("token", token);
        query.setParameter("expirationThreshold", expirationThreshold);
        return query.getResultList().isEmpty();
    }

    private boolean isUserInvalid(@NotNull LogIn logIn) {
        String userQueryStr = "FROM LogIn l WHERE l.userName = :userName AND l.userPass = :userPass";
        Query query = entityManager.createQuery(userQueryStr);
        query.setParameter("userName", logIn.getUserName());
        query.setParameter("userPass", logIn.getUserPass());
        return query.getResultList().isEmpty();
    }

    private void executeUpdate(String queryStr, Object @NotNull ... params) {
        Query query = entityManager.createQuery(queryStr);
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter((String) params[i + 1], params[i]);
        }
        query.executeUpdate();
    }
}
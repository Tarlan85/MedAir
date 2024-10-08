package az.tarlan.medair.login.rest;
//import java.util.logging.Logger;
import az.tarlan.medair.login.entity.LogIn;
import az.tarlan.medair.login.entity.LogInReqBody;
import az.tarlan.medair.login.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
@Component
public class LogInRestController {

    private static final Logger logger = LoggerFactory.getLogger(LogInRestController.class);
    private static final String LOGIN_LOG_MESSAGE = "Login : {}";
    private static final String TOKEN_LOG_MESSAGE = "findToken : {}";

    @Autowired
    private LogInService logInService;

    @PostMapping("/login")
    public LogInReqBody logInUser(@RequestBody LogIn logIn) {
        logMessage(LOGIN_LOG_MESSAGE, logIn);
        return logInService.checkLogIn(logIn);
    }

    @GetMapping("/token/{token}")
    public String validateToken(@PathVariable String token) {
        logMessage(TOKEN_LOG_MESSAGE, token);
        return logInService.checkToken(token);
    }

    private void logMessage(String message, Object value) {
        logger.info(message, value);
    }
}


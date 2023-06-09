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
    private static final Logger logger=LoggerFactory.getLogger(LogInRestController.class);
    private LogInService logInService;
    @Autowired
    public LogInRestController(LogInService logInService) {
        this.logInService = logInService;
    }

    @PostMapping("/login")
    public LogInReqBody checkLogIn(@RequestBody LogIn logIn){
      logger.info("Login : "+logIn);
        return  logInService.checkLogIn(logIn);
    }
    @GetMapping("/token/{token}")
    public String findToken(@PathVariable String token){
        logger.info("findToken : "+token);
        return logInService.checkToken(token);
    }

}

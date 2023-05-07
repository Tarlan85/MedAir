package az.tarlan.medair.login.rest;

import az.tarlan.medair.login.entity.LogIn;
import az.tarlan.medair.login.entity.LogInReqBody;
import az.tarlan.medair.login.entity.Token;
import az.tarlan.medair.login.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RequestMapping("/api")
public class LogInRestController {
    private LogInService logInService;
    @Autowired
    public LogInRestController(LogInService logInService) {
        this.logInService = logInService;
    }

    @PostMapping("/login")
    public LogInReqBody checkLogIn(@RequestBody LogIn logIn){
        //System.out.println("checkLogIn");
        //System.out.println(logIn.toString());
        return  logInService.checkLogIn(logIn);
    }
    @GetMapping("/token/{token}")
    public String findToken(@PathVariable String token){
        //System.out.println("1. checkToken \n token==="+token);
        return logInService.checkToken(token);
    }

}

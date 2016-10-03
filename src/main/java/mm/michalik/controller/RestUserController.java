package mm.michalik.controller;

import mm.michalik.domain.User;
import mm.michalik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maciej on 01.09.16.
 */
@RestController
@RequestMapping("/user/rest")
public class RestUserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    public String hello(@RequestParam String message){
        return message;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<?> getAll(){

        return userService.listAll();
    }

    @RequestMapping(value = "/name",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public User getbyusername( @RequestParam("n")  String username){


        return userService.getByUsername(username);
    }
}

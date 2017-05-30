package web.controllers;

import entities.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.encoding.PasswordEncoder;
//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.IUserService;

import java.util.List;

/**
 * Created by ivan on 19.05.2017.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {
    public static final String USER_RIGHTS = "ROLE_USER";




    public static final Logger logger = Logger.getLogger(UserController.class);


    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable int userId){
        return ResponseEntity.ok(userService.getById(userId));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable int userId) {
        return ResponseEntity.ok(userService.delete(userId));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

//
//    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    public String register(@RequestParam String firstName,
//                           @RequestParam String lastName,
//                           @RequestParam String login,
//                           @RequestParam String password,
//                           @RequestParam String repeatPassword
//                           // ModelMap modelMap
//                                               ){
//        PasswordEncoder encoder = new ShaPasswordEncoder();
//    if(!userService.hasSameLogin(login)){
//        if(password.equals(repeatPassword)){
//            User user = new User();
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setLogin(login);
//            user.setPassword(encoder.encodePassword(password,null));
//            user.setRoles(userService.getRoles(USER_RIGHTS));
//            userService.save(user);
//        }
//    }
//    return "register-auth/register-succesfull";
//    }



}
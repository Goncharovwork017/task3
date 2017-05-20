package web.controllers;

import entities.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IUserService;

import java.util.List;

/**
 * Created by ivan on 19.05.2017.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

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

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable User user) {
        return ResponseEntity.ok(userService.update(user));
    }






}
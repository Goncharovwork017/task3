package web.controllers;


import entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ICourseService;

import java.util.List;

/**
 * Created by ivan on 21.05.2017.
 */
@RestController
@RequestMapping(value = "/course")
public class CourseController {


    @Autowired
    private ICourseService courseService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable int courseId){
        return ResponseEntity.ok(courseService.getById(courseId));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.save(course));
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable int courseId) {
        return ResponseEntity.ok(courseService.delete(courseId));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.update(course));
    }


}

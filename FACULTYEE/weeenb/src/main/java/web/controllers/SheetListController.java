package web.controllers;

import entities.SheetList;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ISheetListService;

import java.util.List;

/**
 * Created by ivan on 21.05.2017.
 */
@RestController
@RequestMapping(value = "/sheetlist")
public class SheetListController {

    @Autowired
    private ISheetListService sheetListService;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<SheetList>> getAll() {
        return ResponseEntity.ok(sheetListService.getAll());
    }

    @RequestMapping(value = "/{sheetId}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable int sheetId){
        return ResponseEntity.ok(sheetListService.getById(sheetId));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody SheetList sheetList) {
        return ResponseEntity.ok(sheetListService.save(sheetList));
    }

    @RequestMapping(value = "/{sheetId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable int sheetId) {
        return ResponseEntity.ok(sheetListService.delete(sheetId));
    }

    @RequestMapping(value = "/{sheetId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable SheetList sheetList) {
        return ResponseEntity.ok(sheetListService.update(sheetList));
    }

}

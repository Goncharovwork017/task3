package service;

import entities.SheetList;

import java.util.List;

/**
 * Created by ivan on 14.05.2017.
 */
public interface ISheetListService extends IService<SheetList> {


    List<SheetList> findStudentWithEndedCourse(int courseId);

}

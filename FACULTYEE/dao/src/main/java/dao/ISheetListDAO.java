package dao;


import entities.SheetList;

import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public interface ISheetListDAO extends IDAO<SheetList> {

    List<SheetList> findStudentWithEndedCourse(int courseId);



}

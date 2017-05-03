package by.nc.dev3.dao;

import by.nc.dev3.entities.SheetList;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public interface SheetListDAO {

    void create(SheetList sheetList) throws SQLException;
    void delete(SheetList sheetList) throws SQLException;
    void update(SheetList sheetList) throws SQLException;
    SheetList find(int id);
    List<SheetList> findAll() throws SQLException;


}

package by.nc.dev3.service.impl;

import by.nc.dev3.dao.SheetListDAO;
import by.nc.dev3.entities.SheetList;
import by.nc.dev3.service.SheetListService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public class SheetListServiceImpl implements SheetListService<SheetList> {

    SheetListDAO sheetListDAO;


    public void create(SheetList sheetList) throws SQLException {
        sheetListDAO.create(sheetList);
    }

    public void delete(SheetList sheetList) throws SQLException {
        sheetListDAO.delete(sheetList);
    }

    public void update(SheetList sheetList) throws SQLException {
        sheetListDAO.update(sheetList);
    }

    public SheetList find(int id) {
        return null;
    }

    public List<SheetList> findAll() throws SQLException {
        return sheetListDAO.findAll();
    }
}

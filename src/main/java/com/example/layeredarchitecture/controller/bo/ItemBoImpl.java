package com.example.layeredarchitecture.controller.bo;

import com.example.layeredarchitecture.dao.SQLutil;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl {
    public ItemDAOImpl itemDAO = new ItemDAOImpl();

    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }


    public boolean add(ItemDTO object) throws SQLException, ClassNotFoundException {
        return itemDAO.add(object);
    }

    public boolean update(ItemDTO object) throws SQLException, ClassNotFoundException {
        return itemDAO.update(object);
    }
    public boolean isExist(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.isExist(id);

    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }
}

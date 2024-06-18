package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLutil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLutil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return allItems;
    }

    @Override
    public boolean add(ItemDTO object) throws SQLException, ClassNotFoundException {

        return SQLutil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", object.getCode(), object.getDescription(), object.getUnitPrice(), object.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO object) throws SQLException, ClassNotFoundException {
        return SQLutil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", object.getDescription(), object.getUnitPrice(), object.getQtyOnHand(), object.getCode());
    }

    @Override
    public boolean isExist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutil.execute("SELECT code FROM Item WHERE code=?", id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLutil.execute("DELETE FROM Item WHERE code=?", id);
    }

    @Override
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLutil.execute("SELECT * FROM Item WHERE code=?", id);
        rst.next();
        return new ItemDTO(id + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
}

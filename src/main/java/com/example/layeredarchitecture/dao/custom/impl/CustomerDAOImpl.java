package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLutil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLutil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    @Override
    public boolean add(CustomerDTO object) throws SQLException, ClassNotFoundException {

        return SQLutil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", object.getId(), object.getName(), object.getAddress());
    }

    @Override
    public boolean update(CustomerDTO object) throws SQLException, ClassNotFoundException {

        return SQLutil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", object.getName(), object.getAddress(), object.getId());
    }

    @Override
    public boolean isExist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutil.execute("SELECT id FROM Customer WHERE id=?", id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLutil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLutil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLutil.execute("SELECT * FROM Customer WHERE id=?", id);
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
    }

}

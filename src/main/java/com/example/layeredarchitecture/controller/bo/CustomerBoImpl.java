package com.example.layeredarchitecture.controller.bo;

import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl {

    public CustomerDAOImpl customerDAO = new CustomerDAOImpl();


    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    public boolean add(CustomerDTO object) throws SQLException, ClassNotFoundException {
        return customerDAO.add(object);
    }

    public boolean update(CustomerDTO object) throws SQLException, ClassNotFoundException {
        return customerDAO.update(object);
    }
    public boolean isExist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.isExist(id);
    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }
}

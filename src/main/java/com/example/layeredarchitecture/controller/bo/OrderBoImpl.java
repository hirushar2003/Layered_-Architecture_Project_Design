package com.example.layeredarchitecture.controller.bo;

import com.example.layeredarchitecture.dao.SQLutil;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public class OrderBoImpl {
    public OrderDAOImpl orderDAO = new OrderDAOImpl();

    public String generateOID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateOID();
    }

    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        return orderDAO.existOrder(orderId);
    }

    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.saveOrder(dto);
    }
}

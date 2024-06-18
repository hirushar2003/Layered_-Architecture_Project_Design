package com.example.layeredarchitecture.controller.bo;

import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailBoImpl {
    public OrderDetailsDAOImpl orderDetailsDAO = new OrderDetailsDAOImpl();

    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.saveOrderDetails(dto);
    }
}

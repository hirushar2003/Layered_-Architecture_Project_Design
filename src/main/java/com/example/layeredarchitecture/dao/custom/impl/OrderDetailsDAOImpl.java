package com.example.layeredarchitecture.dao.custom.impl;


import com.example.layeredarchitecture.dao.SQLutil;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import java.sql.SQLException;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {

        return SQLutil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", dto.getOid(), dto.getItemCode(), dto.getUnitPrice(), dto.getQty());
    }
}

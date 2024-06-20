package com.example.layeredarchitecture.dao;


import com.example.layeredarchitecture.bo.impl.PlaceOrderBoImpl;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory ;
    public DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory != null){
            return daoFactory;
        } else {
            return new DAOFactory();
        }
    }
    public Object getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDetailsDAOImpl();
            case ORDER_DETAILS:
                return new OrderDetailsDAOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBoImpl();
        }
        return null;
    }
}

package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.impl.CustomerBoImpl;
import com.example.layeredarchitecture.bo.impl.ItemBoImpl;
import com.example.layeredarchitecture.bo.impl.PlaceOrderBoImpl;
import com.example.layeredarchitecture.dao.custom.ItemDAO;

public class BoFactory {
    private static BoFactory boFactory ;
    private BoFactory(){

    }
    public static BoFactory getInstance() {
        if (boFactory != null){
            return boFactory ;
        } else {
            return new BoFactory();
        }
    }

    public Object getBo(BoTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case PLACE_ORDER:
                return new PlaceOrderBoImpl();
            default: return null ;
        }
    }
}

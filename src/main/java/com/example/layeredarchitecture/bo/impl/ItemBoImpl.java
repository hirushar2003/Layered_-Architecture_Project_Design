package com.example.layeredarchitecture.bo.impl;


import com.example.layeredarchitecture.bo.ItemBo;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.DAOTypes;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ItemBoImpl implements ItemBo {

    public ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOTypes.ITEM);
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.add(dto);
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.isExist(code);
    }

    @Override
    public String generateNewCode() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}

package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDAO itemDAO = new ItemDAOImpl();
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException{
        return itemDAO.getAll();
    };

    public boolean existItem(String code) throws SQLException, ClassNotFoundException{
        return itemDAO.exist(code);
    };

    public void deleteItem(String code) throws SQLException, ClassNotFoundException{
         itemDAO.Delete(code);
    };

    public boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException{
        return itemDAO.save(item);
    };


    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException{
        return itemDAO.update(item);
    };

    public boolean searchupdateItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.searchupdateItem(item);
    };

    public String generateNewId() throws SQLException, ClassNotFoundException{
        return itemDAO.generateNewId();
    };

    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException{
        return  itemDAO.findItem(newItemCode);
    };

    public ArrayList<ItemDTO> loadAllItemCodes() throws SQLException, ClassNotFoundException{
        return itemDAO.loadAllItemCodes();
    };

}

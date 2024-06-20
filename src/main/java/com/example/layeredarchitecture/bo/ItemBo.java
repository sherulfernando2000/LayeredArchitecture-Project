package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;


    public void deleteItem(String code) throws SQLException, ClassNotFoundException;


    public boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException;



    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException;

    public boolean searchupdateItem(ItemDTO item) throws SQLException, ClassNotFoundException ;

    public String generateNewId() throws SQLException, ClassNotFoundException;

    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException;

    public ArrayList<ItemDTO> loadAllItemCodes() throws SQLException, ClassNotFoundException;
}

package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO> {
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean exist(String code) throws SQLException, ClassNotFoundException;

    public void delete(String code) throws SQLException, ClassNotFoundException;

    public boolean save(ItemDTO item) throws SQLException, ClassNotFoundException;


    public boolean update(ItemDTO item) throws SQLException, ClassNotFoundException;

    public boolean searchupdateItem(ItemDTO item) throws SQLException, ClassNotFoundException;

    public String generateNewId() throws SQLException, ClassNotFoundException;

    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException;

    public ArrayList<ItemDTO> loadAllItemCodes() throws SQLException, ClassNotFoundException;
}

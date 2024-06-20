package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(rst.getString("code"),rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand"));
            allItems.add(itemDTO);
        }
       return allItems;
    }
    @Override

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();
    }
    @Override

    public void delete(String code) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("DELETE FROM Item WHERE code=?",code);

    }
    @Override

    public boolean save(ItemDTO item) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());

    }
    @Override

    public boolean update(ItemDTO item) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());

    }

    @Override
    public boolean searchupdateItem(ItemDTO item) throws SQLException, ClassNotFoundException {


        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());


    }


    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1");

        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
    @Override

    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException {
        if (!exist(newItemCode + "")) {
//                        throw new NotFoundException("There is no such item associated with the id " + code);
        }

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",newItemCode);
        rst.next();
        ItemDTO item = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

        return item;

    }
    @Override

    public ArrayList<ItemDTO> loadAllItemCodes() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");

        ArrayList<ItemDTO> items = new ArrayList<>();
        while (rst.next()) {
           items.add(new ItemDTO(rst.getString("code")));
            // cmbItemCode.getItems().add(rst.getString("code"));)
        }
        return items;
    }



    @Override
    public boolean Exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void Delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String currentId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException {
        return null;
    }
}


package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override// Data Access Object Implementation
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }
    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());

    }


    @Override
    public boolean Exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id) ;
        return  rst.next();
    }

    @Override
    public void Delete(String id) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public String currentId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");

        if (rst.next()) {
            return rst.getString("id");
        }
        return null;
    }

    @Override
    public String search(String newValue) throws SQLException, ClassNotFoundException {


        if (!Exist(newValue + "")) {
//                            "There is no such customer associated with the id " + id
            new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + newValue + "").show();
        }

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue);
        rst.next();
        return rst.getString("name");

        //txtCustomerName.setText(customerDTO.getName());


    }


    @Override
    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        ArrayList<String> customerIds = new ArrayList<>();
        while (rst.next()) {
            customerIds.add(rst.getString("id"));
        }
        return customerIds;
    }
}

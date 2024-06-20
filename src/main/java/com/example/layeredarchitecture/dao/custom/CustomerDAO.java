package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {

    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean Exist(String id) throws SQLException, ClassNotFoundException;

    public void Delete(String id) throws SQLException, ClassNotFoundException;

    public String currentId() throws SQLException, ClassNotFoundException;

    public String search(String newValue) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException;
}

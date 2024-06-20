package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    public  ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(T DTO) throws SQLException, ClassNotFoundException;

    public boolean update(T DTO) throws SQLException, ClassNotFoundException;

    public boolean Exist(String id) throws SQLException, ClassNotFoundException;

    public void Delete(String id) throws SQLException, ClassNotFoundException;

    public String currentId() throws SQLException, ClassNotFoundException;

    public String search(String newValue) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException;
}

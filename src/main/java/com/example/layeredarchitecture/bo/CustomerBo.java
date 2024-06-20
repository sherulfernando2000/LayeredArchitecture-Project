package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean ExistCustomer(String id) throws SQLException, ClassNotFoundException;

    public void DeleteCustomer(String id) throws SQLException, ClassNotFoundException;

    public String currentId() throws SQLException, ClassNotFoundException;

    public String searchCustomer(String newValue) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadAllCustomerIds() throws SQLException, ClassNotFoundException;


}

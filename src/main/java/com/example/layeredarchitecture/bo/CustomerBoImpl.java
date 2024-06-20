package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

        return customerDAO.getAll();
    }

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(customerDTO);
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException{
        return customerDAO.update(customerDTO);
    };

    public boolean ExistCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.Exist(id);
    };

    public void DeleteCustomer(String id) throws SQLException, ClassNotFoundException{
         customerDAO.Delete(id);
    };

    public String currentId() throws SQLException, ClassNotFoundException{
        return customerDAO.currentId();
    };

    public String searchCustomer(String newValue) throws SQLException, ClassNotFoundException{
        return customerDAO.search(newValue);
    };

    public ArrayList<String> loadAllCustomerIds() throws SQLException, ClassNotFoundException{
        return customerDAO.loadAllIds();
    };


}

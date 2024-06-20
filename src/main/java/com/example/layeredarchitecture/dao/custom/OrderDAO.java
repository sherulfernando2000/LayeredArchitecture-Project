package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    public String generateNewOrderId() throws SQLException, ClassNotFoundException;

    public boolean orderIdExist(String orderId) throws SQLException, ClassNotFoundException;

    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;

    //public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}

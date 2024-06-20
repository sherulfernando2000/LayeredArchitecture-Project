package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    public boolean saveOrderDetails(OrderDetailDTO orderDetails, String orderId) throws SQLException, ClassNotFoundException;
}

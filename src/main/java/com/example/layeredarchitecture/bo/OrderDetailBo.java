package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailBo {
    public boolean saveOrderDetails(OrderDetailDTO orderDetails, String orderId) throws SQLException, ClassNotFoundException;
}

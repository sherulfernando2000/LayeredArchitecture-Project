package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailBoImpl implements OrderDetailBo{
    OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

    public boolean saveOrderDetails(OrderDetailDTO orderDetails, String orderId) throws SQLException, ClassNotFoundException{
        return orderDetailDAO.saveOrderDetails(orderDetails,orderId);
    };
}

package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderBoImpl implements OrderBo {

    OrderDAO orderDAO = new OrderDAOImpl();
    public String generateNewOrderId() throws SQLException, ClassNotFoundException{
        return orderDAO.generateNewOrderId();
    };

    public boolean orderIdExist(String orderId) throws SQLException, ClassNotFoundException{
        return orderDAO.orderIdExist(orderId);
    };

    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException{
        return orderDAO.saveOrder(orderId,orderDate,customerId);
    };

    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException{
        return orderDAO.saveOrder(dto);
    };

    /*public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails){
        return orderDAO.saveOrder(orderId,orderDate,customerId,orderDetails);
    };*/

}

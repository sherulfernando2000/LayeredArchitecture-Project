package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderBo {
    public String generateNewOrderId() throws SQLException, ClassNotFoundException;

    public boolean orderIdExist(String orderId) throws SQLException, ClassNotFoundException;

    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;

   // public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

}

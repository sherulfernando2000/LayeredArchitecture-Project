package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public boolean orderIdExist(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return rst.next();
    }
    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderId,orderDate,customerId);

    }

    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, dto.getOrderId());
        stm.setDate(2, Date.valueOf(dto.getOrderDate()));
        stm.setString(3, dto.getCustomerId());
        return stm.executeUpdate()>0;
    }
/*
    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails){
        Connection connection = null;
        try {
            //order
            connection = DBConnection.getDbConnection().getConnection();

            OrderDAO orderDAO = new OrderDAOImpl();
            if (orderDAO.orderIdExist(orderId)) {

            }
            //order
            connection.setAutoCommit(false);

            if (!orderDAO.saveOrder(orderId, orderDate, customerId)) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            //orderDetail
            OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

            for (OrderDetailDTO orderDetailDTO :orderDetails) {
                if (!orderDetailDAO.saveOrderDetails(orderDetailDTO,orderId)) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
            }


            }

             //Search & Update Item

            for (OrderDetailDTO detail : orderDetails) {
                ItemDAO itemDAO = new ItemDAOImpl();
                ItemDTO item = itemDAO.findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                if (!itemDAO.searchupdateItem(item)) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
*/

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDTO DTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDTO DTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void Delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String currentId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException, ClassNotFoundException {
        return null;
    }
}

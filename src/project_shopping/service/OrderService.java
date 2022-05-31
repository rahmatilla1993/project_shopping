/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import project_shopping.models.OrderDetails;

/**
 *
 * @author Admin
 */
public class OrderService extends DBService {
    public boolean addOrderByProduct(OrderDetails details, Integer id_order){
        try {
            String query = "INSERT INTO order_details(id_order, id_product, id_brand,"
                    + "count,total_sum) VALUES(" + id_order + "," + details.getId_product()
                    + "," + details.getId_brand() + "," + details.getCount() + "," + details.getTotal_sum() + ");";
            Statement createStatement = connection.createStatement();
            createStatement.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Integer addMainOrder(float total_sum, Integer id_user){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String format = new SimpleDateFormat("YY-MM-dd hh:mm:ss").format(timestamp);
            
            String query = "INSERT INTO orders(date_of_order, total_sum, id_user) "
                    + "VALUES('" + format + "'," + total_sum + "," + id_user + ");";
            Statement createStatement = connection.createStatement();
            createStatement.execute(query);
            
            String query_id_order = "SELECT id_order FROM orders WHERE date_of_order = '" + format + "';";
            ResultSet rs = createStatement.executeQuery(query_id_order);
            rs.next();
            return Integer.parseInt(rs.getString("id_order"));
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getMainOrder(){
        try {
            String query = "SELECT *FROM orders";
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getOrderDetails(){
        try {
            String query = "SELECT *FROM order_details";
            Statement createStatement = connection.createStatement();
            return createStatement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

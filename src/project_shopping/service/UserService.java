/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_shopping.models.User;

/**
 *
 * @author Admin
 */
public class UserService extends DBService {
//    public boolean addUser(User user){
//        try {
//            String query = "INSERT INTO user(first_name,last_name,username,password,role)"
//                    + "VALUES('" + user.getFirstname() + "','" + user.getLastname() + "','"
//                    + user.getUsername() + "','" + user.getPassword() + "');";
//            Statement createStatement = connection.createStatement();
//            createStatement.execute(query);
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
    
    public boolean addUser(User user){
        try {
            String query = "{? = CALL addUser(?,?,?,?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(2, user.getFirstname());
            statement.setString(3, user.getLastname());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());
            statement.registerOutParameter(1, Types.BOOLEAN);
            statement.executeUpdate();
            return statement.getBoolean(1);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean hasUsername(String _username){
        boolean exist = false;
        try {
            String query = "SELECT username FROM user";
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery(query);
            while(rs.next()){
                String username = rs.getString("username");
                if(username.equals(_username)){
                    exist = true;
                    break;
                }
            }
            return exist;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

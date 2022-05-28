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
    
    public boolean editUser(User user){
        try {
            String query = "UPDATE user SET first_name = '" + user.getFirstname() + "',"
                    + "last_name = '" + user.getLastname() + "',username = '" + user.getUsername() + "',"
                    + "password = '" + user.getPassword() + "' WHERE id_user = " + user.getId_user() + ";";
            Statement createStatement = connection.createStatement();
            createStatement.execute(query);
            return true;
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
    
    public User getUserById(Integer id_user){
        try {
            String query = "SELECT *FROM user WHERE id_user = " + id_user;
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery(query);
            rs.next();
            String firstname = rs.getString("first_name");
            String lastname = rs.getString("last_name");
            String username = rs.getString("username");
            String password = rs.getString("password");
            User user = new User(id_user,firstname,lastname,username,password);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public User getUserByUsername(String _username){
        try {
            String query = "SELECT *FROM user WHERE username = '" + _username + "';";
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery(query);
            rs.next();
            Integer id_user = rs.getInt("id_user");
            String firstname = rs.getString("first_name");
            String lastname = rs.getString("last_name");
            String username = rs.getString("username");
            String password = rs.getString("password");
            User user = new User(id_user,firstname,lastname,username,password);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

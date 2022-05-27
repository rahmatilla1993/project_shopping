/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CategoryService extends DBService {
    
    public ResultSet getCategories(){
        try {
            String query = "SELECT *FROM category";
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<String> getListCategories(){
        List<String> categories = new ArrayList<>();
        try {
            ResultSet rs = getCategories();
            while(rs.next()){
                categories.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    
        public String getCategoryNameById(Integer id){
        try {
            String query = "SELECT *FROM category WHERE id_category = " + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return rs.getString("name");
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
        public Integer getCategoryIdByName(String name){
        try {
            String query = "SELECT *FROM category WHERE name = '" + name + "';";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            String id = rs.getString("id_category");
            return Integer.parseInt(id);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void main(String[]args){
        CategoryService categoryService = new CategoryService();
        List<String> listCategories = categoryService.getListCategories();
        for(String item : listCategories){
            System.out.println(item);
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_shopping.models.Product;

/**
 *
 * @author Admin
 */
public class ProductService extends DBService {
    
    public ResultSet getProducts(){
        try {
            String query = "SELECT *FROM product";
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getProductNames(){
        try {
            String query = "SELECT id_product,product_name FROM product";
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String getProductNameById(Integer id){
        String name = "";
        try {
            String query = "SELECT product_name FROM product WHERE id_product = " + id;
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery(query);
            rs.next();
            name = rs.getString("product_name");
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
    public Float getProductPriceById(Integer id){
        try {
            String query = "SELECT price FROM product WHERE id_product = " + id;
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery(query);
            rs.next();
            return rs.getFloat("price");
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Product getProductById(Integer id){
        try {
            String query = "SELECT *FROM product WHERE id_product = " + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            String name = rs.getString("product_name");
            Date date_delivery = rs.getDate("date_of_delivery");
            Date date_validate = rs.getDate("validate_date");
            boolean status = rs.getBoolean("status");
            float price = rs.getFloat("price");
            String photo_path = rs.getString("photo");
            int id_category = rs.getInt("id_category");
            int id_brand = rs.getInt("id_brand");
            Product product = new Product(id,name,date_delivery,date_validate,status,price,photo_path,id_category,id_brand);
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean addProduct(Product product){
        try {
            String query = "INSERT INTO product(product_name,date_of_delivery,"
                    + "validate_date,status,price,photo,id_category,id_brand)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, product.getName());
            prepareStatement.setDate(2, product.getDate_delivery());
            prepareStatement.setDate(3, product.getValidate_date());
            prepareStatement.setBoolean(4, product.getStatus());
            prepareStatement.setFloat(5, product.getPrice());
            prepareStatement.setString(6, product.getPhoto_path());
            prepareStatement.setInt(7, product.getCategory_id());
            prepareStatement.setInt(8, product.getBrend_id());
            prepareStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean editProduct(Product product){
        try {
            String query = "UPDATE product SET product_name = ?,date_of_delivery = ?,"
                    + "validate_date = ?,status = ?,price = ?,photo = ?,"
                    + "id_category = ?,id_brand = ? WHERE id_product = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, product.getName());
            prepareStatement.setDate(2, product.getDate_delivery());
            prepareStatement.setDate(3, product.getValidate_date());
            prepareStatement.setBoolean(4, product.getStatus());
            prepareStatement.setFloat(5, product.getPrice());
            prepareStatement.setString(6, product.getPhoto_path());
            prepareStatement.setInt(7, product.getCategory_id());
            prepareStatement.setInt(8, product.getBrend_id());
            prepareStatement.setInt(9, product.getId());
            prepareStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteProduct(Integer id){
        try {
            String query = "DELETE FROM product WHERE id_product = " + id;
            Statement createStatement = connection.createStatement();
            createStatement.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

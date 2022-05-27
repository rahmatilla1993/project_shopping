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
public class BrandService extends DBService {
    public ResultSet getBrands(){
        try {
            String query = "SELECT *FROM brand";
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<String> getListBrends(){
        List<String> brends = new ArrayList<>();
        try {
            ResultSet rs = getBrands();
            while(rs.next()){
                brends.add(rs.getString("brand_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brends;
    }
    
    public String getBrandNameById(Integer id){
        try {
            String query = "SELECT *FROM brand WHERE id_brand = " + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return rs.getString("brand_name");
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Integer getBrandIdByName(String name){
        try {
            String query = "SELECT *FROM brand WHERE brand_name = '" + name + "';";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            String id = rs.getString("id_brand");
            return Integer.parseInt(id);
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void main(String[]args){
        BrandService service = new BrandService();
        List<String> listBrends = service.getListBrends();
        for(String item : listBrends){
            System.out.println(item);
        }
    }
}

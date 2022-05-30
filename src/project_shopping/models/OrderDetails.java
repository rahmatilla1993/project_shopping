/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.models;

/**
 *
 * @author Admin
 */
public class OrderDetails {
    
    private Integer id_order_detail;
    private Integer id_product;
    private Integer id_brand;
    private Integer count;
    private float total_sum;

    public OrderDetails(Integer id_order_detail, Integer id_product, Integer id_brand, Integer count, float total_sum) {
        this.id_order_detail = id_order_detail;
        this.id_product = id_product;
        this.id_brand = id_brand;
        this.count = count;
        this.total_sum = total_sum;
    }

    public OrderDetails(Integer id_product, Integer id_brand, Integer count, float total_sum) {
        this.id_product = id_product;
        this.id_brand = id_brand;
        this.count = count;
        this.total_sum = total_sum;
    }
    
    

    public Integer getId_order_detail() {
        return id_order_detail;
    }

    public void setId_order_detail(Integer id_order_detail) {
        this.id_order_detail = id_order_detail;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Integer getId_brand() {
        return id_brand;
    }

    public void setId_brand(Integer id_brand) {
        this.id_brand = id_brand;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public float getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(float total_sum) {
        this.total_sum = total_sum;
    }
    
    
    
}

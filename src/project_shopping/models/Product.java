/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.models;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class Product {
    private Integer id;
    private final String name;
    private final Date date_delivery;
    private final Date validate_date;
    private final Boolean status;
    private final Float price;
    private final String photo_path;
    private final Integer category_id;
    private final Integer brend_id;

    public Product(Integer id, String name, Date date_delivery, Date validate_date, 
            Boolean status, Float price, String photo_path, Integer category_id, Integer brend_id) {
        this.id = id;
        this.name = name;
        this.date_delivery = date_delivery;
        this.validate_date = validate_date;
        this.status = status;
        this.price = price;
        this.photo_path = photo_path;
        this.category_id = category_id;
        this.brend_id = brend_id;
    }

    public Product(String name, Date date_delivery, Date validate_date, Boolean status, 
            Float price, String photo_path, Integer category_id, Integer brend_id) {
        this.name = name;
        this.date_delivery = date_delivery;
        this.validate_date = validate_date;
        this.status = status;
        this.price = price;
        this.photo_path = photo_path;
        this.category_id = category_id;
        this.brend_id = brend_id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate_delivery() {
        return date_delivery;
    }

    public Date getValidate_date() {
        return validate_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public Float getPrice() {
        return price;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public Integer getBrend_id() {
        return brend_id;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", date_delivery=" + date_delivery + 
                ", validate_date=" + validate_date + ", status=" + status + ", price=" + price + ", "
                + "photo_path=" + photo_path + ", category_id=" + category_id + ", brend_id=" + brend_id + '}';
    }
    
    
}

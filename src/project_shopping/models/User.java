/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_shopping.models;

/**
 *
 * @author Admin
 */
public class User {
    private Integer id_user;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String repassword;
    private String role;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(Integer id_user, String firstname, String lastname, String username, String password, String repassword, String role) {
        this.id_user = id_user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.repassword = repassword;
        this.role = role;
    }
    
    public User(Integer id_user, String firstname, String lastname, String username, String password, String repassword) {
        this.id_user = id_user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.repassword = repassword;
    }

    public User(Integer id_user, String firstname, String lastname, String username, String password) {
        this.id_user = id_user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public User(String firstname, String lastname, String username, String password, String repassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.repassword = repassword;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", firstname=" + firstname + ", lastname=" 
                + lastname + ", username=" + username + ", password=" + 
                password + ", repassword=" + repassword + ", role=" + role + '}';
    }

    

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    
    
}

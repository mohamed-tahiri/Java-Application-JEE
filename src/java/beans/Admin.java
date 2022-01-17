/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

public class Admin {
    private int id;
    private String email;
    private String username;
    private String password;
    private String parking;

    public Admin(int id, String email, String username, String password , String parking) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.parking = parking;
    }
    
    public Admin(String email, String username, String password, String parking) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.parking = parking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public String getParking(){
        return parking;
    }
    
    public void setParking(String parking){
        this.parking = parking;
    }
    
    
}

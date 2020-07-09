/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tanyj
 */
public class staffDA {
     private String host = "jdbc:derby://localhost:1527/Location";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private String tableName ="STAFF";
    private String login = "SELECT * from staff where STAFF_ID = ? and password = ?";
    private ResultSet rs=null;
    
     public staffDA(){
        getConnection();
    }
    
    public void getConnection() {
          try{
          conn= DriverManager.getConnection(host, user, password);
          }catch(SQLException ex){
           ex.getMessage();
          }
    }
    
    public boolean login(String username, String password){
         try{
            
            stmt = conn.prepareStatement(login);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();         
            while(rs.next())
                return true;
        }
        catch(SQLException ex){
        ex.getMessage();
        }
    return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import domain.List;
import domain.List;
import domain.Location;
import domain.transport;
import domain.transport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tanyj
 */
public class transportationDA {
    private String host = "jdbc:derby://localhost:1527/Location";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private String tableName ="TRANSPORTATION";
    private String retrieveAllData="Select * from " +tableName;
    private List<transport> listOfTransport = new List<transport>();
    private ResultSet rs; 
     public transportationDA(){
        getConnection();
    }
    
    public void getConnection() {
          try{
          conn= DriverManager.getConnection(host, user, password);
          }catch(SQLException ex){
           ex.getMessage();
          }
    }
    
    public List<transport> getAllTransportData(){
       try {
            
           stmt = conn.prepareStatement(retrieveAllData);
      
            rs = stmt.executeQuery();
           while(rs.next())
           { 
              listOfTransport.add(getCurrentRecord());
           }
        } catch (SQLException ex) {
           ex.getMessage();
        }  
     return listOfTransport;
    }
    
    public transport getCurrentRecord(){
      transport transportobj = null;
        try {       
            transportobj = new transport(Integer.parseInt(rs.getString(1)),rs.getString(2),Integer.parseInt(rs.getString(3)),Double.parseDouble(rs.getString(4)));
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
       
        return transportobj;
 }
}

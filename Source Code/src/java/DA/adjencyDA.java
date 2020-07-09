/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;


import domain.List;
import domain.Location;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tanyj
 */
public class adjencyDA {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tanyj
 */


    private String host = "jdbc:derby://localhost:1527/Location";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private String tableName ="ADJENCENT";
    private String retrieveAllData="Select * from " +tableName;
    private String retrieveAllDataFromTwoTable="Select * from adjencent A , location L ";
   private ResultSet rs=null;
   private String retrieveSpecificData="Select * from " +tableName + " where L_CODE = ? ";
  // new
   private String addNewAdjenct ="insert into " +tableName+ " values(?,?) ";
   private String checkExistinSystem = "select * from adjencent where L_CODE=? and ADJ_CODE=?";
   private String deleteTravelLeg ="select * from location where L_CODE IN (SELECT ADJ_CODE from adjencent A, Location L where A.L_CODE=? and L.L_CODE=?)";
   private String RealdeleteTravelLeg = "delete from adjencent where L_CODE=? and adj_code = ?";
   
   public adjencyDA(){
        getConnection();
    }
    
    public void getConnection() {
          try{
          conn= DriverManager.getConnection(host, user, password);
          }catch(SQLException ex){
           ex.getMessage();
          }
    }

    
    
    
    
 public List<Location> getAllRelatedAdjency(){
     List<Location> loca= new List<Location>();
     
        try {
            
           stmt = conn.prepareStatement(retrieveAllDataFromTwoTable);
      
            rs = stmt.executeQuery();
           while(rs.next())
           { 
              loca.add(getCurrentRecord());
           }
        } catch (SQLException ex) {
           ex.getMessage();
        }

        return loca;
     
 }
 
 public Location getCurrentRecord(){
      Location location = null;
        try {
            
            location = new Location(Double.parseDouble(rs.getString(5)),Double.parseDouble(rs.getString(4)),rs.getString(6),Integer.parseInt(rs.getString(1))
                    ,rs.getString(7).charAt(0),rs.getString(8)=="true"
                    ,rs.getString(9)=="true",rs.getString(10)=="true",Integer.parseInt(rs.getString(11)),rs.getString(12),Integer.parseInt(rs.getString(2)));
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
       
        return location;
 }
    //-------------------------yi jing code------------------------------>
public Location getSpecificRecord(int locationcode){
      
Location loca=null;

        
        try {
           stmt = conn.prepareStatement(retrieveSpecificData);
            stmt.setString(1, String.valueOf(locationcode));
            rs = stmt.executeQuery();
           while(rs.next())
           { loca = new Location(Double.parseDouble(rs.getString(3)), Double.parseDouble(rs.getString(2)), rs.getString(4)
                    , Integer.parseInt(rs.getString(1)),rs.getString(5).charAt(0)
                    ,rs.getString(6)=="true"
                    ,rs.getString(7)=="true",rs.getString(8)=="true",Integer.parseInt(rs.getString(9)),rs.getString(10));
           }
        } catch (SQLException ex) {
           ex.getMessage();
        }

        return loca;
    }



  public int getNumofRecords(){
       int counter=0;
        try {
          stmt=conn.prepareStatement(retrieveAllData);
          rs =stmt.executeQuery();
          while (rs.next()){
              counter++;
          }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
       
        return counter;
  }
    
   //ate add new code 
  public int getNumberofTravelLeg(int LocaCode){
     int counter=0;
        try {
           stmt = conn.prepareStatement(retrieveSpecificData);
            stmt.setString(1,String.valueOf(LocaCode));
            rs = stmt.executeQuery();
           while(rs.next())
           {
               counter++;
           }
        } catch (SQLException ex) {
           ex.getMessage();
        }

        return counter;
    }
  
  
  public boolean addNewAdjency(String source,String destination){
      
        try {
           stmt = conn.prepareStatement(addNewAdjenct);
            stmt.setString(1,source);
             stmt.setString(2,destination);
           if( stmt.executeUpdate()>0)
           {
               return true;
           }
          
        } catch (SQLException ex) {
           ex.getMessage();
           
        }
        return false;
        
  }
  
  public boolean checkExisting(String source,String dest){
      
        try {
          stmt=conn.prepareStatement(checkExistinSystem);
          stmt.setString(1, source);
          stmt.setString(2, dest);
          rs = stmt.executeQuery();
          while(rs.next())
              return true;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
       
        return false;
  }

   public List<Location> selectDeleteLocation(String delLoca,String delLoca1){
     List<Location> loca= new List<Location>();
     
        try {
            
           stmt = conn.prepareStatement(deleteTravelLeg);
           stmt.setString(1, delLoca);
           stmt.setString(2, delLoca1);
           rs = stmt.executeQuery();
           while(rs.next())
           { 
              loca.add(getCurrentDeletedRecords());
           }
        } catch (SQLException ex) {
           ex.getMessage();
        }

        return loca;
     
 }

   public Location getCurrentDeletedRecords(){
      Location location = null;
        try {
            
            location = new Location(Double.parseDouble(rs.getString(3)),Double.parseDouble(rs.getString(2)),rs.getString(4),Integer.parseInt(rs.getString(1))
                    ,rs.getString(5).charAt(0),rs.getString(6)=="true"
                    ,rs.getString(7)=="true",rs.getString(8)=="true",Integer.parseInt(rs.getString(9)),rs.getString(10));
            
            
          
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
       
        return location;
 }
   
   public boolean deleteAdjency(String sourceCode,String destCode){
        try {
          stmt=conn.prepareStatement(RealdeleteTravelLeg);
          stmt.setString(1, sourceCode);
          stmt.setString(2, destCode);
          if(stmt.executeUpdate()>0)
              return true;
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
       
        return false;
   }
  }




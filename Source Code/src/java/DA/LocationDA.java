/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

/**
 *
 * @author User
 */
import domain.Location;
import domain.List;
import domain.linkedlist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDA {
    private String host = "jdbc:derby://localhost:1527/Location";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "location";
    private String tableName2 = "ADJENCENT";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlQueryStr = "SELECT * from " + tableName;
    private String sqlQueryStrADJ = "SELECT * from " + tableName2;
        
    private String sqlsltsomeType = "SELECT * from " + tableName + " where type =  ? ";
  //  private String sqlsltsomeGeo = "SELECT * from " + tableName + " where geography =  ? ";
    private String sqlsltsomeparent = "SELECT * from " + tableName + " where state_id =  ? ";
    private String sqlsltonename = "SELECT * from " + tableName + " where name =  ? ";
    private String sqlsltgetairport = "select * from location where state_id in ( select state_id from state where country_id in ( select country_id from state  where state_id  = ( select state_id from location where name = ? ) ) ) and flight=true ";

 private String sqlgetalllocationfromcontinent = "SELECT L.L_CODE , L.LON , L.LAT ,L.\"NAME\" ,L.\"TYPE\", L.T_STATION, L.B_STATION, L.FLIGHT,L.STATE_ID,L.\"LINK\" FROM continent CT , country C , \"STATE\" S, location L where CT.CON_ID=C.CON_ID and C.COUNTRY_ID= S.COUNTRY_ID and S.STATE_ID = L.STATE_ID and CT.CON_ID=?" ;
    private String sqlgetalllocationfromcountry = "SELECT L.L_CODE , L.LON , L.LAT ,L.\"NAME\" ,L.\"TYPE\", L.T_STATION, L.B_STATION, L.FLIGHT,L.STATE_ID,L.\"LINK\" FROM  country C , \"STATE\" S, location L where C.COUNTRY_ID= S.COUNTRY_ID and S.STATE_ID = L.STATE_ID and C.COUNTRY_ID=? ";
    private String slqgetalllocationfromstate = "SELECT L.L_CODE , L.LON , L.LAT ,L.\"NAME\" ,L.\"TYPE\", L.T_STATION, L.B_STATION, L.FLIGHT,L.STATE_ID,L.\"LINK\" FROM  \"STATE\" S, location L where S.STATE_ID = L.STATE_ID and S.STATE_ID =?";
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
    
    private String sqlgetonelocation = "SELECT * from " + tableName + " where l_code =  ? ";
  
    private String retrieveSpecificData="Select * from " +tableName + " where l_code =  ? ";         
    private ResultSet rs;  

    public LocationDA() {
        getConnection();
    }
    
    
    
      public void getConnection() {
          try{
          conn=DriverManager.getConnection(host, user, password);
          }catch(SQLException ex){
           ex.getMessage();
          }
    }
      
      
      
      public Location getCurrentRecord() {
        Location location = null;
        try {
            location = new Location(Double.parseDouble(rs.getString(3)), Double.parseDouble(rs.getString(2)), rs.getString(4)
                    , Integer.parseInt(rs.getString(1)),rs.getString(5).charAt(0)
                    ,rs.getString(6)=="true"
                    ,rs.getString(7)=="true",rs.getString(8)=="true",Integer.parseInt(rs.getString(9)),rs.getString(10));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return location;
    }

      
    public List<Location>getsomeLocation (int operation,String str){
    
         List<Location> location = new List<Location>();
        try {
            String sqlstr="";
            if( operation== 1 ){
            sqlstr= sqlsltsomeType;
            }
            else if (operation ==3)
                sqlstr= sqlsltsomeparent;
          else if (operation==4){
                sqlstr= sqlgetalllocationfromcontinent;
            }
            else if (operation ==5)
                sqlstr = sqlgetalllocationfromcountry;
            else if (operation ==6)
                sqlstr=slqgetalllocationfromstate;
            stmt = conn.prepareStatement(sqlstr);
            stmt.setString(1, str);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                location.add(getCurrentRecord());
            }
            
            setAdj(location);
            
            
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return location;
    
    
    }
    public List<Location> getAllLocation() {

        List<Location> location = new List<Location>();
        try {
           
                
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                location.add(getCurrentRecord());
            }
           setAdj(location);

           
            
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return location;
    }
    
    public void setAdj(List<Location> location){
        try{
        stmt = conn.prepareStatement(sqlQueryStrADJ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                 for(int i = 0 ; i < location.size() ; i ++)
                 {
                     Location tem_loc = location.getValueOf(i+1);
                         if(tem_loc.equalcode(rs.getInt(1))){
                             for(int j = 0 ; j < location.size() ; j ++){ 
                                 Location tem_loc2 = location.getValueOf(j+1);
                                 if(tem_loc2.equalcode(rs.getInt(2))){
                                     tem_loc.getAdjencies().add(tem_loc2); 
                                     break;
                                 }              
                                }
                             break;
                             }
                         
                 }
            }
        }
        catch(SQLException ex){
        ex.getMessage();
        }
    }
    
    public linkedlist<Location> getAlllinkLocation() {

        linkedlist<Location> location = new linkedlist<Location>();
        try {          
                
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                location.add(getCurrentRecord());
            }
           setAdj(location);

           
            
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return location;
    }
    
    
    public void setAdj(linkedlist<Location> location){
        try{
        stmt = conn.prepareStatement(sqlQueryStrADJ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                 for(int i = 0 ; i < location.getNumberOfEntries(); i ++)
                 {
                     Location tem_loc = location.getEntry(i+1);
                         if(tem_loc.equalcode(rs.getInt(1))){
                             for(int j = 0 ; j < location.getNumberOfEntries(); j ++){ 
                                 Location tem_loc2 = location.getEntry(j+1);
                                 if(tem_loc2.equalcode(rs.getInt(2))){
                                     tem_loc.getAdjencies().add(tem_loc2); 
                                     break;
                                 }              
                                }
                             break;
                             }
                         
                 }
            }
        }
        catch(SQLException ex){
        ex.getMessage();
        }
    }
    
    public Location get_one_loc(String a_loc){
        Location loc= new Location();
     try{
            
             stmt = conn.prepareStatement(sqlsltonename);
            stmt.setString(1, a_loc);
            rs = stmt.executeQuery();
            rs.next();
            loc = getCurrentRecord();                                  
        }
        catch(SQLException ex){
        ex.getMessage();
        }
    return loc;
    }
    
    public Location get_one_loc(int operation , String a_loc){
        Location loc= new Location();
     try{
            
             stmt = conn.prepareStatement(sqlgetonelocation);
            stmt.setString(1, a_loc);
            rs = stmt.executeQuery();
            rs.next();
            loc = getCurrentRecord();                                  
        }
        catch(SQLException ex){
        ex.getMessage();
        }
    return loc;
    }
    
    public Location get_nearest_airport(String a_loc){
        List<Location> loc = new List<Location>();
        Location near = new Location();
        Location curr = new Location();
       try{
        stmt = conn.prepareStatement(sqlsltgetairport);
        stmt.setString(1, a_loc);
        rs = stmt.executeQuery();
       
            while (rs.next()) {
                 loc.add(getCurrentRecord());
            }
            
            curr = get_one_loc(a_loc);
            near = loc.getValueOf(1);
            
            for(int i =0 ; i < loc.size(); i++){
               if(curr.distance(near) >= curr.distance(loc.getValueOf(i+1))){
                  near = loc.getValueOf(i+1);
               }
            }
        }
        catch(SQLException ex){
        ex.getMessage();
        }
       return near;
    }
    
    
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
    
      
}

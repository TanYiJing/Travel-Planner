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
 * @author User
 */
public class categoriesDA {

    private String host = "jdbc:derby://localhost:1527/Location";
    private String user = "nbuser";
    private String password = "nbuser";
    private String continent = "continent";
    private String country = "country";
    private String state = "state";
    private String location = "location";

    private Connection conn;
    private PreparedStatement stmt;
    private String sqlQueryStrcont = "SELECT * from " + continent;
    private String sqlQueryStrCountry = "SELECT * from " + country;
    private String sqlQueryStrState = "SELECT * from " + state;

    private String sqlQuerysomeCountry = "SELECT * from " + country + " where con_id = ? ";
    private String sqlQuerysomeState = "SELECT * from " + state + " where COUNTRY_ID = ? ";

    private String sqlQuerygetstateID = "SELECT state_id from " + location + " where name = ? ";
    private String sqlQuerygetcountryID = "SELECT country_id from " + state + " where state_id = ? ";

    private String sqlQueryAddcont = "INSERT INTO " + continent + " (NAME) VALUES(?)";
    private String sqlQueryAddcount = "INSERT INTO " + country + " (NAME,CON_ID,LINK) VALUES(?,?,?)";
    private String sqlQuerySelectcont = "SELECT CON_ID FROM " + continent + " WHERE NAME = ? ";
    private String sqlQueryAddstate = "INSERT INTO " + state + " (NAME,COUNTRY_ID,LINK) VALUES(?,?,?)";
    private String sqlQuerySelectcount = "SELECT COUNTRY_ID FROM " + country + " WHERE NAME = ? ";
    private String sqlQueryAddlocation = "INSERT INTO " + location + " (LON,LAT,NAME,TYPE,T_STATION,B_STATION,FLIGHT,STATE_ID,LINK) VALUES(?,?,?,?,?,?,?,?,?)";
    private String sqlQuerySelectstate = "SELECT STATE_ID FROM " + state + " WHERE NAME = ? ";
    private String sqlQueryUpdatecont = "UPDATE " + continent + " SET NAME = ? WHERE CON_ID = ?";
    private String sqlQueryUpdatecount = "UPDATE " + country + " SET NAME = ?, CON_ID = ?, LINK = ? WHERE COUNTRY_ID = ?";
    private String sqlQueryUpdatestate = " UPDATE " + state + " SET NAME = ?, COUNTRY_ID = ?, LINK = ? WHERE STATE_ID = ?";
    private String sqlQueryUpdatelocation = " UPDATE " + location + " SET LON = ?, LAT = ?, NAME = ?, TYPE = ?, T_STATION = ?, B_STATION = ?, FLIGHT = ?, STATE_ID = ?, LINK = ? WHERE L_CODE = ?";

    private String slqQuerygetonecountrydetail = "SELECT * FROM COUNTRY WHERE COUNTRY_ID = ?";
    private String slqQuerygetonestatedetail = "SELECT * FROM \"STATE\" where STATE_ID = ?";
    private String slqQuerygetonecontinentdetail = "SELECT * FROM continent where con_id = ?";
    private String slqQueryDeleteCon = "SELECT * FROM continent where con_id = ?";
    private String slqQueryDeleteCount = "SELECT * FROM continent where con_id = ?";
    private String slqQueryDeletestate = "SELECT * FROM continent where con_id = ?";

    private String slqQueryDeletelocation0 = "DELETE FROM ADJENCENT WHERE  ADJ_CODE = ? ";
    private String slqQueryDeletelocation1 = "DELETE FROM ADJENCENT WHERE L_CODE = ?  ";
    private String slqQueryDeletelocation2 = "DELETE FROM LOCATION WHERE L_CODE =  ? ";
    private String slqQueryDeleteState0 = "DELETE FROM ADJENCENT WHERE ADJ_CODE IN  ( SELECT L.L_CODE FROM \"STATE\" S , LOCATION L WHERE L.STATE_ID =S.STATE_ID AND S.STATE_ID=? )";
    private String slqQueryDeleteState1 = "DELETE FROM ADJENCENT WHERE L_CODE IN  ( SELECT L.L_CODE FROM \"STATE\" S , LOCATION L WHERE L.STATE_ID =S.STATE_ID AND S.STATE_ID=? )";
    private String slqQueryDeleteState2 = "DELETE FROM LOCATION WHERE L_CODE IN  ( SELECT L.L_CODE FROM \"STATE\" S , LOCATION L WHERE L.STATE_ID =S.STATE_ID AND S.STATE_ID=? ) ";
    private String slqQueryDeleteState3 = "DELETE FROM STATE WHERE STATE_ID = ? ";
    private String slqQueryDeleteCountry1 = "DELETE FROM ADJENCENT WHERE L_CODE IN  ( SELECT L.L_CODE FROM \"STATE\" S , LOCATION L , COUNTRY C WHERE L.STATE_ID =S.STATE_ID AND C.COUNTRY_ID=S.COUNTRY_ID AND C.COUNTRY_ID=? ) ";
    private String slqQueryDeleteCountry2 = "DELETE FROM LOCATION WHERE L_CODE IN  ( SELECT L.L_CODE FROM \"STATE\" S , LOCATION L , COUNTRY C WHERE L.STATE_ID =S.STATE_ID AND C.COUNTRY_ID=S.COUNTRY_ID AND C.COUNTRY_ID=? ) ";
    private String slqQueryDeleteCountry3 = "DELETE FROM \"STATE\" WHERE STATE_ID IN  ( SELECT S.STATE_ID FROM \"STATE\" S  , COUNTRY C WHERE  C.COUNTRY_ID=S.COUNTRY_ID AND C.COUNTRY_ID=? ) ";
    private String slqQueryDeleteCountry4 = "DELETE FROM COUNTRY WHERE COUNTRY_ID = ?";
    private String slqQueryDeleteContinent1 = "DELETE FROM ADJENCENT WHERE L_CODE IN  ( SELECT L.L_CODE FROM \"STATE\" S , LOCATION L , COUNTRY C ,CONTINENT CT WHERE L.STATE_ID =S.STATE_ID AND C.COUNTRY_ID=S.COUNTRY_ID AND CT.CON_ID = C.CON_ID AND CT.CON_ID=? )";
    private String slqQueryDeleteContinent2 = "DELETE FROM LOCATION WHERE L_CODE IN  ( SELECT L.L_CODE FROM \"STATE\" S , LOCATION L , COUNTRY C , CONTINENT CT  WHERE L.STATE_ID =S.STATE_ID AND CT.CON_ID= C.CON_ID AND  C.COUNTRY_ID=S.COUNTRY_ID AND CT.CON_ID=? )";
    private String slqQueryDeleteContinent3 = "DELETE FROM \"STATE\" WHERE STATE_ID IN  ( SELECT S.STATE_ID FROM \"STATE\" S  , COUNTRY C , CONTINENT CT WHERE  CT.CON_ID = C.CON_ID AND C.COUNTRY_ID=S.COUNTRY_ID AND CT.CON_ID=? )";
    private String slqQueryDeleteContinent4 = "DELETE FROM COUNTRY WHERE COUNTRY_ID IN ( SELECT C.COUNTRY_ID FROM COUNTRY C , CONTINENT CT WHERE CT.CON_ID=C.CON_ID AND CT.CON_ID = ? )";
    private String slqQueryDeleteContinent5 = "DELETE FROM CONTINENT WHERE CON_ID = ?";

//    private String sqlsltsomeType = "SELECT * from " + tableName + " where type =  ? ";
//    private String sqlsltsomeparent = "SELECT * from " + tableName + " where parent_code =  ? ";
//    private String sqlsltonename = "SELECT L_code from " + tableName + " where name =  ? ";
//    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
    private ResultSet rs;

    public categoriesDA() {
        getConnection();
    }

    public void getConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public Location getCurrentRecord(int i) {
        Location location = null;
        try {
            if (i == 1) {
                location = new Location(Integer.parseInt(rs.getString(1)), rs.getString(2));
            } else if (i == 2) {
                location = new Location(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(4));
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return location;
    }

    public List<Location> getAllcont() {

        List<Location> location = new List<Location>();
        try {
            stmt = conn.prepareStatement(sqlQueryStrcont);
            rs = stmt.executeQuery();
            while (rs.next()) {
                location.add(getCurrentRecord(1));
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }

        return location;
    }

    public List<Location> getAllcountry() {

        List<Location> location = new List<Location>();
        try {
            stmt = conn.prepareStatement(sqlQueryStrCountry);
            rs = stmt.executeQuery();
            while (rs.next()) {
                location.add(getCurrentRecord(2));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return location;
    }

    public List<Location> getSomecountry(String id) {

        List<Location> location = new List<Location>();
        try {
            stmt = conn.prepareStatement(sqlQuerysomeCountry);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                location.add(getCurrentRecord(2));
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }

        return location;
    }

    public List<Location> getAllstate() {

        List<Location> location = new List<Location>();
        try {
            stmt = conn.prepareStatement(sqlQueryStrState);
            rs = stmt.executeQuery();
            while (rs.next()) {
                location.add(getCurrentRecord(2));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return location;
    }

    public List<Location> getSomestate(String id) {

        List<Location> location = new List<Location>();
        try {
            stmt = conn.prepareStatement(sqlQuerysomeState);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                location.add(getCurrentRecord(2));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return location;
    }

    public boolean checkSameCountry(String start, String end) {

        try {
            stmt = conn.prepareStatement(sqlQuerygetstateID);
            stmt.setString(1, start);
            rs = stmt.executeQuery();
            rs.next();
            start = rs.getString(1);

            stmt = conn.prepareStatement(sqlQuerygetcountryID);
            stmt.setString(1, start);
            rs = stmt.executeQuery();
            rs.next();
            start = rs.getString(1);

            stmt = conn.prepareStatement(sqlQuerygetstateID);
            stmt.setString(1, end);
            rs = stmt.executeQuery();
            rs.next();
            end = rs.getString(1);

            stmt = conn.prepareStatement(sqlQuerygetcountryID);
            stmt.setString(1, end);
            rs = stmt.executeQuery();
            rs.next();
            end = rs.getString(1);
            return start.equals(end);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    public void AddContinent(String name) {
        try {
            stmt = conn.prepareStatement(sqlQueryAddcont);
            stmt.setString(1, name);
            stmt.execute();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void AddCountry(String name, String ID, String link) {
        try {
            stmt = conn.prepareStatement(sqlQuerySelectcont);
            stmt.setString(1, ID);
            rs = stmt.executeQuery();
            rs.next();
            ID = rs.getString(1);

            stmt = conn.prepareStatement(sqlQueryAddcount);
            stmt.setString(1, name);
            stmt.setString(2, ID);
            stmt.setString(3, link);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void AddState(String name, String ID, String link) {
        try {
            stmt = conn.prepareStatement(sqlQuerySelectcount);
            stmt.setString(1, ID);
            rs = stmt.executeQuery();
            rs.next();
            ID = rs.getString(1);

            stmt = conn.prepareStatement(sqlQueryAddstate);
            stmt.setString(1, name);
            stmt.setString(2, ID);
            stmt.setString(3, link);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

    public void AddLocation(String lon, String lat, String name, String type, String train, String bus, String airport, String ID, String link) {
        try {
            stmt = conn.prepareStatement(sqlQuerySelectstate);
            stmt.setString(1, ID);
            rs = stmt.executeQuery();
            rs.next();
            ID = rs.getString(1);

            stmt = conn.prepareStatement(sqlQueryAddlocation);
            stmt.setString(1, lon);
            stmt.setString(2, lat);
            stmt.setString(3, name);
            stmt.setString(4, type);
            stmt.setString(5, train);
            stmt.setString(6, bus);
            stmt.setString(7, airport);
            stmt.setString(8, ID);
            stmt.setString(9, link);

            System.out.print(train);
            System.out.print(bus);
            System.out.print(airport);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

    public void ModifyCon(String name, String ID) {
        try {
            stmt = conn.prepareStatement(sqlQueryUpdatecont);
            stmt.setString(1, name);
            stmt.setInt(2, Integer.parseInt(ID));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void ModifyCount(String name, String ID, String link, String cid) {
        try {
            stmt = conn.prepareStatement(sqlQuerySelectcont);
            stmt.setString(1, ID);
            rs = stmt.executeQuery();
            rs.next();
            ID = rs.getString(1);

            stmt = conn.prepareStatement(sqlQueryUpdatecount);
            stmt.setString(1, name);
            stmt.setString(2, ID);
            stmt.setString(3, link);
            stmt.setInt(4, Integer.parseInt(cid));
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void ModifyState(String name, String ID, String link, String ctid) {
        try {
            stmt = conn.prepareStatement(sqlQuerySelectcount);
            stmt.setString(1, ID);
            rs = stmt.executeQuery();
            rs.next();
            ID = rs.getString(1);

            stmt = conn.prepareStatement(sqlQueryUpdatestate);
            stmt.setString(1, name);
            stmt.setString(2, ID);
            stmt.setString(3, link);
            stmt.setInt(4, Integer.parseInt(ctid));
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void ModifyLocation(String lon, String lat, String name, String type, String train, String bus, String airport, String ID, String link, String sid) {
        try {
            stmt = conn.prepareStatement(sqlQuerySelectstate);
            stmt.setString(1, ID);
            rs = stmt.executeQuery();
            rs.next();
            ID = rs.getString(1);

            stmt = conn.prepareStatement(sqlQueryUpdatelocation);
            stmt.setString(1, lon);
            stmt.setString(2, lat);
            stmt.setString(3, name);
            stmt.setString(4, type);
            stmt.setString(5, train);
            stmt.setString(6, bus);
            stmt.setString(7, airport);
            stmt.setString(8, ID);
            stmt.setString(9, link);
            System.out.println(sid);
            stmt.setInt(10, Integer.parseInt(sid));
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void DeleteLocation(String id) {
        try {
            stmt = conn.prepareStatement(slqQueryDeletelocation0);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeletelocation1);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeletelocation2);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void DeleteCountry(String id) {
        try {
            stmt = conn.prepareStatement(slqQueryDeleteCountry1);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteCountry2);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteCountry3);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteCountry4);
            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void DeleteState(String id) {
        try {
            stmt = conn.prepareStatement(slqQueryDeleteState0);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteState1);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteState2);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteState3);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void DeleteContinent(String id) {
        try {
            stmt = conn.prepareStatement(slqQueryDeleteContinent1);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteContinent2);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteContinent3);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteContinent4);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(slqQueryDeleteContinent5);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public Location get_one_Country_detail(String id) {
        Location loc = new Location();
        try {

            stmt = conn.prepareStatement(slqQuerygetonecountrydetail);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            rs.next();
            loc = getCurrentRecord(2);

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return loc;
    }

    public Location get_one_State_detail(String id) {
        Location loc = new Location();
        try {

            stmt = conn.prepareStatement(slqQuerygetonestatedetail);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            rs.next();
            loc = getCurrentRecord(2);

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return loc;
    }

    public Location get_one_Continent_detail(String id) {
        Location loc = new Location();
        try {

            stmt = conn.prepareStatement(slqQuerygetonecontinentdetail);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            rs.next();
            loc = getCurrentRecord(1);

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return loc;
    }

}

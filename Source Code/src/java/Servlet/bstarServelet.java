/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import domain.BStar;
import DA.adjencyDA;
import DA.LocationDA;
import DA.transportationDA;
import domain.List;
import domain.Location;
import domain.transport;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tanyj
 */
@WebServlet(name = "bstarServelet", urlPatterns = {"/bstarServelet"})
public class bstarServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int startLoc;
    private int endLoc;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
           
            
            out.println("<title>Servlet fuck</title>");   
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bstarServelet at " + request.getContextPath() + "</h1>");
             adjencyDA adDA = new adjencyDA();
            LocationDA locaDA = new LocationDA();
            startLoc =  locaDA.get_one_loc(request.getParameter("startlocation")).getCode_num()-5000;
            endLoc = locaDA.get_one_loc(request.getParameter("endlocation")).getCode_num()-5000;
           out.print("HIIII");
          /*   List<Location> locapath = new List<Location>();
             locationDA locDA= new locationDA();
             adjencyDA adDA = new adjencyDA();
             Location startlocation = new Location();      
             startlocation = locDA.getSpecificRecord(startLoc);
             Location endLocation = locDA.getSpecificRecord(endLoc);
             List<Location> finalpath= new  List<Location>();
                
                for(int i =0;i<(adDA.getAllRelatedAdjency(startlocation.getCode_num()).size());i++)
             {
                 
               
                 locapath.add(adDA.getAllRelatedAdjency(startlocation.getCode_num()).getValueOf(i+1));
                 //out.println(adDA.getAllRelatedAdjency(startlocation.getCode_num()).getValueOf(i+1).getAdjency());
                out.println(locapath.getValueOf(i+1).getAdjency());
                startlocation.setCode_num(locapath.getValueOf(i+1).getAdjency());
                 
             }
                
                
             
               
             
             
              /* }
          
             
            if(locapath.size()== 0)
            out.println("NULL");
            else {
            out.println(" NOT NULL");
            
         
            }
                       
              */
         
               BStar bstar = new BStar(adDA.getNumofRecords());
              
              
              //out.print(adDA.getAllRelatedAdjency().getValueOf(1).getCode_num()-5000);
           //out.print(startLoc);
           
           //out.print(b.listOfPath.getValueOf(1).getValueOf(2).getName());
           
           /*if(locaDA.checkSameCountry(locaDA.getSpecificRecord(startLoc).getName(), locaDA.getSpecificRecord(endLoc).getName())){
           out.print("Same Country");
           }else
           {
               out.print("Different Country");
               out.print(locaDA.get_nearest_airport(locaDA.getSpecificRecord(startLoc).getName()));
           }
           */
           //real code
           
           //ListofListLocation =bstar.printAllPaths(startLoc, endLoc);
            
             List<List<Location>> ListofListLocation = new List<List<Location>>();
           
              ListofListLocation =bstar.printAllPaths(startLoc, endLoc);
           
           
           transportation transport = new transportation();
        
           
              for(int i = 0;i <ListofListLocation.size();i++)
           {
               out.print("[");
               for(int j =0;j<ListofListLocation.getValueOf(i+1).size();j++)
               out.print(ListofListLocation.getValueOf(i+1).getValueOf(j+1).getName()+",");
               out.print("]\n");
           }
           //transport.
           /*for(int i =0; i < transport.transportMode.size();i++)
           out.print(transport.transportMode.getValueOf(i+1).getName());*/
           out.println("</body>");
           out.println("</html>");
        
     
 
    
        }
    }

    public class transportation {
    public List<transport> transportList= new List<transport>();
    public List<transport> transportMode= new List<transport>();
    //private int totalcost();
    public transportation() {
        transportationDA transDA = new transportationDA();
       transportList = transDA.getAllTransportData();
    }
    
    
    public List<transport> trannsportmode(List<Location> loca){
     for(int i =0;i<loca.size()-1;i++){
         if(loca.getValueOf(i+1).isB_station() && loca.getValueOf(i+2).isB_station())
           transportMode.add(transportList.getValueOf(1));
         else if(loca.getValueOf(i+1).isT_station()&& loca.getValueOf(i+2).isT_station())
             transportMode.add(transportList.getValueOf(2));
         else if(loca.getValueOf(i+1).isFlight()&& loca.getValueOf(i+2).isFlight())
             transportMode.add(transportList.getValueOf(4));
         else
              transportMode.add(transportList.getValueOf(3));
             
    }
    return transportMode;
  
} 



    }}
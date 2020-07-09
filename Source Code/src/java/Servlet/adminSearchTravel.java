/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DA.adjencyDA;
import DA.LocationDA;
import domain.BStar;
import domain.List;
import domain.Location;
import domain.transport;
import domain.transportation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author tanyj
 */
@WebServlet(name = "adminSearchTravel", urlPatterns = {"/adminSearchTravel"})
public class adminSearchTravel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
         
            adjencyDA adDA = new adjencyDA();
            BStar bstar = new BStar(34);
            List<List<Location>> listOfLoca = new List<List<Location>>();
            List<Location> cheapestLoca = new List<Location>();
            List<List<transport>> cheapestTransport = new  List<List<transport>>();
            LocationDA locaDA = new LocationDA();
            HttpSession session=request.getSession();
            transportation transportMode = new transportation();
            List<List<transport>> transportList= new List<List<transport>>();
            //request.getParameter("searchOption");
          int cheapest=1;
            if(request.getParameter("searchOption").equals("Cheapest")==true){
                    
                    listOfLoca=bstar.printAllPaths(locaDA.get_one_loc(request.getParameter("startlocation")).getCode_num()-5000, locaDA.get_one_loc(request.getParameter("endlocation")).getCode_num()-5000);
                    cheapestLoca=listOfLoca.getValueOf(1);
                    
                    for(int i =0;i<listOfLoca.size();i++){
                        transportList.add(transportMode.trannsportmode(listOfLoca.getValueOf(i+1)));
                        
                    }  
                    cheapestTransport.add(transportList.getValueOf(1));
                     
                    for(int i =0 ; i <transportList.size();i++){
                      if(cheapestTransport.getValueOf(1).getValueOf(1).getTotalCost()>transportList.getValueOf(i+1).getValueOf(1).getTotalCost())
                      {
                         
                          cheapest = i+1;
                          cheapestTransport.remove(cheapestTransport.getValueOf(1));
                          cheapestTransport.add(transportList.getValueOf(i+1));
                      }
                    }
                    session.setAttribute("cheapestTransportList", cheapestTransport.getValueOf(1));
                    session.setAttribute("cheapestPathList", listOfLoca.getValueOf(cheapest));
                  
                  
                     response.sendRedirect("userPathOutput.jsp");
                    
                    
            }
            
            else{
                session.setAttribute("source", request.getParameter("startlocation"));
                session.setAttribute("destination", request.getParameter("endlocation"));
           
                      response.sendRedirect("userPathOutput.jsp");

            }
            
            /*
            locationDA locaDA = new locationDA();
            String start =request.getParameter("start");
            out.print("HIHI");
            
            */
           
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

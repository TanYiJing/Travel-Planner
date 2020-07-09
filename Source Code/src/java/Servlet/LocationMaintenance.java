/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DA.categoriesDA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bosco
 */
public class LocationMaintenance extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        categoriesDA cda = new categoriesDA();
        
        String train;
        String bus;
        String airport;
            
        if(request.getParameter("addcon")!=null){
        String name = request.getParameter("Name");
        cda.AddContinent(name);
        }
        else if(request.getParameter("addcount")!=null){
           String name = request.getParameter("Name");
            String id = request.getParameter("ID");
             String link = request.getParameter("Link");
           cda.AddCountry(name,id,link);
        }
        else if(request.getParameter("addstate")!=null){
           String name = request.getParameter("Name");
            String id = request.getParameter("ID");
             String link = request.getParameter("Link");
           cda.AddState(name,id,link);
        }
        else if(request.getParameter("addlocation")!=null){
            String lon = request.getParameter("Longitude");
            String lat = request.getParameter("Latitude");
            String name = request.getParameter("Name");
            String type = request.getParameter("Type");
           
           if(request.getParameter("Train")!=null)  
                   train = "true";   
           else
                   train = "false";
           
           if(request.getParameter("Bus")!=null)
                   bus = "true";  
           else
                   bus = "false";
           
           if(request.getParameter("Airport")!=null)
                   airport = "true";   
           else
                   airport = "false";
            
           String id = request.getParameter("ID");
           String link = request.getParameter("Link");
           cda.AddLocation(lon,lat,name,type,train,bus,airport,id,link);
        }
        response.sendRedirect("LocationMaintenance.jsp");
       
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
    
    


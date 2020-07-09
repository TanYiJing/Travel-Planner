package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ModifyServlet extends HttpServlet {

    
    

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
        
        String train;
        String bus;
        String airport;
        
        categoriesDA cda = new categoriesDA();

        if(request.getParameter("modifycon")!= null){
                String name = request.getParameter("Name");
                String cid = request.getParameter("CONID");
                cda.ModifyCon(name, cid);
            }
        else if(request.getParameter("modifycount")!=null){
            String name = request.getParameter("Name");
             String ID = request.getParameter("ID");
            String link = request.getParameter("Link");
            String cid = request.getParameter("COUNTID");
            cda.ModifyCount(name, ID, link, cid);
        }
        else if(request.getParameter("modifystate")!=null){
            String name = request.getParameter("Name");
             String ID = request.getParameter("ID");
            String link = request.getParameter("Link");
            String ctid = request.getParameter("COUNTID");
            cda.ModifyState(name, ID, link, ctid);
        }
        else if(request.getParameter("modifylocation")!=null){
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
           String sid = request.getParameter("STATEID");
           cda.ModifyLocation(lon,lat,name,type,train,bus,airport,id,link,sid);
        }
        
        
        
       
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

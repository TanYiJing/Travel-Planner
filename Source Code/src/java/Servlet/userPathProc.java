/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DA.transportationDA;
import domain.List;
import domain.Location;
import domain.linkedlist;
import domain.transport;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class userPathProc extends HttpServlet {

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
            List<String> travelmode= new  List<String>();
            HttpSession s = request.getSession();
            linkedlist<Location> result = (linkedlist<Location>)s.getAttribute("aStar_Path");
   
            //System.out.println(s.getAttribute("aStar_Path"));
            transportationDA tda = new transportationDA();
            List<transport> t = new List<>();
            t =  tda.getAllTransportData();
            double cost = 0.0;
            double time = 0.0;
           
            if(result!=null){
            for(int i = 0 ; i< result.getNumberOfEntries()-1;i++){
                if(result.getEntry(i+1).isFlight()&& result.getEntry(i+2).isFlight()){
                cost+= result.getEntry(i+1).distance(result.getEntry(i+2))* t.getValueOf(4).getCost();
                time +=  result.getEntry(i+1).distance(result.getEntry(i+2))/t.getValueOf(4).getSpeed();
                travelmode.add("flight");
                    System.out.println("1");
                }else{
                travelmode.add("car");
                 cost+= result.getEntry(i+1).distance(result.getEntry(i+2))* t.getValueOf(3).getCost();
                time +=  result.getEntry(i+1).distance(result.getEntry(i+2))/t.getValueOf(3).getSpeed();              
                }
            }
            s.setAttribute("cost", cost);
            s.setAttribute("time", time);
            s.setAttribute("travelmode", travelmode);
            System.out.println(travelmode);
            response.sendRedirect("userPathOutput.jsp");

        } else {
            response.sendRedirect("userPathOutput.jsp");

            }
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

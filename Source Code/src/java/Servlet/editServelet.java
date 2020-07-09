/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DA.adjencyDA;
import DA.LocationDA;
import DA.categoriesDA;
import domain.List;
import domain.Location;
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
@WebServlet(name = "editServelet", urlPatterns = {"/editServelet"})
public class editServelet extends HttpServlet {

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
            LocationDA locaDA = new LocationDA();
            categoriesDA cda = new categoriesDA();
             HttpSession session=request.getSession();
            String source = request.getParameter("sourceCode");
            String dest = request.getParameter("locaCode");
          
         if(request.getParameter("button")!=null)
         {
             if(source.equals(dest)==false)
             {
                 if(cda.checkSameCountry(locaDA.getSpecificRecord(Integer.valueOf(source) ).getName(), locaDA.getSpecificRecord(Integer.parseInt(dest)).getName())==true)
                 {
                    if(!adDA.checkExisting(source, dest))
                    {
                        if(adDA.addNewAdjency(source, dest)==true){
                        session.setAttribute("sucess", "Sucessfully Added New Travel Leg To " + locaDA.getSpecificRecord(Integer.valueOf(source)).getName() );
                       response.sendRedirect("EditTravelLeg.jsp");
                        }
                    }
                    else{
                        session.setAttribute("error", "Linking Already Exist In System");
                     response.sendRedirect("EditTravelLeg.jsp");
                    }
                 }
                 else
                 {
                     session.setAttribute("error", "Different Country Cannot Be Linked");
                     response.sendRedirect("EditTravelLeg.jsp");
                 }
                 
                 
             }
             else{
                  session.setAttribute("error", "Cannot Link Yourself");
                  response.sendRedirect("EditTravelLeg.jsp");
             }
         
         } else{
            if(adDA.deleteAdjency(request.getParameter("delSource"), String.valueOf(locaDA.get_one_loc(request.getParameter("delDest")).getCode_num())))
            {
                session.setAttribute("sucess","Sucessfully Delink "+request.getParameter("delDest")+" From "+locaDA.getSpecificRecord(Integer.parseInt(request.getParameter("delSource"))).getName());
            }
            response.sendRedirect("EditTravelLeg.jsp");
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


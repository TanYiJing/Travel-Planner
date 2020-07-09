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

/**
 *
 * @author tanyj
 */
@WebServlet(name = "backendServelet", urlPatterns = {"/backendServelet"})
public class backendServelet extends HttpServlet {

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
            out.println("<title>Servlet backendServelet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet backendServelet at " + request.getContextPath() + "</h1>");
            LocationDA locaDA = new LocationDA();
            adjencyDA adDA = new adjencyDA();
            startLoc =  locaDA.get_one_loc(request.getParameter("startlocation")).getCode_num()-5000;
            endLoc = locaDA.get_one_loc(request.getParameter("endlocation")).getCode_num()-5000;
            BStar bstar = new BStar(adDA.getNumofRecords());
            List<List<Location>> ListofListLocation = new List<List<Location>>();
            ListofListLocation =bstar.printAllPaths(startLoc, endLoc);
           
                for(int i = 0;i <ListofListLocation.size();i++)
                {
                    out.print("[");
                    for(int j =0;j<ListofListLocation.getValueOf(i+1).size();j++)
                    
                        out.print(ListofListLocation.getValueOf(i+1).getValueOf(j+1).getName()+" , ");
                        
                    
                            out.print("]\n");
                }
           
            transportation transport = new transportation();
            List<List<transport>> transportMode = new List<List<transport>>();
            for(int i =0;i<ListofListLocation.size();i++)
            {
                
                transportMode.add(transport.trannsportmode(ListofListLocation.getValueOf(i+1)));
                out.print("[");
                for(int j =0;j<transportMode.getValueOf(i+1).size();j++)
                {
                    out.print(transportMode.getValueOf(i+1).getValueOf(j+1).getName());
                    out.print(",");
                }
                out.print("]");
            }
            
           out.print("RM"+transportMode.getValueOf(1).getValueOf(1).getTotalCost());
        
            out.print("RM"+transportMode.getValueOf(2).getValueOf(1).getTotalCost()); 
            out.print(transportMode.getValueOf(1).getValueOf(1).getHours()+"Hours");
            out.print(transportMode.getValueOf(1).getValueOf(1).getMinutes()+"Minutes");
             out.print(transportMode.getValueOf(2).getValueOf(1).getHours()+"Hours");
            out.print(transportMode.getValueOf(2).getValueOf(1).getMinutes()+"Minutes");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    

    //private int totalcost();
   

    
    

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



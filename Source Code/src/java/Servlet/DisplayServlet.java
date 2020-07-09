/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DA.LocationDA;
import DA.categoriesDA;
import domain.List;
import domain.Location;
//import domain.linkedlist;
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
public class DisplayServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        String submit = request.getParameter("submit");
        String src = request.getParameter("country_id");
        String reload = request.getParameter("reload");
        String display = request.getParameter("display");
        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        String locationtype = request.getParameter("locationtpye");
        LocationDA lda = new LocationDA();
        categoriesDA cda = new categoriesDA();
        List<Location> loc = new List<Location>();

        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            if (reload != null) {
                loc = cda.getAllcont();
                for_printing_sub_place(loc, out);

                //System.out.println(6);
            } else if (src != null) {
                if (src.charAt(0) == '1') { // next btn funtion
                    loc = cda.getSomecountry(src);
                    for_printing_sub_place(loc, out);

                } else if (src.charAt(0) == '2') {

                    loc = cda.getSomestate(src);
                    for_printing_sub_place(loc, out);

                } else if (src.charAt(0) == '3') {
                    System.out.println(src);
                    loc = lda.getsomeLocation(3, src);

                    for (int i = 0; i < loc.size(); i++) {
                        out.println("<form action=\"staff_function.jsp\" action=\"post\" ><div class=\"col-md-3 col-sm-6\">\n"
                                + "            <div class=\"product-grid6\">\n"
                                + "                <div class=\"product-image6\">\n"
                                + "                         <a href=\"#\" >\n"
                                + "                            <img  class=\"pic-1\" src=\"" + loc.getValueOf(i + 1).getLink() + "\" >\n"
                                + "                        </a>\n"
                                + "                        \n"
                                + "                </div>\n"
                                + "                <div class=\"product-content\">\n"
                                + "                    <h3 class=\"title\"><a href=\"#\"> " + loc.getValueOf(i + 1).getName() + "</a></h3>\n"
                                + "                    \n"
                                + "                </div>\n"
                                + "                    \n"
                                + "                <ul class=\"social\">\n"
                                + "                    <li><button name=\"display\" class=\"Display btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getCode_num() + "\" > Display</button></li>\n"
                                + "                    <li><button name=\"edit\" class=\"Edit btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getCode_num() + "\" > Edit</button></li>\n"
                                + "                    <li><button name=\"delete\" class=\"Delete btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getCode_num() + "\" > Delete</button></li>\n"
                                + "\n"
                                + "                </ul>\n"
                                + "            </div>\n"
                                + "        </div> </form>");
                    }

                }
            } else if (display != null) {
                if (display.charAt(0) == '1') { // display btn funtion
                    System.out.println(display);
                    loc = lda.getsomeLocation(4, display);
                    for_printing_sub_place(loc, out);

                } else if (display.charAt(0) == '2') { // display btn funtion
                    System.out.println(display);
                    loc = lda.getsomeLocation(5, display);
                    for_printing_sub_place(loc, out);

                } else if (display.charAt(0) == '3') { // display btn funtion
                    System.out.println(display);
                    loc = lda.getsomeLocation(6, display);
                    for_printing_sub_place(loc, out);

                } else if (display.charAt(0) == '5') { // display btn funtion
                    Location l = lda.get_one_loc(1, display);
                    s.setAttribute("display", l);
                    response.sendRedirect("staff_function.jsp");
                }
            } else if (edit != null) {
                Location l = null;
                if (edit.charAt(0) == '1') { // edit btn funtion
                     l = cda.get_one_Continent_detail(edit);
                } else if (edit.charAt(0) == '2') { // edit btn funtion
                     l = cda.get_one_Country_detail(edit);
                } else if (edit.charAt(0) == '3') { // edit btn funtion
                     l = cda.get_one_State_detail(edit);
                } else if (edit.charAt(0) == '5') { // edit btn funtion
                     l = lda.get_one_loc(1, edit);
                }
                s.setAttribute("edit", l);
                response.sendRedirect("staff_function.jsp");

            }
            else if (delete != null) {
                Location l = null;
                if (delete.charAt(0) == '1') { // edit btn funtion
                     l = cda.get_one_Continent_detail(delete);
                } else if (delete.charAt(0) == '2') { // edit btn funtion
                     l = cda.get_one_Country_detail(delete);
                } else if (delete.charAt(0) == '3') { // edit btn funtion
                     l = cda.get_one_State_detail(delete);
                } else if (delete.charAt(0) == '5') { // edit btn funtion
                     l = lda.get_one_loc(1, delete);
                }
                s.setAttribute("delete", l);
                response.sendRedirect("staff_function.jsp");

            }
            else if (locationtype != null){
            
            loc = lda.getsomeLocation(1, locationtype);
                for_printing_sub_place(loc, out);
            }
            
        }

    }

    public void for_printing_sub_place(List<Location> loc, PrintWriter out) {

        for (int i = 0; i < loc.size(); i++) {
            out.println("<div class=\"col-md-3 col-sm-6\">\n"
                    + "            <div class=\"product-grid6\">\n"
                    + "                <div class=\"product-image6\">\n"
                    + "                         <a href=\"#\" >\n"
                    + "                            <img  class=\"pic-1\" alt=\"\" src=\" " + loc.getValueOf(i + 1).getLink() + " \" >\n"
                    + "                        </a>\n"
                    + "                        \n"
                    + "                </div>\n"
                    + "                <div class=\"product-content\">\n"
                    + "                    <h3 class=\"title\"><a href=\"#\"> " + loc.getValueOf(i + 1).getName() + "</a></h3>\n"
                    + "                    \n"
                    + "                </div>\n"
                    + "                    \n"
                    + "                <ul class=\"social\">\n"
                    + "                    <li><button class=\"country_list btn btn-primary\" id=\"country_list\" value=\"" + loc.getValueOf(i + 1).getCode_num() + "\" > next</button></li>\n"
                    + "                   <li><button name=\"display\" class=\"Display btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getCode_num() + "\" > Display</button></li>\n"
                    + "                    <li><button name=\"edit\" class=\"Edit btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getCode_num() + "\" > Edit</button></li>\n"
                    + "                    <li><button name=\"delete\" class=\"Delete btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getCode_num() + "\" > Delete</button></li>\n"
                    + "                    \n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "        </div>");

        }

        out.println("<script type=\"text/javascript\" class=\"remove\">\n"
                + " \n"
                + "      \n"
                + "    $(\".country_list\").click(function (e) {\n"
                + "      var x = $(this).val();\n"
                + "     e.preventDefault();\n"
                + "     $.ajax({\n"
                + "     url: \"DisplayServlet\",\n"
                + "    // type: \"post\",\n"
                + "     data: {country_id: x},\n"
                + "     cache: false,\n"
                + "     success: function(data) {\n"
                + "     $(\".row\").html(data).slideDown('slow');\n"
                + "     }\n"
                + "     });\n"
                + "      $(\".remove\").remove();\n"
                + "});\n"
                + "\n"
                + "$(\".Display\").click(function (e) {\n"
                + "      var x = $(this).val();\n"
                + "     e.preventDefault();\n"
                + "     $.ajax({\n"
                + "     url: \"DisplayServlet\",\n"
                + "    // type: \"post\",\n"
                + "     data: {display: x},\n"
                + "     cache: false,\n"
                + "     success: function(data) {\n"
                + "     $(\".row\").html(data).slideDown('slow');\n"
                + "     }\n"
                + "     });\n"
                + "      $(\".remove\").remove();\n"
                + "});\n"
                + "\n"
                + "$(\".Edit\").click(function (e) {\n"
                + "      var x = $(this).val();\n"
                + "     e.preventDefault();\n"
                + "     $.ajax({\n"
                + "     url: \"DisplayServlet\",\n"
                + "    // type: \"post\",\n"
                + "     data: {edit: x},\n"
                + "     cache: false,\n"
                + "     success: function(data) {\n"
                + "     $(\".row\").html(data).slideDown('slow');\n"
                + "     }\n"
                + "     });\n"
                + "      $(\".remove\").remove();\n"
                + "});\n"
                + "\n"
                + "$(\".Delete\").click(function (e) {\n"
                + "      var x = $(this).val();\n"
                + "     e.preventDefault();\n"
                + "     $.ajax({\n"
                + "     url: \"DisplayServlet\",\n"
                + "    // type: \"post\",\n"
                + "     data: {delete : x},\n"
                + "     cache: false,\n"
                + "     success: function(data) {\n"
                + "     $(\".row\").html(data).slideDown('slow');\n"
                + "     }\n"
                + "     });\n"
                + "      $(\".remove\").remove();\n"
                + "});\n"
                + "</script>");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

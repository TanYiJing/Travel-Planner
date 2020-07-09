/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DA.LocationDA;
import DA.adjencyDA;
import DA.categoriesDA;
import domain.BStar;
import domain.List;
import domain.Location;
import domain.linkedlist;
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
public class userLocProc extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        String submit = request.getParameter("submit");
        String time_Astar = request.getParameter("time");
        String cost_Bstart = request.getParameter("cost");

        String src = request.getParameter("country_id");
        String reload = request.getParameter("reload");

        LocationDA lda = new LocationDA();
        categoriesDA cda = new categoriesDA();
        List<Location> loc = new List<Location>();
        linkedlist<Location> all_link_loc = new linkedlist<Location>();
        linkedlist<Location> linkloc = new linkedlist<Location>();
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            if (submit != null) {

                String start = request.getParameter("start_in");
                String str[] = request.getParameterValues("mytext[]");
                String end = request.getParameter("end_in");
                if (/*!time_Astar.equals("")*/ request.getParameter("lastchance").equals("2") ) {
                    if (str != null) {
                        for (int i = 0; i < str.length + 1; i++) {
                            if (i == 0) {
                                linkloc.add(lda.get_one_loc(start));
                                if (!cda.checkSameCountry(start, str[i])) {
                                    linkloc.add(lda.get_nearest_airport(start));
                                    linkloc.add(lda.get_nearest_airport(str[i]));
                                }
                                linkloc.add(lda.get_one_loc(str[i]));

                            } else if (i == str.length) {
                                if (!(linkloc.getLastNode().getData().getName().equals(lda.get_one_loc(str[i - 1]).getName()))) {
                                    linkloc.add(lda.get_one_loc(str[i - 1]));
                                }
                                if (!cda.checkSameCountry(str[i - 1], end)) {
                                    linkloc.add(lda.get_nearest_airport(str[i - 1]));
                                    linkloc.add(lda.get_nearest_airport(end));
                                }
                                linkloc.add(lda.get_one_loc(end));
                            } else {
                                if (!(linkloc.getLastNode().getData().getName().equals(lda.get_one_loc(str[i - 1]).getName()))) {
                                    linkloc.add(lda.get_one_loc(str[i]));
                                }
                                if (!cda.checkSameCountry(str[i - 1], str[i])) {
                                    linkloc.add(lda.get_nearest_airport(str[i - 1]));
                                    linkloc.add(lda.get_nearest_airport(str[i]));
                                }
                                linkloc.add(lda.get_one_loc(str[i]));
                            }
                        }
                    } else {
                        linkloc.add(lda.get_one_loc(start));
                        if (!cda.checkSameCountry(start, end)) {
                            linkloc.add(lda.get_nearest_airport(start));
                            linkloc.add(lda.get_nearest_airport(end));
                        }
                        linkloc.add(lda.get_one_loc(end));
                    }

                    all_link_loc = lda.getAlllinkLocation();
                    System.out.println(linkloc.toString());
                    System.out.println("next");

                    for (int i = 0; i < linkloc.getNumberOfEntries(); i++) {
                        for (int j = 0; j < all_link_loc.getNumberOfEntries(); j++) {
                            if (linkloc.getEntry(1).getName().equals(all_link_loc.getEntry(j + 1).getName())) {
                                linkloc.add(all_link_loc.getEntry(j + 1));
                                linkloc.remove(1);
                                break;
                            }
                        }
                    }

                    System.out.println(linkloc.toString());
                    linkedlist<Location> result_loc = new linkedlist<Location>();

                    result_loc.add(linkloc.getEntry(1));
                    for (int i = 0; i < linkloc.getNumberOfEntries() - 1; i++) {
                        if (cda.checkSameCountry(linkloc.getEntry(i + 1).getName(), linkloc.getEntry(i + 2).getName())) {
                            System.out.println(cda.checkSameCountry(linkloc.getEntry(i + 1).getName(), linkloc.getEntry(i + 2).getName()));
                            Location.starsearch(linkloc.getEntry(i + 1), linkloc.getEntry(i + 2));
                            Location.adjust(linkloc.getEntry(i + 1), linkloc.getEntry(i + 2), result_loc);
                        } else {
                            System.out.println(cda.checkSameCountry(linkloc.getEntry(i + 1).getName(), linkloc.getEntry(i + 2).getName()));
                            result_loc.add(linkloc.getEntry(i + 2));
                        }

                    }
                    out.println(result_loc.toString());
                    System.out.println(result_loc.toString());
                    System.out.println("end");
                    HttpSession session = request.getSession();
                    if (!time_Astar.equals("")) {
                        session.setAttribute("astartime", Double.parseDouble(time_Astar));
                    } else {
                        session.setAttribute("astartime", 9999.99);
                    }

                    session.setAttribute("aStar_Path", result_loc);
                    response.sendRedirect("userPathProc");
                } else if (/*!cost_Bstart.equals("") */ request.getParameter("lastchance").equals("1")) {
                    List<List<List<Location>>> loc2D = new List<List<List<Location>>>();
                    loc = new List<Location>();
                    loc.add(lda.get_one_loc(start));
                    if (str != null) {
                        for (int i = 0; i < str.length; i++) {
                            loc.add(lda.get_one_loc(str[i]));
                        }
                    }
                    loc.add(lda.get_one_loc(end));
                    for (int i = 0; i < loc.size() - 1; i++) {
                        BStar b = new BStar(new adjencyDA().getNumofRecords());
                        b.printAllPaths(loc.getValueOf(i + 1).getCode_num() - 5000, loc.getValueOf(i + 2).getCode_num() - 5000);
                        loc2D.add(b.getListOfPath());
                    }

                    HttpSession session = request.getSession();
                    session.setAttribute("bStar_Path", loc2D);
                    if (!cost_Bstart.equals("")) {
                        session.setAttribute("cost", Double.parseDouble(cost_Bstart));
                    } else {
                        session.setAttribute("cost", 9999.99);
                    }

                    response.sendRedirect("userPathProc");

                }

            } else if (reload != null) {
                loc = cda.getAllcont();
                for_printing_sub_place(loc, out);

                //System.out.println(6);
            } else if (src.charAt(0) == '1') {
                loc = cda.getSomecountry(src);
                //loc = cda.getAllcont();
                for_printing_sub_place(loc, out);
                //   System.out.println(2);

            } else if (src.charAt(0) == '2') {

                loc = cda.getSomestate(src);
                for_printing_sub_place(loc, out);

            } else if (src.charAt(0) == '3') {
                System.out.println(src);
                loc = lda.getsomeLocation(3, src);

                for (int i = 0; i < loc.size(); i++) {
                    out.println("<div class=\"col-md-3 col-sm-6\">\n"
                            + "            <div class=\"product-grid6\">\n"
                            + "                <div class=\"product-image6\">\n"
                            + "                         <a  >\n"
                            + "                            <img  class=\"pic-1\" src=\"" + loc.getValueOf(i + 1).getLink() + "\" >\n"
                            + "                        </a>\n"
                            + "                        \n"
                            + "                </div>\n"
                            + "                <div class=\"product-content\">\n"
                            + "                    <h3 class=\"title\"><a > " + loc.getValueOf(i + 1).getName() + "</a></h3>\n"
                            + "                    \n"
                            + "                </div>\n"
                            + "                    \n"
                            + "                <ul class=\"social\">\n"
                            + "                    <li><button class=\"add_start btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getName() + "\" > Start</button></li>\n"
                            + "                    <li><button class=\"add_middle btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getName() + "\" > add</button></li>\n"
                            + "                    <li><button class=\"add_end btn btn-primary\" value=\"" + loc.getValueOf(i + 1).getName() + "\" > End</button></li>\n"
                            + "\n"
                            + "                </ul>\n"
                            + "            </div>\n"
                            + "        </div>");
                }

                out.println("<script class=\"loc_remove\">\n"
                        + "$(document).ready(function() {\n"
                        + "	var max_fields      = 10; //maximum input boxes allowed\n"
                        + "	var wrapper         = $(\".input_fields_wrap\"); //Fields wrapper\n"
                        + "	var add_button      = $(\".add_middle\"); //Add button ID\n"
                        + "	\n"
                        + "	var x = 0; //initlal text box count\n"
                        + "	$(add_button).click(function(e){ //on add input button click\n"
                        + "		e.preventDefault();\n"
                        + "                \n"
                        + "		if(x < max_fields){ //max input box allowed\n"
                        + "			x++; //text box increment\n"
                        + "                     if(x==1)\n"
                        + "                        $(wrapper).append('<label for=\"#\">Travel Leg</label>');   \n"
                        + "                $(wrapper).append('<div><input type=\"text\" name=\"mytext[]\" list=\"all_location\" value=\"'+ $(this).val() +'\" /><a href=\"#\" class=\"remove_field\">Remove</a></div>'); //add input box\n"
                        + "		}     \n"
                        + "	});\n"
                        + "	\n"
                        + "	$(wrapper).on(\"click\",\".remove_field\", function(e){ //user click on remove text\n"
                        + "		e.preventDefault(); $(this).parent('div').remove(); \n"
                        + "                x--;\n"
                        + "                if(x==0){\n"
                        + "                    $(wrapper).children('label').remove();               \n"
                        + "                }\n"
                        + "	});\n"
                        + "        \n"
                        + "        $(\".add_start\").click(function(){\n"
                        + "            var text = $(this).val();\n"
                        + "            $(\".start_in\").val(text) ;\n"
                        + "        })\n"
                        + "            \n"
                        + "       $(\".add_end\").click(function(){\n"
                        + "            var text = $(this).val();\n"
                        + "            $(\".end_in\").val(text) ;\n"
                        + "        }) \n"
                        + "     $(\".loc_remove\").remove();   \n"
                        + "});\n"
                        + "\n"
                        + "</script>");

            }

        }

    }

    public void for_printing_sub_place(List<Location> loc, PrintWriter out) {

        for (int i = 0; i < loc.size(); i++) {
            out.println("<div class=\"col-md-3 col-sm-6\">\n"
                    + "            <div class=\"product-grid6\">\n"
                    + "                <div class=\"product-image6\">\n"
                    + "                         <a  >\n"
                    + "                            <img  class=\"pic-1\" alt=\"\" src=\" " + loc.getValueOf(i + 1).getLink() + " \" >\n"
                    + "                        </a>\n"
                    + "                        \n"
                    + "                </div>\n"
                    + "                <div class=\"product-content\">\n"
                    + "                    <h3 class=\"title\"><a > " + loc.getValueOf(i + 1).getName() + "</a></h3>\n"
                    + "                    \n"
                    + "                </div>\n"
                    + "                    \n"
                    + "                <ul class=\"social\">\n"
                    + "                    <li><button class=\"country_list btn btn-primary\" id=\"country_list\" value=\"" + loc.getValueOf(i + 1).getCode_num() + "\" > next</button></li>\n"
                    + "                    \n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "        </div>");

        }

        out.println("<script class=\"remove\">$(document).ready(function() {\n"
                + "      \n"
                + "    $(\".country_list\").click(function (e) {\n"
                + "      var x = $(this).val();\n"
                + "      \n"
                + "     e.preventDefault();\n"
                + "     $.ajax({\n"
                + "     url: \"userLocProc\",\n"
                + "    // type: \"post\",\n"
                + "     data: {country_id: x},\n"
                + "     cache: false,\n"
                + "     success: function(data) {\n"
                + "     $(\".row_my\").html(data).slideDown('slow');\n"
                + "     }\n"
                + "     });\n"
                + "      \n"
                + "});\n"
                + "$(\".remove\").remove();\n"
                + "});\n"
                + "</script>\n"
                + "");

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

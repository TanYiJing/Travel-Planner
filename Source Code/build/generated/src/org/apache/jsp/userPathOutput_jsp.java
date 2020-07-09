package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DA.transportationDA;
import domain.transport;
import domain.transportation;
import domain.List;
import domain.ListInterface;
import domain.linkedlist;
import domain.linkedlistInterface;
import domain.Location;
import DA.LocationDA;
import DA.categoriesDA;

public final class userPathOutput_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <style>  \n");
      out.write("        * {\n");
      out.write("            -webkit-box-sizing: border-box;\n");
      out.write("            -moz-box-sizing: border-box;\n");
      out.write("            -ms-box-sizing: border-box;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .process-list {\n");
      out.write("            padding: 0;\n");
      out.write("            margin: 0;\n");
      out.write("            list-style-type: none;\n");
      out.write("            font-size: 0;\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .process-step {\n");
      out.write("            display: inline-block;\n");
      out.write("            vertical-align: top;\n");
      out.write("            width: 100px;\n");
      out.write("            min-height: 20px;\n");
      out.write("            padding: 0;\n");
      out.write("            margin: 0;\n");
      out.write("            text-align: center;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .step-wrapper {\n");
      out.write("            padding: 30px 5px 0 5px;\n");
      out.write("            display: block;\n");
      out.write("            position: relative;\n");
      out.write("            overflow: hidden;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .step-wrapper:before {\n");
      out.write("            content: \"\";\n");
      out.write("            position: absolute;\n");
      out.write("            top: 10px;\n");
      out.write("            left: 0;\n");
      out.write("            height: 5px;\n");
      out.write("            width: 100px;\n");
      out.write("            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAFAQMAAABGqu8rAAAAA1BMVEXgUSCWVqGnAAAACklEQVQI12NABQAADwABdYmHTwAAAABJRU5ErkJggg==);\n");
      out.write("            background-repeat: repeat-x;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .first .step-wrapper:before {\n");
      out.write("            left: 50px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .last .step-wrapper:before {\n");
      out.write("            left: auto;\n");
      out.write("            right: 50px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .step-wrapper:after {\n");
      out.write("            content: \"\";\n");
      out.write("            position: absolute;\n");
      out.write("            top: 2px;\n");
      out.write("            left: 0;\n");
      out.write("            right: 0;\n");
      out.write("            height: 20px;\n");
      out.write("            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAA8CAMAAABRqGpkAAAAJ1BMVEUAAADgUSDgUSDgUSDgUSDgUSDgUSDgUSDgUSD////42tDrjm/yt6IPf6ysAAAACHRSTlMAZu67Ed2qmaQXgZMAAACJSURBVHja7ZPbCsAwCEO1dpt2+//vHYR2N/M8GOw82ZBQa1FAVSvuxbTKgU7emXRoi19YBMx+Y0bWH6hILajWFtFWlKV24xZg61aDLzrwmiDdhtiQFwTiAEcq0ji9iLZEm2fPZAPho+NDTt/x8w3e3qPBuUfZalk0SWnsEYGKNE4voi2l5l/dox3ttBONuskuxgAAAABJRU5ErkJggg==);\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-position: top center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .active .step-wrapper:after {\n");
      out.write("            background-position: bottom center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        .shopping-cart-wrapper {\n");
      out.write("            margin-top: 15px;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        .totals .totals-item {\n");
      out.write("            float: right;\n");
      out.write("            clear: both;\n");
      out.write("            width: 100%;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        .totals .totals-item label {\n");
      out.write("            float: left;\n");
      out.write("            clear: both;\n");
      out.write("            width: 79%;\n");
      out.write("            text-align: right;\n");
      out.write("        }\n");
      out.write("        .totals-value {\n");
      out.write("            float: right;\n");
      out.write("            width: 21%;\n");
      out.write("            text-align: right;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        .checkout {\n");
      out.write("            float: right;\n");
      out.write("            border: 0;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            padding: 6px 25px;\n");
      out.write("            background-color: #6b6;\n");
      out.write("            color: #fff;\n");
      out.write("            font-size: 25px;\n");
      out.write("            border-radius: 3px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .checkout:hover {\n");
      out.write("            background-color: #494;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Abril+Fatface\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/open-iconic-bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/aos.css\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/ionicons.min.css\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/jquery.timepicker.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/flaticon.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/icomoon.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <body>\n");
      out.write("\n");
 if ((session.getAttribute("cheapestPathList") == null) && (session.getAttribute("source") == null) ){
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light scrolled awake\" id=\"ftco-navbar\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"Homepage.jsp\">Adventure</a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#ftco-nav\" aria-controls=\"ftco-nav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"oi oi-menu\"></span> Menu\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"ftco-nav\">\n");
      out.write("                    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                        <li class=\"nav-item active\"><a href=\"Homeoage.jsp\" class=\"nav-link\">Home</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a href=\"about.html\" class=\"nav-link\">About</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a href=\"blog.html\" class=\"nav-link\">Blog</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a href=\"contact.html\" class=\"nav-link\">Contact</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
 } else { 
      out.write("\n");
      out.write("       <a href = \"AdminSearchTravel.jsp\" class=\"btn btn-success\" > BACK </a>\n");
      out.write("\n");
}
      out.write("\n");
      out.write("        ");
 //linkedlist<Location> result = new linkedlist<Location>();
            linkedlist<Location> result = (linkedlist<Location>) session.getAttribute("aStar_Path");
            List<List<List<Location>>> many_path = (List<List<List<Location>>>) session.getAttribute("bStar_Path");
            Double astartime = (Double) session.getAttribute("astartime");
            Double time = (Double) session.getAttribute("time");
            Double cost = (Double) session.getAttribute("cost");
            List<String> travelmode = (List<String>) session.getAttribute("travelmode");
            transportation t = new transportation();
            boolean truepath = true;
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("   ");
 if (session.getAttribute("cheapestPathList") != null) { 
      out.write("\n");
      out.write("        <div class=\"form-group\" style=\"margin-top: 10%; text-align: center;\"><label >Cheapest Result</label></div>\n");
      out.write("   ");
 } else if (session.getAttribute("source") != null) {
      out.write("\n");
      out.write("           <div class=\"form-group\" style=\"margin-top: 10%; text-align: center;\"><label >Fastest Result</label></div>\n");
      out.write("   ");
 } else {
      out.write("\n");
      out.write("           <div class=\"form-group\" style=\"margin-top: 10%; text-align: center;\"><label > Result</label></div>\n");
      out.write("   ");
 } 
      out.write("\n");
      out.write("        ");
 if (result != null) { 
      out.write("\n");
      out.write("        ");
 if (astartime >= time) {
      out.write("\n");
      out.write("        <div class=\"process-wrapper\" style=\" text-align: center;\">\n");
      out.write("            <div class=\"travelmode\" style=\" text-align: center; display: inline-block; width: 100%\">\n");
      out.write("                ");
 for (int i = 0; i < travelmode.size(); i++) {
      out.write("\n");
      out.write("                ");
 if (travelmode.getValueOf(i + 1).equals("car")) {
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\" ><img alt=\"\" src=\"https://image.flaticon.com/icons/svg/635/635678.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    ");
} else {
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\" https://image.flaticon.com/icons/svg/635/635683.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\"https://www.ledr.com/colours/white.jpg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\"https://www.ledr.com/colours/white.jpg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <ul class=\"process-list\">\n");
      out.write("\n");
      out.write("                ");
 for (int i = 0; i < result.getNumberOfEntries(); i++) {
                        if (i == 0) { 
      out.write("\n");
      out.write("                <li class=\"process-step first\"> \n");
      out.write("                    ");
 } else if (i == result.getNumberOfEntries() - 1) {
      out.write(" \n");
      out.write("                <li class=\"process-step last\"> \n");
      out.write("                    ");
 } else {
      out.write("\n");
      out.write("                <li class=\"process-step \"> ");
 }
      out.write("  \n");
      out.write("\n");
      out.write("                    <div class=\"step-wrapper\">\n");
      out.write("                        <!-- <img  alt=\"\" src=\"https://cdn4.iconfinder.com/data/icons/urban-transport-3/50/48-512.png\" > -->\n");
      out.write("                        <a href=\"#\">");
      out.print( result.getEntry(i + 1).getName());
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                <li style=\"display: inline-block;\">\n");
      out.write("                    <ul class=\"process-list\">\n");
      out.write("                        <li class=\"process-step\"><i class=\"far fa-clock\"> Duration: ");
      out.print( String.format("%d", time.intValue()));
      out.write('h');
      out.print( String.format("%1.0f", (time - time.intValue()) * 60));
      out.write("m </i><br><i class=\"fas fa-dollar-sign\"> Cost : RM");
      out.print( String.format("%.2f", cost));
      out.write("</i></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li style=\"display: inline-block;\">\n");
      out.write("                    <ul class=\"process-list\">\n");
      out.write("                        <li class=\"process-step\">   <input type=\"radio\" class=\"price\" checked value=\"");
      out.print(cost);
      out.write("\" ></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
} else {
      out.write("         <div style=\"text-align: center;\" > Path Not Found</div> ");
 } 
      out.write("\n");
      out.write("        ");
 } else if (many_path != null) { 
      out.write("\n");
      out.write("\n");
      out.write("        ");
for (int i = 0; i < many_path.size(); i++) {
                for (int j = 0; j < many_path.getValueOf(i + 1).size(); j++) {
                    if (t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getTotalCost() * many_path.size() > cost) {
                        truepath = false;
                    }

                }
            }
        
      out.write("\n");
      out.write("        ");
 if (truepath) {
      out.write("\n");
      out.write("        ");
for (int i = 0; i < many_path.size(); i++) {
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <div style=\"text-align:  center;\"> Path ");
      out.print(i + 1);
      out.write(" : ");
      out.print( many_path.getValueOf(i + 1).getValueOf(1).getValueOf(1).getName());
      out.write(" <i class=\"far fa-arrow-alt-circle-right\"></i> ");
      out.print( many_path.getValueOf(i + 1).getValueOf(1).getValueOf(many_path.getValueOf(i + 1).getValueOf(1).size()).getName());
      out.write(" </div>\n");
      out.write("            ");
 for (int j = 0; j < many_path.getValueOf(i + 1).size(); j++) {
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"process-wrapper\" style=\" text-align: center;\">\n");
      out.write("                <div class=\"travelmode\" style=\" text-align: center; display: inline-block; width: 100%\">\n");
      out.write("                    ");
 List<transport> transportmode = t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1));
                        for (int k = 0; k < transportmode.size(); k++) {
      out.write("\n");
      out.write("                    ");
 if (transportmode.getValueOf(k + 1).getName().equals("Car")) {
      out.write("\n");
      out.write("                    <cincai style=\"margin: 0px  30px;\" ><img alt=\"\" src=\"https://image.flaticon.com/icons/svg/635/635678.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                        ");
} else if (transportmode.getValueOf(k + 1).getName().equals("Airplane")) {
      out.write("\n");
      out.write("                    <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\" https://image.flaticon.com/icons/svg/635/635683.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                        ");
} else if (transportmode.getValueOf(k + 1).getName().equals("Bus")) {
      out.write("\n");
      out.write("                    <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\" https://image.flaticon.com/icons/svg/130/130262.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                        ");
} else if (transportmode.getValueOf(k + 1).getName().equals("Train")) {
      out.write("\n");
      out.write("                    <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\" https://image.flaticon.com/icons/svg/1532/1532079.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                        ");
 } 
      out.write("             \n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\"https://www.ledr.com/colours/white.jpg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\"https://www.ledr.com/colours/white.jpg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <ul class=\"process-list\">\n");
      out.write("                    ");
 for (int n = 0; n < many_path.getValueOf(i + 1).getValueOf(j + 1).size(); n++) {
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        if (n == 0) { 
      out.write("\n");
      out.write("                    <li class=\"process-step first\"> \n");
      out.write("                        ");
 } else if (n == many_path.getValueOf(i + 1).getValueOf(j + 1).size() - 1) {
      out.write(" \n");
      out.write("                    <li class=\"process-step last\"> \n");
      out.write("                        ");
 } else {
      out.write("\n");
      out.write("                    <li class=\"process-step \"> ");
 }
      out.write("  \n");
      out.write("\n");
      out.write("                        <div class=\"step-wrapper\">\n");
      out.write("                            <a href=\"#\">");
      out.print(  many_path.getValueOf(i + 1).getValueOf(j + 1).getValueOf(n + 1).getName());
      out.write("</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    <li style=\"display: inline-block;\">\n");
      out.write("                        <ul class=\"process-list\">\n");
      out.write("                            <li class=\"process-step\"><i class=\"far fa-clock\"> Duration: &nbsp; ");
      out.print( t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getHours());
      out.write(" h ");
      out.print( t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getMinutes());
      out.write("m </i><br><i class=\"fas fa-dollar-sign\"> Cost : RM ");
      out.print( t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getTotalCost());
      out.write(" </i></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li style=\"display: inline-block;\">\n");
      out.write("                        <ul class=\"process-list\">\n");
      out.write("                            <li class=\"process-step\">   <input type=\"radio\" class=\"price\" name=\"set");
      out.print(i);
      out.write("\"  value=\"");
      out.print( t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getTotalCost());
      out.write("\" ></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        ");
 } else {
      out.write("\n");
      out.write("        <div style=\"text-align: center;\" > Path Not Found</div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        ");
 } else if (session.getAttribute("source") != null) { 
      out.write("\n");
      out.write("        ");
         LocationDA lda = new LocationDA();
            categoriesDA cda = new categoriesDA();
            linkedlist<Location> all_link_loc = lda.getAlllinkLocation();

            linkedlist<Location> linkloc = new linkedlist<Location>();
            linkloc.add(lda.get_one_loc((String) session.getAttribute("source")));
            if (!cda.checkSameCountry((String) session.getAttribute("source"), (String) session.getAttribute("destination"))) {
                linkloc.add(lda.get_nearest_airport((String) session.getAttribute("source")));
                linkloc.add(lda.get_nearest_airport((String) session.getAttribute("destination")));
            }
            linkloc.add(lda.get_one_loc((String) session.getAttribute("destination")));

            for (int i = 0; i < linkloc.getNumberOfEntries(); i++) {
                for (int j = 0; j < all_link_loc.getNumberOfEntries(); j++) {
                    if (linkloc.getEntry(1).getName().equals(all_link_loc.getEntry(j + 1).getName())) {
                        linkloc.add(all_link_loc.getEntry(j + 1));
                        linkloc.remove(1);
                        break;
                    }
                }
            }
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
            transportationDA tda = new transportationDA();
            List<transport> tan = new List<transport>();
            tan =  tda.getAllTransportData();
            travelmode= new List<String>() ;
            cost = 0.0 ;
            time = 0.0 ;
           for(int i = 0 ; i< result_loc.getNumberOfEntries()-1;i++){
                if(result_loc.getEntry(i+1).isFlight()&& result_loc.getEntry(i+2).isFlight()){
                cost+= result_loc.getEntry(i+1).distance(result_loc.getEntry(i+2))* tan.getValueOf(4).getCost();
                time +=  result_loc.getEntry(i+1).distance(result_loc.getEntry(i+2))/tan.getValueOf(4).getSpeed();
                travelmode.add("flight");
                }else{
                travelmode.add("car");
                 cost+= result_loc.getEntry(i+1).distance(result_loc.getEntry(i+2))* tan.getValueOf(3).getCost();
                time +=  result_loc.getEntry(i+1).distance(result_loc.getEntry(i+2))/tan.getValueOf(3).getSpeed();              
                }
            }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"process-wrapper\" style=\" text-align: center;\">\n");
      out.write("            <div class=\"travelmode\" style=\" text-align: center; display: inline-block; width: 100%\">\n");
      out.write("                ");
 for (int i = 0; i < travelmode.size(); i++) {
      out.write("\n");
      out.write("                ");
 if (travelmode.getValueOf(i + 1).equals("car")) {
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\" ><img alt=\"\" src=\"https://image.flaticon.com/icons/svg/635/635678.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    ");
} else {
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\" https://image.flaticon.com/icons/svg/635/635683.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\"https://www.ledr.com/colours/white.jpg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <ul class=\"process-list\">\n");
      out.write("\n");
      out.write("                ");
 for (int i = 0; i < result_loc.getNumberOfEntries(); i++) {
                        if (i == 0) { 
      out.write("\n");
      out.write("                <li class=\"process-step first\"> \n");
      out.write("                    ");
 } else if (i == result_loc.getNumberOfEntries() - 1) {
      out.write(" \n");
      out.write("                <li class=\"process-step last\"> \n");
      out.write("                    ");
 } else {
      out.write("\n");
      out.write("                <li class=\"process-step \"> ");
 }
      out.write("  \n");
      out.write("\n");
      out.write("                    <div class=\"step-wrapper\">\n");
      out.write("                        <!-- <img  alt=\"\" src=\"https://cdn4.iconfinder.com/data/icons/urban-transport-3/50/48-512.png\" > -->\n");
      out.write("                        <a href=\"#\">");
      out.print( result_loc.getEntry(i + 1).getName());
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                <li style=\"display: inline-block;\">\n");
      out.write("                    <ul class=\"process-list\">\n");
      out.write("                        <li class=\"process-step\"><i class=\"far fa-clock\"> Duration: ");
      out.print( String.format("%d", time.intValue()));
      out.write('h');
      out.print( String.format("%1.0f", (time - time.intValue()) * 60));
      out.write("m </i><br><i class=\"fas fa-dollar-sign\"> Cost : RM");
      out.print( String.format("%.2f", cost));
      out.write("</i></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>          \n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
 } else if (session.getAttribute("cheapestPathList") != null) { 
      out.write("\n");
      out.write("\n");
      out.write("        ");
 List<Location> yj = (List<Location>) session.getAttribute("cheapestPathList");  
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"process-wrapper\" style=\" text-align: center;\">\n");
      out.write("            <div class=\"travelmode\" style=\" text-align: center; display: inline-block; width: 100%\">\n");
      out.write("                ");
   List<transport> transportmode = (List<transport>) session.getAttribute("cheapestTransportList");
                    for (int k = 0; k < transportmode.size(); k++) {
      out.write("\n");
      out.write("                ");
 if (transportmode.getValueOf(k + 1).getName().equals("Car")) {
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\" ><img alt=\"\" src=\"https://image.flaticon.com/icons/svg/635/635678.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    ");
} else if (transportmode.getValueOf(k + 1).getName().equals("Airplane")) {
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\" https://image.flaticon.com/icons/svg/635/635683.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    ");
} else if (transportmode.getValueOf(k + 1).getName().equals("Bus")) {
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\" https://image.flaticon.com/icons/svg/130/130262.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    ");
} else if (transportmode.getValueOf(k + 1).getName().equals("Train")) {
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\" https://image.flaticon.com/icons/svg/1532/1532079.svg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("                    ");
 } 
      out.write("             \n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                <cincai style=\"margin: 0px  30px;\"><img alt=\"\" src=\"https://www.ledr.com/colours/white.jpg\" style=\"width:40px ; height: 40px; \"></cincai>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <ul class=\"process-list\">\n");
      out.write("\n");
      out.write("                ");
 for (int i = 0; i < yj.size(); i++) {
                        if (i == 0) { 
      out.write("\n");
      out.write("                <li class=\"process-step first\"> \n");
      out.write("                    ");
 } else if (i == yj.size() - 1) {
      out.write(" \n");
      out.write("                <li class=\"process-step last\"> \n");
      out.write("                    ");
 } else {
      out.write("\n");
      out.write("                <li class=\"process-step \"> ");
 }
      out.write("  \n");
      out.write("\n");
      out.write("                    <div class=\"step-wrapper\">\n");
      out.write("                        <!-- <img  alt=\"\" src=\"https://cdn4.iconfinder.com/data/icons/urban-transport-3/50/48-512.png\" > -->\n");
      out.write("                        <a href=\"#\">");
      out.print( yj.getValueOf(i + 1).getName());
      out.write("</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                <li style=\"display: inline-block;\">\n");
      out.write("                    <ul class=\"process-list\">\n");
      out.write("                        <li class=\"process-step\"><i class=\"far fa-clock\"> Duration: ");
      out.print( transportmode.getValueOf(1).getHours() );
      out.write('h');
      out.print( transportmode.getValueOf(1).getMinutes());
      out.write("m </i><br><i class=\"fas fa-dollar-sign\"> Cost : RM");
      out.print( transportmode.getValueOf(1).getTotalCost() );
      out.write("</i></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>          \n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        ");
 if ((session.getAttribute("cheapestPathList")== null) && (session.getAttribute("source")== null) ){
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"totals\" style=\"margin-right: 10%; margin-top: 5%;\">\n");
      out.write("            <div class=\"totals-item\">\n");
      out.write("                <label>Subtotal</label>\n");
      out.write("                <div class=\"totals-value totalprice\" id=\"cart-subtotal\">0</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"totals-item\">\n");
      out.write("                <label>Tax (5%)</label>\n");
      out.write("                <div class=\"totals-value tax\" id=\"cart-tax\">0</div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"totals-item totals-item-total\">\n");
      out.write("                <label>Grand Total</label>\n");
      out.write("                <div class=\"totals-value gtotal\" id=\"cart-total\">0</div>\n");
      out.write("            </div>\n");
      out.write("        <button class=\"checkout\">Checkout</button>\n");
      out.write("        </div>\n");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            var totalprice = 0;\n");
      out.write("            $('.price').click(function () {\n");
      out.write("                totalprice = 0;\n");
      out.write("                $('.price').each(function () {\n");
      out.write("                    if ($(this).prop('checked')) {\n");
      out.write("                        totalprice += parseFloat($(this).val());\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                totalprice = totalprice.toFixed(2);\n");
      out.write("                $('.totalprice').text(totalprice);\n");
      out.write("                $('.tax').text((totalprice * 5 / 100).toFixed(2));\n");
      out.write("                totalprice = parseFloat(totalprice);\n");
      out.write("                $('.gtotal').text((totalprice + (totalprice * 5 / 100)).toFixed(2));\n");
      out.write("\n");
      out.write("\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            ");
  LocationDA lda = new LocationDA();
                List<Location> l = lda.getsomeLocation(1, "2");
            
      out.write("\n");
      out.write("        </script>\n");
      out.write("        ");
   session.removeAttribute("aStar_Path");
            session.removeAttribute("bStar_Path");
            session.removeAttribute("time");
            session.removeAttribute("cost");
            session.removeAttribute("travelmode");
            session.removeAttribute("source");
            session.removeAttribute("destination");
            session.removeAttribute("cheapestPathList");
            session.removeAttribute("cheapestTransportList");

        
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DA.adjencyDA;
import DA.LocationDA;
import domain.Location;
import domain.List;

public final class EditTravelLeg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Angular & PHP Crud</title>\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js\"></script>\n");
      out.write("\t<script src=\"app.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body ng-app=\"myApp\" ng-controller=\"myController\">\n");
      out.write("   \n");
      out.write("<div class=\"container\">\n");
      out.write("     \n");
      out.write("\t<hr>\n");
      out.write("\t\n");
      out.write("\t<h1>All Travel Leg</h1>\n");
      out.write("\t<span class=\"clearfix\"></span>\n");
      out.write("\t<hr>\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t<div class=\"table-responsive\">\n");
      out.write("            \n");
      out.write("            ");
 
                if(session.getAttribute("error")!=null) {
      out.write("\n");
      out.write("            <div class=\"alert alert-danger alert-dismissable\" ng-if=\"messageInfo\">\n");
      out.write("\t  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n");
      out.write("          ");
      out.print( session.getAttribute("error").toString() );
      out.write("\n");
      out.write("\t</div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            ");
 session.removeAttribute("error"); 
      out.write("\n");
      out.write("            ");
 
                if(session.getAttribute("sucess")!=null) {
      out.write("\n");
      out.write("            <div class=\"alert alert-success alert-dismissable\" ng-if=\"messageInfo\">\n");
      out.write("\t  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n");
      out.write("          ");
      out.print( session.getAttribute("sucess").toString() );
      out.write("\n");
      out.write("\t</div>\n");
      out.write("            ");
} session.removeAttribute("sucess");
      out.write("\n");
      out.write("          \n");
      out.write("            \n");
      out.write("\t\t<table class=\"table table-striped  table-responsive table-hover \">\n");
      out.write("\t\t\t<thead>\n");
      out.write("\t\t\t\t<tr class=\"info\">\n");
      out.write("\t\t\t\t\t<th>Location ID</th>\n");
      out.write("\t\t\t\t\t<th>Location Name</th>\n");
      out.write("\t\t\t\t\t<th>Current Travel Leg Number</th>\n");
      out.write("                                        <th>View</th>\n");
      out.write("\t\t\t\t\t<th>Add</th>\n");
      out.write("\t\t\t\t\t<th>Delete</th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</thead>\n");
      out.write("\t\t\t<tbody>\n");
      out.write("\t\t\t\t ");
 LocationDA locaDA = new LocationDA();
                                  adjencyDA adDA = new adjencyDA();
                              List<Location> locaList = new  List<Location>(); 
                              locaList=locaDA.getAllLocation();
                         for (int i=0;i<locaList.size();i++) {
      out.write("\n");
      out.write("                          \n");
      out.write("                         <tr ng-repeat=\"user in users\">\n");
      out.write("                                   \n");
      out.write("                                <td>");
      out.print( locaList.getValueOf(i+1).getCode_num());
      out.write(" </td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print( locaList.getValueOf(i+1).getName() );
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print( adDA.getNumberofTravelLeg(locaList.getValueOf(i+1).getCode_num()) );
      out.write("</td>\n");
      out.write("                                        <td><button type=\"button\" class=\"btn btn-success view\" data-toggle=\"modal\" data-target=\"#View");
      out.print(locaList.getValueOf(i+1).getCode_num());
      out.write("\" >View</button></td>\n");
      out.write("                                        <td><button type=\"button\" class=\" btn btn-info editbtn\" data-toggle=\"modal\" data-target=\"#modaledit\" ng-click=\"selectUser(user)\" value=\"");
      out.print( locaList.getValueOf(i+1).getCode_num());
      out.write("\" >Edit</button></td>\n");
      out.write("\t\t\t\t\t\n");
      out.write("                                        <td><button type=\"button\" class=\"btn btn-danger delete\" data-toggle=\"modal\" data-target=\"#");
      out.print(locaList.getValueOf(i+1).getCode_num());
      out.write("\" ng-click=\"selectUser(user)\">Delete</button></td>\n");
      out.write("                                        \n");
      out.write("                                </tr>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("\t\t\t</tbody>\n");
      out.write("\t\t</table>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write(" ");
for (int i=0; i< locaList.size();i++ ) { 
      out.write("                   \n");
      out.write(" <div class=\"modal fade\" id=\"View");
      out.print( locaList.getValueOf(i+1).getCode_num() );
      out.write("\" role=\"dialog\">\n");
      out.write("\t<div class=\"modal-dialog\">\n");
      out.write("\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">View All Travel Leg of ");
      out.print( locaList.getValueOf(i+1).getName());
      out.write("</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("                        \n");
      out.write("                        <table class=\"table table-striped  table-responsive table-hover \">\n");
      out.write("\t\t\t<thead>\n");
      out.write("\t\t\t\t<tr class=\"info\">\n");
      out.write("\t\t\t\t\t<th>Location ID</th>\n");
      out.write("\t\t\t\t\t<th>Location Name</th> \n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</thead>\n");
      out.write("                        ");
 
                            List<Location> viewAll = adDA.selectDeleteLocation(String.valueOf(locaList.getValueOf(i+1).getCode_num()), String.valueOf(locaList.getValueOf(i+1).getCode_num())); 
                            for(int j =0 ;j<viewAll.size();j++){
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print( viewAll.getValueOf(j+1).getCode_num() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( viewAll.getValueOf(j+1).getName());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    \n");
      out.write("\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-info pull-right\" data-dismiss=\"modal\" >Close</button>\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write(" ");
}
      out.write("                      \n");
      out.write("  \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("<div class=\"modal fade\" id=\"modaledit\" role=\"dialog\">\n");
      out.write("\t<div class=\"modal-dialog\">\n");
      out.write("\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">Add New Travel Leg</h4>\n");
      out.write("                                <h5>Editing: <div id=\"sourceLoca\"></div></h5>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-body\">\n");
      out.write("                            <form class=\"form-horizontal\" action=\"editServelet\">\n");
      out.write("                                <input id=\"sourceCode\" name=\"sourceCode\" hidden>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label col-md-2\">Location Name</label>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-10\">\n");
      out.write("                                                    <input list=\"location\" type=\"text\"  id=\"locaName\" name=\"locaName\" class=\" form-control\">\n");
      out.write("\t\t\t\t\t\t\t <datalist id=\"location\">\n");
      out.write("                                                             ");
for (int i =0;i< locaList.size();i++) { 
      out.write("\n");
      out.write("\n");
      out.write("                                                             <option value=\"");
      out.print( locaList.getValueOf(i+1).getName());
      out.write("\" >\n");
      out.write("                                                                 ");
}
      out.write("\n");
      out.write("                                                             </datalist>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label col-md-2\">Location Code</label>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-10\">\n");
      out.write("                                                    <input type=\"text\" class=\" form-control\" id=\"locaCode\" name=\"locaCode\" readonly=\"true\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-2 col-md-offset-2\">\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-info \"   name=\"button\" value=\"update\">ADD</button>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-footer\">\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-info pull-right\" data-dismiss=\"modal\" >Close</button>\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write(" \n");
      out.write(" ");
for (int i=0; i< locaList.size();i++ ) { 
      out.write("\n");
      out.write(" <form action=\"editServelet\">\n");
      out.write(" <div class=\"modal fade\" id=\"");
      out.print( locaList.getValueOf(i+1).getCode_num() );
      out.write("\" role=\"dialog\">\n");
      out.write("\t<div class=\"modal-dialog\">\n");
      out.write("\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">Deleting Travel Leg</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-body\">\n");
      out.write("                            <input list=\"");
      out.print(locaList.getValueOf(i+1).getName());
      out.write("\" type=\"text\"  class=\" form-control\" name=\"delDest\">\n");
      out.write("                            <datalist id=\"");
      out.print(locaList.getValueOf(i+1).getName());
      out.write("\">\n");
      out.write("                           ");

                               List<List<Location>> delLoca = new List<List<Location>>();
                               delLoca.add(adDA.selectDeleteLocation(String.valueOf(locaList.getValueOf(i+1).getCode_num()), String.valueOf(locaList.getValueOf(i+1).getCode_num())));
                               for(int j =0;j < delLoca.getValueOf(1).size();j++){
                                
      out.write("\n");
      out.write("                                   \n");
      out.write("                                <option value=\"");
      out.print( delLoca.getValueOf(1).getValueOf(j+1).getName() );
      out.write("\">  \n");
      out.write("                               ");
}
      out.write("\n");
      out.write("                             </datalist>\n");
      out.write("                            \n");
      out.write("                               <input value=\"");
      out.print( locaList.getValueOf(i+1).getCode_num());
      out.write("\" name=\"delSource\">\n");
      out.write("                            \n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"modal-footer\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-info \" >Yes</button> \n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-info \" data-dismiss=\"modal\" >No</button>\t\t\n");
      out.write("\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</form>\n");
}
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("  \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("     $(\"#locaName\").change(function(){\n");
      out.write("        var location = document.getElementById(\"locaName\").value;\n");
      out.write("\n");
      out.write("    ");
 for(int i =0 ;i< locaList.size();i++){ 
      out.write("   \n");
      out.write("    if(location == '");
      out.print( locaList.getValueOf(i+1).getName() );
      out.write("'){\n");
      out.write("         $(\"#locaCode\").val(\"");
      out.print( locaList.getValueOf(i+1).getCode_num()  );
      out.write("\") ;\n");
      out.write("    }\n");
      out.write("    ");
}
      out.write("\n");
      out.write("}\n");
      out.write("    );\n");
      out.write("    \n");
      out.write("  $(\".editbtn\").click(function(e){\n");
      out.write("         sourceCode = $(this).val();\n");
      out.write("      ");
 for(int i =0 ;i< locaList.size();i++){ 
      out.write("   \n");
      out.write("    if(sourceCode == '");
      out.print( locaList.getValueOf(i+1).getCode_num());
      out.write("'){\n");
      out.write("        $(\"#sourceLoca\").html(\"Name : ");
      out.print( locaList.getValueOf(i+1).getName() );
      out.write(" <br/> Location Code : ");
      out.print( locaList.getValueOf(i+1).getCode_num());
      out.write("\");\n");
      out.write("        $(\"#sourceCode\").val(\"");
      out.print( locaList.getValueOf(i+1).getCode_num());
      out.write("\");\n");
      out.write("    }\n");
      out.write("    ");
}
      out.write("\n");
      out.write("       \n");
      out.write("      \n");
      out.write("    });  \n");
      out.write("    \n");
      out.write("  \n");
      out.write("  \n");
      out.write("  \n");
      out.write("  \n");
      out.write("</script>\n");
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

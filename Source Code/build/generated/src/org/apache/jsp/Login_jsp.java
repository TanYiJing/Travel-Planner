package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.xml.ws.spi.http.HttpContext;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<!------ Include the above in your HEAD tag ---------->\n");
      out.write("\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("     \n");
      out.write(".login-block{\n");
      out.write("    background: #DE6262;  /* fallback for old browsers */\n");
      out.write("    background: -webkit-linear-gradient(to bottom, #F0C27B, #4B1248);  /* Chrome 10-25, Safari 5.1-6 */\n");
      out.write("    background: linear-gradient(to bottom, #606c88, #3f4c6b); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\n");
      out.write("    float:left;\n");
      out.write("    width:100%;\n");
      out.write("    padding : 133px 0;\n");
      out.write("    height: 100%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write(".container{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}\n");
      out.write(".carousel-inner{border-radius:0 10px 10px 0;}\n");
      out.write(".carousel-caption{text-align:left; left:5%;}\n");
      out.write(".login-sec{padding: 50px 30px; position:relative;}\n");
      out.write(".login-sec .copy-text{position:absolute; width:80%; bottom:20px; font-size:13px; text-align:center;}\n");
      out.write(".login-sec .copy-text i{color:#FEB58A;}\n");
      out.write(".login-sec .copy-text a{color:#E36262;}\n");
      out.write(".login-sec h2{margin-bottom:30px; font-weight:800; font-size:30px; color: #0038A8;}\n");
      out.write(".login-sec h2:after{content:\" \"; width:100px; height:5px; background:#FEB58A; display:block; margin-top:20px; border-radius:3px; margin-left:auto;margin-right:auto}\n");
      out.write(".btn-login{background: #DE6262; color:#fff; font-weight:600;}\n");
      out.write(".banner-text{width:70%; position:absolute; bottom:40px; padding-left:20px;}\n");
      out.write(".banner-text h2{color:#fff; font-weight:600;}\n");
      out.write(".banner-text h2:after{content:\" \"; width:100px; height:5px; background:#FFF; display:block; margin-top:20px; border-radius:3px;}\n");
      out.write(".banner-text p{color:#fff;}\n");
      out.write("\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("\n");
      out.write("      \n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <title>Login</title>\n");
      out.write("    <body>\n");
      out.write("      <section class=\"login-block\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("\t<div class=\"row\">\n");
      out.write("\t\t<div class=\"col-md-4 login-sec\">\n");
      out.write("\t\t    <h2 class=\"text-center\">Login Now</h2>\n");
      out.write("<form class=\"login-form\" method=\"post\" action=\"LoginProcess\">\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("\n");
      out.write("    <label for=\"exampleInputEmail1\" class=\"text-uppercase\">Username</label>\n");
      out.write("    <input type=\"text\" class=\"form-control\" placeholder=\"\" name=\"username\">\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"exampleInputPassword1\" class=\"text-uppercase\">Password</label>\n");
      out.write("    <input type=\"password\" class=\"form-control\" placeholder=\"\" name=\"password\">\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("    <div class=\"form-check\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <button type=\"submit\" name=\"stafflogin\" style=\"margin-top: 8px;\"  class=\"btn btn-login float-left\">Staff Login</button>\n");
      out.write("    ");
 if(session.getAttribute("error")!=null){
        
      out.write("\n");
      out.write("        <br><br><div style=\"color: red;\"> ");
      out.print(session.getAttribute("error").toString());
      out.write("</div>\n");
      out.write("        ");
} session.removeAttribute("error"); 
      out.write("\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("</form >\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-md-8 banner-sec\">\n");
      out.write("            <div id=\"carouselExampleIndicators\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                 <ol class=\"carousel-indicators\">\n");
      out.write("                    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\n");
      out.write("                    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\n");
      out.write("                  </ol>\n");
      out.write("            <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("    <div class=\"carousel-item active\">\n");
      out.write("      <img class=\"d-block img-fluid\" src=\"https://images.pexels.com/photos/2166553/pexels-photo-2166553.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940\" alt=\"First slide\">\n");
      out.write("      <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("        <div class=\"banner-text\">\n");
      out.write("            <h2>This is Heaven</h2>\n");
      out.write("            <p>Wherever you go, go with all your heart.</p>\n");
      out.write("        </div>\t\n");
      out.write("  </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("      <img class=\"d-block img-fluid\" src=\"https://images.pexels.com/photos/2325446/pexels-photo-2325446.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940\" alt=\"First slide\">\n");
      out.write("      <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("        <div class=\"banner-text\">\n");
      out.write("            <h2>This is a place where champions are born</h2>\n");
      out.write("            <p>Life is short and the world is wide.</p>\n");
      out.write("        </div>\t\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("      <img class=\"d-block img-fluid\" src=\"https://images.pexels.com/photos/2095850/pexels-photo-2095850.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940\" alt=\"First slide\">\n");
      out.write("      <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("        <div class=\"banner-text\">\n");
      out.write("            <h2>A place that does not have it's limit</h2>\n");
      out.write("            <p>The best dreams happen when you’re awake.</p>\n");
      out.write("        </div>\t\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("            </div>\t   \n");
      out.write("\t\t    \n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</section>  \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
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

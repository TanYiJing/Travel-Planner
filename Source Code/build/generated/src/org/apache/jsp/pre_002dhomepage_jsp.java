package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pre_002dhomepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title></title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/Pre-homepage.css\">\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("<style>\n");
      out.write("    :root {\n");
      out.write("  --container-bg-color: #333;\n");
      out.write("  --left-bg-color: rgba(133, 113, 24, 0.23);\n");
      out.write("  --left-button-hover-color: rgba(255, 64, 0, 0.3);\n");
      out.write("  --right-bg-color: rgba(43, 43, 43, 0.8);\n");
      out.write("  --right-button-hover-color: rgba(92, 92, 92, 0.3);\n");
      out.write("  --hover-width:75%;\n");
      out.write("  --other-width:25%;\n");
      out.write("  --time:2s;\n");
      out.write("}\n");
      out.write("\n");
      out.write("html, body {\n");
      out.write("  padding:0;\n");
      out.write("  margin:0;\n");
      out.write("  \n");
      out.write("  width: 100%;\n");
      out.write("  height: 100%;\n");
      out.write("  overflow-x: hidden;\n");
      out.write("}\n");
      out.write("p{\n");
      out.write("   font-size: 1.5rem;\n");
      out.write("  color: #fff;\n");
      out.write("  position: absolute;\n");
      out.write("  left: 50%;\n");
      out.write("  top: 35%;\n");
      out.write("  transform: translateX(-50%);\n");
      out.write("  white-space: nowrap;\n");
      out.write("  text-shadow: 2px 2px 10px #111;\n");
      out.write("  letter-spacing: 3px;\n");
      out.write("}\n");
      out.write("h1 {\n");
      out.write("  font-size: 4rem;\n");
      out.write("  color: #fff;\n");
      out.write("  position: absolute;\n");
      out.write("  left: 50%;\n");
      out.write("  top: 20%;\n");
      out.write("  transform: translateX(-50%);\n");
      out.write("  white-space: nowrap;\n");
      out.write("  text-shadow: 2px 2px 10px #111;\n");
      out.write("  letter-spacing: 3px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".button {\n");
      out.write("  display: block;\n");
      out.write("  position: absolute;\n");
      out.write("  left: 50%;\n");
      out.write("  top: 60%;\n");
      out.write("  height: 2.5rem;\n");
      out.write("  padding-top: 1.3rem;\n");
      out.write("  width: 15rem;\n");
      out.write("  text-align: center;\n");
      out.write("  color: #fff;\n");
      out.write("  border: #fff solid 0.2rem;\n");
      out.write("  font-size: 1rem;\n");
      out.write("  font-weight: bold;\n");
      out.write("  text-transform: uppercase;\n");
      out.write("  text-decoration: none;\n");
      out.write("  transform: translateX(-50%);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".split.left .button:hover {\n");
      out.write("  background-color: var(--left-button-hover-color);\n");
      out.write("  border-color: var(--left-button-hover-color);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".split.right .button:hover {\n");
      out.write("  background-color: var(--right-button-hover-color);\n");
      out.write("  border-color: var(--right-button-hover-color);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container {\n");
      out.write("  position: relative;\n");
      out.write("  width: 100%;\n");
      out.write("  height: 100%;\n");
      out.write("  background: var(--container-bg-color);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".split{\n");
      out.write("\tposition: absolute;\n");
      out.write("\twidth: 50%;\n");
      out.write("\theight: 100%;\n");
      out.write("\toverflow: hidden;\n");
      out.write("\n");
      out.write("}\n");
      out.write(".split.left{\n");
      out.write("\tleft: 0;\n");
      out.write("\tbackground: url(https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940);\n");
      out.write("\tbackground-size: cover;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write(".split.left:before{\n");
      out.write("\tposition: absolute;\n");
      out.write("\tcontent: \"\";\n");
      out.write("\twidth: 100%;\n");
      out.write("\theight: 100%;\n");
      out.write("\tbackground: var(--left-bg-color);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".split.right{\n");
      out.write("\tright: 0;\n");
      out.write("\tbackground: url(https://images.pexels.com/photos/1271619/pexels-photo-1271619.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940);\n");
      out.write("\tbackground-size: cover;\n");
      out.write("background-attachment: fixed;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write(".split.right:before{\n");
      out.write("\tposition: absolute;\n");
      out.write("\tcontent: \"\";\n");
      out.write("\twidth: 100%;\n");
      out.write("\theight: 100%;\n");
      out.write("\tbackground: var(--right-bg-color);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".split.left, .split.right, .split.right:before, .split.left:before {\n");
      out.write("  transition: 2s;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".hover-left .left {\n");
      out.write("  width: var(--hover-width);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".hover-left .right {\n");
      out.write("  width: var(--other-width);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".hover-left .right:before {\n");
      out.write("  z-index: 2;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".hover-right .right {\n");
      out.write("  width: var(--hover-width);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".hover-right .left {\n");
      out.write("  width: var(--other-width);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".hover-right .left:before {\n");
      out.write("  z-index: 2;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("@media (max-width: 1000px){\n");
      out.write("\th1{\n");
      out.write("\t\tfont-size: 1.3rem;\n");
      out.write("\n");
      out.write("\t}\n");
      out.write("\t.button{\n");
      out.write("width: 11rem;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("@media (max-height: 1000px)\n");
      out.write("{\n");
      out.write("\t.button{\n");
      out.write("\t\ttop: 50%;\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script type=\"text/javascript\" src=\"js/prehomepage.js\" defer></script>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  <audio src=\"business.mp3\" loop autoplay=\"true\"></audio>\n");
      out.write("<div class=\"container\" id=\"container\" >\n");
      out.write(" \n");
      out.write("  <div class=\"split left\" id=\"left\" > \n");
      out.write("   \n");
      out.write("    <h1>Staff Login</h1>\n");
      out.write("    <a href=\"Login.jsp\" class=\"button\">Login</a>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"split right\" id=\"right\">\n");
      out.write("     \n");
      out.write("    <h1>Traveller</h1>\n");
      out.write("    <p> </p>\n");
      out.write("    <a href=\"Homepage.jsp\" class=\"button\" >Search A Route</a>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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

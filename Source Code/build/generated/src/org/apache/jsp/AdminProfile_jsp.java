package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <style>\n");
      out.write("        video {\n");
      out.write("    width: 500px;\n");
      out.write("    height: 500px;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <a href=\"AdminPage.jsp\" class=\"btn btn-success\"  > BACK </a>\n");
      out.write("\n");
      out.write("        <div style=\"text-align:center;\">\n");
      out.write("  <video id=\"screenshot-video\" class=\"videostream\" autoplay=\"\"></video>\n");
      out.write("  <img id=\"screenshot-img\">\n");
      out.write("  <p><button id=\"screenshot-button\" hidden></button></p>\n");
      out.write("  <div>Staff Name : Tan Yi Jing</div>\n");
      out.write("  <div>Staff ID : 1001</div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        function handleError(error) {\n");
      out.write("  console.error('navigator.getUserMedia error: ', error);\n");
      out.write("}\n");
      out.write("const constraints = {\n");
      out.write("  video: {width: {min: 1280}, height: {min: 720}}\n");
      out.write("};\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("(function() {\n");
      out.write("  const button = document.querySelector('#screenshot-button');\n");
      out.write("  const img = document.querySelector('#screenshot-img');\n");
      out.write("  const video = document.querySelector('#screenshot-video');\n");
      out.write("\n");
      out.write("  const canvas = document.createElement('canvas');\n");
      out.write("\n");
      out.write("  button.onclick = video.onclick = function() {\n");
      out.write("    canvas.width = video.videoWidth;\n");
      out.write("    canvas.height = video.videoHeight;\n");
      out.write("    canvas.getContext('2d').drawImage(video, 0, 0);\n");
      out.write("    // Other browsers will fall back to image/png\n");
      out.write("    img.src = canvas.toDataURL('image/webp');\n");
      out.write("  };\n");
      out.write("\n");
      out.write("  function handleSuccess(stream) {\n");
      out.write("    video.srcObject = stream;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  navigator.mediaDevices.getUserMedia(constraints).\n");
      out.write("      then(handleSuccess).catch(handleError);\n");
      out.write("})();\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" setTimeout(function(){ \n");
      out.write(" \n");
      out.write(" $( \"#screenshot-button\" ).trigger( \"click\" );\n");
      out.write(" \n");
      out.write(" }, 5000);\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("window.onload = function () {\n");
      out.write("    var fiveMinutes = 5,\n");
      out.write("        display = document.querySelector('#time');\n");
      out.write("    startTimer(fiveMinutes, display);\n");
      out.write("};\n");
      out.write("        </script>\n");
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

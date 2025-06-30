package org.apache.jsp.Admin_005fDashboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Admin Dashboard</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    \n");
      out.write("    <!-- CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css\">\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        .modal {\n");
      out.write("            display: flex;\n");
      out.write("            position: fixed;\n");
      out.write("            z-index: 9999;\n");
      out.write("            left: 0; top: 0;\n");
      out.write("            width: 100%; height: 100%;\n");
      out.write("            background-color: rgba(0,0,0,0.5);\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-box {\n");
      out.write("            background: white;\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 0 15px #000;\n");
      out.write("            width: 300px;\n");
      out.write("            text-align: center;\n");
      out.write("            position: relative;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-box input {\n");
      out.write("            width: 90%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin: 10px 0;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-box button {\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .close-btn {\n");
      out.write("            position: absolute;\n");
      out.write("            top: 10px;\n");
      out.write("            right: 15px;\n");
      out.write("            font-size: 20px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("   <script>\n");
      out.write("    window.onload = function () {\n");
      out.write("        // Get URL parameter for login error\n");
      out.write("        const urlParams = new URLSearchParams(window.location.search);\n");
      out.write("        const loginError = urlParams.get('error');\n");
      out.write("\n");
      out.write("        // If error=1, it means login failed\n");
      out.write("        if (loginError === '1') {\n");
      out.write("            // Clear previous popupShown state (so popup appears again)\n");
      out.write("            sessionStorage.removeItem(\"popupShown\");\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Now handle popup as usual\n");
      out.write("        if (!sessionStorage.getItem(\"popupShown\")) {\n");
      out.write("            document.getElementById(\"loginModal\").style.display = \"flex\";\n");
      out.write("            sessionStorage.setItem(\"popupShown\", \"true\");\n");
      out.write("        } else {\n");
      out.write("            document.getElementById(\"loginModal\").style.display = \"none\";\n");
      out.write("        }\n");
      out.write("    };\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<!-- Admin Dashboard content -->\n");
      out.write("<div class=\"admin-header\">\n");
      out.write("    <h1>Admin Dashboard</h1>\n");
      out.write("    <div class=\"admin-icon\">\n");
      out.write("        <i class=\"fa-solid fa-user-tie\"></i>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"admin-dashboard\">\n");
      out.write("    <li><i class=\"fa-solid fa-house\"></i><a href=\"home.jsp\">Home</a></li>\n");
      out.write("    <li><i class=\"fa-solid fa-user-plus\"></i><a href=\"add_donors.jsp\">Add Donors</a></li>\n");
      out.write("    <li><i class=\"fa-solid fa-list-ul\"></i><a href=\"donor_list.jsp\">Donor List</a></li>\n");
      out.write("    <li><i class=\"fa-solid fa-address-book\"></i><a href=\"update_contact.jsp\">Update Contact Info</a></li>\n");
      out.write("    <li><i class=\"fa-solid fa-envelope\"></i><a href=\"message.jsp\">Message</a></li>\n");
      out.write("</div>\n");
      out.write("<div class=\"welcome-admin\">\n");
      out.write("    <img src=\"../images/welcome-admin-banner1.jpg\" alt=\"welcome-admin-banner1\" class=\"welcome-admin-banner1\" style=\"width: 100%; height: 100%;\">\n");
      out.write("    <h1>WELCOME ADMIN</h1>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Login Modal (shows on every page load) -->\n");
      out.write("<div id=\"loginModal\" class=\"modal\">\n");
      out.write("    <div class=\"login-box\">\n");
      out.write("        <span class=\"close-btn\" onclick=\"document.getElementById('loginModal').style.display='none'\">&times;</span>\n");
      out.write("        <h2>Admin Login</h2>\n");
      out.write("        <form action=\"../AdminLoginServlet\" method=\"post\">\n");
      out.write("            <input type=\"text\" name=\"username\" placeholder=\"Enter Username\" required />\n");
      out.write("            <input type=\"password\" name=\"password\" placeholder=\"Enter Password\" required />\n");
      out.write("            <button type=\"submit\">Login</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
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

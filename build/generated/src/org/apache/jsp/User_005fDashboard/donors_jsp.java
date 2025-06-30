package org.apache.jsp.User_005fDashboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;;

public final class donors_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM updatecontact");
    Statement stmt1 = con.createStatement(); // ✅ Separate statement
    ResultSet rs1 = stmt1.executeQuery("SELECT * FROM donor_list");

      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Donors</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css\">\n");
      out.write("        <style>\n");
      out.write("            .donor-card {\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                padding: 15px;\n");
      out.write("                margin: 10px;\n");
      out.write("                box-shadow: 0 2px 5px rgba(0,0,0,0.1);\n");
      out.write("                background-color: #fdfdfd;\n");
      out.write("                width: 300px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");

            while (rs.next()) {
        
      out.write(" \n");
      out.write("        <div class=\"header\">\n");
      out.write("            <ul class=\"header-content\">\n");
      out.write("                <li><img src=\"../images/logo.png\" alt=\"logo\" class=\"logo-img\"></li>\n");
      out.write("                <li>\n");
      out.write("                    <p class=\"slogan\">\"Be someone's superhero. Donate blood today.\"</p>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <p class=\"phone\">+91");
      out.print(rs.getString("phone"));
      out.write("</p>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <p class=\"email\">");
      out.print(rs.getString("email"));
      out.write("</p>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"nav\">\n");
      out.write("            <ul class=\"nav-content\">\n");
      out.write("                <li class=\"nav-names\"><a href=\"home.jsp\"><i class=\"fa fa-home\"></i> Home</li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"about.jsp\" target=\"\"><i class=\"fa fa-info-circle\"></i> About Us</li>\n");
      out.write("                </a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"why_donate_blood.jsp\"><i class=\"fa fa-heartbeat\"></i> Why\n");
      out.write("                        Donate Blood</li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"become_donor.jsp\"><i class=\"fa fa-user-plus\"></i> Become Donor\n");
      out.write("                </li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"donors.jsp\"><i class=\"fa fa-users\"></i> View Donors</li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"need_blood.jsp\"><i class=\"fa fa-tint\"></i> Need Blood</li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"contactus.jsp\"><i class=\"fa fa-envelope\"></i> Contact Us</li></a>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"donor-page\">\n");
      out.write("            ");
 while (rs1.next()) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"donor-card\">\n");
      out.write("                ");
 if ("Not Available".equalsIgnoreCase(rs1.getString("status"))) { 
      out.write("\n");
      out.write("                <h2 style=\"color: white; background-color: gray; padding: 8px; text-align: center; border-radius: 5px;\">\n");
      out.write("                    Not Available\n");
      out.write("                </h2>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"donor-info\">\n");
      out.write("                    <h2><i class=\"fa fa-user\"></i> ");
      out.print(rs1.getString("name"));
      out.write(' ');
      out.write('(');
      out.print(rs1.getString("blood_group"));
      out.write(")</h2>\n");
      out.write("                    <p><strong>Blood Group:</strong> ");
      out.print(rs1.getString("blood_group"));
      out.write("</p>\n");
      out.write("                    <p><strong>Phone:</strong> ");
      out.print(rs1.getString("phone"));
      out.write("</p>\n");
      out.write("                    <p><strong>Email:</strong> ");
      out.print(rs1.getString("email"));
      out.write("</p>\n");
      out.write("                    <p><strong>Age:</strong> ");
      out.print(rs1.getString("age"));
      out.write("</p>\n");
      out.write("                    <p><strong>Address:</strong> ");
      out.print(rs1.getString("address"));
      out.write("</p>\n");
      out.write("                    <p><strong>Gender:</strong> ");
      out.print(rs1.getString("gender"));
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <div class=\"quick-links\">\n");
      out.write("                <h1>Quick Links</h1>\n");
      out.write("                <li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"about.jsp\">About</a></li>\n");
      out.write("                <li><a href=\"why_donate_blood.jsp\">Why Donate Blood</a></li>\n");
      out.write("                <li><a href=\"become_donor.jsp\">Become Donor</a></li>\n");
      out.write("                <li><a href=\"donors.jsp\">View Donors</a></li>\n");
      out.write("                <li><a href=\"need_blood.jsp\">Need Blood</a></li>\n");
      out.write("                <li><a href=\"contactus.jsp\">Contact Us</a></li>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-contact\">\n");
      out.write("                <h1>Contact Us</h1>\n");
      out.write("                <p>Address:");
      out.print(rs.getString("address"));
      out.write("</p>\n");
      out.write("                <p>Phone number:");
      out.print(rs.getString("phone"));
      out.write("</p>\n");
      out.write("                <p>Email:");
      out.print(rs.getString("email"));
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-icon\">\n");
      out.write("                <h1>Follow Us</h1>\n");
      out.write("                <a href=\"https://facebook.com\" target=\"_blank\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                <a href=\"https://instagram.com\" target=\"_blank\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"copyrights\">\n");
      out.write("            <p>&copy;2025 Blood Donation Website.All rights reserved By Sangeetha Rajendran.</p>\n");
      out.write("        </div>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        ");

            rs.close();
            stmt.close();
            rs1.close();
            stmt1.close();
            con.close();
        
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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

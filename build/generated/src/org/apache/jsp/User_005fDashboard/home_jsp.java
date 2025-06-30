package org.apache.jsp.User_005fDashboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;;

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
      out.write("\n");
      out.write("\n");

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM updatecontact");

      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Blood Donation Website</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css\">\n");
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
      out.write("                   <p class=\"phone\">+91");
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
      out.write("                <li class=\"nav-names\"><a href=\"about.jsp#about\" target=\"\"><i class=\"fa fa-info-circle\"></i> About Us</li>\n");
      out.write("                </a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"why_donate_blood.jsp#why_donate_blood\"><i class=\"fa fa-heartbeat\"></i> Why\n");
      out.write("                        Donate Blood</li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"become_donor.jsp#become_donor\"><i class=\"fa fa-user-plus\"></i> Become Donor\n");
      out.write("                </li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"donors.jsp#donors\"><i class=\"fa fa-users\"></i> View Donors</li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"need_blood.jsp#need_blood\"><i class=\"fa fa-tint\"></i> Need Blood</li></a>\n");
      out.write("                <li class=\"nav-names\"><a href=\"contactus.jsp#contactus\"><i class=\"fa fa-envelope\"></i> Contact Us</li></a>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"home\">\n");
      out.write("            <div class=\"home-content\">\n");
      out.write("                <img src=\"../images/banner.jpg\" alt=\"banner\" class=\"banner-img\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"slogan1\">\n");
      out.write("                <p class=\"slogan1-content\"><i class=\"fa fa-tint\"></i> Donate Blood and Save Lives</li>\n");
      out.write("                </p>\n");
      out.write("                <button class=\"slogan1-button\"><a href=\"need_blood.jsp\">Need Blood</a></button>\n");
      out.write("                <button class=\"slogan1-button\"><a href=\"become_donor.jsp\">Become Donar</a></button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"blood-donor-day\">\n");
      out.write("            <img src=\"../images/banner7.jpg\" alt=\"banner7\" style=\"width: 600px; height: 400px;\" class=\"banner7\">\n");
      out.write("            <div class=\"donor-day-content\">\n");
      out.write("                <h1>🩸 World Blood Donor Day - June 14</h1>\n");
      out.write("                <p>World Blood Donor Day is observed every year on June 14 to raise global awareness of the need for safe\n");
      out.write("                    blood and blood products for transfusion. It also serves as a special day to thank voluntary, unpaid\n");
      out.write("                    blood donors for their life-saving gifts of blood.</p>\n");
      out.write("                <h1>🌍 Why is it celebrated?</h1>\n");
      out.write("                <p>To highlight the importance of voluntary, safe, and unpaid blood donation.\n");
      out.write("\n");
      out.write("                    To ensure adequate supplies of safe blood for patients in need.\n");
      out.write("\n");
      out.write("                    To promote a culture of regular blood donation in society.</p>\n");
      out.write("                <h1>❤️ Significance of Blood Donation</h1>\n");
      out.write("                <p>Every two seconds, someone in the world needs blood.\n");
      out.write("\n");
      out.write("                    A single blood donation can save up to three lives.\n");
      out.write("\n");
      out.write("                    Blood cannot be manufactured – it only comes from healthy donors.\n");
      out.write("\n");
      out.write("                    Donated blood is used in surgeries, accident care, cancer treatment, and childbirth.</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"process\">\n");
      out.write("            <div class=\"process-card\">\n");
      out.write("                <i class=\"fa-regular fa-clock\"></i>\n");
      out.write("                <p>It takes only an hour</p>\n");
      out.write("\n");
      out.write("                <p>Donate blood save lives!</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"process-card\">\n");
      out.write("                <i class=\"fa-solid fa-glass-water\"></i>\n");
      out.write("                <p>You will get free refreshments after donation</p>\n");
      out.write("\n");
      out.write("                <p>Donation of blood is safe and healthy</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"process-card\">\n");
      out.write("                <i class=\"fa-solid fa-indian-rupee-sign\"></i>\n");
      out.write("                <p>it costs nothing</p>\n");
      out.write("\n");
      out.write("                <p>Give blood and stay healthy</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"process-card\">\n");
      out.write("                <i class=\"fa-solid fa-heart-pulse\"></i>\n");
      out.write("                <p>There is nothing better than saving a life</p>\n");
      out.write("\n");
      out.write("                <p>Every blood donor is a hero</p>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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

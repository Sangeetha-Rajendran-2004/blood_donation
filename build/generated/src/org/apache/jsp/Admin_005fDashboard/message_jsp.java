package org.apache.jsp.Admin_005fDashboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;;

public final class message_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_donation?useSSL=false&serverTimezone=UTC", "root", "Root");

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM message");
    
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Document</title>\n");
      out.write("     <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"admin-header\">\n");
      out.write("        <h1>Admin Dashboard</h1>\n");
      out.write("        <div class=\"admin-icon\">\n");
      out.write("            <i class=\"fa-solid fa-user-tie\" ></i>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"admin-dashboard\">\n");
      out.write("        <li><i class=\"fa-solid fa-house\"></i><a href=\"home.jsp\">Home</a></li>\n");
      out.write("         <li><i class=\"fa-solid fa-user-plus\"></i> <a href=\"add_donors.jsp\">Add Donors</a></li>\n");
      out.write("        <li><i class=\"fa-solid fa-list-ul\"></i> <a href=\"donor_list.jsp\">Donor List</a></li>\n");
      out.write("        <li><i class=\"fa-solid fa-address-book\"></i> <a href=\"update_contact.jsp\">Update Contact Info</a></li>\n");
      out.write("        <li><i class=\"fa-solid fa-envelope\"></i> <a href=\"message.jsp\">Message</a></li>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"add-donor\">\n");
      out.write("       <table >\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>Full Name</th>\n");
      out.write("            <th>Phone</th>\n");
      out.write("            <th>Email</th>\n");
      out.write("            <th>Message</th>\n");
      out.write("            <th>Action</th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");

    while(rs.next()){

      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(rs.getString("name"));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString("phone"));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString("email"));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString("message"));
      out.write("</td>\n");
      out.write("        <td>\n");
      out.write("            <form method=\"post\" action=\"../DeleteMessageServlet\">\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print(rs.getInt("id"));
      out.write("\">\n");
      out.write("                <button type=\"submit\" onclick=\"return confirm('Are you sure you want to delete this message?')\">Delete</button>\n");
      out.write("            </form>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");

    }

      out.write("\n");
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
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

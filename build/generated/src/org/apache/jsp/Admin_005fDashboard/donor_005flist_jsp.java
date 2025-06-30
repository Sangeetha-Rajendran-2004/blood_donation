package org.apache.jsp.Admin_005fDashboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class donor_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    String search = request.getParameter("search");
    boolean isSearch = (search != null && !search.trim().isEmpty());

    int page1 = 1;
    int recordsPerPage = 8;

    if (request.getParameter("page1") != null && !isSearch) {
        page1 = Integer.parseInt(request.getParameter("page1"));
    }

    int start = (page1 - 1) * recordsPerPage;

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");

    Statement stmt = con.createStatement();
    ResultSet rs;
    int totalRecords = 0;
    int totalPages = 1;

    if (isSearch) {
        String query = "SELECT * FROM donor_list WHERE name LIKE '" + search + "%' OR blood_group LIKE '" + search + "%' OR address LIKE '" + search + "%'";

        rs = stmt.executeQuery(query);
    } else {
        rs = stmt.executeQuery("SELECT * FROM donor_list LIMIT " + start + ", " + recordsPerPage);

        Statement countStmt = con.createStatement();
        ResultSet countRs = countStmt.executeQuery("SELECT COUNT(*) FROM donor_list");
        if (countRs.next()) {
            totalRecords = countRs.getInt(1);
        }
        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
        countRs.close();
        countStmt.close();
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Donor List</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css\">\n");
      out.write("        <style>\n");
      out.write("            .toggle-btn {\n");
      out.write("                padding: 5px 12px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                color: white;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .available {\n");
      out.write("                background-color: green;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .not-available {\n");
      out.write("                background-color: gray;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"admin-header\">\n");
      out.write("            <h1>Admin Dashboard</h1>\n");
      out.write("            <div class=\"admin-icon\">\n");
      out.write("                <i class=\"fa-solid fa-user-tie\"></i>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"admin-dashboard\">\n");
      out.write("            <li><i class=\"fa-solid fa-house\"></i><a href=\"home.jsp\">Home</a></li>\n");
      out.write("            <li><i class=\"fa-solid fa-user-plus\"></i><a href=\"add_donors.jsp\">Add Donors</a></li>\n");
      out.write("            <li><i class=\"fa-solid fa-list-ul\"></i><a href=\"donor_list.jsp\">Donor List</a></li>\n");
      out.write("            <li><i class=\"fa-solid fa-address-book\"></i><a href=\"update_contact.jsp\">Update Contact Info</a></li>\n");
      out.write("            <li><i class=\"fa-solid fa-envelope\"></i><a href=\"message.jsp\">Message</a></li>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"add-donor\">\n");
      out.write("            <!-- Search Form -->\n");
      out.write("            <form method=\"get\" action=\"donor_list.jsp\">\n");
      out.write("                <input type=\"search\" name=\"search\" value=\"");
      out.print( (search != null) ? search : "");
      out.write("\" placeholder=\"Search by name, blood group, or address\" class=\"search-donor\">\n");
      out.write("                <button type=\"submit\" style=\"padding:5px 10px;margin-left:10px\">Search</button>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Name</th>\n");
      out.write("                        <th>Blood Group</th>\n");
      out.write("                        <th>Phone</th>\n");
      out.write("                        <th>Email</th>\n");
      out.write("                        <th>Age</th>\n");
      out.write("                        <th>Address</th>\n");
      out.write("                        <th>Gender</th>\n");
      out.write("                        <th>Action</th>\n");
      out.write("                        <th>Available or Not</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        boolean hasResults = false;
                        while (rs.next()) {
                            hasResults = true;
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(rs.getString("name"));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString("blood_group"));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString("phone"));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString("email"));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString("age"));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString("address"));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString("gender"));
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("    <form method=\"post\" action=\"../deleteDonorServlet\" onsubmit=\"return confirm('Are you sure you want to delete this donor?');\">\n");
      out.write("        <input type=\"hidden\" name=\"email\" value=\"");
      out.print( rs.getString("email") );
      out.write("\">\n");
      out.write("        <button type=\"submit\">Delete</button>\n");
      out.write("    </form>\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("                        <td>\n");
      out.write("                            <button class=\"toggle-btn available\" onclick=\"toggleStatus(this)\">Available</button>\n");
      out.write("                        </td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                        if (!hasResults) {
                    
      out.write("\n");
      out.write("                    <tr><td colspan=\"8\" style=\"text-align:center;\">No results found</td></tr>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <!-- Pagination only if not in search mode -->\n");
      out.write("            ");
 if (!isSearch) { 
      out.write("\n");
      out.write("            <div style=\"margin-top: 20px;\">\n");
      out.write("                ");
 if (page1 > 1) {
      out.write("\n");
      out.write("                <a href=\"donor_list.jsp?page1=");
      out.print( page1 - 1);
      out.write("\" style=\"padding: 8px 15px; margin:2px; background-color: blue; color:white; text-decoration: none;\">Previous</a>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                ");
 for (int i = 1; i <= totalPages; i++) {
      out.write("\n");
      out.write("                <a href=\"donor_list.jsp?page1=");
      out.print( i);
      out.write("\" style=\"padding: 8px 15px; margin:2px; background-color: ");
      out.print( (i == page1) ? "blue" : "#f0f0f0");
      out.write("; color: ");
      out.print( (i == page1) ? "#fff" : "#000");
      out.write("; text-decoration: none;\">\n");
      out.write("                    ");
      out.print( i);
      out.write("\n");
      out.write("                </a>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                ");
 if (page1 < totalPages) {
      out.write("\n");
      out.write("                <a href=\"donor_list.jsp?page1=");
      out.print( page1 + 1);
      out.write("\" style=\"padding: 8px 15px; margin:2px; background-color: blue; color:white; text-decoration: none;\">Next</a>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            rs.close();
            stmt.close();
            con.close();
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function toggleStatus(btn) {\n");
      out.write("                if (btn.classList.contains(\"available\")) {\n");
      out.write("                    btn.classList.remove(\"available\");\n");
      out.write("                    btn.classList.add(\"not-available\");\n");
      out.write("                    btn.innerText = \"Not Available\";\n");
      out.write("                } else {\n");
      out.write("                    btn.classList.remove(\"not-available\");\n");
      out.write("                    btn.classList.add(\"available\");\n");
      out.write("                    btn.innerText = \"Available\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
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


import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import java.io.PrintWriter;
import javax.servlet.http.*;

public class updatecontactservlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Use correct port number (usually 3306)
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE updatecontact SET address=?,phone=?,email=?");

            ps.setString(1, address);
            ps.setString(2, phone);
            ps.setString(3, email);

            ps.executeUpdate();
            con.close();

            out.println("<script type='text/javascript'>");
            out.println("alert('Inserted Successfully');");
            out.println("window.location='Admin_Dashboard/update_contact.jsp';");
            out.println("</script>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }

    }
}

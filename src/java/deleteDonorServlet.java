import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class deleteDonorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");

            PreparedStatement ps = con.prepareStatement("DELETE FROM donor_list WHERE email = ?");
            ps.setString(1, email);

            int i = ps.executeUpdate();
            con.close();

            response.sendRedirect("Admin_Dashboard/donor_list.jsp"); // Refresh the donor list
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<pre>" + e + "</pre>");
        }
    }
}

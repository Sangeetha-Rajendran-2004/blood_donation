import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class updateStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String currentStatus = request.getParameter("status");
        
        // Toggle the status
        String newStatus = currentStatus.equals("Available") ? "Not Available" : "Available";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");

            PreparedStatement ps = con.prepareStatement("UPDATE donor_list SET status=? WHERE email=?");
            ps.setString(1, newStatus);
            ps.setString(2, email);
            ps.executeUpdate();
            con.close();

            response.sendRedirect("Admin_Dashboard/donor_list.jsp"); // redirect to donor list

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

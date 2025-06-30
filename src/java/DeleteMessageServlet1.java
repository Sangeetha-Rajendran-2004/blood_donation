import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DeleteMessageServlet1") // URL mapping
public class DeleteMessageServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String idStr = request.getParameter("id");

        // Safety check: ID should not be null or empty
        if (idStr == null || idStr.isEmpty()) {
            out.println("<script>alert('Invalid Request: ID missing'); window.location='Admin_Dashboard/message.jsp';</script>");
            return;
        }

        try {
            int id = Integer.parseInt(idStr); // Convert ID to int

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blood_donation?useSSL=false&serverTimezone=UTC", "root", "Root");

            PreparedStatement deleteStmt = con.prepareStatement(
                "DELETE FROM message WHERE id = ?");
            deleteStmt.setInt(1, id);

            int rowsDeleted = deleteStmt.executeUpdate();
            con.close();

            if (rowsDeleted > 0) {
                out.println("<script>alert('Message deleted successfully'); window.location='Admin_Dashboard/message.jsp';</script>");
            } else {
                out.println("<script>alert('No record found to delete'); window.location='Admin_Dashboard/message.jsp';</script>");
            }

        } catch (NumberFormatException e) {
            out.println("<script>alert('Invalid ID format'); window.location='Admin_Dashboard/message.jsp';</script>");
        } catch (Exception e) {
            e.printStackTrace(out); // Debug error
        }
    }
}

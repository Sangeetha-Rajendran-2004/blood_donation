import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;


public class DeleteMessageServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
  
        String email = request.getParameter("email");
        
      

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Use correct port number (usually 3306)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");

            PreparedStatement deleteStmt = con.prepareStatement(
                        "DELETE FROM message WHERE name=? AND phone=? AND email=?");
            
          
            
            deleteStmt.setString(3, email);
            deleteStmt.executeUpdate();
            
            
            con.close();

            out.println("<script type='text/javascript'>");
            out.println("alert('Deleted Successfully');");
            out.println("window.location='Admin_Dashboard/message.jsp';");
            out.println("</script>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
        
    }
}
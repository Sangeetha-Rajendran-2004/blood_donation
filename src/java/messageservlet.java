
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class messageservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String message=request.getParameter("message");
                
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Use correct port number (usually 3306)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO message(name, phone, email, message) VALUES (?, ?, ?, ?)");
            
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setString(4, message);
            
            ps.executeUpdate();
            con.close();
            
            out.println("<script type='text/javascript'>");
            out.println("alert('Inserted Successfully');");
            out.println("window.location='User_Dashboard/contactus.jsp';");
            out.println("</script>");
        }
        catch (Exception e) {
            e.printStackTrace();
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
    }

}
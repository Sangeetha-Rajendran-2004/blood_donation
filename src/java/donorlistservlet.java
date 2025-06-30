import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;


public class donorlistservlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
        String name = request.getParameter("name");
        String blood_group = request.getParameter("blood_group");
        String phone = request.getParameter("phone");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
      

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Use correct port number (usually 3306)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO donor_list(name, blood_group, phone, email, age, address, gender) VALUES (?,?, ?, ?, ?, ?, ?)");
            
            ps.setString(1, name);
            ps.setString(2, blood_group);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, age);
            ps.setString(6, address);
            ps.setString(7, gender);
            
           


            int i=ps.executeUpdate();
            
             if (i > 0) {
                PreparedStatement deleteStmt = con.prepareStatement(
                        "DELETE FROM donors WHERE name=? AND phone=? AND email=?");
                deleteStmt.setString(1, name);
                deleteStmt.setString(2, phone);
                deleteStmt.setString(3, email);
                deleteStmt.executeUpdate();
            }
            con.close();

            out.println("<script type='text/javascript'>");
            out.println("alert('Updated Successfully');");
            out.println("window.location='Admin_Dashboard/add_donors.jsp';");
            out.println("</script>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
        
    }
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Replace with your actual admin credentials
        if ("admin".equals(username) && "admin123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", username);
            response.sendRedirect("Admin_Dashboard/home.jsp");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            response.sendRedirect("Admin_Dashboard/home.jsp?error=1");

        }
    }
}

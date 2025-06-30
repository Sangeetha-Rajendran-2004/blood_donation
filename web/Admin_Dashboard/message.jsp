<%-- 
    Document   : message
    Created on : 27 Jun, 2025, 7:31:11 PM
    Author     : Sange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;" %>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_donation?useSSL=false&serverTimezone=UTC", "root", "Root");

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM message");
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Message</title>
     <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

</head>
<body>
    <div class="admin-header">
        <h1>Admin Dashboard</h1>
        <div class="admin-icon">
            <i class="fa-solid fa-user-tie" ></i>
        </div>
    </div>
    <div class="admin-dashboard">
        <li><i class="fa-solid fa-house"></i><a href="home.jsp">Home</a></li>
         <li><i class="fa-solid fa-user-plus"></i> <a href="add_donors.jsp">Add Donors</a></li>
        <li><i class="fa-solid fa-list-ul"></i> <a href="donor_list.jsp">Donor List</a></li>
        <li><i class="fa-solid fa-address-book"></i> <a href="update_contact.jsp">Update Contact Info</a></li>
        <li><i class="fa-solid fa-envelope"></i> <a href="message.jsp">Message</a></li>
    </div>

    <div class="add-donor">
       <table >
    <thead>
        <tr>
            <th>Full Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Message</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <%
    while(rs.next()){
%>
    <tr>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getString("phone")%></td>
        <td><%=rs.getString("email")%></td>
        <td><%=rs.getString("message")%></td>
        <td>
                <form method="post" action="../DeleteMessageServlet1">
    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
    <button type="submit" onclick="return confirm('Are you sure you want to delete this message?')">Delete</button>
</form>
        </td>
 

    </tr>
<%
    }
%>

    </tbody>
</table>
</body>
</html>

<%-- 
    Document   : add_donors.jsp
    Created on : 27 Jun, 2025, 7:30:29 PM
    Author     : Sange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_donation?useSSL=false&serverTimezone=UTC", "root", "Root");

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM donors");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Donors</title>
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
                        <th>Name</th>
                        <th>Blood Group</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Age</th>
                        <th>Address</th>
                        <th>Gender</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        while (rs.next()) {
                    %>

                    <tr>
                        <td><%=rs.getString("name")%></td>
                        <td><%=rs.getString("blood_group")%></td>
                        <td><%=rs.getString("phone")%></td>
                        <td><%=rs.getString("email")%></td>
                        <td><%=rs.getString("age")%></td>
                        <td><%=rs.getString("address")%></td>
                        <td><%=rs.getString("gender")%></td>

                        <td>
                            <form method="post" action="../donorlistservlet">
                                <input type="hidden" name="name" value="<%=rs.getString("name")%>">
                                <input type="hidden" name="blood_group" value="<%=rs.getString("blood_group")%>">
                                <input type="hidden" name="phone" value="<%=rs.getString("phone")%>">
                                <input type="hidden" name="email" value="<%=rs.getString("email")%>">
                                <input type="hidden" name="age" value="<%=rs.getString("age")%>">
                                <input type="hidden" name="address" value="<%=rs.getString("address")%>">
                                <input type="hidden" name="gender" value="<%=rs.getString("gender")%>">
                                <button>update</button></a>
                                
                            </form>

                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

        </div>
    </body>
</html>

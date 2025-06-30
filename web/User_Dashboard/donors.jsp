<%-- 
    Document   : donors
    Created on : 27 Jun, 2025, 7:32:22 PM
    Author     : Sange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;" %>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM updatecontact");
    Statement stmt1 = con.createStatement(); // ✅ Separate statement
    ResultSet rs1 = stmt1.executeQuery("SELECT * FROM donor_list");
%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Donors</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <style>
            .donor-card {
                border: 1px solid #ccc;
                border-radius: 8px;
                padding: 15px;
                margin: 10px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
                background-color: #fdfdfd;
                width: 300px;
            }

        </style>

    </head>

    <body>
        <%
            while (rs.next()) {
        %> 
        <div class="header">
            <ul class="header-content">
                <li><img src="../images/logo.png" alt="logo" class="logo-img"></li>
                <li>
                    <p class="slogan">"Be someone's superhero. Donate blood today."</p>
                </li>
                <li>
                    <p class="phone">+91<%=rs.getString("phone")%></p>
                </li>
                <li>
                    <p class="email"><%=rs.getString("email")%></p>
                </li>
            </ul>
        </div>

        <div class="nav">
            <ul class="nav-content">
                <li class="nav-names"><a href="home.jsp"><i class="fa fa-home"></i> Home</li></a>
                <li class="nav-names"><a href="about.jsp" target=""><i class="fa fa-info-circle"></i> About Us</li>
                </a>
                <li class="nav-names"><a href="why_donate_blood.jsp"><i class="fa fa-heartbeat"></i> Why
                        Donate Blood</li></a>
                <li class="nav-names"><a href="become_donor.jsp"><i class="fa fa-user-plus"></i> Become Donor
                </li></a>
                <li class="nav-names"><a href="donors.jsp"><i class="fa fa-users"></i> View Donors</li></a>
                <li class="nav-names"><a href="need_blood.jsp"><i class="fa fa-tint"></i> Need Blood</li></a>
                <li class="nav-names"><a href="contactus.jsp"><i class="fa fa-envelope"></i> Contact Us</li></a>
            </ul>
        </div>

        <div class="donor-page">
            <% while (rs1.next()) {%>


            <div class="donor-card">
                <% if ("Not Available".equalsIgnoreCase(rs1.getString("status"))) { %>
                <h2 style="color: white; background-color: gray; padding: 8px; text-align: center; border-radius: 5px;">
                    Not Available
                </h2>
                <% }%>


                <div class="donor-info">
                    <h2><i class="fa fa-user"></i> <%=rs1.getString("name")%> (<%=rs1.getString("blood_group")%>)</h2>
                    <p><strong>Blood Group:</strong> <%=rs1.getString("blood_group")%></p>
                    <p><strong>Phone:</strong> <%=rs1.getString("phone")%></p>
                    <p><strong>Email:</strong> <%=rs1.getString("email")%></p>
                    <p><strong>Age:</strong> <%=rs1.getString("age")%></p>
                    <p><strong>Address:</strong> <%=rs1.getString("address")%></p>
                    <p><strong>Gender:</strong> <%=rs1.getString("gender")%></p>
                </div>
            </div>

            <%}%>
        </div>



        <div class="footer">
            <div class="quick-links">
                <h1>Quick Links</h1>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="why_donate_blood.jsp">Why Donate Blood</a></li>
                <li><a href="become_donor.jsp">Become Donor</a></li>
                <li><a href="donors.jsp">View Donors</a></li>
                <li><a href="need_blood.jsp">Need Blood</a></li>
                <li><a href="contactus.jsp">Contact Us</a></li>
            </div>

            <div class="footer-contact">
                <h1>Contact Us</h1>
                <p>Address:<%=rs.getString("address")%></p>
                <p>Phone number:<%=rs.getString("phone")%></p>
                <p>Email:<%=rs.getString("email")%></p>
            </div>

            <div class="footer-icon">
                <h1>Follow Us</h1>
                <a href="https://facebook.com" target="_blank"><i class="fab fa-facebook-f"></i></a>
                <a href="https://instagram.com" target="_blank"><i class="fab fa-instagram"></i></a>

            </div>
        </div>
        <div class="copyrights">
            <p>&copy;2025 Blood Donation Website.All rights reserved By Sangeetha Rajendran.</p>
        </div>
        <%}%>
        <%
            rs.close();
            stmt.close();
            rs1.close();
            stmt1.close();
            con.close();
        %>

    </body>

</html>

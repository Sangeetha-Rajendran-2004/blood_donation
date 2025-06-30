<%-- 
    Document   : about
    Created on : 27 Jun, 2025, 7:31:49 PM
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
%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>About Us</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

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

        <div class="about">
            <div class="about-content">
                <img src="../images/banner2.jpg" alt="banner2" class="about-img">
            </div>
            <div class="about-section">
                <h2 class="about-h2"><i class="fa fa-info-circle"></i> About Us</li>
                </h2>
                <p class="about-p">
                    We are a dedicated non-profit organization working to promote the importance of voluntary blood
                    donation.
                    Our mission is to ensure that every patient in need of blood gets it on time, safely and freely.
                </p>

                <p class="about-p">
                    Founded by a team of compassionate individuals, our organization connects willing blood donors with
                    hospitals,
                    blood banks, and patients through a digital platform. We believe that donating blood is one of the
                    noblest
                    acts of kindness that saves lives and brings communities together.
                </p>

                <p class="about-p">
                    Through awareness campaigns, blood donation drives, and technology-powered services, we aim to create a
                    culture of regular voluntary blood donation. Our platform makes it easier for people to register as
                    donors,
                    request blood in emergencies, and view donor availability across locations.
                </p>

                <p class="about-p">
                    Join us in our journey to save lives. Your single act of donation can be someone’s second chance at
                    life.
                </p>
            </div>

        </div>

        <div class="footer">
            <div class="quick-links">
                <h1>Quick Links</h1>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="why_donate_blood.jsp">Why Donate Blood</a></li>
                <li><a href="become_donar.jsp">Become Donor</a></li>
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

    </body>

</html>

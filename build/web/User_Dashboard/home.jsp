<%-- 
    Document   : home
    Created on : 27 Jun, 2025, 7:32:31 PM
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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Blood Donation Website</title>
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
                <li class="nav-names"><a href="about.jsp#about" target=""><i class="fa fa-info-circle"></i> About Us</li>
                </a>
                <li class="nav-names"><a href="why_donate_blood.jsp#why_donate_blood"><i class="fa fa-heartbeat"></i> Why
                        Donate Blood</li></a>
                <li class="nav-names"><a href="become_donor.jsp#become_donor"><i class="fa fa-user-plus"></i> Become Donor
                </li></a>
                <li class="nav-names"><a href="donors.jsp#donors"><i class="fa fa-users"></i> View Donors</li></a>
                <li class="nav-names"><a href="need_blood.jsp#need_blood"><i class="fa fa-tint"></i> Need Blood</li></a>
                <li class="nav-names"><a href="contactus.jsp#contactus"><i class="fa fa-envelope"></i> Contact Us</li></a>
            </ul>
        </div>

        <div class="home">
            <div class="home-content">
                <img src="../images/banner.jpg" alt="banner" class="banner-img">
            </div>
            <div class="slogan1">
                <p class="slogan1-content"><i class="fa fa-tint"></i> Donate Blood and Save Lives</li>
                </p>
                <button class="slogan1-button"><a href="need_blood.jsp">Need Blood</a></button>
                <button class="slogan1-button"><a href="become_donor.jsp">Become Donar</a></button>
            </div>
        </div>




        <div class="blood-donor-day">
            <img src="../images/banner7.jpg" alt="banner7" style="width: 600px; height: 400px;" class="banner7">
            <div class="donor-day-content">
                <h1>🩸 World Blood Donor Day - June 14</h1>
                <p>World Blood Donor Day is observed every year on June 14 to raise global awareness of the need for safe
                    blood and blood products for transfusion. It also serves as a special day to thank voluntary, unpaid
                    blood donors for their life-saving gifts of blood.</p>
                <h1>🌍 Why is it celebrated?</h1>
                <p>To highlight the importance of voluntary, safe, and unpaid blood donation.

                    To ensure adequate supplies of safe blood for patients in need.

                    To promote a culture of regular blood donation in society.</p>
                <h1>❤️ Significance of Blood Donation</h1>
                <p>Every two seconds, someone in the world needs blood.

                    A single blood donation can save up to three lives.

                    Blood cannot be manufactured – it only comes from healthy donors.

                    Donated blood is used in surgeries, accident care, cancer treatment, and childbirth.</p>
            </div>
        </div>

        <div class="process">
            <div class="process-card">
                <i class="fa-regular fa-clock"></i>
                <p>It takes only an hour</p>

                <p>Donate blood save lives!</p>


            </div>
            <div class="process-card">
                <i class="fa-solid fa-glass-water"></i>
                <p>You will get free refreshments after donation</p>

                <p>Donation of blood is safe and healthy</p>
            </div>
            <div class="process-card">
                <i class="fa-solid fa-indian-rupee-sign"></i>
                <p>it costs nothing</p>

                <p>Give blood and stay healthy</p>


            </div>
            <div class="process-card">
                <i class="fa-solid fa-heart-pulse"></i>
                <p>There is nothing better than saving a life</p>

                <p>Every blood donor is a hero</p>

            </div>
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
    </body>

</html>

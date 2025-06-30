<%-- 
    Document   : become_donor
    Created on : 27 Jun, 2025, 7:32:01 PM
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
        <title>Become Donor</title>
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


        <div class="become-donar">
            <div class="become-donor-img">
                <img src="../images/banner4.avif" alt="banner4" style="width: 600px; height: 600px;">
            </div>
            <div class="become-donor-form">
                <h1 class="become-donor-h1"><i class="fa fa-user-plus"></i> Become Donor
                    </li>
                </h1>
                <form action="../becomedonorservlet" class="become-donar-form1" method="post">
                    <input type="text" placeholder="Name" required class="donor-form-input" name="name">
                    <select class="donor-form-input" name="blood_group">
                        <option value="" hidden="displayed" >Blood Group</option>
                        <option value="A+">A Positive(A+)</option>
                        <option value="A-">A Negative(A-)</option>
                        <option value="B+">B Positive(B+)</option>
                        <option value="B-">B Negative(B-)</option>
                        <option value="O+">O Positive(O+)</option>
                        <option value="O-">O Negative(O-)</option>
                        <option value="AB+">AB Positive(AB+)</option>
                        <option value="AB-">AB Negative(AB-)</option>
                    </select>
                    <input type="text" placeholder="Phone" required class="donor-form-input" name="phone">
                    <input type="email" placeholder="email" required class="donor-form-input" name="email">
                    <input type="text" placeholder="age" required class="donor-form-input" name="age">
                    <input type="text" placeholder="Address" required class="donor-form-input" name="address">
                    <select class="donor-form-input" name="gender">
                        <option value="--Select Gender--">Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="Transgender">Transgender</option>
                    </select>
                    <button type="submit" class="donor-form-button">Submit</button>
                </form>

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

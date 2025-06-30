<%-- 
    Document   : why_donate_blood
    Created on : 27 Jun, 2025, 7:32:56 PM
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
        <title>Why Donate Blood</title>
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

        <div class="why_donate_blood">
            <div class="why_donate_blood-img">
                <img src="../images/banner3.jpg" alt="banner3" class="donate_blood-img">
            </div>
            <div class="why_donate_blood-content">
                <h2 class="donate-blood-h2"><i class="fa fa-heartbeat"></i> Why
                    Donate Blood</li>
                </h2>

                <p class="donate-blood-p">
                    Blood donation is one of the most selfless and life-saving acts a person can do. Every two seconds,
                    someone in the world needs blood—be it due to an accident, surgery, cancer treatment, or chronic
                    illness. A single donation can save up to three lives.
                </p>

                <p class="donate-blood-p">
                    Unlike medicines or other treatments, blood cannot be manufactured. It can only come from generous
                    donors like you. Regular blood donation helps ensure that blood is available when it is most needed,
                    especially during emergencies and medical procedures.
                </p>

                <p class="donate-blood-p">
                    Apart from saving lives, donating blood also offers health benefits to the donor. It stimulates the
                    production of new blood cells and can help maintain a healthy iron level. It’s a quick, simple, and safe
                    process that takes just 15-20 minutes but makes a lasting difference.
                </p>

                <p class="donate-blood-p">
                    By donating blood, you become a hero in someone’s life. Your contribution brings hope, heals families,
                    and strengthens our communities.
                </p class="donate-blood-p">

                <h3 class="donate-blood-h2">Top Reasons to Donate Blood</h3>
                <ul>
                    <li class="donate-blood-p">🩸 You can save up to 3 lives with one donation.</li>
                    <li class="donate-blood-p">🩺 It’s good for your own health — promotes blood renewal.</li>
                    <li class="donate-blood-p">❤️ It connects you to the community in a meaningful way.</li>
                    <li class="donate-blood-p">⚕️ Hospitals always need a stable supply of blood for emergencies.</li>
                    <li class="donate-blood-p">🌍 It creates awareness and encourages others to donate too.</li>
                </ul>

                <p class="donate-blood-p" style="font-weight: bold; color: red; font-size: 30px;">
                    Be the reason someone lives. Become a blood donor today!
                </p>
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
</html>

<%-- 
    Document   : need_blood
    Created on : 27 Jun, 2025, 7:32:44 PM
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
    
   String selectedGroup = request.getParameter("blood-group");

PreparedStatement ps = con.prepareStatement("SELECT * FROM donor_list WHERE blood_group = ?");
ps.setString(1, selectedGroup);
ResultSet rs1 = ps.executeQuery();


%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Need Blood</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    </head>

    <body>
        <%            while (rs.next()) {
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

        <div class="need-blood">
            <div class="need-blood-form">
                <form action="need_blood.jsp" class="need-blood-form1" method="get">
                    <h1 class="need-blood-h1"><i class="fa fa-tint"></i> Need Blood</li>
                    </h1>
                    <select name="blood-group" id="blood-group" class="select">
                        <option value="" disabled selected>Blood Group</option>
                        <option value="A+">A positive (A+)</option>
                        <option value="A-">A negative (A-)</option>
                        <option value="B+">B positive (B+)</option>
                        <option value="B-">B negative (B-)</option>
                        <option value="AB+">AB positive (AB+)</option>
                        <option value="AB-">AB negative (AB-)</option>
                        <option value="O+">O positive (O+)</option>
                        <option value="O-">O negative (O-)</option>
                    </select>

                    <textarea name="reason" id="reason" placeholder="Reason why do you need blood"
                              class="select1"></textarea>
                    <button type="submit" class="need-blood-button">Search <i class="fas fa-search"></i></button>
                </form>
            </div>
        </div>

        <div class="donors-list">
            <% while(rs1.next()){%>
            <div  class="donor-card1">
                 <% if ("Not Available".equalsIgnoreCase(rs1.getString("status"))) { %>
                <h2 style="color: white; background-color: gray; padding: 8px; text-align: center; border-radius: 5px;">
                    Not Available
                </h2>
                <% }%>
                <p><strong>Name:</strong><%=rs1.getString("name")%></p>
                <p><strong>Blood:</strong><%=rs1.getString("blood_group")%></p>
                <p><strong>Age:</strong><%=rs1.getString("age")%></p>
                <p><strong>Gender:</strong><%=rs1.getString("gender")%></p>
                <p><strong>Phone:</strong><%=rs1.getString("phone")%></p>
                <p><strong>Email:</strong><%=rs1.getString("email")%></p>
                <p><strong>Address:</strong><%=rs1.getString("address")%></p>
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

    </body>

</html>

<%-- 
    Document   : update_contact
    Created on : 27 Jun, 2025, 7:31:28 PM
    Author     : Sange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Contact</title>
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

    <div class="contact-update">
        <form method="post" action="../updatecontactservlet">
              <label for="address" class="label1">Address</label>
        <input type="text" placeholder="address" class="input1" name="address">
        <label for="contact-number" class="label2">Phonenumber</label>
        <input type="text" placeholder="Phone number" class="input2" name="phone">
        <label for="email" class="label3">Email</label>
        <input type="email" placeholder="Email" class="input3" name="email">
        <button type="submit" class="contact-update-button">Update Contact</button>
        </form>
      
    </div>
</body>
</html>

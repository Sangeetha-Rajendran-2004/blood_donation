<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <style>
        .modal {
            display: flex;
            position: fixed;
            z-index: 9999;
            left: 0; top: 0;
            width: 100%; height: 100%;
            background-color: rgba(0,0,0,0.5);
            justify-content: center;
            align-items: center;
        }

        .login-box {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px #000;
            width: 300px;
            text-align: center;
            position: relative;
        }

        .login-box input {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            font-size: 16px;
        }

        .login-box button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }

        .close-btn {
            position: absolute;
            top: 10px;
            right: 15px;
            font-size: 20px;
            cursor: pointer;
            color: #333;
        }
    </style>

   <script>
    window.onload = function () {
        // Get URL parameter for login error
        const urlParams = new URLSearchParams(window.location.search);
        const loginError = urlParams.get('error');

        // If error=1, it means login failed
        if (loginError === '1') {
            // Clear previous popupShown state (so popup appears again)
            sessionStorage.removeItem("popupShown");
        }

        // Now handle popup as usual
        if (!sessionStorage.getItem("popupShown")) {
            document.getElementById("loginModal").style.display = "flex";
            sessionStorage.setItem("popupShown", "true");
        } else {
            document.getElementById("loginModal").style.display = "none";
        }
    };
</script>


</head>
<body>

<!-- Admin Dashboard content -->
<div class="admin-header">
    <h1>Admin Dashboard</h1>
    <div class="admin-icon">
        <i class="fa-solid fa-user-tie"></i>
    </div>
</div>
<div class="admin-dashboard">
    <li><i class="fa-solid fa-house"></i><a href="home.jsp">Home</a></li>
    <li><i class="fa-solid fa-user-plus"></i><a href="add_donors.jsp">Add Donors</a></li>
    <li><i class="fa-solid fa-list-ul"></i><a href="donor_list.jsp">Donor List</a></li>
    <li><i class="fa-solid fa-address-book"></i><a href="update_contact.jsp">Update Contact Info</a></li>
    <li><i class="fa-solid fa-envelope"></i><a href="message.jsp">Message</a></li>
</div>
<div class="welcome-admin">
    <img src="../images/welcome-admin-banner1.jpg" alt="welcome-admin-banner1" class="welcome-admin-banner1" style="width: 100%; height: 100%;">
    <h1>WELCOME ADMIN</h1>
</div>

<!-- Login Modal (shows on every page load) -->
<div id="loginModal" class="modal">
    <div class="login-box">
        <span class="close-btn" onclick="document.getElementById('loginModal').style.display='none'">&times;</span>
        <h2>Admin Login</h2>
        <form action="../AdminLoginServlet" method="post">
            <input type="text" name="username" placeholder="Enter Username" required />
            <input type="password" name="password" placeholder="Enter Password" required />
            <button type="submit">Login</button>
        </form>
    </div>
</div>

</body>
</html>

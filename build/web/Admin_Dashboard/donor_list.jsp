<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    String search = request.getParameter("search");
    boolean isSearch = (search != null && !search.trim().isEmpty());

    int page1 = 1;
    int recordsPerPage = 6;

    if (request.getParameter("page1") != null && !isSearch) {
        page1 = Integer.parseInt(request.getParameter("page1"));
    }

    int start = (page1 - 1) * recordsPerPage;

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_donation?useSSL=false", "root", "Root");

    Statement stmt = con.createStatement();
    ResultSet rs;
    int totalRecords = 0;
    int totalPages = 1;

    if (isSearch) {
        String query = "SELECT * FROM donor_list WHERE name LIKE '" + search + "%' OR blood_group LIKE '" + search + "%' OR address LIKE '" + search + "%'";

        rs = stmt.executeQuery(query);
    } else {
        rs = stmt.executeQuery("SELECT * FROM donor_list LIMIT " + start + ", " + recordsPerPage);

        Statement countStmt = con.createStatement();
        ResultSet countRs = countStmt.executeQuery("SELECT COUNT(*) FROM donor_list");
        if (countRs.next()) {
            totalRecords = countRs.getInt(1);
        }
        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
        countRs.close();
        countStmt.close();
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Donor List</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <style>
            .toggle-btn {
                padding: 5px 12px;
                border: none;
                border-radius: 5px;
                color: white;
                cursor: pointer;
            }

            .available {
                background-color: blue;
            }

            .not-available {
                background-color: gray;
            }

        </style>
    </head>
    <body>
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

        <div class="add-donor">
            <!-- Search Form -->
            <form method="get" action="donor_list.jsp">
                <input type="search" name="search" value="<%= (search != null) ? search : ""%>" placeholder="Search by name, blood group, or address" class="search-donor">
                <button type="submit" style="padding:5px 10px;margin-left:10px">Search</button>
            </form>

            <table>
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
                        <th>Available or Not</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        boolean hasResults = false;
                        while (rs.next()) {
                            hasResults = true;
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
                            <form method="post" action="../deleteDonorServlet" onsubmit="return confirm('Are you sure you want to delete this donor?');">
                                <input type="hidden" name="email" value="<%= rs.getString("email")%>">
                                <button type="submit">Delete</button>
                            </form>
                        </td>

                       <td>
    <form method="post" action="../updateStatusServlet">
        <input type="hidden" name="email" value="<%= rs.getString("email")%>">
        <%
            String status = rs.getString("status");
            String buttonClass = "not-available";
            if ("Available".equalsIgnoreCase(status)) {
                buttonClass = "available";
            }
        %>
        <input type="hidden" name="status" value="<%= (status != null) ? status : "Not Available" %>">
        <button type="submit" class="toggle-btn <%= buttonClass %>">
            <%= (status != null) ? status : "Not Available" %>
        </button>
    </form>
</td>


                    </tr>
                    <%
                        }
                        if (!hasResults) {
                    %>
                    <tr><td colspan="8" style="text-align:center;">No results found</td></tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <!-- Pagination only if not in search mode -->
            <% if (!isSearch) { %>
            <div style="margin-top: 20px;">
                <% if (page1 > 1) {%>
                <a href="donor_list.jsp?page1=<%= page1 - 1%>" style="padding: 8px 15px; margin:2px; background-color: blue; color:white; text-decoration: none;">Previous</a>
                <% } %>

                <% for (int i = 1; i <= totalPages; i++) {%>
                <a href="donor_list.jsp?page1=<%= i%>" style="padding: 8px 15px; margin:2px; background-color: <%= (i == page1) ? "blue" : "#f0f0f0"%>; color: <%= (i == page1) ? "#fff" : "#000"%>; text-decoration: none;">
                    <%= i%>
                </a>
                <% } %>

                <% if (page1 < totalPages) {%>
                <a href="donor_list.jsp?page1=<%= page1 + 1%>" style="padding: 8px 15px; margin:2px; background-color: blue; color:white; text-decoration: none;">Next</a>
                <% } %>
            </div>
            <% } %>

        </div>

        <%
            rs.close();
            stmt.close();
            con.close();
        %>
        <script>
            function toggleStatus(btn) {
                if (btn.classList.contains("available")) {
                    btn.classList.remove("available");
                    btn.classList.add("not-available");
                    btn.innerText = "Not Available";
                } else {
                    btn.classList.remove("not-available");
                    btn.classList.add("available");
                    btn.innerText = "Available";
                }
            }
        </script>

    </body>
</html>

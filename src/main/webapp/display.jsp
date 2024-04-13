<%@ page import="java.util.List" %>
<%@ page import="models.ContactModel" %>
<%@ page import="dao.ContactDao" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: sasin
  Date: 4/12/2024
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Page</title>
    <link rel="stylesheet" href="./css/display.css">
</head>
<body>
<div class="container">
    <h1>All Contacts</h1>
    <table class="rwd-table">
        <tbody>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Social Media</th>
            <th>Action</th>
        </tr>

        <%
            List<ContactModel> contactList;
            try {
                ContactDao contactDao = new ContactDao();

                contactList = contactDao.getAllContact();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            for(ContactModel contact:contactList){
        %>

        <tr>
            <td data-th="Supplier Name">
                <%=contact.getId()%>
            </td>
            <td data-th="Supplier Name">
                <%=contact.getName()%>
            </td>
            <td data-th="Invoice Number">
                <%=contact.getEmail()%>
            </td>
            <td data-th="Invoice Date">
                <%=contact.getPhone()%>
            </td>
            <td data-th="Due Date">
                <%=contact.getSocial()%>
            </td>
            <td data-th="Due Date" class="action-data">
                <div>
                    <form action="update.jsp" method="post">
                        <input type="hidden" name="contactId" id="contactId" value="<%=contact.getId()%>" >
                        <button class="btn" type="submit">Edit</button>
                    </form>
                </div>
                <div>
                    <form action="delete" method="post">
                        <input type="hidden" name="contactId" id="id" value="<%=contact.getId()%>" >
                        <button class="btn" type="submit">Delete</button>
                    </form>
                </div>
            </td>
        </tr>

        <% }%>
        </tbody>
    </table>

</div>
</body>
</html>

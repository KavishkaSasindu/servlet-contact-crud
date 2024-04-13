<%@ page import="models.ContactModel" %>
<%@ page import="dao.ContactDao" %><%--
  Created by IntelliJ IDEA.
  User: sasin
  Date: 4/12/2024
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Page</title>
  <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div class="container">

  <%
    int contactId = Integer.parseInt(request.getParameter("contactId"));
    ContactModel contactModel = null;
    try{
      ContactDao contactDao = new ContactDao();
      contactModel = contactDao.getOneContact(contactId);
    }catch(Exception e){
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    %>



  <form id="contact" action="update" method="post">
    <h3>Update Contact</h3>
    <h4>Contact us for custom quote</h4>
    <fieldset>
      <input placeholder="Your Id" type="hidden" name="contactId" tabindex="1" value="<%=contactModel.getId()%>" required autofocus >
    </fieldset>
    <fieldset>
      <input placeholder="Your name" type="text" name="name" tabindex="1" value="<%=contactModel.getName()%>" required autofocus>
    </fieldset>
    <fieldset>
      <input placeholder="Your Email Address" name="email" type="email" tabindex="2" value="<%=contactModel.getEmail()%>" required>
    </fieldset>
    <fieldset>
      <input placeholder="Your Phone Number" name="phone" type="tel" tabindex="3" value="<%=contactModel.getPhone()%>" required>
    </fieldset>
    <fieldset>
      <input placeholder="Your any social media link" name="social" type="url" value="<%=contactModel.getSocial()%>" tabindex="4" required>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Update</button>
    </fieldset>
  </form>
</div>
</body>
</html>

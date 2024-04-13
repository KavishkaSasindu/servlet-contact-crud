<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Add Contact</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div class="container">
    <form id="contact" action="add" method="post">
        <h3>Add a Contact</h3>
        <h4>Contact us for custom quote</h4>
        <fieldset>
            <input placeholder="Your name" type="text" name="name" tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input placeholder="Your Email Address" name="email" type="email" tabindex="2" required>
        </fieldset>
        <fieldset>
            <input placeholder="Your Phone Number" name="phone" type="tel" tabindex="3" required>
        </fieldset>
        <fieldset>
            <input placeholder="Your any social media link" name="social" type="url" tabindex="4" required>
        </fieldset>
        <fieldset>
            <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>
    </form>
</div>
</body>
</html>
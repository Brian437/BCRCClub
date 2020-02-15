<%-- 
    Document   : BCRCIndex
    Created on : Jan 21, 2013, 3:08:16 PM
    Author     : Brian Chaves & RJ Coulton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="BCRCBanner.jsp" /> 
    <center>
         <h4>Java Web Technologies</h4>
         Section 2<br />
         <h4>Pair Programming Team</h4>
         Driver: Brian Chaves<br />
         Observer: RJ Coulton<br />
         Current Date and Time is:  <%= new java.util.Date() %>
    </center>
    </body>
</html>

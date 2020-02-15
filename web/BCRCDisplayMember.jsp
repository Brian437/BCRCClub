<%-- 
    Document   : BCRCDisplayMember
    Created on : Jan 21, 2013, 3:02:19 PM
    Author     : Brian Chaves & RJ Coulton
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Display Member</title>
</head>
<body>
    <jsp:include page="BCRCBanner.jsp" />

    <%
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String program = request.getParameter("program");
        String year = request.getParameter("year");
        
    %>
    <h1>Thanks for joining our club</h1>

    <p>Here is the information that you entered:</p>

    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <td align="right">Full Name:</td>
            <td><%=fullName  %></td>
        </tr>
        <tr>
            <td align="right">Email:</td>
            <td><%= email %></td>
        </tr>
        <tr>
            <td align="right">Phone Number</td>
            <td><%= number %></td>
        </tr>
        <tr>
            <td align="right">Degree/Program</td>
            <td><%= program %></td>
        </tr>
        <tr>
            <td align="right">Year:</td>
            <td><%= year %></td>
        </tr>
    </table>

    <p>To register another member, click on the Back <br>
    button in your browser or the Return button shown <br>
    below.</p>

    <form action="BCRCRegister.jsp" method="get">
        <input type="submit" value="Return">
    </form>

</body>
</html>
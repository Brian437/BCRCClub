<%-- 
    Document   : newjspBCMembers
    Created on : 4-Apr-2013, 9:18:38 PM
    Author     : Brian Chaves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Members</title>
        <jsp:include page="BCRCBanner.jsp" />
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Full Name</th>
                <th>Email Address</th>
                <th>Phone Number</th>
                <th>Program</th>
                <th>Year</th>
            </tr>
            <c:forEach var="member" items="${members}" >
                <tr>
                    <td>${member.fullName}</td>
                    <td>${member.emailAddress}</td>
                    <td>${member.phoneNumber}</td>
                    <td>${member.programName}</td>
                    <td>${member.yearLevel}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

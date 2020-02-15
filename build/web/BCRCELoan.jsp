<%-- 
    Document   : BCRCLoan
    Created on : Mar 18, 2013, 3:16:56 PM
    Updated on : Mar 25. 2013
    Author     : Brian Chaves & RJ Coulton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="club.business.Book"%>
<%@page import="club.business.ELoan" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eLoan</title>
    </head>
    <body>
        <jsp:include page="BCRCBanner.jsp" />
        <title>eLoan</title>
        <table border="1">
            <tr style="font-weight: bold">
                <td>Code</td>
                <td>Description</td>
                <td>QOH</td>
                <td>Action</td>
            </tr>
            <c:forEach var="item" items="${loanItems}">
                <tr>
                    <td>${item.code}</td>
                    <td>${item.description}</td>
                    <td style="text-align: right">${item.quantity}</td>
                    <td>
                        <c:if test="${item.quantity >= 1}">
                            <a href="<c:url value=
                                'BCRCCart?action=reserve&code=${item.code}'
                                />">
                                
                                Reserve
                            </a>
                        </c:if>
                        <c:if test="${item.quantity ==0}">
                            N/A
                        </c:if>
                    </td>
                </tr>
            </c:forEach>        
        </table>
    </body>
</html>

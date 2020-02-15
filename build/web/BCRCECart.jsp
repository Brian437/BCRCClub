<%-- 
    Document   : BCRCECart
    Created    : 20-Mar-2013, 9:09:39 AM
    Updated    : 25-Mar-2013
    Author     : Brian Chaves & RJ Coulton
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="club.business.ELoan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="club.business.Book"%>
<%@page import="club.business.ECart" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eCart</title>
    </head>
    <body>
        <jsp:include page="BCRCBanner.jsp" />
        <table border="1">
            <tr>
                <td style="font-weight: bold;text-align: center" colspan="3">
                    Your Loan Cart
                </td>
            </tr>
            <tr style="font-weight: bold">
                <td style="width: 100px">Code</td>
                <td style="width: 500px">Description</td>
                <td style="width: 200px;text-align: right">Quantity</td>
            </tr>
            <c:set var="total" value="0"/>
            <c:forEach var="item" items="${cartItems}">
                <tr>
                    <td>${item.code}</td>
                    <td>${item.description}</td>
                    <td style="text-align: right">${item.quantity}</td>
                    <c:set var="total" value="${total + item.quantity}" />
                </tr>
                <tr> </tr>
            </c:forEach>
                <tr>
                    <td style="height: 25px" colspan="3"></td>
                </tr>
            <tr>
                <td colspan="2" style="text-align: right;font-weight: bold">
                    Total:
                </td>
                <td style="text-align: right">${total}</td>
            </tr>
            <tr>
                <td colspan="3">
                    <a href="BCRCClearCart">
                        Clear The cart
                    </a>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <a href="BCRCLoan">
                        Return to eLoan
                    </a>
                </td>
            </tr>
                
        </table>
    </body>
</html>

<%-- 
    Document   : BCRCConfrimDelete
    Created on : 22-Feb-2013, 12:36:58 PM
    Updated on : 25-Feb-2013
    Author     : Brian Chaves & Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Delete</title>
    </head>
    <body>
         <jsp:include page="BCRCBanner.jsp" />
        <%@ page import="club.business.Book" %>
        <% Book book = (Book) request.getAttribute("book"); %>
        <h1>Are you sure you want to delete this book?</h1>
        <table border ="1">
            <tr>
                <td>Book:</td>
                <td><%=book.getCode()%></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><%=book.getDescription()%></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><%=book.getQuantity()%></td>
            </tr>
        </table>

        <button onClick="window.location=
         'BCRCDeleteBookServlet?confirm=confirm&code\n\=<%=book.getCode()%>'">
            Yes</button>
        <button onClick="window.location='BCRCDisplayBooks'">No</button>

    </body>
</html>

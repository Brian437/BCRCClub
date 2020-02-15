<%-- 
    Document   : BCRCBooks
    Created on : Feb 11, 2013, 3:03:52 PM
    Updated on : Feb 25, 2013,
    Author     : Brian Chaves & RJ Coulton
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maintain Books</title>
    </head>
    <body>
        <jsp:include page="BCRCBanner.jsp" />
        <%@ page import="club.business.Book" %>
        <% ArrayList<Book> books = (ArrayList<Book>)
                request.getAttribute("books"); %>
        <h1>List of books</h1>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Description</td>
                <td>Quanity</td>
                <td></td>
            </tr>
                <%
                    for(Book book:books)
                    {
                        %>
                            <tr>
                            <td><%=book.getCode()%></td>
                            <td><%=book.getDescription()%></td>
                            <td><%=book.getQuantity()%></td>
                            <td><a href =                                   
                  "BCRCDeleteBookServlet?code=<%=book.getCode()%>&confirm=no">
                                 Delete</a></td>
                            </tr>
                        <%
                    }                                           
                %>
        </table>
        <br />
        <form name="goToAddBook" method="post" action="BCRCBook.jsp">
            <input type="submit" value="Add Book">
        </form>
    </body>
</html>

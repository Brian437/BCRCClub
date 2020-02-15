<%-- 
    Document   : BCRCBook
    Created on : 17-Feb-2013, 9:59:49 AM
    Updated on : 25-Feb-2013
    Author     : Brian Chaves & RJ Coulton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add a Book</title>
    <%
        String message = (String)request.getAttribute("message");
        String code=(String)request.getAttribute("code");
        String description=(String)request.getAttribute("description");
        String quantity=(String)request.getAttribute("quantity");
        if(message==null)
        {
            message="";
        }
        if(code==null)
        {
            code="";
        }
        if(description==null)
        {
            description="";
        }
        if(quantity==null)
        {
            quantity="";
        }
    %>
</head>
<body>
    <jsp:include page="BCRCBanner.jsp" />
    <h1> Add Book</h1>
    <div style="color: red">
        <%=message%>
    </div>
    <form action="BCRCAddBook" method="post" > 
        <table>
            <tr>
                <td align="right">Code: </td>
                <td><input type=“text” name="code" value="<%=code%>"/></td>
            </tr>
            <tr>
                <td align="right">Description:</td>
                <td><input type=“text” name="description" size="60"
                           value="<%=description%>"/></td>
            </tr>
            <tr>
                <td align="right">Quantity:</td>
                <td><input type=“text” name="quantity"
                           value="<%=quantity%>"/></td>
            </tr>
        </table>
        <br />
        <input type="submit" value="Add Book" />
        <input type="button" value="View Book"
               onclick="location.href='BCRCDisplayBooks'" />
    </form>
</body>
</html>

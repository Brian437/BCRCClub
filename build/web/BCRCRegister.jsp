<%-- 
    Document   : BCRCRegister
    Created on : Jan 21, 2013, 3:20:48 PM
    Updated on : Apr 08, 2013,11:12:38 AM 
    Author     : Brian Chaves & RJ Coulton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <jsp:include page="BCRCBanner.jsp" />
        
        <%--<form action="BCRCDisplayMember.jsp" method="post">--%>
        <form action="BCAddMember" method="post">
            <h1>New Member Registration Form</h1>
            <div style="color: red" >
                ${errorMessage}
            </div>
            <table>
                <tr>
                    <td>
                       Full Name: 
                    </td>
                    <td>
                        <input type="text" name="fullName" size ="40">
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email" size ="60">
                    </td>
                </tr>
                <tr>
                    <td>
                        Phone Number
                    </td>
                    <td>
                        <input type="text" name="number" size ="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Degree/Program:
                    </td>
                    <td>
                        <select name ="program">
                            <option>CP</option>
                            <option>CPA</option>
                            <option>ITID</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Year:
                    </td>
                    <td>
                        <select name ="year">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <input type="reset" value="Reset">
                        <input type="submit" value="Register">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

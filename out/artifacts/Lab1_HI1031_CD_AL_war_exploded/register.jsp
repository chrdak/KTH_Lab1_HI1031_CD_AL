<%@ page import="UI.UserVM" %><%--
  Created by IntelliJ IDEA.
  User: Degern
  Date: 2016-09-24
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username != null && password != null) {
        if(UserVM.createUser(username, password)) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("userLogin.jsp");
        }else {
            response.sendRedirect("register.jsp");
        }
    }

%>



<form method="post" action="register.jsp">
    <td> Username </td>
    <td><input type = "text" name = "username" value = "" />

    <td> Password </td>
    </td><input type = "password" name = "password" value = "" />
    <tr>
        <td><input class="btn btn-submit" type = "submit" value = "Register" />
    </tr>
</form>

</body>
</html>

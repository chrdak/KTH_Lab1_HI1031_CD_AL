<%@ page import="UI.UserVM" %><%--
  Created by IntelliJ IDEA.
  User: Degern
  Date: 2016-09-21
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>




<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
  <head>
    <title>Login Page$</title>
  </head>
  <body>

  <%
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      if(username != null && password != null) {

          if(UserVM.exists(username, password)) {
              session.setAttribute("username", username);
              session.setAttribute("password", password);
              response.sendRedirect("userLogin.jsp");
          }else {
              response.sendRedirect("error.jsp");
          }
      }
  %>


     <form method="post" action="index.jsp">
        <td> Name </td>
            <td><input type = "text" name = "username" value = "" />

        <td> Password </td>
            </td><input type = "password" name = "password" value = "" />
        <tr>
            <td><input class="btn btn-submit" type = "submit" value = "Login" />
     </tr>
     </form>


  <form method="post" action="register.jsp">
          <input class="btn btn-submit" type = "submit" value = "Register" />
  </form>
  </body>
</html>

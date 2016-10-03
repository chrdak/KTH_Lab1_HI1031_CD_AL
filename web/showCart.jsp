<%--
  Created by IntelliJ IDEA.
  User: Degern
  Date: 2016-09-21
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<%@ page import="UI.ProductVM" %>
<%@ page import="UI.Cart" %>

<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<head>
    <title>Login Page$</title>
</head>
<body>

<%
    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");
    if (username == null && password == null) {
        response.sendRedirect("error.jsp");
    }

    Cart cart = (Cart) session.getAttribute("cart");
%>

<br>
<% for (int i = 0; i < cart.getCartProducts().size(); i++) { %>
<ul>
    <li><%=cart.getCartProducts().get(i).getCode()%>  <%=cart.getCartProducts().get(i).getName()%></li>
</ul>
<% } %>

<form method="post" action="userLogin.jsp">
    <input class="btn btn-submit" type="submit" value="Back to shop"/>
</form>

</body>
</html>

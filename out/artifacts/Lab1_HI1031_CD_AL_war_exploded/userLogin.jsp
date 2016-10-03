<%--
  Created by IntelliJ IDEA.
  User: Degern
  Date: 2016-09-22
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="UI.ProductVM" %>
<%@ page import="UI.Cart" %>

<html>
<head>
    <title>UserLogin$</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");
    if (username == null && password == null) {
        response.sendRedirect("error.jsp");
    }

    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
        cart = Cart.create();
        session.setAttribute("cart", cart);
    }


%>
Logged in: <%= (String) session.getAttribute("username")%>
<br>
Products:
<br>
<% for (int i = 0; i < ProductVM.getAllProducts().size(); i++) { %>
<ul>
    <form method="post" action="userLogin.jsp">
        <li>
            <label>
                <%= ProductVM.getAllProducts().get(i).getCode()%>
                <%=ProductVM.getAllProducts().get(i).getName()%>
            </label>
            <button type="submit" name="product" value= "<%=ProductVM.getAllProducts().get(i).getCode()%>">
            Add to cart
            </button>
        </li>
    </form>

</ul>
<% } %>
<%
    String productToBeAddedToCart = request.getParameter("product");
    if (productToBeAddedToCart != null) {
        cart.addToCart(ProductVM.getProductByCode(Integer.parseInt(productToBeAddedToCart)));
    }
%>


<form method="post" action="showCart.jsp">
    <input class="btn btn-submit" type="submit" value="Show Cart"/>
</form>

</body>
</html>

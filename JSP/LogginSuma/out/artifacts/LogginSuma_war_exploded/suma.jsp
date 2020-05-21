<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.logging.Level" %><%--
  Created by IntelliJ IDEA.
  User: alepj
  Date: 21/05/2020
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Suma</title>
</head>
<body>
<% PrintWriter print = response.getWriter();
    print.print("El resultado de la suma " + request.getParameter("num1") + " + " + request.getParameter("num2") + " es: ");
    print.print(request.getAttribute("resultado"));
    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Esta aplicación es de Alejandro Paniagua Jurado");%>
</body>
</html>

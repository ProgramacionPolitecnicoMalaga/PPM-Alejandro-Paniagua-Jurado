<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.logging.Level" %><%--
  Created by IntelliJ IDEA.
  User: alepj
  Date: 21/05/2020
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>El promedio de tres número</title>
</head>
<body>
<%
    PrintWriter printer = response.getWriter();
    printer.print("El promedio de los numeros " + request.getParameter("num1") + " + " + request.getParameter("num2")+ " + " + request.getParameter("num3") + " es: ");
    printer.print(request.getAttribute("resultado"));
    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Esta aplicación es de Alejandro Panaigua Jurado");
%>
</body>
</html>

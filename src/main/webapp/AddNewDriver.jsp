<%--
  Created by IntelliJ IDEA.
  User: Lena
  Date: 27.10.2014
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новый водитель</title>
</head>
<body>
<form method="post" action="AddNewDriverServlet">
  Имя: <input type="text" name="firstName">
  Фамилия: <input type="text" name="lastName">
  Отчество: <input type="text" name="patronymic">
  Номер прав: <input type="text" name="licenseNumber">
  <input type="submit" value="Add">

</form>

</body>
</html>

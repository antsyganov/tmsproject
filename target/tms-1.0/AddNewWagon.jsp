<%--
  Created by IntelliJ IDEA.
  User: Lena
  Date: 27.10.2014
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового вагона</title>
</head>
<body>
<form method="post" action="RegNewWagonServlet">
  Регистрационный номре: <input type="text" name="regNumber">
  Число водителей в смене: <input type="text" name="numberOfDriver">
  Класс вместимости: <input type="text" name="classCapacity">
  <input type="submit" value="Add">
</form>
</body>
</html>

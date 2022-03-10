<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 01.03.2022
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
    <title>Calculator page</title>
</head>
<body>
<form action="/calc" method="post">
    <input type="text" name="value1" placeholder="Value 1">

    <select name="operation">
        <option disabled selected >Select operation</option>
        <option value="sum">+</option>
        <option value="dif">-</option>
        <option value="mult">*</option>
        <option value="div">/</option>
    <input type="text" name="value2" placeholder="Value 2">
    <button>Result</button>
    ${msgResult}
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 01.03.2022
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Calculator page</title>
</head>
<body>
<s:form action="/calc" method="post" modelAttribute="calcOperation">
    <s:input path="value1" placeholder="Value 1" />
    <s:select path="operation">
        <option disabled selected>Select operation</option>
        <option value="sum">+</option>
        <option value="dif">-</option>
        <option value="mult">*</option>
        <option value="div">/</option>
    </s:select>
    <s:input path="value2" placeholder="Value 2"/>
    <s:button>Result </s:button> ${msgResult}
</s:form>
</body>
</html>

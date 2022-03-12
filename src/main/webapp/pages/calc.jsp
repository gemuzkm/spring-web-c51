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
    <s:errors path="value1" delimiter=", "/>
    <br>

    <s:select path="operation">
        <option disabled selected>Select operation</option>
        <option value="SUM">+</option>
        <option value="SUBTRACT">-</option>
        <option value="MULTIPLY">*</option>
        <option value="DIVIDE">/</option>
    </s:select>
    <s:errors path="operation"/>
    <br>

    <s:input path="value2" placeholder="Value 2"/>
    <s:errors path="value2" delimiter=", "/>
    <br>

    <s:button>Result </s:button> ${msgResult}
</s:form>
</body>
</html>

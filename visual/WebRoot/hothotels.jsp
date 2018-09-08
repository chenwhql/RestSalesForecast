<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2016/12/10
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>hothotels</title>
</head>
<body>
<c:forEach items="${hotHotels}" var="hotel" varStatus="s">
${hotel.hotelName}<br/>
</c:forEach>
</body>
</html>

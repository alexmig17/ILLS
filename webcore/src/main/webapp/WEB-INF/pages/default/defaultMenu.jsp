<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 30.11.2017
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<ul>
 <c:forEach items="${menu.items}" var="item" >
	<li><a href="${item.name}"  >${item.name}</a></li>

 </c:forEach>
</ul>


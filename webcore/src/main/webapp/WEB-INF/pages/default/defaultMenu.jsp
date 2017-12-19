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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%--<jsp:useBean id="menu" class="com.ills.dto.MenuDTO" />--%>
<div class="side">
    <nav class="left_side_menu">
        <input type="checkbox" name="toggle" id="menu" class="toggleMenu">
        <label for="menu" class="toggleMenu"><i class="fa fa-bars"></i>${menu.name}</label>
        <ul >
            <c:if test="${fn:length(menu.items) > 0}" >
                <c:set var="items" value="${menu.items}" scope="request"/>
                <c:set var="nestingCount" value="0" scope="request" />
                <c:set var="nestingLevel" value="" scope="request" />
                <jsp:include page="/WEB-INF/pages/default/defaultMenuItems.jsp"/>
            </c:if>
        </ul>


    </nav>

</div>

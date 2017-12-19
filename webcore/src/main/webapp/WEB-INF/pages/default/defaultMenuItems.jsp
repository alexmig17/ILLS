<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 16.12.2017
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<jsp:useBean id="items" class="java.util.ArrayList" scope="request" />--%>

<c:forEach  items="${items}" var="item" >
    <c:set var="nestingCount" value="${nestingCount +1}" scope="request" />
    <c:set var="items" value="${item.items}" scope="request"/>
        <li ${item.selected == true ?"class ='menu_selected'" : ""}>
            <div class="line">
                <a href="/ills/${item.context.uri}/view?id=${item.context.viewList[0].id}"  >${item.name}</a>
                <c:if test= "${fn:length(item.context.viewList) > 1}">
                    <div class="toggleDropMenu">
                        <ul class="menu__drop">
                            <c:forEach items="${item.context.viewList}" var="view" >
                                <li ${view.selected == true ? "class =' menu_selected'" : ''}><a href="/ills/${item.context.uri}/view?id=${view.id}"  >${view.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>
                <c:if test= "${fn:length(item.items) > 0}">
                    <label for="subMenu${nestingLevel.concat(nestingCount)}" class="toggleSubMenu"></label>
                </c:if>
            </div>
            <c:if test= "${fn:length(item.items) > 0}">
                <input type="checkbox" name="toggle" id="subMenu${nestingLevel.concat(nestingCount)}" class="toggleSubMenu">
                <ul>
                    <c:set var="nestingLevel" value="${nestingLevel.concat(nestingCount).concat('-')}" scope="request" />
                    <jsp:include page="/WEB-INF/pages/default/defaultMenuItems.jsp"/>
                </ul>
            </c:if>
        </li>

</c:forEach>
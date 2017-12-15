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

<div class="side">
    <ul class="menu">
        <li class="left-menu-name">${menu.name}</li>
         <c:forEach items="${menu.items}" var="item" >



            <li class="menu__list ${item.selected == true ? 'menu_selected' : ''}">
                <a href="${item.context.uri}/view?name=${item.context.viewList[0].id}"  >${item.name}</a>
                <c:if test= "${fn:length(item.context.viewList) > 1}">
                    <ul class="menu__drop">
                    <c:forEach items="${item.context.viewList}" var="view" >
                        <li><a href="${item.context.uri}/view?id=${view.id}"  >${view.name}</a></li>
                    </c:forEach>
                    </ul>
                </c:if>
            </li>
         </c:forEach>
    </ul>
</div>

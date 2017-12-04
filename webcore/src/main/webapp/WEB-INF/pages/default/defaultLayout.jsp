<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<c:set var="root" value="/ills" scope="request"/>
<c:set var="img" value="${root}/static/images" scope="request"/>
<c:set var="css" value="${root}/static/css" scope="request"/>
<c:set var="js" value="${root}/static/jscript" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%--<title><s:insertAttribute name="title" ignore="true"/></title>--%>
    <tiles:importAttribute name="title" />
    <title><%--<spring:message code="${title}"></spring:message>--%></title>


    <link rel="stylesheet" href="${css}/components/common.css">
    <script type="text/javascript" data-main="${js}/components/require.controller" src="${js}/libs/require.js"></script>


</head>
<body>

<header id="header" class="wrap header">
    <s:insertAttribute name="header"/>
</header>


<section class="wrap main">
    <section class="wrap-in">
        <nav class="sidebar" id ="sidebar">
            <s:insertAttribute name="menu"/>
        </nav>
        <section class="mainside" id="content">
            <s:insertAttribute name="content"/>
        </section>
    </section>
</section>
<div class="push"></div>
<footer class="wrap footer" id="footer">
    <s:insertAttribute name="footer"/>
</footer>
<div id="imgUrl" attr="${img}"/>
</body>
</html>
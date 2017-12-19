<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 19.12.2017
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="user" class="com.ills.dto.UserDTO" scope="request" />
<jsp:useBean id="person" class="com.ills.dto.PersonDTO" scope="request" >
    <jsp:setProperty name="person" property="user"  value="user" />
</jsp:useBean>
<jsp:setProperty name="student" property="person" value="person" />--%>

<jsp:useBean id="student" class="com.ills.dto.StudentDTO" scope="request" />
<jsp:useBean id="user" class="com.ills.dto.UserDTO" scope="request" />
<jsp:useBean id="person" class="com.ills.dto.PersonDTO" scope="request" />
<jsp:setProperty name="student" property="person" value="${person}" />
<jsp:setProperty name="person" property="user" value="${user}" />

<form id="form" name="form" method="post" action="<%--/ills/admin/students/add/view?id=std.add.default--%>#" th:action="@{**/add/view}" th:object="${student}" title="Анкета">
    <fieldset>
        <legend>Данные о студенте:</legend>
        <input type="text" size="26" maxlength="25" id="person.lastName" name="person.lastName" placeholder="Фамилия" title="Фамили" pattern="[A-Z]{1}[a-z]{1,24}" required autofocus th:field="*{person.lastName}" />
        <input type="text" size="26" maxlength="25" id="person.firstName" name="person.firstName" placeholder="Имя" title="Имя" pattern="[A-Z]{1}[a-z]{1,24}" required th:field="*{person.firstName}" />
        <%--<input type="date" id="person.dob" name="person.dob" placeholder="Дата рождения" title="Дата рождения" th:field="*{person.dob}"/>--%>
        <input type="tel" id="person.homePhone" name="person.homePhone" placeholder="Домашний телефон" title="Домашний телефон" pattern="2[0-9]{2}-[0-9]{2}-[0-9]{2}" th:field="*{person.homePhone}"/>
        <input type="text" size="26" maxlength="25" id="person.user.login" name="person.user.login" placeholder="Логин" title="Логин"  required th:field="*{person.user.login}"/>
        <input type="password" size="26" maxlength="25" id="person.user.password" name="person.user.password" placeholder="Пароль" title="Пароль"  required th:field="*{person.user.password}"/>
    </fieldset>
    <fieldset>
        <legend>Кнопки управления</legend>
        <input type="submit" id="send"  value="Отправить">
        <input type="reset" id="reset"  value="Сбросить">
        <br>
    </fieldset>

</form>









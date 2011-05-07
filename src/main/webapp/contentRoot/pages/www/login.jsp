<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="loginForm">
    <form method="post">
        <input name="login" type="text" maxlength="64" tabindex="1">
        <input name="password" type="password" maxlength="128" tabindex="2">
        <button type="submit"><span><spring:message code="login.enter"/></span></button>
    </form>
</div>
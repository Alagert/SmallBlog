<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="loginForm">
    <form:form method="post" commandName="login">
        <table>
            <tr>
                <td>
                    <spring:message code="login.login"/>
                </td>
                <td>
                    <form:input path="login"/>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="login.pass"/>
                </td>
                <td>
                    <form:password path="pass"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit"><span><spring:message code="login.login"/></span></button>
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </form:form>
</div>
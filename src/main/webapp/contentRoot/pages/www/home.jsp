<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath">${pageContext.request.contextPath}</c:set>

<div id="users">
    <h2>
        <spring:message code="home.text"/>
    </h2>
    <ul>
        <c:forEach items="${requestScope.users}" var="user">
            <li>
                <a href="${contextPath}/showUser.htm?userNick=${user.nickName}">${user.nickName}</a> <br/>
            </li>
        </c:forEach>
    </ul>
</div>
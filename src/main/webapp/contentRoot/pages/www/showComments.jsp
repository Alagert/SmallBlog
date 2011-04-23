<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath">${pageContext.request.contextPath}</c:set>


<script type='text/javascript' src='${contextPath}/dwr/interface/blogService.js'></script>
<script type='text/javascript' src='${contextPath}/dwr/engine.js'></script>
<script type='text/javascript' src='${contextPath}/dwr/util.js'></script>
<script type="text/javascript" src="${contextPath}/js/user.js"></script>

<spring:message code="showComments.post.comments"/><br/>
<br/>
<ul>
<c:forEach items="${requestScope.comments}" var="comment">
    <li>
        <spring:message code="showComments.post.text"/> ${comment.comment}<br/>
        <spring:message code="showComments.post.date"/> ${comment.timestamp}<br/>
    </li>
</c:forEach>
</ul>
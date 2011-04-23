<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath">${pageContext.request.contextPath}</c:set>


<script type='text/javascript' src='${contextPath}/dwr/interface/blogService.js'></script>
<script type='text/javascript' src='${contextPath}/dwr/engine.js'></script>
<script type='text/javascript' src='${contextPath}/dwr/util.js'></script>
<script type="text/javascript" src="${contextPath}/js/user.js"></script>

<script language="Javascript">
    var subjectLabel = "<spring:message code="showUser.subject"/>"
    var txtLabel = "<spring:message code="showUser.txt"/>"
    var timeLabel = "<spring:message code="showUser.time"/>"
    var seeCommentsLabel = "<spring:message code="showUser.see.comments"/>"
</script>

<spring:message code="showUser.user.name"/>${requestScope.user.name}<br/>
<spring:message code="showUser.user.nick.name"/>${requestScope.user.nickName}<br/>
<a href="javascript:showUserPosts('${requestScope.user.nickName}');"><spring:message code="showUser.user.posts"/></a>

<br/><br/>

<div id="userPosts">

</div>



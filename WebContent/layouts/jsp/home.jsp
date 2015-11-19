<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:choose>
	<c:when test="${hasOffer}">
		<button type="button" class="btn btn-default" onclick="window.location.href='${pageContext.request.contextPath}/createoffer'">
		Edit</button>
	</c:when>
	<c:otherwise>
			<button type="button" class="btn btn-default" onclick="window.location.href='${pageContext.request.contextPath}/createoffer'">
			Create new Offer</button>
	</c:otherwise>

</c:choose>

<table class="table table-striped table-hover">
	<tr>
		<th class="col-sm-1" >Name</th>
		<th class="col-sm-1">Email</th>
		<th class="col-sm-3">Offer</th>
	</tr>

	<c:forEach var="offer" items="${offers}">
		<tr>
			<td><c:out value="${offer.user.name}"></c:out></td>
			<td><A href="<c:url value='/message?uid=${offer.username}'/>">
					contact</A></td>
			<td><c:out value="${offer.text}"></c:out></td>

		</tr>
	</c:forEach>
</table>

<script type="text/javascript">
	getMessages();
</script>
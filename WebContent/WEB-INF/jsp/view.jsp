<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="menu.jsp"%>

<c:url value="/save" var="theAction" />
<form:form method="post" action="${theAction}" modelAttribute="unitForm">
	<table id="formTable" class="formTable">
		<tr>
			<td>Nimi:</td>
			<td><form:input disabled='true' id="nameBox" name="nameBox"
					path="unit.name" /></td>
		</tr>
		<tr>
			<td>Kood:</td>
			<td><form:input disabled='true' id="codeBox" path="unit.code" /></td>
		</tr>
		<tr>
			<td>Ülemüksus:</td>
			<td><form:select disabled='true' id="superUnitCode"
					path="unit.superUnitId">
					<form:option value=""></form:option>
					<c:forEach items="${unitForm.units}" var="temp">
						<c:choose>
							<c:when
								test="${temp.code == unitForm.supUnit.code}">
								<form:option value="${temp.code}"
									selected='true'>${temp.name}</form:option>
							</c:when>

							<c:otherwise>
								<form:option value="${temp.code}">${temp.name}</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select></td>
		</tr>

		<tr>
			<td>Alamüksused:</td>

			<td><c:forEach items="${unitForm.subUnits}" var="unit"
					varStatus="status">
					<span id="sub_${unit.code}">${unit.code}</span>
					<c:if test="${status.last==false}">, </c:if>
				</c:forEach></td>
		</tr>
		<tr>
			<td align="right" colspan="2"><br /> <a
				href="<c:url value='/search' />" id="backLink">Tagasi</a></td>
		</tr>
	</table>
</form:form>
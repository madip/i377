<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="menu.jsp"%>

<div id="add">
<c:url value="/save" var="theAction" />
<form:form method="post" action="${theAction}" modelAttribute="unitForm">
	<table id="formTable" class="formTable">
		<tr>
			<td>Nimi:</td>
			<td><form:input id="nameBox" path="unit.name" /></td>
		</tr>
		<tr>
			<td>Kood:</td>
			<td><form:input id="codeBox" path="unit.code" /></td>
		</tr>
		<tr>
			<td>Ülemüksus:</td>
			<td><form:select id="superUnitCode" path="unit.superUnitId">
					<form:option value=""></form:option>
					<c:forEach items="${unitForm.units}" var="temp">
						<form:option value="${temp.code}">${temp.name}</form:option>
					</c:forEach>
				</form:select></td>
		</tr>

		<tr>
			<td>Alamüksused:</td>
			<td></td>
		</tr>
		<tr>
			<td align="right" colspan="2"><br /> <input id="addButton"
				type=submit value="Lisa" /></td>
		</tr>
	</table>
</form:form>
</div>




<%@ include file="Menu.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="Add" method="post">
	<table id="formTable" class="formTable">
		<tr>
			<td>Nimi:</td>
			<td><input id="nameBox" name="name" disabled='disabled'
				value="${unitName}" /></td>
		</tr>
		<tr>
			<td>Kood:</td>
			<td><input id="codeBox" name="code" disabled='disabled'
				value="${unitCode}" /></td>
		</tr>
		<tr>
			<td>Ülemüksus:</td>
			<td><select id="superUnitCode" name="superUnitCode"
				disabled='disabled'>
					<option value=""></option>
					<c:forEach items="${listLowerUnit}" var="type">
						<c:choose>
							<c:when test="${superUnit.id==type.id}">
								<option value="${type.code}" selected='selected'>${type.name}</option>
							</c:when>

							<c:otherwise>
								<option value="${type.code}">${type.name}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Alamüksused:</td>
			<td><c:forEach items="${subUnit}" var="unit" varStatus="status">
					<span id="sub_${unit.code}">${unit.code}</span><c:if test="${status.last==false}">, </c:if>
				</c:forEach></td>
		</tr>
		<tr>
			<td align="right" colspan="2"><br /> <a href="Search" id="backLink">Tagasi</a></td>
		</tr>
	</table>
</form>
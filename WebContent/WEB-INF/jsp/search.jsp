<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="menu.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/search" var="theAction" />
<form:form action="${theAction}" method="get"
	modelAttribute="searchString">
	<input id="searchStringBox" value="" name="searchString" />
	<input id="filterButton" type="submit" value="Filtreeri" />
	<br />
	<br />
</form:form>
<table id="listTable" class="listTable">
	<thead>
		<tr>
			<th scope="col">Nimi</th>
			<th scope="col">Kood</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="item" items="${searchResults}">
			<tr>
				<td>
					<div id="row_${item.code}">
						<a id="view_${item.code}"
							href="<c:url value='/view/${item.code}'/>">${item.name}</a>
					</div>
				</td>
				<td>${item.code}</td>
				<td><a id="delete_${item.code}"
					href="<c:url value='/delete/${item.code}'/>">Kustuta</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="Menu.jsp"%>
<div id="add">
	<form action="Add" method="post">
		<table id="formTable" class="formTable">
			<tr>
				<td>Nimi:</td>
				<td><input id="nameBox" name="name" /></td>
			</tr>
			<tr>
				<td>Kood:</td>
				<td><input id="codeBox" name="code" /></td>
			</tr>
			<tr>
				<td>Ülemüksus:</td>
				<td><select id="superUnitCode" name="superUnitCode">
						<option value=""></option>
						<c:forEach items="${listLowerUnit}" var="type">
							<option value="${type.code}">${type.name}</option>
						</c:forEach>
				</select></td>
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
	</form>
</div>




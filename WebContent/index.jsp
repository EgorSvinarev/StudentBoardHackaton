<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="DataBase.TableModel.*" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="cache-control" content="no-cache" />
	<title>ИРБИС.Учащиеся</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css">
</head>
<body>
	<div class="main">
		<a href="${pageContext.request.contextPath}">
			<div class="main__leftbar">
				<div class="leftbar__logobox">
					<img src="${pageContext.request.contextPath}/Content/logo.png" alt="ИРБИС">
				</div>
				<div class="leftbar__spanbox"><span>Информация об учащихся</span></div>
			</div>
		</a>
		<div class="main__mainbar">
			<div class="mainbar__navbar">
				<div class="navbar__search_form">
					<form action="?search=true" method="post">
						<input id="search_field_input" type="text" name="data">
						<input id="search_field_btn" type="submit" value="Поиск">
					</form>
				</div>
				<div class="navbar__output_regulation_panel">
					Сортировать по
					<button class="output_regulation_panel_btns" id="output_regulation_panel__alphabet_sort" value="forward">Алфавиту</button>
					<button class="output_regulation_panel_btns" id="output_regulation_panel__groups_sort" value="forward">Группам</button>
				</div>

			</div>

			<div id="mainbar__table">
				<table cellspacing="0" cellpadding="0" id="table__table">
					<tr><th>id</th><th>Имя</th><th>Фамилия</th><th>Пол</th><th>Возраст</th><th>Город</th><th>Id группы</th></tr>
					<%
						Person[] persons = (Person[]) request.getAttribute("persons");
						Student[] students = (Student[]) request.getAttribute("students");
						for (int i = 0; i < persons.length; i++) {
							Person person = persons[i];
							Student student = students[i];
							pageContext.setAttribute("currentId", person.getId());
							%>
								<tr class="entry">
									<td class="entry_id"><a href="student?id=${currentId}"><%=persons[i].getId() %></a></td>
									<td class="entry_name"><%=persons[i].getName() %></td>
									<td class="entry_surname"><%=persons[i].getSurname() %></td>
									<td class="entry_gender"><%=persons[i].getGender() %></td>
									<td class="entry_age"><%=persons[i].getAge() %></td>
									<td class="entry_town"><%=persons[i].getTown() %></td>
									<td class="entry_group_id"><%=students[i].getGroupId() %></td>
								</tr>
							<%
						}
						
					%>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/sort_by_alphabet.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/sort_by_group.js"></script>
</body>
</html>
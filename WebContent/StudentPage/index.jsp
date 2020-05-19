<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "DataBase.TableModel.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="cache-control" content="no-cache" />
	<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/StudentPage/style.css">
</head>
<body>
	<%
		Person person = (Person) request.getAttribute("person");
		Student student = (Student) request.getAttribute("student");
	%>
	
	<div class="main">
		<a href="${pageContext.request.contextPath}">
			<div class="main__leftbar">
				<div class="leftbar__logobox">
					<img src="${pageContext.request.contextPath}\Content\logo.png" alt="ИРБИС">
				</div>
				<div class="leftbar__spanbox"><span>Информация об учащихся</span></div>
			</div>
		</a>
		<div class="main__rightbar">
			<div class="rightbar__top">
				<div class="top__person_info scrollable">
					<div class="rightbar__header">Личная инфомарция</div>
					<span class="rightbar__info_field">Имя: <%=person.getName() %></span><br>
					<span class="rightbar__info_field">Фамилия: <%=person.getSurname() %></span><br>
					<span class="rightbar__info_field">Возраст: <%=person.getAge() %></span><br>
					<span class="rightbar__info_field">Пол: <%=person.getGender() %></span><br>
					<span class="rightbar__info_field">Город: <%=person.getTown() %></span><br>
				</div>
				<div class="top__student_info scrollable">
					<div class="rightbar__header">Инфомарция о студенте</div>
					<span class="rightbar__info_field">Id студента: <%=person.getId() %></span><br>
					<span class="rightbar__info_field">Id группы: <%=student.getGroupId() %></span><br>
				</div>
			</div>
			<div class="rightbar__bottom">
				<div class="bottom__biography scrollable">
					<div class="rightbar__header">Биография студента</div>
				</div>
			</div>
			<div class="rightbar__button_panel">
				<button id="button_panel__change_btn">Редактировать</button>
			</div>
		</div>
	</div>

</body>
</html>
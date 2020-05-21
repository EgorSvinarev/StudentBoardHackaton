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
		<div class="main__rightbar" id="main__rightbar">
			<div class="rightbar__top">
				<div class="top__person_info scrollable">
					<div class="rightbar__header">Личная инфомарция</div>
					<div class="rightbar__info_field" id="name">Имя: <span class="info_field__info"><%=person.getName() %></span></div>
					<div class="rightbar__info_field" id="surname">Фамилия: <span class="info_field__info"><%=person.getSurname() %></span></div>
					<div class="rightbar__info_field" id="age">Возраст: <span class="info_field__info"><%=person.getAge() %></span></div>
					<div class="rightbar__info_field" id="gender">Пол: <span class="info_field__info"><%=person.getGender() %></span></div>
					<div class="rightbar__info_field" id="town">Город: <span class="info_field__info"><%=person.getTown() %></span></div>
				</div>
				<div class="top__student_info scrollable">
					<div class="rightbar__header">Инфомарция о студенте</div>
					<div class="rightbar__info_field" id="id">Id студента: <span class="info_field__info"><%=student.getId() %></span></div>
					<div class="rightbar__info_field" id="group_id">Id группы: <span class="info_field__info"><%=student.getGroupId() %></span></div>
				</div>
			</div>
			<div class="rightbar__bottom">
				<div class="bottom__biography scrollable">
					<div class="rightbar__header">Биография студента</div>
				</div>
			</div>
			<div class="rightbar__button_panel">
				<button id="button_panel__edit_btn" class="button_panel__buttons" type="button">Редактировать</button>
				<button id="button_panel__change_save_btn" class="button_panel__buttons" type="button">Сохранить</button>
				<button id="button_panel__cancel_editing_btn" class="button_panel__buttons" type="button">Отмена</button>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/StudentPage/cancel_editing.js"></script>
	<script src="${pageContext.request.contextPath}/StudentPage/handle_editing.js"></script>
	</div>

</body>
</html>
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
		<div class="main__infobar">
			<div class="infobar__leftside">
				<span>Имя: <%=person.getName() %></span><br>
				<span>Фамилия: <%=person.getSurname() %></span><br>
				<span>Пол: <%=person.getGender() %></span><br>
				<span>Возраст: <%=person.getAge() %></span>
			</div>
			<div class="infobar__rightside">
				<span>Город: <%=person.getTown() %></span><br>
				<span>Id ученика: <%=person.getId() %></span><br>
				<span>Id группы: <%=student.getGroupId() %></span>
			</div>
		</div>
	</div>

</body>
</html>
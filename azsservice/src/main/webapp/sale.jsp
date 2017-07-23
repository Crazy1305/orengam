<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.orengam.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Выбор топлива</title>
</head>
<body>
	<c:forEach items="${pumps}" var="pump">
		<div>
			<p>ТРК <c:out value="${pump.nPump}"/></p>
			<c:forEach items="${pump.nozzles}" var="nozzle">
				<div>
					<p><c:out value="${nozzle.petroleum.caption}" /></p>
				</div>
				
			</c:forEach>
			<div>
			</div>
		</div>
	</c:forEach>
</body>
</html>
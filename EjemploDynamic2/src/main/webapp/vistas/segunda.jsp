<%@ include file="/vistas/cabecera.jsp" %>

<html>
<head>
<title>CSI2</title>
</head>
<body>
<!--  
	<h1><b>Alumnos de CSI2</b></h1>
	<c:forEach items="${clase.atributos}" var="items">
		<c:out value="${items}"></c:out></br>
	</c:forEach>
-->	
	
	<h1><b>Registro de alumno</b></h1>
	<form action="<%= request.getContextPath() %>/OnGetPost" method="Post">
		<ul>Nombre: <input type="text" name="nombre" ></ul>
		<ul>Apellidos: <input type="text" name="apellidos" ></ul>
		<ul>Edad: <input type="text" name="edad" ></ul>
		<ul><button type="submit">Enviar</button></ul>
	</form>	
</body>
</html>
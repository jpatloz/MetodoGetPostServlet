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
	Nombre: <input type="text" name="nombre" ><br>
	Apellidos: <input type="text" name="apellidos" ><br>
	Edad: <input type="text" name="edad" ><br>
	<button type="submit">Enviar</button>
	</form>
	
</body>
</html>
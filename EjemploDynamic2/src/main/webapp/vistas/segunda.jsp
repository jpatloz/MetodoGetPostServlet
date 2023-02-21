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
	
	<h1><b>Registro de alumnos</b></h1>
	
	<c:forEach items="${miModelo.listaAlumnos}" var="alumno">
      <c:out value="${alumno.nombre_alumno}"/> 
      <i><c:out value="${alumno.apellidos_alumno}"/></i>
      <br><br>
    </c:forEach>
	<a href="<c:url value="navegacionFormulario"/>">A formulario</a>
</body>
</html>
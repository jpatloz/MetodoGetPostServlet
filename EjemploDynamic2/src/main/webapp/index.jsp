<%@ include file="/vistas/cabecera.jsp" %>

<html>
<head>
<title>Gestión de ordenadores y alumnos</title>
</head>
<body>
	<h1>Gestión escolar</h1>
	<a href="<c:url value="formularioAlumno"/>">1) Insertar Alumno</a><br>
	<a href="<c:url value="bajaAlumno"/>">2) Baja de un alumno</a><br>
	<a href="<c:url value="formularioPortatil"/>">3) Insertar portatil</a><br>
</body>
</html>
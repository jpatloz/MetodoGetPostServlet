<%@ include file="/vistas/cabecera.jsp" %>

<html>
<head>
<title>Registro</title>
</head>
<body>
	<p>El alumno registrado es: </p>
	<ul>
		<li>Nombre: ${alumno.nombre}</li>
		<li>Apellidos: ${alumno.apellidos}</li>
		<li>Edad: ${alumno.edad}</li>
	</ul>
</body>
</html>
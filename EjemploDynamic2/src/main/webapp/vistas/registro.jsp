<%@ include file="/vistas/cabecera.jsp" %>

<html>
<head>
<title>Registro</title>
</head>
<body>
	<h1>Nuevo Alumno</h1>
    <form:form method="POST" 
          action="insertarAlumno" modelAttribute="insertarAlumno">
             <table>
                <tr>
    				<td><form:label path="nombre_alumno">NOMBRE COMPLETO:</form:label>
    			<form:input type="text" path="nombre_alumno"/></td>
                </tr>
                <tr>
    				<td><form:label path="apellidos_alumno">APELLIDOS:</form:label>
    				<form:input type="text"  path="apellidos_alumno"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form> 
</body>
</html>
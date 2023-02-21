<%@ include file="/vistas/cabecera.jsp" %>

<html>
<head>
<title>Registro</title>
</head>
<body>
	<h1>Nuevo Alumno</h1>
    <form:form method="POST" 
          action="guardarAlumno" modelAttribute="alumno">
             <table>
                <tr>
                    <td><form:label path="nombre_alumno">Nombre</form:label></td>
                    <td><form:input path="nombre_alumno"/></td>
                </tr>
                <tr>
                    <td><form:label path="apellidos_alumno">Apellidos</form:label></td>
                    <td><form:input path="apellidos_alumno"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form> 
</body>
</html>
<%@ include file="/vistas/cabecera.jsp" %>

<html>
<head>
<title>CSI2</title>
</head>
<body>
    <h1>Introduzca el id de un alumno</h1>
    <form:form method="POST" 
          action="eliminarAlumno" modelAttribute="alumnoEliminado">
             <table>
                <tr>
                    <td><form:label path="id_alumno">Id </form:label></td>
                    <td><form:input path="id_alumno"/></td>
                </tr>
      		</table>
     </form:form>
     <p>Mensaje de confirmación: <c:out value="${miModelo.mensaje}"/></p> 
</body>
</html>
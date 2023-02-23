<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
  <title>Matriculación del alumno</title>
  </head>
  <body>
    <h1>Datos del Alumno</h1>
    <form:form method="POST" 
          action="guardarAlumno" modelAttribute="alumnoInsertado">
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
                    <td><form:label path="num_telefono">Teléfono</form:label></td>
                    <td><form:input path="num_telefono"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form> 
        <p>Mensaje del controlador: <c:out value="${miModelo.mensaje}"/></p>  
 </body>
</html>
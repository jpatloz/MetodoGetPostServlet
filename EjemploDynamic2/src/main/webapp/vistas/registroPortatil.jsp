<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
  <title>Dar de alta un ordenador</title>
  </head>
  <body>
    <h1>Datos del ordenador</h1>
    <form:form method="POST" 
          action="guardarPortatil" modelAttribute="ordenadorInsertado">
             <table>
                <tr>
                    <td><form:label path="marca">Marca</form:label></td>
                    <td><form:input path="marca"/></td>
                </tr>
                <tr>
                    <td><form:label path="modelo">Modelo</form:label></td>
                    <td><form:input path="modelo"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form> 
        <p>Mensaje del controlador: <c:out value="${miModelo.mensaje}"/></p>  
 </body>
</html>
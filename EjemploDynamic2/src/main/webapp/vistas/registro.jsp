<%@ include file="/vistas/cabecera.jsp" %>

<html>
<head>
<title>Registro</title>
</head>
<body>
<p>El usuario registrado es: </p>
<%
String nombrePersona = request.getParameter("nombre");

out.print(nombrePersona);
%>

</body>
</html>
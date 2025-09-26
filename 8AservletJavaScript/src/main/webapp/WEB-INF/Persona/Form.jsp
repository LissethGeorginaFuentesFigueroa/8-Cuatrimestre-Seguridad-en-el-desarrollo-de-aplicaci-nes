<%--
  Created by IntelliJ IDEA.
  User: CA2-Enero
  Date: 19/02/2024
  Time: 07:39 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Persona</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/PersonaServlet" method="post">
    <p><label for="nombre">Nombre</label>
        <input type="text" name="nombre" id="nombre">
    </p>
    <p><label for="semblanza">Semblanza</label>
        <textarea name="semblanza" id="semblanza" cols="30" rows="10"></textarea>
    </p>
    <button type="submit">Enviar</button>
</form>

</body>
</html>

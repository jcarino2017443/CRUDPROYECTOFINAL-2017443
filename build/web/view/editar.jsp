<%-- 
    Document   : editar
    Created on : 02-sep-2020, 13:47:48
    Author     : Bryan
--%>

<%@page import="modelo.Persona"%>
<%@page import="modeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title></title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-2">
            <%
                PersonaDAO nuevapersonaDao = new PersonaDAO();
                int codPersona = Integer.parseInt((String)request.getAttribute("codPer"));
                Persona nuevaPersona = (Persona)nuevapersonaDao.list(codPersona);
            %>
            <h1></h1>
                <form action="Controlador">
                    <Strong>DPI:</Strong><br>
                    <input class="form-control" type="text" name="txtDPI" value="<%=nuevaPersona.getDPI()%>"><br><br>
                    <Strong>Nombre:</Strong><br>
                    <input class="form-control" type="text" name="txtNombre" value="<%=nuevaPersona.getNombrePersona()%>"><br><br>
                    <input type="hidden" name="txtCodigoPersona" value="<%=nuevaPersona.getCodigoPersona() %>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"><br>

                </form>
             </div>
        </div>
        
    </body>
</html>

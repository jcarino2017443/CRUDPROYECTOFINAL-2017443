<%-- 
    Document   : listar
    Created on : 2/09/2020, 02:53:07 PM
    Author     : 15cab
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Persona"%>
<%@page import="modeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Personas</h1>
            <a href="Controlador?accion=add">Agregar Nuevo</a>
            <table border="1">
                <thead>
                    <tr>
                        <td>CODIGO PERSONA</td>
                        <td>DPI</td>
                        <td>NOMBRES</td>
                        <td>ACCIONES</td>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao = new PersonaDAO();
                    List<Persona> listaPersona = dao.listar();
                    Iterator<Persona>iterator = listaPersona.iterator();
                    Persona per = null;
                    while(iterator.hasNext()){
                        per = iterator.next();
                    
                %>    
                <tbody>
                    <tr>
                         <td><%=per.getCodigoPersona()%></td>
                         <td><%=per.getDPI()%></td>
                         <td><%=per.getNombrePersona()%></td>
                         <td>
                             <a href="Controlador?accion=editar&codigoPersona=<%= per.getCodigoPersona()%>">Edit</a>
                             <a>Remove</a>
                         </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>

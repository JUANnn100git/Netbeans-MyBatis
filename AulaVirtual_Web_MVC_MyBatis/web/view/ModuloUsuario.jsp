<%@page import="pe.edu.cibertec.pojos.Usuario"%>
<%@page import="pe.edu.cibertec.dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%
    UsuarioDao dao = new UsuarioDao();
    List<Usuario> usuarios = null;
    try {
        usuarios = dao.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CDN 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" >
        -->
        <!-- Bootstrap Source Files -->
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../resources/js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modulo de Usuario</h1>
        <br>
        <table class="table table-bordered table-condensed table-hover">
            <thead>
                <tr class="info" style="font-weight:bold">
                    <td>ID</td>
                    <td>Nombre de Usuario</td>
                    <td>Nombres</td>
                    <td>Apellidos</td>
                    <td>Correo</td>
                    <td>Estado</td>
                    <td>Rol</td>
                    <td colspan="2">Acciones</td>
                </tr>
            </thead>
            <tbody>
                <% for (Usuario u : usuarios) {%>
                <tr>
                    <td><%= u.getId()%></td>
                    <td><%= u.getNombreUsuario()%></td>
                    <td><%= u.getNombres()%></td>
                    <td><%= u.getApellidos()%></td>
                    <td><%= u.getCorreo()%></td>
                    <td><%= u.getEstado().getNombre()%></td>
                    <td><%= u.getRol().getNombre()%></td>
                    <td><a href="FormUsuario.jsp?action=updateUsuario&id=<%= u.getId()%>">Actualizar</td>
                    <td><a href="/AulaVirtual_Web_MVC/ControladorServlet?action=deleteUsuario&id=<%= u.getId()%>">Eliminar</td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <a href="FormUsuario.jsp?action=createUsuario">Crear Usuario</a>
    </body>
</html>

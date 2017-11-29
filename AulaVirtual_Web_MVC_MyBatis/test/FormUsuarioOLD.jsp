(<%@page import="java.util.List"%>
<%@page import="pe.edu.cibertec.dao.RolDao"%>
<%@page import="pe.edu.cibertec.entity.Rol"%>
<%@page import="pe.edu.cibertec.entity.Usuario"%>
<%@page import="pe.edu.cibertec.dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String action = request.getParameter("action");
    UsuarioDao dao = new UsuarioDao();
    Usuario u = new Usuario();
    RolDao rolDao = new RolDao();
    List<Rol> roles = rolDao.list();
    if (action.equals("createUsuario")) {
        u.setId(-1);
        u.setNombreUsuario("");
        u.setNombres("");
        u.setApellidos("");
        u.setContrasenia("");
        u.setCorreo("");
        u.setRol(new Rol());

    } else if (action.equals("updateUsuario")) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            u = dao.read(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="/AulaVirtual_Web_MVC/ControladorServlet?action=<%=action%>">
            <br>ID: <input type="text" name="txtId" value="<%= u.getId()%>" readonly />
            <br>Nombre de Usuario: <input type="text" name="txtNombreUsuario" value="<%= u.getNombreUsuario()%>" />
            <br>Nombres: <input type="text" name="txtNombres" value="<%= u.getNombres()%>" />
            <br>Apellidos: <input type="text" name="txtApellidos" value="<%= u.getApellidos()%>" />
            <br>Contraseña: <input type="text" name="txtContrasenia" value="<%= u.getContrasenia()%>" />
            <br>Correo: <input type="text" name="txtCorreo" value="<%= u.getCorreo()%>" />
            <br>Rol:<select name="cboRol">
                <% for (Rol r : roles) {
                        if (r.getId() == u.getRol().getId()) {
                %>
                <option value="<%=r.getId()%>" selected><%=r.getNombre()%></option>
                <% } else {%>
                <option value="<%=r.getId()%>"><%=r.getNombre()%></option>
                <% }  
                }%>
            </select>
            <br><input type="submit" name="btnCrear" value="submit" />
        </form>
    </body>
</html>

<%@page import="pe.edu.cibertec.dao.EstadoDao"%>
<%@page import="pe.edu.cibertec.pojos.Estado"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.cibertec.dao.RolDao"%>
<%@page import="pe.edu.cibertec.pojos.Rol"%>
<%@page import="pe.edu.cibertec.pojos.Usuario"%>
<%@page import="pe.edu.cibertec.dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String action = request.getParameter("action");
    UsuarioDao dao = new UsuarioDao();
    Usuario u = new Usuario();
    RolDao rolDao = new RolDao();
    EstadoDao estadoDao = new EstadoDao();
    List<Rol> roles = rolDao.list();
    List<Estado> estados = estadoDao.list();
    String operacionBoton = "";
    if (action.equals("createUsuario")) {
        u.setId(-1);
        u.setNombreUsuario("");
        u.setNombres("");
        u.setApellidos("");
        u.setContrasenia("");
        u.setCorreo("");
        u.setEstado(new Estado());
        u.setRol(new Rol());
        operacionBoton = "Crear Usuario";
    } else if (action.equals("updateUsuario")) {
        operacionBoton = "Actualizar Usuario";

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
        <!-- Bootstrap Source Files -->
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../resources/js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container"  >
            <form class="form-horizontal" method="post" action="/AulaVirtual_Web_MVC/ControladorServlet?action=<%=action%>" id="frmUsuario">
                <div class="form-group">
                    <div class="col-sm-7" style="text-align: center;">
                        <h2>Formulario de Usuario</h2>
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-2 control-label">ID:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtId" value="<%= u.getId()%>" readonly>
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-2 control-label">Nombre de Usuario:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtNombreUsuario" value="<%= u.getNombreUsuario()%>">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-2 control-label">Nombres:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtNombres" value="<%= u.getNombres()%>">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-2 control-label">Apellidos:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtApellidos" value="<%= u.getApellidos()%>">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-2 control-label">Contraseña:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtContrasenia" value="<%= u.getContrasenia()%>">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-2 control-label">Correo:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtCorreo" value="<%= u.getCorreo()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Estado</label>
                    <div class="col-sm-4 selectContainer">
                        <select class="form-control" name="cboEstado">
                            <% for (Estado e : estados) {
                                    if (e.getId() == u.getEstado().getId()) {
                            %>
                            <option value="<%=e.getId()%>" selected><%=e.getNombre()%></option>
                            <% } else {%>
                            <option value="<%=e.getId()%>"><%=e.getNombre()%></option>
                            <% }
                                }%>
                        </select>
                    </div>
                </div>   
                <div class="form-group">
                    <label class="col-sm-2 control-label">Rol</label>
                    <div class="col-sm-4 selectContainer">
                        <select class="form-control" name="cboRol">
                            <% for (Rol r : roles) {
                                    if (r.getId() == u.getRol().getId()) {
                            %>
                            <option value="<%=r.getId()%>" selected><%=r.getNombre()%></option>
                            <% } else {%>
                            <option value="<%=r.getId()%>"><%=r.getNombre()%></option>
                            <% }
                                }%>
                        </select>
                    </div>
                </div>            
            </form>
            <div class="form-group col-sm-6"  style="text-align: center;">
                <button class="btn btn-primary" type="submit" form="frmUsuario"><%=operacionBoton%></button>
            </div>
    </body>
</div>
</html>

<%@page import="com.java.dao.EspecialidadDao"%>
<%@page import="com.java.pojos.Especialidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/structure/header.jsp"%>
        <%
            String operacion = request.getParameter("operacion");;
            String operacionBoton = null;
            String actionRequest = null;
            int id = -1;
            String descripcion = "";
            Especialidad especialidad = new Especialidad();
            EspecialidadDao dao = new EspecialidadDao();
            if (operacion.equals("create")) {
                operacionBoton = "Crear Especialidad";
                actionRequest = "createEspecialidad";
            } else if (operacion.equals("update")) {
                operacionBoton = "Actualizar Especialidad";
                try {
                    especialidad = dao.read(Integer.parseInt(request.getParameter("id")));
                    id = especialidad.getId();
                    descripcion = especialidad.getNombre();
                    actionRequest = "updateEspecialidad";
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        %>
        <title>Formulario de Especialidad</title>
    </head>
    <body>
        <div class="container"  >
            <form class="form-horizontal" method = "POST" action="/WebClinica_MyBatis/controller?action=<%=actionRequest%>" name="frmEspecialidad" id="frmEspecialidad">
                <div class="form-group">
                    <div class="col-sm-7" style="text-align: center;">
                        <h2>Formulario de Especialidad</h2>
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">ID de Especialidad:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtId" placeholder="Ingrese el ID de la especialidad"
                               value="<%= id %>" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Nombre:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtNombre" placeholder="Ingrese el Nombre"
                               value="<%= descripcion %>">
                    </div>
                </div>
            </form>
            <div class="form-group col-sm-6"  style="text-align: center;">
                <button class="btn btn-primary" type="submit" form="frmEspecialidad"><%=operacionBoton%></button>
            </div>
        </div>
    </body>
    <% request.setAttribute("actionView", "readEspecialidad");%>
    <%@include file="/structure/footerList.jsp" %>
</html>

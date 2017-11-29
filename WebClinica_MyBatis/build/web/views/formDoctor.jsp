<%@page import="com.java.pojos.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="com.java.dao.EspecialidadDao"%>
<%@page import="com.java.dao.DoctorDao"%>
<%@page import="com.java.pojos.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/structure/header.jsp"%>
        <%
            Boolean isUpdate = false;
            Doctor doctor = new Doctor();
            EspecialidadDao espDao = new EspecialidadDao();
            request.setAttribute("especialidades", espDao.list());
            if (request.getParameter("operacion").equals("create")) {
                isUpdate = false;
            } else if (request.getParameter("operacion").equals("update")) {
                isUpdate = true;
                doctor = new DoctorDao().read(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("selectedEspecialidad", doctor.getEspecialidad().getId());
            }
        %>
        <title>Formulario de Doctor</title>
    </head>
    <body>
        <div class="container"  >
            <form class="form-horizontal" method = "POST" action="/WebClinica_MyBatis/controller?action=<%= isUpdate ? "updateDoctor" : "createDoctor"%>" name="frmDoctor" id="frmDoctor">
                <div class="form-group">
                    <div class="col-sm-7" style="text-align: center;">
                        <h2>Formulario de Doctor</h2>
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">ID de Doctor:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtId" placeholder="ID Autogenerado"
                               value="<%= isUpdate ? doctor.getId() : -1%>" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Nombres:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtNombre" placeholder="Ingrese el nombre" value="<%= isUpdate ? doctor.getNombre() : ""%>">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Apellido Paterno:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtApPaterno" placeholder="Ingrese el Apellido P." value="<%= isUpdate ? doctor.getAp_paterno() : ""%>">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Apellido Materno:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtApMaterno" placeholder="Ingrese el Apellido M." value="<%= isUpdate ? doctor.getAp_materno() : ""%>">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Especilidad:</label>
                    <div class="col-sm-4">
                        <select name='cboEspecialidad'>
                            <c:forEach items="${especialidades}" var="especialidad">
                                <option value="${especialidad.id}" ${especialidad.id == selectedEspecialidad ? 'selected' : ''}>${especialidad.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>     
            </form>
            <div class="form-group col-sm-6"  style="text-align: center;">
                <button class="btn btn-primary" type="submit" form="frmDoctor"><%= isUpdate ? "Actualizar Doctor" : "Crear Doctor"%></button>
            </div>
        </div>
    </body>
    <% request.setAttribute("actionView", "readDoctor");%>
    <%@include file="/structure/footerList.jsp" %>
</html>

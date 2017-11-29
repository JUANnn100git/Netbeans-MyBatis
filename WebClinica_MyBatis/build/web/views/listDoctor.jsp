
<%@page import="com.java.pojos.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="com.java.dao.EspecialidadDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%
    EspecialidadDao espDao = new EspecialidadDao();
    request.setAttribute("especialidades", espDao.list());
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/structure/header.jsp"%>
        <script src="<%=request.getContextPath()%>/resources/js/funciones.js" type="text/javascript"></script>
        <title>Lista de Doctores</title>
    </head>
    <body class="bodyOverflow">
        <br>
        <section class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1 class="panel-title"><strong>Lista de Doctores</strong></h1>
                        </div>
                        <div class="panel-body table-responsive">
                            <table class="table table-bordered table-condensed table-hover" id="tableScroll">
                                <thead>
                                    <tr class="info">
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Apellido P.</th>
                                        <th>Apellido M.</th>
                                        <th>Especialidad</th>
                                        <th colspan=2 style="text-align:center;">Acciones</th>  
                                    </tr>            
                                </thead>
                                <tbody>
                                    <c:forEach items = "${doctores}" var = "doctor">
                                        <tr>
                                            <td><c:out value ="${doctor.id}"/></td>
                                            <td><c:out value ="${doctor.nombre}"/></td>
                                            <td><c:out value ="${doctor.ap_paterno}"/></td>
                                            <td><c:out value ="${doctor.ap_materno}"/></td>
                                            <td><c:out value ="${doctor.especialidad.nombre}"/></td>
                                            <td style="text-align:center;"><a href="views/formDoctor.jsp?operacion=update&id=<c:out value = "${doctor.id}"/>">
                                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                                            <td style="text-align:center;"><a href="javascript:void(0);" onclick="eliminar('controller?action=deleteDoctor&id=<c:out value = "${doctor.id}"/>')">
                                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <a href="views/formDoctor.jsp?operacion=create" class="btn btn-success">Crear Doctor</a>
            </div>
        </section>
    </body>
    <%@include file="/structure/footer.jsp" %>
</html>

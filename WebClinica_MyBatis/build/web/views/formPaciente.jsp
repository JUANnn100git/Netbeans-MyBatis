<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/structure/header.jsp"%>
        <title>Formulario de Paciente</title>
    </head>
    <body>
        <div class="container"">
            <form class="form-horizontal" method = "POST" action="/WebClinica_MyBatis/controller?action=createPaciente" name="frmPaciente" id="frmPaciente">
                <div class="form-group">
                    <div class="col-sm-7" style="text-align: center;">
                        <h2>Formulario de Paciente</h2>
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">ID de Paciente:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtIdPaciente" placeholder="Ingrese el ID del Paciente">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Nombres:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtNombre" placeholder="Ingrese el Nombre">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Apellido Paterno:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtApPaterno" placeholder="Ingrese el Apellido P.">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Apellido Materno:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtApMaterno" placeholder="Ingrese el Apellido M.">
                    </div>
                </div>

                <div class="form-group">	
                    <label class="col-sm-3 control-label">Tipo de Documento de Identidad:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtTipodocid" placeholder="Ingrese el Tipo de Documento de ID.">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Número de Documento de Identidad</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtNumerodedocid" placeholder="Ingrese el Número de Documento de ID">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Edad:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtEdad" placeholder="Ingrese la Edad.">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Dirección:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtDireccion" placeholder="Ingrese la Dirección.">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Teléfono:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="txtTelefono" placeholder="Ingrese el Teléfono.">
                    </div>
                </div>
            </form>
            <div class="form-group col-sm-6"  style="text-align: center;">
                <button class="btn btn-primary" type="submit" form="frmPaciente">Crear Paciente</button>
            </div>
            
        </div>
        <br><br><br>
           <%@include file="/structure/footer.jsp" %>
    </body>
    
</html>

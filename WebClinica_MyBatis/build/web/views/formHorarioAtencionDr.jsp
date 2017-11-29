<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/structure/header.jsp"%>
        <title>Formulario de Horario de Atención de los Doctores</title>
    </head>
    <body>
        <div class="container"  >
            <form class="form-horizontal" method = "POST" action="/WebClinica_MyBatis/controller?action=createDoctor" name="frmHorarioAtencion" id="frmDoctor">
                <div class="form-group">
                    <div class="col-sm-7" style="text-align: center;">
                        <h2>Formulario de Horario de Atención de los Doctores</h2>
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">ID de Doctor:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtIdDoctor" placeholder="Ingrese el ID del doctor">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Hora de Inicio</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtHoradeinicio" placeholder="Ingrese la Hora de Inicio">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Hora de Fin:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtHorafin" placeholder="Ingrese la Hora de Fin">
                    </div>
                </div>
                <div class="form-group">	
                    <label class="col-sm-3 control-label">Número de Consultorio:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="txtNumeroConsultorio" placeholder="Ingrese el Número de Consultorio">
                    </div>
                </div>
            </form>
            <div class="form-group col-sm-6"  style="text-align: center;">
                <button class="btn btn-primary" type="submit" form="frmHorarioAtencion">Crear Horario de Atención</button>
            </div>
        </div>
    </body>
    <%@include file="/structure/footer.jsp" %>
</html>

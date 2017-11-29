<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/structure/header.jsp"%>
        <title>Clinica Cibertec DAT</title>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>CLINICA Cibertec - DAT</h1>
            </div>
        </header>
        <div class="container">
            <section class="main row">
                <article class="col-md-12">
                    <p>
                    <h3>Caso de Estudio Java Fundamentals</h3>
                    Una clínica de Lima, se ha decidido en crear una aplicación de software en Java para permitir realizar las citas de sus pacientes. Esta es una aplicación Web que muestra dicho requerimiento utilizando el patrón MVC y las siguientes tecnologías: POO, jsp, jstl, servlets, conexión a Base de Datos MySQL con MyBatis, JavaScript, HTML, CSS y Bootstrap.
                    </p>
                </article>
            </section>
            <br>
            <div class="row">
                <div class="color1 col-xs-12 col-sm-6 col-md-4 panel">
                    <p >
                    <h3 style="text-align:center;">Menu de Opciones</h3>
                    </p>	
                    <a href="controller?action=readEspecialidad" class="btn btn-lg btn-block btn-primary">Especialidad</a>
                    <a href="controller?action=readDoctor" class="btn btn-lg btn-block btn-success">Doctor</a>
                    <a href="views/formPaciente.jsp" class="btn btn-lg btn-block btn-info">Paciente</a>
                    <a href="views/formHorarioAtencionDr.jsp" class="btn btn-lg btn-block btn-warning">Horario de Atención</a>
                    <a href="views/formCitaPaciente.jsp" class="btn btn-lg btn-block btn-danger">Cita Médica</a>
                    <br>

                </div>
                <div class=" color2 col-xs-12 col-sm-6 col-md-8 panel" style="padding-left: 0px;  padding-right: 0px;">
                    <div style="padding-left: 8px;  padding-right: 8px; padding-bottom: 8px;">
                        <div>
                            <h3 style="text-align:center;">Base de Datos
                                <button type="button" class="btn btn-default" aria-label="Left Align"  onclick="location.href = 'views/databaseScript.jsp';">
                                    <span class="glyphicon glyphicon-book" aria-hidden="true"></span>
                                </button>
                            </h3>
                        </div>
                        <img src="resources/images/dbclinica.png" class="img-responsive">
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="container">
                <h4>Juan Villanueva Aguinaga</h4>
            </div>
        </footer>
    </body>
</html>

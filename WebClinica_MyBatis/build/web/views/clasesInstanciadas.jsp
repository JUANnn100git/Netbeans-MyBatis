<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/structure/header.jsp"%>
        <%
            Object objeto = request.getAttribute("objeto");
            String objetoNombre = objeto.getClass().getSimpleName();
        %>
        <title>Clases Instanciadas</title>
    </head>
    <body>
        <header style="background: #2c3e50;color:#fff;">
            <div class="container">
                <h1>Clases Instanciadas</h1>
            </div>
        </header>
        <div class="container">
            <section class="main row">
                <article class="col-md-12">
                    <p>
                    <h3>La clase <%=objetoNombre%> ha sido instanciada</h3>
                    </p>
                </article>
            </section>
            <br>
            <div class="row">
                <div class="color1 col-xs-12 col-sm-6 col-md-4" style="background: #2c3e50;color:#fff;">
                    <p>
                    <h3>Datos del objeto</h3>
                    <h3><%=objeto.toString()%></h3>
                    </p>	
                    <br>
                </div>
            </div>
        </div>

    </body>
    <%@include file="/structure/footer.jsp" %>
</html>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <%@include file="commons/CDN(4).jsp" %>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="icon" href="img/ico.png">
        <style>
            body {
                margin: auto;
            }
        </style>
    </head>
    <body>
        <div class="cuerpo">
            <h1>Registrado</h1>
            <div class="alert alert-success">
                <strong>Proceso Finalizado!</strong><a class="alert-link">Informe enviado</a>.
                <div>
                    <a type="button" class="txtbtn btn btn-outline-danger" href="Menu_U.jsp">
                        <i class="fas fa-edit"></i><b>Finalizar</b>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>

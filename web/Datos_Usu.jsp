<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <%@include file="commons/CDN(4).jsp" %>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="icon" href="img/ico.png">
    </head>
    <body>
        <%@include file="commons/Co_Usu/Cabecera_U.jsp" %>
        <div class="cuerpo">
            <div class="barra">
                <%@include file="commons/Co_Usu/SideBar_U.jsp" %>
            </div>
            <div class="contenido">
                <center>
                    <h1 class="lt">
                        <b>Datos de Usuario</b>
                    </h1>
                </center>
                <br>
                <div class="tabla2">
                    <table>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo">Usuario:</h1></th>
                            <td class="lt3 ñ" colspan="2">${Usu.getNombres()}</td>
                        </tr>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo">Contacto:</h1></th>
                            <td class="lt3 ñ" colspan="2">${Usu.getContacto()}</td>
                        </tr>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo">Correo:</h1></th>
                            <td class="lt3 ñ" colspan="2">${Usu.getCorreo()}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

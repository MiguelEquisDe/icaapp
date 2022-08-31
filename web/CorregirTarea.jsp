<%@page import="beens.RegistroBeens"%>
<%@page import="java.util.ListIterator"%>
<%@page import="DAO.RegistroDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Reasignar Tarea</title>
        <%@include file="commons/CDN(4).jsp" %>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <link rel="icon" href="img/ico.png">
    </head>
    <body>
        <%@include file="commons/Co_Admin/Cabecera_A.jsp" %>
        <div class="cuerpo">
            <div class="barra">
                <%@include file="commons/Co_Admin/SideBar_A.jsp" %>
            </div>
            <div class="contenido">
                <center>
                    <h1 class="lt">
                        <b>Reasignar Tarea</b>
                    </h1>
                </center>
                <br>
                <form class="bdr" action="ControladorCasino?menu=datos" method="POST" enctype="multipart/form-data">
                    <div class="form-group d-flex">
                        <div class="aucont">
                            <a class="lt" style="color: black; font-size: small; text-decoration: none;">(No se ha implementado un metodo para reconocer tildes y la "ñ")</a>
                            <div class="lt2t t" style="width: 100%;">
                                <center><label style="margin-bottom: 0px; float: none" class="lt2 t"><b>Título</b></label></center>
                                <a style="color: black; font-size: small;">(Nombre del casino o la tarea)</a>
                                <input type="text" value="${datos.getNombres()}" name="nom" class="form-control">
                            </div>
                            <div class="lt2 t" style="width: 100%;">
                                <br>
                                <center><label style="margin-bottom: 0px;"><b>Descripción</b></label></center>
                                <a style="color: black; font-size: small;">(# de Maquina y/o descripción de la tarea)</a>
                                <textarea class="txtt" name="des" style="height: 300px">${datos.getDescripcion()}</textarea>
                            </div>
                            <center>
                            </center>
                            <div class="lt2 t" style="width: 100%;">
                                <center><label style="margin-bottom: 0px;"><b>Solución:</b></label></center>
                                <a style="color: black; font-size: small; float: left;">(Solución de la tarea)</a>
                                <textarea class="txtt" name="sol" style="height: 300px" disabled="disabled" required>${datos.getSolucion()}</textarea>
                            </div>
                        </div>
                    </div>
                    <div>
                        <center>
                            <button type="submit" name="accion" value="establecerr" class="txtbtn btn btn-outline-warning">
                                <i class="fas fa-edit"></i> <b>Reasignar</b>
                            </button>
                        </center>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

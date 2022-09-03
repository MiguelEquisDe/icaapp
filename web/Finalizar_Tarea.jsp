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
        <title>Finalizar Tarea</title>
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
                        <b>Proceso de Finalización</b>
                    </h1>
                </center>
                <br>
                <form class="bdr" action="ControladorCasino?menu=datos" method="POST" enctype="multipart/form-data">
                    <div class="form-group d-flex">
                        <div class="aucont">
                            <center>
                                <div class="lt2 t" style="width: 100%;">
                                    <input type="text" value="${Usu.getNombres()}" name="nom" hidden="">
                                    Título: ${datos.getNombres()}
                                    <input type="text" value="${datos.getNombres()}" name="tarea" hidden="">
                                    <br>
                                    <center><label style="margin-bottom: 0px;"><b>Solución:</b></label></center>
                                    <a style="color: black; font-size: small; float: left;">(Solución de la tarea)</a>
                                    <textarea class="txtt" name="sol" style="height: 300px" required>${datos.getSolucion()}</textarea>

                                    <center><label style="margin-bottom: 0px;"><b>Imagen</b></label></center>
                                    <a style="color: black; font-size: small; float:left;">(Inserte evidencia de lo realizado)</a>
                                    <br>
                                    <a style="color: black; font-size: small; float:left;">(1 Foto max.)</a>
                                    <div style="max-width: max-content;">
                                        <input type="file" style="width: 100%;" name="imgP" accept="image/*" required>
                                    </div>
                                </div>
                            </center>
                            <div class="conteni">
                                <center>
                                    <a style="color: white; font-size: small;">Verificar los datos antes de finalizar</a>
                                </center>
                            </div>
                        </div>
                    </div>
                    <div>
                        <center>
                            <button type="submit" name="accion" value="Insertar_Finalizar" class="txtbtn btn btn-outline-success">
                                <i class="fas fa-edit"></i><b>Finalizar</b>
                            </button>
                        </center>
                    </div>
                    </br>
                </form>
            </div>
        </div>
    </body>
</html>

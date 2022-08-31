<%@page import="beens.BeensCasinos"%>
<%@page import="java.util.ListIterator"%>
<%@page import="DAO.CasinoDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <script src="js/push.min.js"></script>

        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Menú</title>
        <%@include file="commons/CDN(4).jsp" %>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                <%
                    List lista = new CasinoDAO().get_0();
                    ListIterator list = lista.listIterator();
                    while (list.hasNext()) {
                        BeensCasinos reM = (BeensCasinos) list.next();
                %>
                <div class="conte col-sm-12">
                    <div class="lt" style="text-decoration: none;">
                        <div class="co">
                            <div class="contenedor">
                                <div class="contimg">
                                    <img class="imgcas" src="ControladorImg?id_casino=<%= reM.getId_casino()%>">
                                </div>
                            </div>
                            <div class="pcc">
                                <div class="cimg">
                                    <h1>
                                        <b><%= reM.getNombres()%></b>
                                    </h1>
                                </div>
                                <br><br>
                                <div class="cimg2">
                                    <textarea class="txt" rows="5" disabled="disabled"><%= reM.getDescripcion()%></textarea>
                                </div>
                            </div>
                        </div>
                        <center>
                            <a href="ControladorCasino?menu=datos&accion=Cargar&id_casino=<%= reM.getId_casino()%>" style="float: right;" class="txtbtn btn btn-outline-success">
                                <b>Actualizar</b>
                            </a>
                        </center>
                        <center>
                            <a href="ControladorCasino?menu=datos&accion=Borrar&id_casino=<%= reM.getId_casino()%>" style="float: right;" class="txtbtn btn btn-outline-danger">
                                <b>Borrar</b>
                            </a>
                        </center>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>

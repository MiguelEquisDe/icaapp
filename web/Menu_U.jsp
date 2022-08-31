<%@page import="beens.BeensCasinos"%>
<%@page import="java.util.ListIterator"%>
<%@page import="DAO.CasinoDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Menú</title>
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
                            <a href="ControladorCasino?menu=datos&accion=Cargar_Finalizar&id_casino=<%= reM.getId_casino()%>" style="float: right;" class="txtbtn btn btn-outline-success">
                                <b>Finalizar Tarea</b>
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

<%@page import="beens.RegistroBeens"%>
<%@page import="java.util.ListIterator"%>
<%@page import="DAO.RegistroDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista Usuarios</title>
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
                        <b>Agregar o modificar usuario</b>
                    </h1>
                </center>
                <br>
                <form class="bdr" action="ControladorA?menu=Administrador" method="POST">
                    <div class="form-group d-flex">
                        <div class="aucont">
                            <div class="rrr">
                                <div class="lt2 t">
                                    <center><label class="txtba"><b>Nombre</b></label></center>
                                    <input type="text" value="${datos.getNombres()}" name="nombres" class="form-control" placeholder="Nombre de usuario" required>
                                    <a style="color: white; font-size: small">(Ingrese el nombre del Usuario)</a>
                                </div>
                                <div class="lt2 t">
                                    <center><label class="txtba"><b>Contacto</b></label></center>
                                    <input type="number" value="${datos.getContacto()}" name="contacto" class="form-control" placeholder="Numero de contacto" required>
                                    <a style="color: white; font-size: small">(Verificar numero telefónico)</a>
                                </div>
                                <div class="lt2 t">
                                    <center><label class="txtba"><b>Correo</b></label></center>
                                    <input type="email" value="${datos.getCorreo()}" name="correo" class="form-control" placeholder="Correo electrónico" required>
                                    <a style="color: white; font-size: small">(Verificar el correo electrónico)</a>
                                </div>
                                <div class="lt2 t">
                                    <center><label class="txtba"><b>Rol</b></label></center>
                                    <input type="text" value="${datos.getRol()}" name="rol" class="form-control" placeholder="¿Administrador o Usuario?">
                                    <a style="color: white; font-size: small">(Asegurese de asignar correctamente el Rol)
                                        <br>(Al dejar el espacio en blanco se le asignará rol de Usuario)</a>
                                </div>
                            </div>
                            <center>
                                <a style="color: white; font-size: small">Verificar los datos antes de agregar o actualizar</a>
                            </center>
                        </div>
                    </div>
                    <center>
                        <div>
                            <center>
                                <button type="submit" name="accion" value="agregar" class="txtbtn btn btn-outline-primary">
                                    <i class="fas fa-user-plus"></i> <b>Agregar</b>
                                </button>
                                <button type="submit" name="accion" value="modificar" class="txtbtn btn btn-outline-success">
                                    <i class="fas fa-edit"></i> <b>Modificar</b>
                                </button>
                            </center>
                        </div>
                    </center>
                    </br>
                </form>
                <%
                    List lista = new RegistroDAO().getAll();
                    ListIterator list = lista.listIterator();
                    while (list.hasNext()) {
                        RegistroBeens reM = (RegistroBeens) list.next();
                %>
                <div class="tabla">
                    <table>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo"><b>ID:</b></h1></th>
                            <td class="lt3 ñ" colspan="2"><%= reM.getId_registro()%></td>
                        </tr>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo"><b>Usuario:</b></h1></th>
                            <td class="lt3 ñ" colspan="2"><%= reM.getNombres()%></td>
                        </tr>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo"><b>Contacto:</b></h1></th>
                            <td class="lt3 ñ" colspan="2"><%= reM.getContacto()%></td>
                        </tr>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo"><b>Correo:</b></h1></th>
                            <td class="lt3 ñ" colspan="2"><%= reM.getCorreo()%></td>
                        </tr>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo"><b>Rol:</b></h1></th>
                            <td class="lt3 ñ" colspan="2"><%= reM.getRol()%></td>
                        </tr>
                        <tr class="ñ">
                            <th><h1 class="lt ttlo"><b>Opciones:</b></h1></th>
                            <td class="ñ">
                        <center>
                            <a href="ControladorA?menu=Administrador&accion=cargar&id_registro=<%= reM.getId_registro()%>" class="txtbtn btn btn-outline-success">
                                <b>Actualizar</b>
                            </a>
                            <a href="ControladorA?menu=Administrador&accion=borrar&id_registro=<%= reM.getId_registro()%>" class="txtbtn btn btn-outline-danger">
                                <b>Borrar</b>
                            </a>
                        </center>
                        </td>
                        </tr>
                    </table>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>

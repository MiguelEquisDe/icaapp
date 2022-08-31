<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <%@include file="commons/CDN(4).jsp"%>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/push.js/0.0.11/push.min.js"></script>
        <link rel="icon" href="img/ico.png">
    </head>
    <body>
        <br><br>
        <div class="conten">
            <center>
                <div class="cl"> 
                    <div class="cb">
                        <form action="ValidarIngreso"  method="POST">
                            <center>
                                <img class="limg" src="img/ruser.png"/>
                            </center>
                            <div class="cu">
                                <div class="form-group">
                                    <label class="lt"><b>Usuario</b></label>
                                    <center>
                                        <input type="text" class="usu form-control" placeholder="Ingrese Usuario" name="usr" style="text-align: center;" required>
                                    </center>
                                    <br>
                                    <center>
                                        <button type="submit" name="accion" value="ingresar" class="txtbtn btn btn-outline-danger">Ingresar</button>
                                    </center>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </center>
        </div>
    </body>
</html>
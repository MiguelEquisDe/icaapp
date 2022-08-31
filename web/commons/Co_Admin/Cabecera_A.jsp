<nav class="cab navbar navbar-expand-md bg-dark navbar-dark">
    <div class="btn-group">
        <button type="button" class="btn btn-default dropdown-toggle"
                data-toggle="dropdown" style="box-shadow: 2px 2px 15px transparent, -2px -2px 15px transparent, 
                -2px 2px 15px transparent, 2px -2px 15px transparent;">
            <center>
                <img src="img/PFL.png" class="cabe">
            </center>
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" role="menu">
            <li><a class="dropdown-item" style="background-color: white;"><b>${Administrador.getNombres()}</b></a></li>
            <li class="divider"></li>
            <li><a class="dropdown-item" href="ControladorA?menu=Administrador&accion=cerrarS">Cerrar Sesion</a></li>                
        </ul>
    </div>
</nav>
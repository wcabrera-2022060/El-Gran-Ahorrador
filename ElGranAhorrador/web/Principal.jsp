<%-- 
    Document   : index
    Created on : 5/07/2023, 05:24:30 PM
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Principal</title>
        <%-- Link hacia el CSS --%>
        <link rel="stylesheet" href="./css/styles.css">

        <%-- Importando jQuery libreria --%>
        <script
            src="https://code.jquery.com/jquery-3.7.0.slim.min.js"
            integrity="sha256-tG5mcZUtJsZvyKAxYLVXrmjKBVLd6VpVccqz/r4ypFE="
        crossorigin="anonymous"></script>

        <%-- Link hacia las animaciones con jQuery --%>
        <script src="./js/animacionBoton.js" defer></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-custom navbar-mainbg">
            <i class="navbar-brand navbar-logo" href="#">El Gran Ahorrador</i>
            <button class="navbar-toggler" type="button" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars text-white"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto navbar-nav-scroll">
                    
                    
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador?menu=Home" target="myFrame"><i class="far fa-copy"></i>Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Login&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=TipoEmpleado&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Tipo Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Sucursal&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Sucursales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Afiliado&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Afiliados</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=MetodoPago&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Método de pago</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Cupon&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Cupones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=TipoProducto&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Tipo de Producto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Inventario&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Inventario</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Empleado&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Cliente&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Envio&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Envío</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Producto&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Proveedor&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Proveedores</a>
                    </li>
                    <%-- Estás entidades después serán trasladadas al carrito de compras --%>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Factura&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Factura</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=Compra&accion=Listar" target="myFrame"><i class="far fa-copy"></i>Compra</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown dropdown-edit">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${login.getUsuario()}
                </button>
                <div class="dropdown-menu text-center dropdown-menu-edit" aria-labellebdy="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                        <img src="ControladorIMG?id=${login.getIdLogin()}" alt="60" width="60"/>
                        
                    </a>
                    <a class="dropdown-item" href="#" >${login.getUsuario()}</a>
                    <a class="dropdown-item" href="#" >${login.getUsuario()}@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" name="Salir" class="dropdown-item" href="index.jsp">Salir</button>
                    </form>
                </div>
            </div>
        </nav>


        <div class="m-4" style="height: 1200px">
            <iframe name="myFrame" style="height: 100%; width: 100%; border:none"></iframe>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>

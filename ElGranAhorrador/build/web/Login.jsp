<%-- 
    Document   : Fotos
    Created on : 3/09/2023, 12:30:42 AM
    Author     : weslly
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <%--Cambiar Nombre a su entidad osea donde dice Vista Envio--%>
        <title>Vista Login</title>
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


        <div class="card-body">
            <%--Cambiar Nombre a su entidad osea donde dice Envio--%>
            <h1 class="form-group text-center">Login</h1>
            <form action="Controlador?menu=Login" method="POST" enctype="multipart/form-data">
                <%--Si necesitan agregar más atributos copien lo que esta bajo de este comentario--%>

                <div class="form-group">
                    <%--Cambian el atributo: de la etiqueta <Label> y colocan sus atributos--%>
                    <label>Id:</label>
                    <input type="text" value="" name="txtIdLogin" class="form-control" readonly="true">
                </div>


                <%--Hasta aca, y lo pegan en orden porfa, conforme a sus atributos--%>
                <div class="form-group">
                    <label>Usuario:</label>
                    <input type="text" value="" name="txtUsuario" class="form-control" required>
                </div>

                <div class="form-group">
                    <label>Contra:</label>
                    <input type="text" value="" name="txtContrasena" class="form-control" required>
                </div>

                <div class="form-group">
                    <label>Tipo:</label>
                    <input type="text" value="" name="txtTipoUsuario" class="form-control" required>
                </div>

                <div class="form-group">
                    <label>Foto:</label>
                    <input type="file" value="" name="fileFoto" class="form-control">
                </div>


                <div class="botones">
                    <div name="accion" value="Actualizar" class="button button-actualizar" href="#">
                        <span>
                            <input class="quitar" type="submit" name="accion" value="Actualizar">
                        </span>
                    </div>
                    <div name="accion" value="Agregar" class="button button-agregar" href="#">
                        <span>
                            <input class="quitar" type="submit" name="accion" value="Agregar">
                        </span>
                    </div>
                </div>
            </form>
        </div>


        <table class="table table-hover">
            <thead>
            <th>ID</th>
            <th>Usuario</th>
            <th>Contraseña</th>
            <th>tipo</th>
            <th>foto</th>
        </thead>
        <tbody>
            <c:forEach var="login" items="${listaLogin}">
                <tr>
                    <td>${login.getIdLogin()}</td>
                    <td>${login.getUsuario()}</td>
                    <td>${login.getContrasena()}</td>
                    <td>${login.getTipoUsuario()}</td>
                    <td><img src="ControladorIMG?id=${login.getIdLogin()}" width="150" height="130"></td>
                    <td>
                        <a class="button button-editar" href="Controlador?menu=TipoEmpleado&accion=Editar&codigoTipoEmpleado=${tipoEmpleado.getIdTipoEmpleado()}"><span>Editar</span></a>
                        <a class="button button-eliminar" href="#" data-toggle="modal" data-target="#deleteModal-${tipoEmpleado.getIdTipoEmpleado()}"><span>Eliminar</span></a>
                    </td>
                </tr>
            </c:forEach>   
        </tbody>
    </table>



    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>

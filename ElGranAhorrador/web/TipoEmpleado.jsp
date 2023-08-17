<%-- 
    Document   : TipoEmpleado
    Created on : 15/08/2023, 06:26:55 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <%--Cambiar Nombre a su entidad osea donde dice Vista Envio--%>
        <title>Vista Tipo Empleado</title>
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
            <h1 class="form-group text-center">Tipo Empleado</h1>
            <form>
                <%--Si necesitan agregar más atributos copien lo que esta bajo de este comentario--%>
                <div class="form-group">
                    <%--Cambian el atributo: de la etiqueta <Label> y colocan sus atributos--%>
                    <label>Id Tipo Empleado:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>
                <%--Hasta aca, y lo pegan en orden porfa, conforme a sus atributos--%>
                <div class="form-group">
                    <label>Tipo Empleado:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>
                <div class="form-group">
                    <label>Descipción:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>
                <div class="form-group">
                    <label>Departamento:</label>
                    <input type="text" value="" name="" class="form-control">
                </div>
                <div class="botones">
                    <div name="accion" value="Actualizar" class="button button-actualizar" href="#"><span>Actualizar</span></div>
                    <div name="accion" value="Agregar" class="button button-agregar" href="#"><span>Agregar</span></div>
                </div>
            </form>
        </div>


        <table class="table table-hover">
            <thead>
            <th>ID TIPO EMPLEADO</th>
            <th>TIPO EMPLEADO</th>
            <th>DESCRIPCIÓN</th>
            <th>DEPARTAMENTO</th>
            <th>ACCIONES</th>
        </thead>
        <tbody>
            <c:forEach var="tipoEmpleado" items="${tipoEmpleados}">
                <tr>
                    <td>${tipoEmpleado.getIdTipoEmpleado()}</td>
                    <td>${tipoEmpleado.getTipoEmpleado()}</td>
                    <td>${tipoEmpleado.getDescripcion()}</td>
                    <td>${tipoEmpleado.getDepartamento()}</td>
                    <td>
                        <div class="button button-editar" href="#"><span>Editar</span></div>
                        <div class="button button-eliminar" href="#"><span>Eliminar</span></div>
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

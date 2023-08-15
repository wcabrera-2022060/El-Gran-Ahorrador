<%-- 
    Document   : ListaEnvio
    Created on : 10/08/2023, 11:06:44 PM
    Author     : Mr Hermes Jr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Vista Envío</title>
    </head>
    <body>
        <div class="m-4" style="height: 500px">

            <table class="table table-hover">
                <thead>
                <th>ID ENVÍO</th>
                <th>DIRECCIÓN ENVÍO</th>
                <th>TELÉFONO CONTACTO</th>
                <th>ID EMPLEADO</th>
                <th>ACCIONES</th>
                </thead>
                <tbody>
                <c:forEach var="envio" items="${envios}">
                    <tr>
                        <td>${envio.getIdEnvio()}</td>
                        <td>${envio.getDireccionEnvio()}</td>
                        <td>${envio.getTelefonoContacto()}</td>
                        <td>${envio.getIdEmpleado()}</td>
                        <td>
                            <a class="btn btn-warning" href="#">Editar</a>
                            <a class="btn btn-danger" href="#">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>        
                </tbody>
            </table>
        </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>

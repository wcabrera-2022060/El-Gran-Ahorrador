<%-- 
    Document   : MetodoPago
    Created on : 11/08/2023, 06:19:12 PM
    Author     : JoseMario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <%--Cambiar Nombre a su entidad osea donde dice Vista Envio--%>
        <title>Vista MetodoPago</title>
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
                    <h1 class="form-group text-center">MétodoPago</h1>
                    <form action="Controlador?menu=MetodoPago" method="POST">
                        <div class="form-group">
                            <label>ID Método Pago:</label>
                            <input type="text" value="${metodoPagoEncontrado.getIdMetodoPago()}" name="txtidMetodoPago" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Método Pago:</label>
                            <input type="text" value="${metodoPagoEncontrado.getMetodoPago()}" name="txtMetodoPago" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Pago Total:</label>
                            <input type="text" value="${metodoPagoEncontrado.getPagoTotal()}" name="txtPagoTotal" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Banco:</label>
                            <input type="text" value="${metodoPagoEncontrado.getBanco()}" name="txtBanco" class="form-control">
                        </div>
                        <div class="botones">
                    <div name="accion" value="Actualizar" class="button button-actualizar" href="#"><span><input class="quitar" type="submit" name="accion" value="Actualizar"></span></div>
                    <div name="accion" value="Agregar" class="button button-agregar" href="#"><span><input class="quitar" type="submit" name="accion" value="Agregar"></span></div>
                </div>
                    </form>
                </div>
            </div>

                <table class="table table-hover">
                    <thead>
                        <th>ID MÉTODO PAGO</th>
                        <th>MÉTODO PAGO</th>
                        <th>PAGO TOTAL</th>
                        <th>BANCO</th>
                    </thead>
                    <tbody>
                    <c:forEach var="metodopago" items="${metodoPagos}">
                    <tr>
                        <td>${metodopago.getIdMetodoPago()}</td>
                        <td>${metodopago.getMetodoPago()}</td>
                        <td>${metodopago.getPagoTotal()}</td>
                        <td>${metodopago.getBanco()}</td>
                        <td>
                            <a class="button button-editar" href="Controlador?menu=MetodoPago&accion=Editar&idMetodoPago=${metodopago.getIdMetodoPago()}"><span>Editar</span></a>
                            <a class="button button-eliminar" href="Controlador?menu=MetodoPago&accion=Eliminar&idMetodoPago=${metodopago.getIdMetodoPago()}"><span>Eliminar</span></a>
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


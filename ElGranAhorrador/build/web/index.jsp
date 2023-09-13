<%-- 
    Document   : index
    Created on : 21/07/2023, 07:18:11 PM
    Author     : user
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>
        <title>Login</title>
        <link rel="stylesheet" href="./css/styles.css">
        <script src="./js/animacionBoton.js" defer></script>
        <style>
            body{
                background-color: #1E56A0;
            }
        </style>
    </head>
    <body>
        <section>
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-md-8 col-lg-6 col-xl-7">
                        <div class="card" style="border-radius: 1rem; border: none;">
                            <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                                <li class="nav-item text-center">
                                    <a class="nav-link active btl" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Login</a>
                                </li>
                                <li class="nav-item text-center">
                                    <a class="nav-link btr" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Sign In</a>
                                </li>

                            </ul>
                            <div class="tab-content" id="pills-tabContent">
                                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                                    <div class="d-flex align-items-center">
                                        <div class="card-body p-4 p-lg-5 text-black">
                                            <form class="form-sign" action="Validar" method="POST">
                                                <div class="d-flex justify-content-center align-items-center mb-3 pb-1">
                                                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                                    <img src="./img/LogoElGranAhorradorMejorada.png" width="275px" height="200px">
                                                </div>

                                                <h5 class="fw-normal text-center mb-3 pb-3" style="letter-spacing: 1px;">Inicia sesión</h5>

                                                <div class="form-outline mb-4">
                                                    <input input type="text" name="txtUser" class="form-control" placeholder="Correo electrónico"/>
                                                </div>

                                                <div class="form-outline mb-4">
                                                    <input type="password" name="txtPass" class="form-control" placeholder="Contraseña" />
                                                </div>

                                                <div class="pt-1 mb-4">
                                                    <input type="submit"name="accion"value="Ingresar" class="btn btn-dark btn-lg btn-block">
                                                </div>

                                                <a class="small text-muted" href="#!">¿Olvidó su contraseña?</a>
                                                <p class="mb-5 pb-lg-2" style="color: #393f81;"></p>
                                            </form>
                                        </div>
                                    </div>
                                </div>


                                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                                    <div class="d-flex align-items-center">
                                        <div class="card-body p-4 p-lg-5 text-black">
                                            <form action="Controlador?menu=Login" method="POST" enctype="multipart/form-data">
                                                <%--Si necesitan agregar más atributos copien lo que esta bajo de este comentario--%>

                                                <div class="d-flex justify-content-center align-items-center mb-3 pb-1">
                                                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                                     <img src="./img/LogoElGranAhorradorMejorada.png" width="275px" height="200px">
                                                </div>

                                                <h5 class="fw-normal text-center mb-3 pb-3" style="letter-spacing: 1px;">Registrate</h5>

                                                <div class="form-outline mb-4">
                                                    <input type="text" name="txtUsuario" class="form-control" required placeholder="Usuario" />
                                                </div>

                                                <div class="form-outline mb-4">
                                                    <input type="password" name="txtContrasena" class="form-control" required placeholder="Contraseña" />
                                                </div>

                                                <div class="form-outline mb-4">
                                                    <input type="text" name="txtTipoUsuario" value="0" class="form-control" required placeholder="Tipo Usuario" readonly="true" />
                                                </div>
                                                <label>Incluya una foto</label>
                                                <div class="previ">
                                                    <input type="file" name="fileFoto" accept=".png, .jpg, .jpeg" onchange="previewImage(event, '#imgPreview')">
                                                    <img class="ver" id="imgPreview" width="200px" height="200px">
                                                </div>
                                                
                                                <div class="pt-5 mb-10">
                                                    <input type="submit" name="accion" value="Agregar" class="btn btn-dark btn-lg btn-block margen">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
<%-- 
    Document   : Alumno
    Created on : 08-31-2016, 05:23:31 PM
    Author     : Laboratorio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.sv.udb.controlador.*"%>
<%@page import="com.sv.udb.modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<title>PARCIAL DE POO2</title>
    
     <!-- Normalize CSS -->
	<link rel="stylesheet" href="css/normalize.css">
    
     <!-- Materialize CSS -->
	<link rel="stylesheet" href="css/materialize.min.css">
    
     <!-- Material Design Iconic Font CSS -->
	<link rel="stylesheet" href="css/material-design-iconic-font.min.css">
    
    <!-- Malihu jQuery custom content scroller CSS -->
	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.css">
    
    <!-- Sweet Alert CSS -->
    <link rel="stylesheet" href="css/sweetalert.css">
    
    <!-- MaterialDark CSS -->
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <!-- Nav Lateral -->
    <section class="NavLateral full-width">
        <div class="NavLateral-FontMenu full-width ShowHideMenu"></div>
        <div class="NavLateral-content full-width">
            <header class="NavLateral-title full-width center-align">
                JAVA WEB <i class="zmdi zmdi-close NavLateral-title-btn ShowHideMenu"></i>
            </header>
            <figure class="full-width NavLateral-logo">
                <img src="assets/img/logo.png" alt="material-logo" class="responsive-img center-box">
                <figcaption class="center-align">PARCIAL 01 POO2</figcaption>
            </figure> 
            <div class="NavLateral-Nav">
                <ul class="full-width">
                    <li>
                        <a href="index.html" class="waves-effect waves-light"><i class="zmdi zmdi-view-web zmdi-hc-fw"></i> INICIO</a>
                    </li>
                    <li>
                        <a href="Alumno.jsp" class="waves-effect waves-light"><i class="zmdi zmdi-desktop-windows zmdi-hc-fw"></i>ALUMNO</a>
                    </li>
                    <li>
                        <a href="Grupo.jsp" class="waves-effect waves-light"><i class="zmdi zmdi-desktop-windows zmdi-hc-fw"></i>GRUPO</a>
                    </li>
                    
                </ul>
            </div>  
        </div>  
    </section>

    <!-- Page content -->
    <section class="ContentPage full-width">
        <!-- Nav Info -->
        <div class="ContentPage-Nav full-width">
            <ul class="full-width">
                <li class="btn-MobileMenu ShowHideMenu"><a href="#" class="tooltipped waves-effect waves-light" data-position="bottom" data-delay="50" data-tooltip="Menu"><i class="zmdi zmdi-more-vert"></i></a></li>
                <li><figure><img src="assets/img/user.png" alt="UserImage"></figure></li>
                <li style="padding:0 5px;">Keneth Cruz</li>
                <li><a href="#" class="tooltipped waves-effect waves-light btn-ExitSystem" data-position="bottom" data-delay="50" data-tooltip="Cerrar sesion"><i class="zmdi zmdi-power"></i></a></li>
                <li><a href="#" class="tooltipped waves-effect waves-light btn-Search" data-position="bottom" data-delay="50" data-tooltip="Buscar"><i class="zmdi zmdi-search"></i></a></li>
               
            </ul>   
        </div>

        <!-- Notifications area -->
        <div class="container">
            <div class="row">
                <h2 class="center-align">Registros de alumno</h2>
                <div class="input-field col s6">
                    <center><h5>Movimiento realizado:</h5></center>
                </div>
                <div class="input-field col s6">
                    <center><h5>${mensAler}</h5></center>
                </div>

                <br><br>
                <form class="col s12" role="form" action="AlumnosServ" method="post">
                    <input type="hidden" name="codiAlum" value="${codiAlum}"/>
      
                    <div class="row">
                        <div class="input-field col s6">
                            <label for="nombAlum">Nombre alumno</label>
                            <br>
                            <input name="nombAlum" type="text" class="validate" value="${nombAlum}"/>

                        </div>

                        <div class="input-field col s6">
                            <label for="apelAlum">Apellido alumno</label>
                            <br>
                            <input name="apelAlum" type="text" class="validate" value="${apelAlum}"/>

                        </div>
                    </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <label for="mailAlum">Correo alumno</label>
                                    <br>
                                    <input name="mailAlum" type="text" class="validate" value="${mailAlum}"/>

                                </div>

                                <div class="input-field col s6">
                                    <label for="teleAlum">Telefono alumno</label>
                                    <br>
                                    <input name="teleAlum" type="text" class="validate" value="${teleAlum}"/>

                                </div>
                            </div> 
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <label for="fechNaciAlum">Fecha nacimiento</label>
                                            <br>
                                            <input type="date"class="form-control" name="fechNaciAlum" >
                                        </div>

                                        <div class="input-field col s6">
                                            <label for="geneAlum">Genero alumno</label>
                                            <br>
                                            <br>
                                            <select class="browser-default" name="geneAlum">
                                                <option value="f">Femenino</option>
                                                <option value="m">Masculino</option>
                                            </select>

                                        </div>
                                    </div> 
                                            <div class="row">
                                                <div class="input-field col s12">
                                                    <label for="direAlum">Direccion</label>
                                                    <br>
                                                    <input name="direAlum" type="text"  class="validate" value="${direAlum}"/>
                                                </div>

                                                
                                            </div> 
        
                        <br><br><br>
        <!--acciones-->
        <div class="container" style="margin-bottom: 128px;">
            <div class="row">
                
                <div class="col s12 center-align">
                     <input type="submit" class="waves-effect waves-light btn"  name="cursBton" value="Guardar"/>
                </div>
            </div>
        </div>
                </form>
        
        <!--registros consultados-->
        
            </div>
        </div>

        <!--Icon Prefixes-->



        <br><br><br><br><br><br><br>
        <!-- Footer -->
        <footer class="footer-MaterialDark">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">

                    </div>
                    <div class="col l4 offset-l2 s12">

                    </div>
                </div>
            </div>
            <div class="NavLateralDivider"></div>
            <div class="footer-copyright">
                <div class="container center-align">
                    © 2016 Keneth Orlando Vasquez Cruz
                </div>
            </div>
        </footer>
    </section>

    <!-- Sweet Alert JS -->
    <script src="js/sweetalert.min.js"></script>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-2.2.0.min.js"><\/script>')</script>

    <!-- Materialize JS -->
    <script src="js/materialize.min.js"></script>

    <!-- Malihu jQuery custom content scroller JS -->
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>

    <!-- MaterialDark JS -->
    <script src="js/main.js"></script>
</body>
</html>

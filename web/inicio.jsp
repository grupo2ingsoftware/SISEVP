<%-- 
    Document   : index
    Created on : 01/06/2013, 10:25:09 PM
    Author     : laptop-w8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Inicio</title>
        <link rel="stylesheet" type="text/css" href="css/principal.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/themes/default/default.css"  />
        <link rel="stylesheet" type="text/css" media="screen" href="css/themes/nivo-slider.css"  />
        <link rel="stylesheet" type="text/css" media="screen" href="css/themes/style.css"  />        
    </head>
    <body>        
        <div id="contenedorGeneral">
            <header id="CG_Superior">
                <div id="CGS_Arriba" style="position: fixed; top: 0;">
                    <div id="CGSA_Sup">
                        <div id="CGSAS_Logo">
                            <s:a action="index"><img src="imagenes/fondo/logo.png" alt=""></s:a>
                        </div>
                        <div id="CGSAS_Sistema">
                            <div style="float: right">
                                <div  class="Acf90b0">
                                    <s:a action="iu_login" cssClass="Acf90b0">Entrar</s:a><span style="padding:0px 5px 0px 5px;"> | </span>
                                    <a href="./paginas/mapa.jsp" cssClass="Acf90b0">Mapa de sitio</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="CGSA_Inf">
                        <div id="CGSAI_Menu">
                            <nav>
                                <ul>
                                    <li><s:a action="index"><img src="imagenes/pagina/home.png"  alt="" title="" width="30" height="25"/></s:a></li>
                                    <li><a href="http://www.munilurin.gob.pe/municipalidad/">MuniLurin</a></li>
                                    <li><a href="http://www.peru.gob.pe/docs/PLANES/10066/PLAN_10066_POI_-_PLAN_OPERATIVO_INSTITUCIONAL_2012_2012.pdf">Mision</a></li>
                                    <li><a href="http://www.peru.gob.pe/docs/PLANES/10066/PLAN_10066_POI_-_PLAN_OPERATIVO_INSTITUCIONAL_2012_2012.pdf">Vision</a></li>
                                    <li><a href="http://www.munilurin.gob.pe/turismo/">Saber más</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="barra">
                    </div>            
                </div>
            </header>
            <div id="CG_Centro">
                <div id="CGC_superior">
                    <p></p>
                </div>
                <div id="CGC_centro">
                    <div id="CGC_Izquierda">

                    </div>
                    <p class="imagen_centro">
                        <img  src="imagenes/pagina/playa.png" />
                    </p>

                </div>
            </div>
            <footer id="CG_Inferior">

            </footer>
        </div>
    </body>
</html>

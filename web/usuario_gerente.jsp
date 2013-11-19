<%-- 
    Document   : usuario_gerente
    Created on : 02/06/2013, 09:44:40 PM
    Author     : laptop-w8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerente: </title>
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
                                    <s:a action="logout" cssClass="Acf90b0">Salir</s:a><span style="padding:0px 5px 0px 5px;"> | </span>
                                    <a href="mapa.jsp" cssClass="Acf90b0">Mapa de sitio</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="CGSA_Inf">
                        <div id="CGSAI_Menu">
                            <nav>
                                <ul>
                                    <li><s:a action="index"><img src="imagenes/pagina/home.png"  alt="" title="" width="30" height="25"/></s:a></li>
                                    <li><s:a action="iu_cobro">COBRO</s:a></li>
                                    <li><s:a action="iu_cobro_reporte">REPORTE</s:a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="barra">
                    </div>            
                </div>
            </header>
            <div id="CG_Centro">
                <s:if test="#session['usuario']==null">
                    <h1>Usted no tiene una sesion activa.Por favor login</h1>            
                </s:if>
                <s:else>
                    Usuario: <s:property value="#session['usuario']" />
                </s:else>
            </div>
            <footer id="CG_Inferior">

            </footer>
        </div>
    </body>
</html>
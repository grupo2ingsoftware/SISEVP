<%-- 
    Document   : newjsp
    Created on : 02/06/2013, 07:37:27 PM
    Author     : laptop-w8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Ayder</title>
        <link rel="stylesheet" type="text/css" href="css/login.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/themes/default/default.css"  />
        <link rel="stylesheet" type="text/css" media="screen" href="css/themes/nivo-slider.css"  />
        <link rel="stylesheet" type="text/css" media="screen" href="css/themes/style.css"  />   
    </head>
    <body onload="document.ingreso.usuario_codigo.focus()">
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
                                    <li><a href="./paginas/munilurin.jsp">MuniLurin</a></li>
                                    <li><a href="./paginas/mision.jsp">Mision</a></li>
                                    <li><a href="./paginas/vision.jsp">Vision</a></li>
                                    <li><a href="./paginas/conocer.jsp">Saber más</a></li>
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
                </div>
                <div id="CGC_Centro">
                    <div id="tabla">
                    <s:form  action="login" name="ingreso">
                        <s:textfield name="usuario_codigo" label="CODIGO"/>
                        <s:password  name="usuario_password" label="CONTRASEÑA"/>
                        <s:submit value="INGRESAR"/>
                    </s:form>
                    </div>                    
                </div>
            </div>
            <footer id="CG_Inferior">
            </footer>
        </div>
    </body>
</html>

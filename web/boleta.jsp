<%-- 
    Document   : boleta
    Created on : 30/06/2013, 06:57:25 PM
    Author     : laptop-w8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Impresion de Boleta</title>
        <link rel="stylesheet" type="text/css" href="css/boleta.css" />
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
                                    <a href="./paginas/mapa.jsp" cssClass="Acf90b0">Mapa de sitio</a>
                                </div>
                            </div>
                            <div id="CGSAI_usuario" style="float: right">
                                <nav>
                                    <ul>
                                        <li><s:property value="#session.usuario.apellidos"/>, <s:property value="#session.usuario.nombre"/></li>
                                        <li><s:property value="#session.usuario.codigo"/></li>                                        
                                        <li><s:a action="index"><img src="imagenes/usuario/usuario.png"  alt="" title="" width="35" height="30"/></s:a></li>
                                    </ul>
                                </nav>
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
                <div id="CGC_superior">
                </div>
                <div id="CGC_Izquierda">

                </div>
                <div id="CGC_Centro">
                    <div id="tabla">
                        <label  style="margin: 0 auto;color: blue;display: block; margin: .5em 0 0 0; font-size: large; font-family: sans-serif;">BOLETA DE COBRO</label>
                        <s:form action="imprimir_boleta">
                            <s:label  value="%{fecha}" />
                            <s:textfield readonly="true" name="num_ticket" label="Nro de Ticket" value="%{num_ticket}" />
                            <s:textfield readonly="true" name="num_placa" label="Nro de Placa" value="%{num_placa}" />
                            <s:textfield readonly="true" name="nombre_encargado" label="Encargado" value="%{nombre_encargado}" />
                            <s:textfield readonly="true" name="hora_ingreso" label="Hora de ingreso" value="%{hora_ingreso}" />
                            <s:textfield readonly="true" name="hora_salida" label="Hora de Salida" value="%{hora_salida}" />
                            <s:textfield readonly="true" name="monto" label="Monto Pagado" value="%{monto}" />
                            <s:submit value="IMPRIMIR" />
                        </s:form>
                    </div>
                </div>
                <div id="CGC_Derecha">

                </div>
            </div>  


            <footer id="CG_Inferior">

            </footer>
        </div>
    </body>
</html>

<%-- 
    Document   : ticket
    Created on : 29/06/2013, 01:54:43 AM
    Author     : laptop-w8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Impresion de Ticket</title>
        <link rel="stylesheet" type="text/css" href="css/ticket.css" />
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
                                    <li ><s:a action="iu_registro_ingreso" >INGRESO</s:a></li>
                                    <li><s:a action="iu_registro_acampante">ACAMPANTES</s:a></li>
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
                        <label  style="margin: 0 auto;color: blue;display: block; margin: .5em 0 0 0; font-size: large; font-family: sans-serif;">TICKET DE INGRESO</label>
                    <s:form action="imprimir_ticket">                            
                            <s:textfield readonly="true" label="Numero de ticket" name="num_ticket" value="%{num_ticket}"/>
                            <s:textfield readonly="true" label="Numero de placa" name="numero_placa" value="%{numero_placa}"/>
                            <s:textfield readonly="true" label="Hora de Ingreso" name="hora_ingreso" value="%{hora_ingreso}"/>
                            <s:reset value="IMPRIMIR" />
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
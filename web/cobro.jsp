<%-- 
    Document   : registro_encargado_cobro
    Created on : 03/06/2013, 12:12:10 PM
    Author     : laptop-w8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de <s:property value="#session.usuario.nombre"/></title>
        <link rel="stylesheet" type="text/css" href="css/cobro.css" />
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
                        <s:form action="cobro">                        
                            <label  style="margin: 0 auto;color: blue;display: block; margin: .5em 0 0 0; font-size: large; font-family: sans-serif;">RESULTADO</label>
                            
                            <s:textfield readonly="true" name="num_placa" value="%{num_placa}" label="NUMERO DE PLACA"/>
                            <s:textfield readonly="true" name="hora_ingreso" value="%{hora_ingreso}" label="HORA DE INGRESO"/>
                            <s:textfield readonly="true" name="hora_salida" value="%{hora_salida}" label="HORA DE SALIDA"/>
                            <s:textfield readonly="true" name="tiempo_estancia" value="%{tiempo_estancia}" label="TIEMPO DE ESTANCIA"/>
                            <s:textfield readonly="true" name="monto" value="%{monto}" label="MONTO"/>
                            <s:submit name="registrar_cobro" value="REGISTRAR COBRO" />
                            <s:submit name="registrar_ingreso" value="Registrar Infractor" />
                        </s:form>
                    </div>         

                </div>
            </div> 

            <footer id="CG_Inferior">

            </footer>
        </div>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 17/06/2013, 09:43:17 PM
    Author     : laptop-w8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<s:if test="#session['usuario']==null">
    <s:include value="inicio.jsp" />
</s:if>
<s:else>
    <s:include value="%{#session.pagina}" />
</s:else>
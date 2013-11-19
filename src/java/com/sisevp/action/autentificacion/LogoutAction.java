/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.autentificacion;

import com.opensymphony.xwork2.ActionSupport;
import com.sisevp.negocio.Usuario;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author laptop-w8
 */
public class LogoutAction extends ActionSupport implements SessionAware {

    Map<String, Object> sesion;

    @Override
    public String execute() throws Exception {
        Usuario usuarioDesconectado=(Usuario)sesion.get("usuario");
        System.out.println("Usuario desconectado: "+usuarioDesconectado.getCodigo());
        sesion.remove("usuario");
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.ingreso;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

/**
 *
 * @author laptop-w8
 */
public class IURegistroIngresoAction extends ActionSupport {

    private String hora_actual;

    @Override
    public String execute() throws Exception {
        hora_actual = (new Date().getHours()) + ":" + (new Date().getMinutes()) + ":" + (new Date().getSeconds());
        return SUCCESS;
    }

    public String getHora_actual() {
        return hora_actual;
    }

    public void setHora_actual(String hora_actual) {
        this.hora_actual = hora_actual;
    }
}

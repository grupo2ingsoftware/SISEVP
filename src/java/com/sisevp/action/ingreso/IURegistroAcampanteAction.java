/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.ingreso;

import com.opensymphony.xwork2.ActionSupport;
import com.sisevp.negocio.Registro;

/**
 *
 * @author laptop-w8
 */
public class IURegistroAcampanteAction extends ActionSupport{
    private String hora_actual;

    @Override
    public String execute() throws Exception {
        hora_actual = Registro.hora_inicio;
        return SUCCESS;
    }

    public String getHora_actual() {
        return hora_actual;
    }

    public void setHora_actual(String hora_actual) {
        this.hora_actual = hora_actual;
    }
}

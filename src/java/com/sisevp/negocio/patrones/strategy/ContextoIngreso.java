/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.strategy;

import com.sisevp.negocio.Registro;
import java.io.Serializable;

/**
 *
 * @author laptop-w8
 */
public class ContextoIngreso implements Serializable{

    private EstrategiaRegistro estrategiaRegistro;
    private Registro registro;

    public void registrarIngreso(String id_codigo) {
        if (registro.getVehiculo().getTipo().equals("normal")) {
            estrategiaRegistro = new EstrategiaClienteNormal();
            estrategiaRegistro.registrar(registro,id_codigo);
        }
        if (registro.getVehiculo().getTipo().equals("exonerado")) {
            estrategiaRegistro = new EstrategiaClienteExonerado();
            estrategiaRegistro.registrar(registro,id_codigo);
        }
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
}

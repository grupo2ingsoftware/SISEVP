/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

/**
 *
 * @author laptop-w8
 */
public class RegistroMontoCobrador {

    private String id_MC;
    private String id_empleado;
    private String fecha;
    private double monto;

    public String getId_MC() {
        return id_MC;
    }

    public void setId_MC(String id_MC) {
        this.id_MC = id_MC;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

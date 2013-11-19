/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

/**
 *
 * @author laptop-w8
 */
public class RegistroMontoLiquidador {
    private String id_ML;
    private String id_empleado;
    private String fecha;
    private double monto;

    public String getId_ML() {
        return id_ML;
    }

    public void setId_ML(String id_ML) {
        this.id_ML = id_ML;
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

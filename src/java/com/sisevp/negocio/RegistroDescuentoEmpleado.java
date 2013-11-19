/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

/**
 *
 * @author laptop-w8
 */
public class RegistroDescuentoEmpleado {

    private String id_desc;
    private String id_empleado;
    private double monto_desc;
    private String fecha;

    public String getId_desc() {
        return id_desc;
    }

    public void setId_desc(String id_desc) {
        this.id_desc = id_desc;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public double getMonto_desc() {
        return monto_desc;
    }

    public void setMonto_desc(double monto_desc) {
        this.monto_desc = monto_desc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

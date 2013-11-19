/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

/**
 *
 * @author laptop-w8
 */
public class Reporte_Infractores {

    private int id_rep_infrac;
    private String fecha;
    private String tipo;

    public int getId_rep_infrac() {
        return id_rep_infrac;
    }

    public void setId_rep_infrac(int id_rep_infrac) {
        this.id_rep_infrac = id_rep_infrac;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

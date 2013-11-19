/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.observer;

/**
 *
 * @author laptop-w8
 */
public class ObservadorMonto implements Observer{
    private double montoAdeudado;

    @Override
    public void actualizar(Observable observable) {
        
    }

    public double getMontoAdeudado() {
        return montoAdeudado;
    }

    public void setMontoAdeudado(double montoAdeudado) {
        this.montoAdeudado = montoAdeudado;
    }
    
}

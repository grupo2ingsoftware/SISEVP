/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.observer;

/**
 *
 * @author laptop-w8
 */
public class ObservadorEstado implements Observer {
    private boolean estado;

    @Override
    public void actualizar(Observable observable) {
        
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}

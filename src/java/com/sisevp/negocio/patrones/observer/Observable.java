/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.observer;

import java.util.List;

/**
 *
 * @author laptop-w8
 */
public class Observable {
    private List vector;
    private boolean estado;
    
    public void agregarObservador(Observer observer){
        
    }
    
    public void eliminarObservador(Observer observer){
        
    }
    
    public void notificar(){
        
    }

    public List getVector() {
        return vector;
    }

    public void setVector(List vector) {
        this.vector = vector;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}

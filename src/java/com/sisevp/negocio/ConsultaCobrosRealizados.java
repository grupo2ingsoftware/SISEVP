/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

/**
 *
 * @author Santiago
 */
public class ConsultaCobrosRealizados {
    
    String Num_Placa   =null;
    String Hora_inicio =null;
    String Hora_fin    =null;
    double Monto       =0;

    public ConsultaCobrosRealizados() {
        
    }

    
    
    public String getNum_Placa() {
        return Num_Placa;
    }

    public void setNum_Placa(String Num_Placa) {
        this.Num_Placa = Num_Placa;
    }

    public String getHora_inicio() {
        return Hora_inicio;
    }

    public void setHora_inicio(String Hora_inicio) {
        this.Hora_inicio = Hora_inicio;
    }

    public String getHora_fin() {
        return Hora_fin;
    }

    public void setHora_fin(String Hora_fin) {
        this.Hora_fin = Hora_fin;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    
    
    
    
}

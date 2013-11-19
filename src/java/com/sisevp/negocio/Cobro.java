/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

import java.io.Serializable;

/**
 *
 * @author laptop-w8
 */
public class Cobro implements Serializable {

    private Boleta boleta;
    private Infractor infractor;
    private int id_cobro;
    private String fecha_cobro;
    private String hora_cobro;
    private double monto;
    public static double monto_media = 0.50;

    public Cobro() {
        boleta = new Boleta();
    }

    public String calcularEstancia(String hora_cobro, String hora_registro) {
        String[] primero, segundo;
        primero = hora_registro.split(":");
        segundo = hora_cobro.split(":");

        int Numero_Sec_segundo = Integer.valueOf(segundo[0]) * 3600 + Integer.valueOf(segundo[1]) * 60 + Integer.valueOf(segundo[2]);
        int Numero_Sec_primero = Integer.valueOf(primero[0]) * 3600 + Integer.valueOf(primero[1]) * 60 + Integer.valueOf(primero[2]);

        int diferencia = Numero_Sec_segundo - Numero_Sec_primero;
        int hora = diferencia / 3600;
        int minuto = (diferencia - hora * 3600) / 60;
        int segundos = diferencia - hora * 3600 - minuto * 60;

        return hora + ":" + minuto + ":" + segundos;
    }

    public void calcularMonto(String hora_cobro, String hora_registro) {
        String[] primero, segundo;
        primero = hora_registro.split(":");
        segundo = hora_cobro.split(":");

        int Numero_Sec_segundo = Integer.valueOf(segundo[0]) * 3600 + Integer.valueOf(segundo[1]) * 60 + Integer.valueOf(segundo[2]);
        int Numero_Sec_primero = Integer.valueOf(primero[0]) * 3600 + Integer.valueOf(primero[1]) * 60 + Integer.valueOf(primero[2]);

        int diferencia = Numero_Sec_segundo - Numero_Sec_primero;
        int hora = diferencia / 3600;
        int minuto = (diferencia - hora * 3600) / 60;

        int mediaHoras = 2 * hora;
        int num_media_hora = 0;
        
        if (minuto < 10) {
            mediaHoras += 0;
        } else {
            if (minuto <= 40) {
                mediaHoras += 1;
            } else {
                mediaHoras += 2;
            }

        }

        mediaHoras += num_media_hora;
        monto = mediaHoras * monto_media;
    }

    public int getId_cobro() {
        return id_cobro;
    }

    public void setId_cobro(int id_cobro) {
        this.id_cobro = id_cobro;
    }

    public String getFecha_cobro() {
        return fecha_cobro;
    }

    public void setFecha_cobro(String fecha_cobro) {
        this.fecha_cobro = fecha_cobro;
    }

    public String getHora_cobro() {
        return hora_cobro;
    }

    public void setHora_cobro(String hora_cobro) {
        this.hora_cobro = hora_cobro;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public Infractor getInfractor() {
        return infractor;
    }

    public void setInfractor(Infractor infractor) {
        this.infractor = infractor;
    }
}

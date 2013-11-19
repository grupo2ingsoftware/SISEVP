/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.cobro;

import com.opensymphony.xwork2.ActionSupport;
import com.sisevp.negocio.Cobro;
import com.sisevp.negocio.Registro;
import com.sisevp.negocio.Ticket;
import com.sisevp.negocio.Vehiculo;
import java.util.Date;

/**
 *
 * @author laptop-w8
 */
public class CobroBusquedaAction extends ActionSupport {

    private String tipo;
    private String entrada;
    private String num_placa;
    private String hora_ingreso;
    private String hora_salida;
    private String tiempo_estancia;
    private double monto;

    @Override
    public String execute() throws Exception {
        boolean existe = false;
        Cobro cobro = new Cobro();

        Registro registro = new Registro();
        Ticket ticket = new Ticket();
        Vehiculo vehiculo = new Vehiculo();
        if (tipo.equals("ticket")) {
            ticket.buscar_Ticket(Integer.valueOf(entrada));
            vehiculo.buscar_Num_Placa(Integer.valueOf(entrada));
            if (ticket.getNumero_ticket() != 0) {
                existe = true;
                if (vehiculo.getN_placa().equals("")) {
                    existe = false;
                }
            }
        }
        if (tipo.equals("Num_Placa")) {
            vehiculo.buscar_Num_Placa(entrada);
            ticket.buscar_Ticket(entrada);
            if (!vehiculo.getN_placa().equals("")) {
                existe = true;
            }
        }

        if (existe) {
            registro.setTicket(ticket);
            registro.setVehiculo(vehiculo);
            registro.buscar_Hora_Registro_Placa();

            num_placa = registro.getVehiculo().getN_placa();
            hora_ingreso = registro.getHora_registro();
            System.out.println("la hora es: " + hora_ingreso);
            Date fecha_sistema = new Date();
            hora_salida = fecha_sistema.getHours() + ":" + fecha_sistema.getMinutes() + ":" + fecha_sistema.getSeconds();
            tiempo_estancia = cobro.calcularEstancia(hora_salida, hora_ingreso);
            cobro.calcularMonto(hora_salida, hora_ingreso);
            monto = cobro.getMonto();

            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getNum_placa() {
        return num_placa;
    }

    public void setNum_placa(String num_placa) {
        this.num_placa = num_placa;
    }

    public String getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getTiempo_estancia() {
        return tiempo_estancia;
    }

    public void setTiempo_estancia(String tiempo_estancia) {
        this.tiempo_estancia = tiempo_estancia;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

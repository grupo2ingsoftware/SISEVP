/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.ingreso;

import com.opensymphony.xwork2.ActionSupport;
import com.sisevp.negocio.Encargado_Registro;
import com.sisevp.negocio.Registro;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author laptop-w8
 */
public class IngresoAction extends ActionSupport implements SessionAware {

    private String numero_placa;
    private String tipo;
    Map<String, Object> sesion;
    private String num_ticket;
    private String hora_ingreso;

    @Override
    public String execute() throws Exception {
        Encargado_Registro encargado = (Encargado_Registro) sesion.get("usuario");
        Date fecha_sistema = new Date();
        String fecha_registro = (fecha_sistema.getYear() + 1900) + "-" + (fecha_sistema.getMonth() + 1) + "-" + fecha_sistema.getDate();
        String hora_registro = fecha_sistema.getHours() + ":" + fecha_sistema.getMinutes() + ":" + fecha_sistema.getSeconds();
        Registro ingreso = new Registro();
        ingreso.registrar_Ingreso(numero_placa, tipo, fecha_registro, hora_registro);
        encargado.setRegistro(ingreso);
        encargado.ejecutarRegistro();

        num_ticket=encargado.getRegistro().getTicket().getNumero_ticket()+"";
        numero_placa=encargado.getRegistro().getVehiculo().getN_placa();
        hora_ingreso=encargado.getRegistro().getHora_registro();
        
        return SUCCESS;
    }

    public String getNumero_placa() {
        return numero_placa;
    }

    public void setNumero_placa(String numero_placa) {
        this.numero_placa = numero_placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNum_ticket() {
        return num_ticket;
    }

    public void setNum_ticket(String num_ticket) {
        this.num_ticket = num_ticket;
    }

    public String getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }
}

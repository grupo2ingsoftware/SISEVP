/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.cobro;

import com.opensymphony.xwork2.ActionSupport;
import com.sisevp.negocio.Cobro;
import com.sisevp.negocio.Encargado_Cobro;
import com.sisevp.negocio.Registro;
import com.sisevp.negocio.Vehiculo;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author laptop-w8
 */
public class CobroAction extends ActionSupport implements SessionAware {

    private String fecha;
    private String num_ticket;
    private String num_placa;
    private String nombre_encargado;
    private String hora_ingreso;
    private String hora_salida;
    private String tiempo_estancia;
    private double monto;
    Map<String, Object> sesion;

    @Override
    public String execute() throws Exception {

        Date fecha_sistema = new Date();
        String fecha_registro = (fecha_sistema.getYear() + 1900) + "-" + (fecha_sistema.getMonth() + 1) + "-" + fecha_sistema.getDate();
        Cobro cobro = new Cobro();

        Encargado_Cobro encargado = (Encargado_Cobro) sesion.get("usuario");

        Registro registro = new Registro();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setN_placa(num_placa);
        registro.setVehiculo(vehiculo);

        cobro.setMonto(monto);
        cobro.setHora_cobro(hora_salida);
        cobro.setFecha_cobro(fecha_registro);

        setNombre_encargado(encargado.getNombre());
        setFecha(fecha_registro);

        encargado.setCobro(cobro);
        encargado.cobrar(registro);
        setNum_ticket(cobro.getBoleta().getNumero_boleta() + "");
        setMonto(cobro.getMonto());
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sesion = map;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNum_ticket() {
        return num_ticket;
    }

    public void setNum_ticket(String num_ticket) {
        this.num_ticket = num_ticket;
    }

    public String getNombre_encargado() {
        return nombre_encargado;
    }

    public void setNombre_encargado(String nombre_encargado) {
        this.nombre_encargado = nombre_encargado;
    }
}

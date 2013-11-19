/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author laptop-w8
 */
public class Registro implements Serializable {

    private Vehiculo vehiculo;
    private Ticket ticket;
    private int id_registro;
    private String fecha_registro;
    private String hora_registro;
    public static String hora_inicio = "09:00:00";

    public void registrar_Ingreso(String numero_placa, String tipo, String fecha_registro, String hora_registro) {
        vehiculo = new Vehiculo();
        vehiculo.setN_placa(numero_placa);
        vehiculo.setTipo(tipo);
        vehiculo.insertarVehiculoBD();

        ticket = new Ticket();
        ticket.generar_Ticket();
        ticket.id_ticket();
        System.out.println("numero de ticket antes de contexto: " + ticket.getNumero_ticket());

        this.fecha_registro = fecha_registro;
        this.hora_registro = hora_registro;
    }

    public void registrar_Vehiculos_acampantes() {
    }

    public void buscar_Id_registro(String num_placa) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery("SELECT id_registro FROM registro where num_placa='" + num_placa + "'");
            if (consulta.next()) {
                id_registro = consulta.getInt("id_registro");
            }
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void buscar_Hora_Registro_Ticket() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery("SELECT hora_registro FROM registro where num_ticket=" + ticket.getNumero_ticket() + "");
            if (consulta.next()) {
                hora_registro = consulta.getString("hora_registro");
            }
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void buscar_Hora_Registro_Placa() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery("SELECT hora_registro FROM registro where num_placa='" + vehiculo.getN_placa() + "'");
            if (consulta.next()) {
                hora_registro = consulta.getString("hora_registro");
            }
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getHora_registro() {
        return hora_registro;
    }

    public void setHora_registro(String hora_registro) {
        this.hora_registro = hora_registro;
    }
}

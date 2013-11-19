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
public class Vehiculo implements Serializable {

    private String n_placa;
    private String tipo;
    
    public Vehiculo(){
        n_placa="";
        tipo="";
    }

    public void insertarVehiculoBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            SentenciaSQL.execute("insert into vehiculo values ('" + n_placa + "','" + tipo + "')");

            Conexion.close();
            SentenciaSQL.close();

            System.out.println("dnfdknaskdlnvakds");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void buscar_Num_Placa(String num_placa) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery("SELECT num_placa FROM registro where  num_placa='" + num_placa + "'");
            if (consulta.next()) {
                n_placa = consulta.getString("num_placa");
            }
            consulta = SentenciaSQL.executeQuery("SELECT tipo FROM vehiculo where numero_placa='" + n_placa + "'");
            if (consulta.next()) {
                tipo = consulta.getString("tipo");
            }
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void buscar_Num_Placa(int ticket_buscar) {
        int numero_ticket = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();

            ResultSet consulta = SentenciaSQL.executeQuery("SELECT numero_ticket FROM ticket where numero_ticket=" + ticket_buscar + "");
            if (consulta.next()) {
                numero_ticket = consulta.getInt("numero_ticket");
                System.out.println("1:"+numero_ticket);
            }
            consulta = SentenciaSQL.executeQuery("SELECT num_placa FROM registro where num_ticket=" + numero_ticket + "");
            if (consulta.next()) {
                n_placa = consulta.getString("num_placa");
                System.out.println("2:"+n_placa);
            }
            consulta = SentenciaSQL.executeQuery("SELECT tipo FROM vehiculo where numero_placa='" + n_placa+ "'");
            if (consulta.next()) {
                tipo = consulta.getString("tipo");
                System.out.println("3:"+tipo);
            }
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getN_placa() {
        return n_placa;
    }

    public void setN_placa(String n_placa) {
        this.n_placa = n_placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

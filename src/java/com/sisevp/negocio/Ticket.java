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
public class Ticket implements Serializable {

    private int numero_ticket;
    
    public Ticket(){
        numero_ticket=0;
    }

    public void generar_Ticket() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            SentenciaSQL.execute("insert into ticket value () ");
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void id_ticket() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery("SELECT max(numero_ticket) AS numero_ticket FROM ticket");
            if (consulta.next()) {
                numero_ticket = consulta.getInt("numero_ticket");
            }
            consulta.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void buscar_Ticket(int ticket_buscar) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery("SELECT numero_ticket FROM ticket where numero_ticket=" + ticket_buscar + "");
            if (consulta.next()) {
                numero_ticket = consulta.getInt("numero_ticket");
            }
            consulta.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void buscar_Ticket(String num_placa) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery("SELECT num_ticket FROM registro where num_placa='" + num_placa + "'");
            if (consulta.next()) {
                numero_ticket = consulta.getInt("num_ticket");
            }
            consulta.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getNumero_ticket() {
        return numero_ticket;
    }
}

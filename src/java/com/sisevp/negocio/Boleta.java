/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author laptop-w8
 */
public class Boleta  implements Serializable{

    private int numero_boleta;

    public void generar_Boleta(int n_boleta,int id_cobro) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();
            SentenciaSQL.execute("INSERT into boleta values (" + n_boleta + "," + id_cobro + ") ");

            setNumero_boleta(n_boleta);
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void generar_Boleta_Infractor() {
    }

    public int getNumero_boleta() {
        return numero_boleta;
    }

    public void setNumero_boleta(int numero_boleta) {
        this.numero_boleta = numero_boleta;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author laptop-w8
 */
public class SubGerente extends Usuario {

    public void aniadirDescuento() {
    }

    public void verificarMontoLiq() {
    }

    public void aniadirRegistro() {
    }

    public void generarRep_Ingresos() {
    }

    public void generarRep_Infractores() {
    }

    public void buscar_Infractor() {
    }

    public void registrarPagoInfractor() {
    }

    @Override
    public void login(String codigo, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");

            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery(""
                    + "select usuario.codigo,nombre,apellidos,cargo"
                    + "from usuario,subgerente "
                    + "where subgerente.codigo='" + codigo + "' and usuario.codigo='" + codigo + "' and usuario.password='" + password + "'");

            if (consulta.next()) {
                setCodigo(consulta.getString("codigo"));
                setNombre(consulta.getString("nombre"));
                setApellidos(consulta.getString("apellidos"));
                setCargo(consulta.getString("cargo"));
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

    @Override
    public void logout() {
        
    }
}

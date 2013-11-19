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
public class Liquidador extends Usuario {

    public void actualizar_Ingreso() {
    }

    public void aniadirRegistro() {
    }

    public void aniadirDescuento() {
    }

    public void verificarMontoEC() {
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
                    + "from usuario,liquidador "
                    + "where liquidador.codigo='" + codigo + "' and usuario.codigo='" + codigo + "' and usuario.password='" + password + "'");

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

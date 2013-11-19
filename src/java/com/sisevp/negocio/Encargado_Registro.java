/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio;

import com.sisevp.negocio.patrones.strategy.ContextoIngreso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author laptop-w8
 */
public class Encargado_Registro extends Usuario {

    private ContextoIngreso contextoIngreso;
    private Registro registro;
    private String turno;

    public void ejecutarRegistro() {

        contextoIngreso = new ContextoIngreso();
        contextoIngreso.setRegistro(registro);
        contextoIngreso.registrarIngreso(getCodigo());
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public void login(String codigo, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");

            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery(""
                    + "select usuario.codigo,nombre,apellidos,cargo,turno "
                    + "from usuario,encargado_ingreso "
                    + "where encargado_ingreso.codigo='" + codigo + "' and usuario.codigo='" + codigo + "' and usuario.password='" + password + "'");

            if (consulta.next()) {
                setCodigo(consulta.getString("codigo"));
                setNombre(consulta.getString("nombre"));
                setApellidos(consulta.getString("apellidos"));
                setCargo(consulta.getString("cargo"));
                setTurno(consulta.getString("turno"));
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

    public ContextoIngreso getContextoIngreso() {
        return contextoIngreso;
    }

    public void setContextoIngreso(ContextoIngreso contextoIngreso) {
        this.contextoIngreso = contextoIngreso;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
}

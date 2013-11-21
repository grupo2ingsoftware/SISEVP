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
public class Encargado_Cobro extends Usuario {

    private Cobro cobro;
    private String turno;

    public void cobrar(Registro registro) {
        int id_registro = 0, num_ticket = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            Statement SentenciaSQL = Conexion.createStatement();

            ResultSet consulta = SentenciaSQL.executeQuery("SELECT id_registro FROM registro where num_placa='" + registro.getVehiculo().getN_placa() + "'");
            if (consulta.next()) {
                id_registro = consulta.getInt("id_registro");
            }
            consulta = SentenciaSQL.executeQuery("SELECT num_ticket FROM registro where id_registro=" + id_registro + "");
            if (consulta.next()) {
                num_ticket = consulta.getInt("num_ticket");
            }

            SentenciaSQL.execute("INSERT INTO cobro (fecha_cobro,hora_cobro,monto_cobro,cod_encarg_cobro,id_reg,num_ticket) "
                    + "VALUES ('" + cobro.getFecha_cobro() + "','" + cobro.getHora_cobro() + "'," + cobro.getMonto() + ",'" + getCodigo() + "'," + id_registro + "," + num_ticket + ")");
            consulta = SentenciaSQL.executeQuery("SELECT max(id_cobro) AS id_cobro FROM cobro ");
            if (consulta.next()) {
                cobro.setId_cobro(consulta.getInt("id_cobro"));

                cobro.getBoleta().generar_Boleta(num_ticket, consulta.getInt("id_cobro"));
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

    public void sancionar() {
    }

    @Override
    public void login(String codigo, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");

            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery(""
                    + "select usuario.codigo,nombre,apellidos,cargo,turno "
                    + "from usuario,encargado_cobro "
                    + "where encargado_cobro.codigo='" + codigo + "' and usuario.codigo='" + codigo + "' and usuario.password='" + password + "'");

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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Cobro getCobro() {
        return cobro;
    }

    public void setCobro(Cobro cobro) {
        this.cobro = cobro;
    }
}

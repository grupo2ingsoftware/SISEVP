/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.negocio.patrones.dao;

import com.sisevp.negocio.Registro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fisi
 */
public class BDMysqlRegistroDAO implements RegistroDAO {

    @Override
    public void registrar(Registro registro, String id_codigo) {
        String cod_encarg_registro = id_codigo;
        String fecha_registro = registro.getFecha_registro();
        String hora_registro = registro.getHora_registro();
        String num_placa = registro.getVehiculo().getN_placa();
        int num_ticket = registro.getTicket().getNumero_ticket();

        System.out.println("Estrategia cliente normal");
        System.out.println("Encargado: " + cod_encarg_registro + ",Fecha registro: " + fecha_registro + ",Hora registro: " + hora_registro + ",Numero de Placa: " + num_placa + ",Numero Ticket: " + num_ticket);

        try {
            
            Connection Conexion = BDMysqlDAOFactoria.crearconexion();
            Statement SentenciaSQL = Conexion.createStatement();

            SentenciaSQL.execute("insert "
                    + "into registro(cod_encarg_registro,fecha_registro,hora_registro,num_placa,num_ticket) "
                    + "values ('" + cod_encarg_registro + "','" + fecha_registro + "','" + hora_registro + "','" + num_placa + "'," + num_ticket + ")");

            Conexion.close();

            SentenciaSQL.close();
        }  catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}

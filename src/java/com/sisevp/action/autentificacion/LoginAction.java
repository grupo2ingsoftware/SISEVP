/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.autentificacion;

import com.opensymphony.xwork2.ActionSupport;
import com.sisevp.negocio.Encargado_Cobro;
import com.sisevp.negocio.Encargado_Registro;
import com.sisevp.negocio.Gerente;
import com.sisevp.negocio.Liquidador;
import com.sisevp.negocio.SubGerente;
import com.sisevp.negocio.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author laptop-w8
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private String usuario_codigo;
    private String usuario_password;
    private Usuario usuario;
    private String presentacion;
    Map<String, Object> sesion;

    @Override
    public String execute() throws Exception {
        usuario = null;
        
        login();

        if (usuario != null) {
            sesion.put("usuario", usuario);
            sesion.put("pagina", presentacion);
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public void login() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");

            Statement SentenciaSQL = Conexion.createStatement();
            ResultSet consulta = SentenciaSQL.executeQuery("select cargo from usuario where usuario.codigo='" + getUsuario_codigo() + "' and usuario.password='" + getUsuario_password() + "' ");

            if (consulta.next()) {
                System.out.println("cargo");
                String cargo = consulta.getString("cargo");
                System.out.println(""+cargo);
                if (cargo.equals("Gerente")) {
                    usuario = new Gerente();
                    usuario.login(usuario_codigo, usuario_password);
                    presentacion = "/usuario_gerente.jsp";
                } else {
                    if (cargo.equals("SubGerente")) {
                        usuario = new SubGerente();
                        usuario.login(usuario_codigo, usuario_password);
                        presentacion = "/usuario_subgerente.jsp";
                    } else {
                        if (cargo.equals("Liquidador")) {
                            usuario = new Liquidador();
                            usuario.login(usuario_codigo, usuario_password);
                            presentacion = "/usuario_liquidador.jsp";
                        } else {
                            if (cargo.equals("Encargado_Cobro")) {
                                usuario = new Encargado_Cobro();
                                usuario.login(usuario_codigo, usuario_password);
                                presentacion = "/usuario_encargado_cobro.jsp";
                            } else {
                                usuario = new Encargado_Registro();
                                usuario.login(usuario_codigo, usuario_password);
                                presentacion = "/usuario_encargado_registro.jsp";
                            }
                        }
                    }
                }
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
    public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }

    public String getUsuario_codigo() {
        return usuario_codigo;
    }

    public void setUsuario_codigo(String usuario_codigo) {
        this.usuario_codigo = usuario_codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getUsuario_password() {
        return usuario_password;
    }

    public void setUsuario_password(String usuario_password) {
        this.usuario_password = usuario_password;
    }
}

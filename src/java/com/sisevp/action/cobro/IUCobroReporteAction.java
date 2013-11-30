/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisevp.action.cobro;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.sisevp.negocio.ConsultaCobrosRealizados;
import com.sisevp.negocio.Encargado_Cobro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 *
 * @author laptop-w8
 */
public class IUCobroReporteAction extends ActionSupport {
    Map<String, Object> sesion;
    
    String codigo=null;
    String nombre=null;
    String fecha=null;
    String hora_ingreso=null;
    String hora_salida=null;
    double monto_recaudado=0;
    
    ArrayList<ConsultaCobrosRealizados> ListaConsultas;

    ConsultaCobrosRealizados consultaCobrosRealizados=null;
    
    
    
    @Override
    public String execute() throws Exception {
        
        
        boolean existe = false;
        Calendar c=new GregorianCalendar();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH)+1);
        String anio = Integer.toString(c.get(Calendar.YEAR));

        Encargado_Cobro encargado = (Encargado_Cobro) sesion.get("usuario");
        
        codigo= encargado.getCodigo();
        //codigo      ="0001";
         nombre      =encargado.getNombre();
         fecha       =dia+"-"+mes+"-"+anio;
         if(!"tarde".equals(encargado.getTurno())){
             hora_ingreso="09:00";
           hora_salida ="15:00";
         } else {
            hora_ingreso="15:00";
            hora_salida ="17:00";
        }
         
        
        
        if (true) {
           
            consultaCobrosRealizados();

            return SUCCESS;
        } else {
            return ERROR;
        }
        
        
    }

    public void consultaCobrosRealizados() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BasedeDatos = "jdbc:mysql://localhost:3306/sisevp";
            Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "root");
            //Connection Conexion = DriverManager.getConnection(BasedeDatos, "root", "");

            Statement SentenciaSQL = Conexion.createStatement();
            String query="SELECT "
                    + " r.`num_placa` num_placa "
                    + " ,r.`hora_registro` hora_inicio  "
                    + " ,c.`hora_cobro` hora_fin  "
                    + " ,c.`monto_cobro`  monto "
                    + " FROM `registro` r,`cobro` c "
                    + " WHERE r.`id_registro`=c.`id_reg` "
                    + " and c.cod_encarg_cobro='"+codigo+"'";
                    String adicional =" WHERE r.`cod_encarg_registro`='ec' ";
            System.out.println("query:"+query);
            ResultSet rs = SentenciaSQL.executeQuery(query);

            ListaConsultas= new ArrayList<ConsultaCobrosRealizados>();
            monto_recaudado=0;
            while (rs.next()) {
                consultaCobrosRealizados = new ConsultaCobrosRealizados();
                consultaCobrosRealizados.setNum_Placa(rs.getString("num_placa"));
                consultaCobrosRealizados.setHora_inicio(rs.getString("hora_inicio"));
                consultaCobrosRealizados.setHora_fin(rs.getString("hora_fin"));
                consultaCobrosRealizados.setMonto(rs.getDouble("monto"));
                monto_recaudado=monto_recaudado+rs.getDouble("monto");
                ListaConsultas.add(consultaCobrosRealizados);                
            }
            
            sesion.put("monto_recaudado", monto_recaudado);
                    
            System.out.println(" tamaño de consultas: "+ListaConsultas.size()+"");
            rs.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public ArrayList<ConsultaCobrosRealizados> getListaConsultas() {
        return ListaConsultas;
    }

    public void setListaConsultas(ArrayList<ConsultaCobrosRealizados> ListaConsultas) {
        this.ListaConsultas = ListaConsultas;
    }

    public ConsultaCobrosRealizados getConsultaCobrosRealizados() {
        return consultaCobrosRealizados;
    }

    public void setConsultaCobrosRealizados(ConsultaCobrosRealizados consultaCobrosRealizados) {
        this.consultaCobrosRealizados = consultaCobrosRealizados;
    }

    public double getMonto_recaudado() {
        return monto_recaudado;
    }

    public void setMonto_recaudado(double monto_recaudado) {
        this.monto_recaudado = monto_recaudado;
    }

        public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }
    
}

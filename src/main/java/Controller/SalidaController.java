package Controller;

import Model.Salida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class SalidaController {
    public static boolean insertar(Salida salida){
        String sql = "insert into salida (idinventario,idcliente,idempleado,fecha_venta) values (?,?,?,?);";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, salida.getIdinventario());
            pst.setInt(2, salida.getIdcliente());
            pst.setInt(3, salida.getIdempleado());
            pst.setTimestamp(4, salida.getFecha_venta());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Salida> mostrar(){
        List<Salida> listSalida = new ArrayList<>();
        String sql = "select * from salida order by idventa asc;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql); ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Salida salida = new Salida
        (rs.getInt("idventa"), rs.getInt("idinventario"), rs.getInt("idcliente"), 
                rs.getInt("idempleado"), rs.getTimestamp("fecha_venta"));
                listSalida.add(salida);
            }
            return listSalida;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean actualizar(Salida salida){
        String sql = "update salida set idinventario=?,idcliente=?,idempleado=?,fecha_venta=? where idventa=?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, salida.getIdinventario());
            pst.setInt(2, salida.getIdcliente());
            pst.setInt(3, salida.getIdempleado());
            pst.setTimestamp(4, salida.getFecha_venta());
            pst.setInt(5, salida.getIdventa());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Salida returnById(int id){
        String sql = "select * from salida where idventa = ?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                Salida salida = new Salida
        (rs.getInt("idventa"), rs.getInt("idinventario"), rs.getInt("idcliente"), 
                rs.getInt("idempleado"), rs.getTimestamp("fecha_venta"));
                return salida;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean eliminar(int id){
        String sql = "delete from salida where idventa=?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }    
        return false;
    }
}

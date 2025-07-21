package Controller;

import Model.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class InventarioController {
    public static boolean insertar(Inventario inventario){
        String sql = "insert into inventario (idcompra,cantidad,fecha_ingreso,fecha_salida) values (?,?,?,?);";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, inventario.getIdcompra());
            pst.setInt(2, inventario.getCantidad());
            pst.setTimestamp(3, inventario.getFecha_ingreso());
            pst.setTimestamp(4, inventario.getFecha_salida());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Inventario> mostrar(){
        String sql = "select * from inventario order by idinventario asc;";
        List<Inventario> listInventario = new ArrayList<>();
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql); ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Inventario inventario = new Inventario
        (rs.getInt("idinventario"), rs.getInt("idcompra"), rs.getInt("cantidad"), 
                rs.getTimestamp("fecha_ingreso"), rs.getTimestamp("fecha_salida"));
                listInventario.add(inventario);
            }
            return listInventario;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean actualizar(Inventario inventario){
        String sql = "update inventario set idcompra=?,cantidad=?,fecha_ingreso=?,fecha_salida=? where idinventario=?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, inventario.getIdcompra());
            pst.setInt(2, inventario.getCantidad());
            pst.setTimestamp(3, inventario.getFecha_ingreso());
            pst.setTimestamp(4, inventario.getFecha_salida());
            pst.setInt(5, inventario.getIdinventario());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Inventario returnById(int id){
        String sql = "select * from inventario where idinventario = ?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    Inventario inventario = new Inventario
        (rs.getInt("idinventario"), rs.getInt("idcompra"), rs.getInt("cantidad"), 
                rs.getTimestamp("fecha_ingreso"), rs.getTimestamp("fecha_salida"));
                    return inventario;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean eliminar(int id){
        String sql = "delete from inventario where idinventario = ?;";
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

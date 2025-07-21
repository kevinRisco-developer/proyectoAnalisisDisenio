package Controller;

import Model.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class CompraController {
    public static boolean insertar(Compra compra){
        String sql = "insert into compra (idproducto,costo,cantidad) values (?,?,?);";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = 
                con.prepareStatement(sql)){
            pst.setInt(1, compra.getIdproducto());
            pst.setDouble(2, compra.getCosto());
            pst.setInt(3, compra.getCantidad());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Compra> mostrar(){
        List<Compra> listCompra = new ArrayList<>();
        String sql = "select * from compra order by idcompra asc;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = 
                con.prepareStatement(sql);ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Compra compra = new Compra
        (rs.getInt("idcompra"), rs.getInt("idproducto"), rs.getDouble("costo"), 
                rs.getInt("cantidad"));
                listCompra.add(compra);
            }
            return listCompra;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean actualizar(Compra compra){
        String sql = "update compra set idproducto  = ?,costo=?,cantidad=? where idcompra=?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = 
                con.prepareStatement(sql)){
            pst.setInt(1, compra.getIdproducto());
            pst.setDouble(2, compra.getCosto());
            pst.setInt(3, compra.getCantidad());
            pst.setInt(4, compra.getIdcompra());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Compra returnById(int id){
        String sql = "select * from compra where idcompra=?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = 
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    Compra compra = new Compra
        (rs.getInt("idcompra"), rs.getInt("idproducto"), rs.getDouble("costo"), 
                rs.getInt("cantidad"));
                    return compra;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean eliminar(int id){
        String sql = "delete from compra where idcompra=?;";
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

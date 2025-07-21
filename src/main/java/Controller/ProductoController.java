package Controller;

import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class ProductoController {
    public static boolean insertar(Producto producto){
        String sql = "insert into producto (idproveedor,nombre,cantidad,unidad_medida,precio_venta) values (?,?,?,?,?);";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, producto.getIdprovedor());
            pst.setString(2, producto.getNombre());
            pst.setInt(3, producto.getCantidad());
            pst.setString(4, producto.getUnidad_medida());
            pst.setDouble(5, producto.getPrecio_venta());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Producto> mostrar(){
        List<Producto> listProducto = new ArrayList<>();
        String sql = "select * from producto order by idproducto asc;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql); ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Producto producto = new Producto
        (rs.getInt("idproducto"), rs.getInt("idproveedor"), 
                rs.getString("nombre"), rs.getDouble("precio_venta"), 
                rs.getInt("cantidad"), rs.getString("unidad_medida"));
                listProducto.add(producto);
            }
            return listProducto;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean actualizar(Producto producto){
        String sql = "update producto set idproveedor=?,nombre=?,cantidad=?,unidad_medida=?,precio_venta=? where idproducto = ?";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, producto.getIdprovedor());
            pst.setString(2, producto.getNombre());
            pst.setInt(3, producto.getCantidad());
            pst.setString(4, producto.getUnidad_medida());
            pst.setDouble(5, producto.getPrecio_venta());
            pst.setInt(6, producto.getIdproducto());
            return pst.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Producto returnById(int id){
        String sql = "select * from producto where idproducto=?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    Producto producto = new Producto
        (rs.getInt("idproducto"), rs.getInt("idproveedor"), 
                rs.getString("nombre"), rs.getDouble("precio_venta"), 
                rs.getInt("cantidad"), rs.getString("unidad_medida"));
                    return producto;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean eliminar(int id){
        String sql = "delete from producto where idproducto = ?;";
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

package Controller;
import Model.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;
public class ProveedorController {
    public static boolean insertar(Proveedor proveedor){
        String sql = "insert into proveedor (nombre,telefono,ruc) values (?,?,?);";
        try(Connection con = Conexion.getConexion();PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setString(1, proveedor.getNombre());
            pst.setString(2, proveedor.getTelefono());
            pst.setString(3, proveedor.getRuc());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }    
    public static List<Proveedor> mostrar(){
        List<Proveedor> listProveedor = new ArrayList<>();
        String sql = "select * from proveedor order by idproveedor asc;";
        try(Connection con = Conexion.getConexion();PreparedStatement pst =
                con.prepareStatement(sql);ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Proveedor proveedor = new Proveedor
        (rs.getInt("idproveedor"), rs.getString("nombre"), rs.getString("telefono"), 
                rs.getString("ruc"));
                listProveedor.add(proveedor);
            }
            return listProveedor;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean actualizar(Proveedor proveedor){
        String sql = "update proveedor set nombre= ?,telefono=?,ruc=? where idproveedor = ?;";
        try(Connection con = Conexion.getConexion();PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setString(1, proveedor.getNombre());
            pst.setString(2, proveedor.getTelefono());
            pst.setString(3, proveedor.getRuc());
            pst.setInt(4, proveedor.getIdprovedor());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Proveedor returnById(int id){
        String sql = "select * from proveedor where idproveedor = ?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = 
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    Proveedor proveedor = new Proveedor
        (rs.getInt("idproveedor"), rs.getString("nombre"), rs.getString("telefono"), 
                rs.getString("ruc"));
                    return proveedor;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean eliminar(int id){
        String sql = "delete from proveedor where idproveedor = ?;";
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

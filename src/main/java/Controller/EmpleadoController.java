package Controller;

import Model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class EmpleadoController {
    public static List<Empleado> mostrar(){
        List<Empleado> listEmpleado = new ArrayList<>();
        String sql = "select * from empleado order by idempleado asc;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = 
                con.prepareStatement(sql);ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Empleado empleado = new Empleado
        (rs.getInt("idempleado"), rs.getInt("idpersona"), rs.getDouble("sueldo"), 
                rs.getString("acceso"), rs.getString("usuario"), 
                rs.getString("contrasena"), rs.getString("estado"));
                listEmpleado.add(empleado);
            }
            return listEmpleado;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean insertar(Empleado empleado){
        String sql = "insert empleado (idpersona,sueldo,acceso,usuario,contrasena,estado) values (?,?,?,?,?,?);";
        try(Connection con = Conexion.getConexion();PreparedStatement pst = 
                con.prepareStatement(sql)){
            pst.setInt(1, empleado.getIdpersona());
            pst.setDouble(2, empleado.getSueldo());
            pst.setString(3, empleado.getAcceso());
            pst.setString(4, empleado.getUsuario());
            pst.setString(5, empleado.getContrasena());
            pst.setString(6, empleado.getEstado());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean actualizar(Empleado empleado){
        String sql = "update empleado set idpersona = ?, sueldo=?,acceso=?,usuario = ?, contrasena = ?,estado=? where idempleado = ?;";
        try(Connection con = Conexion.getConexion();PreparedStatement pst = 
                con.prepareStatement(sql)){
            pst.setInt(1, empleado.getIdpersona());
            pst.setDouble(2, empleado.getSueldo());
            pst.setString(3, empleado.getAcceso());
            pst.setString(4, empleado.getUsuario());
            pst.setString(5, empleado.getContrasena());
            pst.setString(6, empleado.getEstado());
            pst.setInt(7, empleado.getIdempleado());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean eliminar(int id){
        String sql = "delete from empleado where idempleado = ?;";
        try(Connection con = Conexion.getConexion();PreparedStatement pst = 
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Empleado returnById(int id){
        String sql = "select * from empleado where idempleado = ?;";
        try(Connection con = Conexion.getConexion();PreparedStatement pst = 
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    Empleado empleado = new Empleado
        (rs.getInt("idempleado"), rs.getInt("idpersona"), rs.getDouble("sueldo"), 
                rs.getString("acceso"), rs.getString("usuario"), 
                rs.getString("contrasena"), rs.getString("estado"));
                    return empleado;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

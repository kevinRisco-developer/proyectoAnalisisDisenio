package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Conexion;
import Model.Persona;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class PersonaController {
    public static boolean insertar(Persona persona){
        String sql = "insert into persona (nombre,apellidos,tipo_documento,num_documento,direccion,telefono,email) values (?,?,?,?,?,?,?);";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)){
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellidos());
            pst.setString(3, persona.getTipo_documento());
            pst.setInt(4, persona.getNum_documento());
            pst.setString(5, persona.getDireccion());
            pst.setString(6, persona.getTelefono());
            pst.setString(7, persona.getEmail());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean actualizar(Persona persona){
        String sql = "update persona set nombre = ?, apellidos=?,tipo_documento=?,num_documento=? ,direccion=?,telefono=?,email=? where idpersona = ?";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)){
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellidos());
            pst.setString(3, persona.getTipo_documento());
            pst.setInt(4, persona.getNum_documento());
            pst.setString(5, persona.getDireccion());
            pst.setString(6, persona.getTelefono());
            pst.setString(7, persona.getEmail());
            pst.setInt(8, persona.getIdpersona());
            return pst.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Persona returnById(int id){
        String sql = "select * from persona where idpersona = ?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)){
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    Persona persona = new Persona
        (rs.getInt("idpersona"), rs.getString("nombre"), 
                rs.getString("apellidos"), rs.getString("tipo_documento"), 
                rs.getInt("num_documento"), rs.getString("direccion"), 
                rs.getString("telefono"), rs.getString("email"));
                    return persona;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean eliminar(int id){
        String sql = "delete from persona where idpersona=?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Persona> mostrar(){
        String sql = "select * from persona order by idpersona asc;";
        List<Persona> listPersona = new ArrayList<>();
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql); ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Persona persona = new Persona(rs.getInt("idpersona"), rs.getString("nombre"), 
                rs.getString("apellidos"), rs.getString("tipo_documento"), 
                rs.getInt("num_documento"), rs.getString("direccion"), 
                rs.getString("telefono"), rs.getString("email"));
                listPersona.add(persona);
            }
            return listPersona;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package Controller;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class ClienteController {
    public static boolean insertar(Cliente cliente){
        String sql = "insert cliente (idpersona) values (?);";
        try(Connection con = Conexion.getConexion();PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1,cliente.getIdpersona());
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean eliminar(int id){
        String sql = "delete from cliente where idcliente=?;";
        try(Connection con = Conexion.getConexion(); PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            return pst.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static Cliente returnById(int id){
        String sql = "select * from cliente where idcliente = ?;";
        try(Connection con = Conexion.getConexion();PreparedStatement pst =
                con.prepareStatement(sql)){
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    Cliente cliente = new Cliente
        (rs.getInt("idcliente"), rs.getInt("idpersona"), 
                rs.getString("codigo_cliente"));
                    return cliente;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static List<Cliente> mostrar(){
        List<Cliente> listCliente = new ArrayList<>();
        String sql = "select * from cliente order by idcliente asc;";
        try(Connection con = Conexion.getConexion();PreparedStatement pst = 
                con.prepareStatement(sql);ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Cliente cliente = new Cliente
        (rs.getInt("idcliente"), rs.getInt("idpersona"), 
                rs.getString("codigo_cliente"));
                listCliente.add(cliente);
            }
            return listCliente;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

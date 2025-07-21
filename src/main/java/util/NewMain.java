/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package util;

import java.sql.Connection;

/**
 *
 * @author ADM
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = Conexion.getConexion();
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                conn.close(); // No olvides cerrar la conexión
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}

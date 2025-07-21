package Model;

import java.sql.Timestamp;

public class Salida {
    int idventa;
    int idinventario;
    int idcliente;
    int idempleado;
    Timestamp fecha_venta;

    public Salida(int idventa, int idinventario, int idcliente, int idempleado, Timestamp fecha_venta) {
        this.idventa = idventa;
        this.idinventario = idinventario;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.fecha_venta = fecha_venta;
    }

    public Salida() {
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public Timestamp getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Timestamp fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
}

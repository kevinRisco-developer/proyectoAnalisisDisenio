package Model;
import java.sql.Timestamp;
public class Inventario {
    int idinventario;
    int idcompra;
    int cantidad;
    Timestamp fecha_ingreso;
    Timestamp fecha_salida;

    public Inventario(int idinventario, int idcompra, int cantidad, Timestamp fecha_ingreso, Timestamp fecha_salida) {
        this.idinventario = idinventario;
        this.idcompra = idcompra;
        this.cantidad = cantidad;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
    }

    public Inventario() {
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Timestamp fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Timestamp getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Timestamp fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
}

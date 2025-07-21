package Model;

public class Compra {
    int idcompra;
    int idproducto;
    double costo;
    int cantidad;

    public Compra(int idcompra, int idproducto, double costo, int cantidad) {
        this.idcompra = idcompra;
        this.idproducto = idproducto;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public Compra() {
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}

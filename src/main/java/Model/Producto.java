package Model;

public class Producto {
    int idproducto;
    int idprovedor;
    String nombre;
    double precio_venta;
    int cantidad;
    String unidad_medida;

    public Producto(int idproducto, int idprovedor, String nombre, double precio_venta, int cantidad, String unidad_medida) {
        this.idproducto = idproducto;
        this.idprovedor = idprovedor;
        this.nombre = nombre;
        this.precio_venta = precio_venta;
        this.cantidad = cantidad;
        this.unidad_medida = unidad_medida;
    }

    public Producto() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdprovedor() {
        return idprovedor;
    }

    public void setIdprovedor(int idprovedor) {
        this.idprovedor = idprovedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }
    
}

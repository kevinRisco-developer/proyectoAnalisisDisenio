package Model;

public class Proveedor {
    int idprovedor;
    String nombre;
    String telefono;
    String ruc;

    public Proveedor(int idprovedor, String nombre, String telefono, String ruc) {
        this.idprovedor = idprovedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ruc = ruc;
    }

    public Proveedor() {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
}

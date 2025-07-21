package Model;

public class Empleado {
    int idempleado;
    int idpersona;
    double sueldo;
    String acceso;
    String usuario;
    String contrasena;
    String estado;

    public Empleado(int idempleado, int idpersona, double sueldo, String acceso, String usuario, String contrasena, String estado) {
        this.idempleado = idempleado;
        this.idpersona = idpersona;
        this.sueldo = sueldo;
        this.acceso = acceso;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Empleado() {
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

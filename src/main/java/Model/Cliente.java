package Model;

public class Cliente {
    int idcliente;
    int idpersona;
    String codigo_cliente;

    public Cliente(int idcliente, int idpersona, String codigo_cliente) {
        this.idcliente = idcliente;
        this.idpersona = idpersona;
        this.codigo_cliente = codigo_cliente;
    }

    public Cliente() {
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
}

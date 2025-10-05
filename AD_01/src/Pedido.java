import java.io.Serializable;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id, clienteId, cantidad;
    private String producto;

    public Pedido() {
    }

    public Pedido(int id, int clienteId, int cantidad, String producto) {
        this.id = id;
        this.clienteId = clienteId;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%d,%s\n",id,clienteId,cantidad,producto);
    }
}

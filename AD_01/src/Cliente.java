import java.io.Serializable;
//Implementacion de serializable
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    //Defino las variables
    private int id;
    private String nombre,email;

    //Constructor por defecto
    public Cliente() {
    }

    //Constructor con todo
    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Formateado el metodo toString
    @Override
    public String toString() {
        return String.format("%d,%s,%s\n", id, nombre,email);
    }
}
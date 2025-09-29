import java.util.Scanner;

public class Explorador {

    /*Clase que llamara a un metodo concreto de la clase Directorios para explorar las
    Rutas*/

    public static void main(String[] args) {
        //Inicializamos
        Directorios dir = new Directorios();
        Recursivo recursivo = new Recursivo();
        //Llamamos al metodo Scanner para pocer leer por consola
        Scanner scanner  = new Scanner(System.in);
        System.out.println("¿Que ruta quieres explorar?");
        //Scaneamos lo que le entra por consola y le llamamos "ruta"
        String ruta = scanner.nextLine();
        //Ejecutamos nuestro metodo con la "ruta" Scaneada
        recursivo.InfDirRecur(ruta);
    }
}

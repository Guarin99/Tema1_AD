import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Directorios {
    public void InfDirectorio(String ruta) {
        //Llamamos al metodo File y nos cremaos nuesta variale
        File file = new File(ruta);
        //Formateamos como recibimos la fecha y le damos la estrutura deseada
        String fecha = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").format(new Date(file.lastModified()));
        //Controlamos que la ruta introducida sea correcta si no lo es saldra por el else "Ruta no encontada"
        if (file.exists()) {
            System.out.println("La ruta del directorio es: '" + file.getAbsolutePath() + "'");
            //Creamos un array con los directorios y ficheros que tenemos en la ruta introducida
            File[] fileName = file.listFiles();
            if (fileName != null) {

                for (File item : fileName) {
                    //Manejamos los items dependiendo si es directorio o archivo para que muestren una cosa o otra
                    if (item.isDirectory()) {
                        System.out.println("[Directorio] " + item.getName() + " - Fecha ultima modificacion: " + fecha);
                    } else if (item.isFile()) {
                        long tamanio = item.length();
                        System.out.println("[Archivo] " + item.getName() + "(" + tamanio + " bytes)" +
                                " - Fecha ultima modificacion: " + fecha);
                    }
                }
            } else {
                System.out.println("Ruta no encontrada");
            }
        }
    }
}

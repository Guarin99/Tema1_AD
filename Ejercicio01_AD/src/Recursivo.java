import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recursivo {

    public void InfDirRecur(String ruta) {
        //Lamamos al metodo File y le pasamos la ruta scaneada en el Explorador
        File file = new File(ruta);

        //controlamos que la ruta introducida sea valida
        if (!file.exists()){
            System.out.println("Direccion no encontrada" + ruta);
        }
        //Corregimos el formato de la fecha que nos aparecera por pantalla
        String fecha = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss")
                .format(new Date(file.lastModified()));
        //Mostamos los directorios si no son directorios saldran por el else identificados como archivos
        if (file.isDirectory()) {
            System.out.println("[Directorio] " + file.getName()+" " +fecha);
        //Creamos el array con los elementos que contiene el directorio
            File[] fileName = file.listFiles();
            if (fileName != null) {
                for (File item : fileName) {
        //Creamos otra correccion para que entre dentro de los elementos
                    String fechaItem = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss")
                            .format(new Date(file.lastModified()));
        //LLamamos al metodo para hacer la misma operacion con cada directorio
                    if (item.isDirectory()) {
                        InfDirRecur(item.getAbsolutePath());
                    }
                    //Mostramos los archivos
                    else if (item.isFile()) {
                        long tamanio = item.length();
                        System.out.println("[Archivo] " + item.getName() + "(" +tamanio+" bytes)" +" - Fecha ultima modificacion: " +fechaItem);
                    }
                }
            }else {
                long tamannio = file.length();
                System.out.println("[Archivo] " + file.getName() + "(" +tamannio+" bytes)" +" - Fecha ultima modificacion: " +fecha);
            }
        }
    }
}
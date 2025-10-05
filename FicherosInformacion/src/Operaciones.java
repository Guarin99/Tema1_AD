import java.io.File;
import java.io.IOException;

public class Operaciones {

    public void informacionFichero(String path) {
        File file = new File(path);

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Hay un problema con la entrada/salida");
            }
        } else {
            //Obtener info del file
            System.out.println(file.exists());
            System.out.println(file.isFile());
            System.out.println(file.canWrite());
            System.out.println(file.canRead());
            System.out.println(file.canExecute());
            System.out.println(file.isDirectory());
        }
    }

    public void informacionDirectorio(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            System.out.println("vamos a trabajar con directorios");
            System.out.println("La ruta del directorio es " + file.getAbsolutePath());
            //cuantos ficheros tiene una carpeta
            //saca la lista de nombres que hay en la carpeta
            String[] nombreFicheros = file.list();
            File[] ficheros = file.listFiles();
            for (File item : ficheros) {
                if (!item.isHidden()) {
                    System.out.println(item.getAbsolutePath());
                }
            }

        } else if (!file.exists()) {
            file.mkdir();//crea un directorio
            //file.mkdirs;//crea toda las capetas de la ruta
        }
    }


}

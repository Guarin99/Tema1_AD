import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Metodos {

    public void escribirObjetos(String path) {
        //Metodo para escribir objetos en un fichero
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        //Creado el flujo saliente de escritura en el fichero
        try {
            fos = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fos);

            ArrayList<Object> datos = new ArrayList<>();
            //Creamos un listado de objetos
            datos.add(new Cliente(1, "Ruben", "Ruben@gmail.com"));
            datos.add(new Cliente(2, "Raul", "Raul@gmail.com"));
            datos.add(new Cliente(3, "Quique", "Quique@gmail.com"));
            datos.add(new Pedido(1, 1, 5, "Camiseta roja"));
            datos.add(new Pedido(2, 1, 10, "Calcetines"));
            datos.add(new Pedido(3, 2, 1, "Chaqueta "));
            datos.add(new Pedido(4, 3, 3, "Polar"));
            datos.add(new Pedido(5, 3, 2, "Pantalon"));

            oos.writeObject(datos);
            //Escrivimos el grupo de objetos del listado en un fichero
            System.out.println("Datos alamcenados en el fichero 'archivo.dat' :  " + path);
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("No tienes permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
            }//Capturamos posibles errores
        }
    }


    public void leerObjetos(String path) {
        //Metodo para leer objetos del fichero creado
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        //Creamos el flujo entrante para poder mostrar los objetos
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            ArrayList<Object> datos = (ArrayList<Object>) ois.readObject();
            //Recuperamos el listado de objetos escritos
            for (Object obj : datos) {
                //Recorremos el listado uno por uno
                if (obj instanceof Cliente) {
                //Definimos que clase de objeto es(Cliente)
                    Cliente cliente = (Cliente) obj;
                    //Transformamos el objeto a un cliente
                    System.out.println("Cliente");
                    System.out.println("ID : " + cliente.getId());
                    System.out.println("Nombre:" + cliente.getNombre());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("-------------------------------");
                    //Damos la estructura desada para mostrar el listado
                } else if (obj instanceof Pedido) {
                //Volvemos a definir el objeto(Pedido)
                    Pedido pedido = (Pedido) obj;
                    //Tranformamos el objeto a pedido
                    System.out.println("Pedido");
                    System.out.println("ID Pedido:" + pedido.getId());
                    System.out.println("ID cliente: " + pedido.getClienteId());
                    System.out.println("Cantidad: " + pedido.getCantidad());
                    System.out.println("Producto: " + pedido.getProducto());
                    System.out.println("-------------------------------");
                    //Damos la estructura
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, no se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("No tienes permisos");
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase de lectura");
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }//Capturamos posibles errores
        }
    }

    public void añadirObjeto(String path, Object nuevo) {
        //Metodo para añadir objetos a un fichero existente
        File file = new File(path);
        ArrayList<Object> datos = new ArrayList<>();
        if (file.exists() && file.length() > 0) {
        //Comprobamos que la direccion existe y que no esta vacia
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                //Creamos el flujo de entrada para traenos el listado
                datos = (ArrayList<Object>) ois.readObject();
                //Leemos todos los objetos existentes en la lista
            } catch (FileNotFoundException e) {
                System.out.println("No se puede acceder fichero");
            } catch (IOException e) {
                System.out.println("no se puede leer el fichero ");
            } catch (ClassNotFoundException e) {
                System.out.println("error de clase");
            }//Capturamos posibles errores

        }

        datos.add(nuevo);
        //Añadimos el nuevo objeto a la lista que hemos leido anteriormente
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            //Creamos el flujo saliente y escrivimos el nuevo obejeto en el listado del archivo
            System.out.println("Objeto añadido correctamente");
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("No tienes permisos");
        }//Capturamos posibles errores
    }

    public void escrituraFichero(String datPath,String csvCliente,String csvPedido){
        File file =new File(datPath);
        FileInputStream fis = null;
        ObjectInputStream ois =null;
        PrintWriter pwClientes = null;
        PrintWriter pwPedidos = null;

        if(!file.exists()||file.length() == 0){
            System.out.println("El fichero no existe o no contiene nada");
        }

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            pwClientes = new PrintWriter( new FileWriter(csvCliente));
            pwPedidos = new PrintWriter(new FileWriter(csvPedido));

            ArrayList<Object>datos = (ArrayList<Object>) ois.readObject();

            pwClientes.println("         ID-NOMBRE-EMAIL");
            pwPedidos.println("           ID-CLIENTE_ID-CANTIDAD-DESCRIPCION");

            for (Object obj : datos){
                if (obj instanceof Cliente){
                    Cliente c = (Cliente) obj;
                    pwClientes.println("Cliente:         "+ c.getId()+ "," + c.getNombre() + "," + c.getEmail());
                } else if (obj instanceof Pedido){
                    Pedido p =(Pedido) obj;
                    pwPedidos.println("Pedido:            " + p.getId() + " ,"+ p.getClienteId() + ", "+p.getCantidad()+","+p.getProducto());
                }
            }
            System.out.println("archivoS creado a partir de los objetos del .dat");
            System.out.println("Clientes  :"+csvCliente);
            System.out.println("Pedidos  :"+csvPedido);
        } catch (IOException e) {
            System.out.println("Error, sin permiso de escritura");
        } catch (ClassNotFoundException e) {
            System.out.println("Sin permisos de lectura");
        } finally {
            try {
                pwClientes.close();
                pwPedidos.close();
        }catch (NullPointerException e){
                System.out.println("Error al cerrar");
            }
        }
    }

}

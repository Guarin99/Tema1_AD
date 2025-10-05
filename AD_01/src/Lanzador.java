public class Lanzador {
    public static void main(String[] args) {
        Metodos met = new Metodos();

        //met.escribirObjetos("C:\\Users\\ruben\\Documents\\DAM\\2ºDAM\\AccesoDatos\\Tema1_AD\\AD_01\\src\\resources\\archivo.dat");
        met.leerObjetos("C:\\Users\\ruben\\Documents\\DAM\\2ºDAM\\AccesoDatos\\Tema1_AD\\AD_01\\src\\resources\\archivo.dat");
        //met.añadirObjeto("C:\\Users\\ruben\\Documents\\DAM\\2ºDAM\\AccesoDatos\\Tema1_AD\\AD_01\\src\\resources\\archivo.dat",new Cliente(4,"Alba","Alba@gmail.com") );
        /*met.escrituraFichero("C:\\Users\\ruben\\Documents\\DAM\\2ºDAM\\AccesoDatos\\Tema1_AD\\AD_01\\src\\resources\\archivo.dat",
                             "C:\\Users\\ruben\\Documents\\DAM\\2ºDAM\\AccesoDatos\\Tema1_AD\\AD_01\\src\\resources\\clientes.csv",
                             "C:\\Users\\ruben\\Documents\\DAM\\2ºDAM\\AccesoDatos\\Tema1_AD\\AD_01\\src\\resources\\pedido.csv");*/
    }
}

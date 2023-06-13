/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenextraordinarioprogramacion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Fabian Salinas
 */
public class ExamenExtraordinarioProgramacion {

    public static void comprueba(int resultado) throws Exception {
        if (resultado == 1) {
            System.out.println("Hecho");
        } else {
            throw new Exception("Error en el proceso");
        }
    }

    public static void comprueba(boolean resultado) throws Exception {
        if (!resultado) {
            System.out.println("Hecho");
        } else {
            throw new Exception("Error en el proceso");
        }
    }
    public static Scanner entrada = new Scanner(System.in);

    //funcion para guardar las consultas en un txt
    public static void guardar() throws IOException {
        String ruta = "Resultados";
        File resultado = new File(ruta);
        if (!resultado.exists()) {
            resultado.mkdir();
        }
        System.out.println("escribe el nombre donde se guardara el txt con las consultas");
        //pregunta al user el nombre de como quiere que se llame la carpeta donde se guarda el resultado
        String nombre = entrada.nextLine();
        FileWriter writer = new FileWriter(ruta + File.separator + nombre + ".txt", false);

    }
    public static ArrayList<Productos> Productos = new ArrayList<Productos>();

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Productos p1 = new Productos(0, "", 0, 0);
        Productos p2 = new Productos(0, "", 0, 0);

        try {
            InetAddress direccion = InetAddress.getLocalHost();
            System.out.println("La dirección IP de tu computadora es: " + direccion.getHostAddress());
        } catch (UnknownHostException ex) {
            System.out.println("No se pudo determinar la dirección IP de tu computadora.");
        }

        System.out.println();
        //cuando se conecte a la base de datos el tipo booleano te dara true, significa que estas conectado a la bbdd de cristina ,Con esto se conecta a la base de datos 1 vez
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://10.230.109.71:3306?serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            int opcion;
            int nr;
            boolean ex = true;

            ex = stmt.execute("USE tienda_electronica;");
            System.out.println("USE tienda_eletronica;");
            comprueba(ex);

            do {
                System.out.println("1 mostrar los datos de un producto concreto , dado su id");
                System.out.println("2 mostrar el stock total por cada tipo de producto");
                System.out.println("3 mostrar el numero de productos por sistema operativo");
                System.out.println("4 añadir un producto a su coleccion o estructura de datos");
                System.out.println("5 salir del menu");
                opcion = entrada.nextInt();

                switch (opcion) {
                    //pregunta al usuario el id del producto que guarda el id en la consulta y deberia salir por pantalla el id selecionado de ese producto con todos sus datos
                    case 1:
                        System.out.println(" introduce id del producto");
                        int id = entrada.nextInt();
                        ResultSet idProducto = stmt.executeQuery("SELECT * FROM productos WHERE id=" + id + ";");

                        while (idProducto.next()) {
                            System.out.println(
                                    "id: " + idProducto.getInt("id")
                                    + "nombre: " + idProducto.getString("nombre")
                                    + "precio :" + idProducto.getString("precio")
                                    + "stock :" + idProducto.getInt("stock")
                                    + "tipo :" + idProducto.getString("tipo")
                                    + "categoria :" + idProducto.getString("categoria")
                                    + "marca :" + idProducto.getString("marca")
                                    + "sistema operativo :" + idProducto.getString("sistema_operativo"));
                        }
                        entrada.next();
//                         writer.write("")
                        System.out.println(
                                "id: " + idProducto.getInt("id")
                                + "nombre: " + idProducto.getString("nombre")
                                + "precio :" + idProducto.getString("precio")
                                + "stock :" + idProducto.getInt("stock")
                                + "tipo :" + idProducto.getString("tipo")
                                + "categoria :" + idProducto.getString("categoria")
                                + "marca :" + idProducto.getString("marca")
                                + "sistema operativo :" + idProducto.getString("sistema_operativo"));

                        break;
                    //pregunta al usuario el nombre del producto para luego indicar por pantalla su stock
                    case 2:
                        //ejemplo tablet tiene 15 stock
                        System.out.println("2");
                        System.out.println("introduce el producto para saber su stock");
                        String producto = entrada.nextLine();
                        ResultSet stockProducto = stmt.executeQuery("SELECT stock FROM productos WHERE tipo=" + producto + ";");
                        while (stockProducto.next()) {
                            System.out.println(stockProducto.getInt("stock"));
                        }
                        System.out.println(stockProducto.getInt("stock"));
                        break;
                    case 3:
                        //pregunta el usuario el sistema operativo y deberia salir por pantalla el numero de productos  con ese sistema.
                        System.out.println("introduce el nombre del sistema para mostrar su numero");
                        String sistema = entrada.nextLine();
                        ResultSet sistemaOperativo = stmt.executeQuery("SELECT COUNT(*) FROM productos WHERE sistema_operativo=' " + sistema + " ';");
                        while (sistemaOperativo.next()) {
                            System.out.println(
                                    "id: " + sistemaOperativo.getInt("id")
                                    + "nombre: " + sistemaOperativo.getString("nombre")
                                    + "precio :" + sistemaOperativo.getString("precio")
                                    + "stock :" + sistemaOperativo.getInt("stock")
                                    + "tipo :" + sistemaOperativo.getString("tipo")
                                    + "categoria :" + sistemaOperativo.getString("categoria")
                                    + "marca :" + sistemaOperativo.getString("marca")
                                    + "sistema operativo :" + sistemaOperativo.getString("sistema_operativo"));
                        }

                        System.out.println("id: " + sistemaOperativo.getInt("id")
                                + "nombre: " + sistemaOperativo.getString("nombre")
                                + "precio :" + sistemaOperativo.getString("precio")
                                + "stock :" + sistemaOperativo.getInt("stock")
                                + "tipo :" + sistemaOperativo.getString("tipo")
                                + "categoria :" + sistemaOperativo.getString("categoria")
                                + "marca :" + sistemaOperativo.getString("marca")
                                + "sistema operativo :" + sistemaOperativo.getString("sistema_operativo"));
                        break;

                    case 4:
                        //en esta parte deberia añadir un nuevo producto a la base de datos de cristina
                        System.out.println("PD : cada producto tiene su ID , no debe repetirse");
                        System.out.println("introduce la id del producto");
                        int insertarID = entrada.nextInt();
                        System.out.println("introduce nombre del producto");
                        String insertarNombre = entrada.nextLine();
                        System.out.println("instroduce el precio que tiene que tiene");
                        int insertarPrecio = entrada.nextInt();
                        System.out.println("insertar el stock que tiene el producto");
                        int insertarStock = entrada.nextInt();
                        System.out.println("introduce el tipo (table,smarphone,etc..) ");
                        String insertarTipo = entrada.nextLine();
                        System.out.println("introduce su categoria");
                        String insertarCategoria = entrada.nextLine();
                        System.out.println("introduce su marca");
                        String insertarMarca = entrada.nextLine();
                        System.out.println("Introduce el sistema operativo");
                        String insertarSistema = entrada.nextLine();
                        ex = stmt.execute(""
                                + "insert into productos(id,nombre,precio,stock,tipo,categoria,marca,sistema_operativo)"
                                + "value (" + insertarID + ",'" + insertarNombre + "'," + insertarPrecio + "," + insertarStock + ",'" + insertarTipo + "'," + insertarCategoria + "," + insertarMarca + "," + insertarSistema + ");");
                        break;
                }
                guardar();
            } while (opcion != 5);

            //cierra la conexion y el statement
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }
}

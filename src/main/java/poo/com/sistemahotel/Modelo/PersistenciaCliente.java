/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersistenciaCliente {

        private String RUTA_ARCHIVO = "src/main/resources/archivos/usuarios.txt"; //Archivo donde se obtendrá y guardará la información
        private static File usuarios;
        //  Asociación:Una PersistenciaCliente almacena muchos clientes (*)
        private ArrayList<Cliente> clientes;

        public PersistenciaCliente() {
                clientes = new ArrayList<>();
                usuarios = new File(RUTA_ARCHIVO);
        }

        // Guardar, Buscar, Actualizar, Eliminar y Listar Clientes    
        /**
         * Guardar un nuevo cliente en el archivo
         *
         * @param c
         */
        public void guardarCliente(Cliente c) {
                //Guardar en el arreglo
                clientes.add(c);
                //Guardar en el archivo
                escribirArchivo();
        }

        /**
         * Retorna un cliente en base al id
         *
         * @param cedula
         * @return
         */
        public Cliente buscarCliente(String cedula) {
                for (Cliente c : clientes) {
                        if (c.getCedula().equalsIgnoreCase(cedula)) {
                                return c;
                        }
                }
                return null;
        }

        /**
         * Actualiza la información de un cliente en el archivo
         *
         * @param c
         */
        public void actualizarCliente(Cliente c) {
                //Actualizar en el arreglo
                for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getCedula()
                                .equals(c.getCedula())) {
                                clientes.set(i, c);
                        }
                }

                //Actualizar en el archivo
                escribirArchivo();
        }

        /**
         * Eliminar el cliente del archivo
         *
         * @param id
         */
        public void eliminarCliente(String cedula) {
                //Remover del arreglo
                for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i)
                                .getCedula()
                                .equalsIgnoreCase(cedula)) {
                                clientes.remove(i);
                        }
                }

                //Remover del archivo
                escribirArchivo();
        }

        public ArrayList<Cliente> listarClientes() {
                return clientes;
        }

        /**
         * Cargar los usuarios desde el archivo y guardarlos en el arreglo de clientes
         *
         * @param RUTA_ARCHIVO
         */
        public void cargarClientes() {
                try {
                        if (usuarios == null) {
                                JOptionPane.showMessageDialog(null, "No existen usuarios en el registro", "Error Usuarios", 0);
                                return;
                        }
                        BufferedReader br = new BufferedReader(new FileReader(usuarios));
                        String linea;
                        while ((linea = br.readLine()) != null) {
                                String[] informacion = linea.split(";");
                                //Orden Nombre; Apellidos; Contraseña; Cedula; Telefono; Correo, Dirección
                                clientes.add(new Cliente(informacion[3], informacion[0], informacion[1], informacion[4], informacion[5], informacion[6], informacion[2]));
                        }
                        br.close();
                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al leer el archivo de clientes" + ex.getMessage(), "Error Archivo", 0);
                }
        }

        /**
         * Metodo para escribir en el archivo de usuarios
         */
        private void escribirArchivo() {
                try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(usuarios));
                        for (Cliente cliente : clientes) {
                                //Orden Nombre; Apellidos; Contraseña; Cedula; Telefono; Correo, Dirección
                                bw.append(cliente.getNombre() + ";" + cliente.getApellido() + ";" + cliente.getPassword() + ";" + cliente.getCedula() + ";" + cliente.getTelefono() + ";" + cliente.getCorreo() + ";" + cliente.getDireccion());
                                bw.newLine();
                        }
                        bw.close();

                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de clientes: " + ex.getMessage(), "Error Archivo", 0);
                }
        }
}

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

public class PersistenciaHabitacion {

        private String RUTA_ARCHIVO = "archivos/habitaciones.txt"; //Archivo donde se obtendrá y guardará la información
        private File habitacionesArchivo;

        // Asociación
        // Una PersistenciaHabitacion almacena muchas habitaciones (*)
        private ArrayList<Habitacion> habitaciones;

        public PersistenciaHabitacion() {
                this.habitaciones = new ArrayList<>();
                this.habitacionesArchivo = new File(RUTA_ARCHIVO);
        }

        // Guardar, Buscar, Actualizar, Eliminar y Listar Habitaciones
        public void guardarHabitacion(Habitacion h) {
                habitaciones.add(h);

                escribirArchivo();
        }

        public Habitacion buscarHabitacion(int id) {
                for (Habitacion h : habitaciones) {
                        if (h.getNumero() == id) {
                                return h;
                        }
                }
                return null;
        }

        public void actualizarHabitacion(Habitacion h) {
                for (int i = 0; i < habitaciones.size(); i++) {
                        if (habitaciones.get(i).getNumero()
                                == h.getNumero()) {
                                habitaciones.set(i, h);
                        }
                }

                escribirArchivo();
        }

        public void eliminarHabitacion(int id) {
                for (int i = 0; i < habitaciones.size(); i++) {
                        if (habitaciones.get(i).getNumero()
                                == id) {
                                habitaciones.remove(i);
                        }
                }

                escribirArchivo();
        }

        public ArrayList<Habitacion> listarHabitaciones() {
                return habitaciones;
        }

        /**
         * Tomar la información del archivo y guardarla en el arreglo de habitaciones
         */
        public void cargarHabitaciones() {
                try {

                        if (habitaciones == null) {
                                return;
                        }
                        BufferedReader br = new BufferedReader(new FileReader(habitacionesArchivo));
                        String linea;
                        while ((linea = br.readLine()) != null) {
                                String[] informacion = linea.split(";");
                                //Orden numero;tipo;precio;estado
                                habitaciones.add(new Habitacion(Integer.parseInt(informacion[0]), informacion[1], Double.parseDouble(informacion[2]), informacion[3]));
                        }
                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al leer el archivo de habitaciones" + ex.getMessage(), "Error Archivo", 0);
                }
        }

        /**
         * Guardar la información del arreglo de habitaciones en el archivo
         */
        private void escribirArchivo() {
                try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(habitacionesArchivo));
                        for (Habitacion habitacion : habitaciones) {
                                //Orden numero;tipo;precio;estado
                                bw.append(habitacion.getNumero() + ";" + habitacion.getTipo() + ";" + habitacion.getPrecioPorNoche() + ";" + habitacion.getEstado());
                                bw.newLine();
                        }
                        bw.close();

                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de habitaciones: " + ex.getMessage(), "Error Archivo", 0);
                }
        }
}

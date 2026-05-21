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
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersistenciaReserva {
        private String RUTA_ARCHIVO = "src/main/resources/archivos/reservas.txt"; //Archivo donde se obtendrá y guardará la información
        private File reservasArchivo;
        
    // Asociación: Una PersistenciaReserva almacena muchas reservas (*)
    private ArrayList<Reserva> reservas;
    
    public PersistenciaReserva(){
            this.reservas = new ArrayList<>();
            this.reservasArchivo = new File(RUTA_ARCHIVO);
    }
    
    // Guardar, buscar, actualizar, eliminar y listar reservas
    public void guardarReserva(Reserva r){
        reservas.add(r);
        
        escribirArchivo();
    }

    public Reserva buscarReserva(int id){
        for(Reserva r:reservas){
            if(r.getIdReserva()==id){
                return r;
             }
        }
        return null;
    }

    public void actualizarReserva(Reserva r){
        for(int i=0;i<reservas.size();i++){
            if(reservas.get(i)
                    .getIdReserva()
                    ==r.getIdReserva()){
                reservas.set(i,r);
            }
        }
        
        escribirArchivo();
    }

    public void eliminarReserva(int id){
        for(int i=0;i<reservas.size();i++){
            if(reservas.get(i)
                    .getIdReserva()==id){
                reservas.remove(i);
             }
        }
        
        escribirArchivo();
    }

    public ArrayList<Reserva> listarReservas(){
        return reservas;
    }

    /**
     * Cargar la información de reservas y guardarla en el arreglo
     */
   public void cargarReservas(){
           try{
                        if(reservas == null){
                                return;
                        }
                        BufferedReader br = new BufferedReader(new FileReader(reservasArchivo));
                        String linea;
                        while((linea = br.readLine()) != null){
                                String[] informacion = linea.split(";");
                                //Orden numero;anioInicio-mesInicio-diaInicio;anioFin-mesFin-diaFin;estado
                                String[] fechaInicio = informacion[1].split("-");
                                String[] fechaFin = informacion[2].split("-");
                                LocalDate fechaReserva = LocalDate.now();
                                LocalDate fechaEntradaPrevista = LocalDate.of(Integer.parseInt(fechaInicio[0]), Integer.parseInt(fechaInicio[1]), Integer.parseInt(fechaInicio[2])); //YYYY-MM-DD
                                LocalDate fechaSalidaPrevista = LocalDate.of(Integer.parseInt(fechaFin[0]), Integer.parseInt(fechaFin[0]), Integer.parseInt(fechaFin[0])); //YYYY-MM-DD
                                reservas.add(new Reserva(Integer.parseInt(informacion[0]), fechaReserva, fechaEntradaPrevista, fechaSalidaPrevista, informacion[7]));
                        }
                }catch(IOException ex){
                        JOptionPane.showMessageDialog(null, "Error al leer el archivo de reservas" + ex.getMessage(), "Error Archivo", 0);
                }
   }
   
   /**
    * Escribir en el archivo de reservas con la información del arreglo
    */
   private void escribirArchivo(){
           try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(reservasArchivo));
                        for(Reserva reserva : reservas){
                                //Orden numero;anioInicio-mesInicio-diaInicio;anioFin-mesFin-diaFin;estado
                                bw.append(reserva.getIdReserva() + ";" + reserva.getFechaEntradaPrevista() + ";" + reserva.getFechaSalidaPrevista() + ";" + reserva.getFechaReserva() + ";" + reserva.getEstado());
                                bw.newLine();
                        }
                        bw.close();

                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de reservas: " + ex.getMessage(), "Error Archivo", 0);
                }
   }
}


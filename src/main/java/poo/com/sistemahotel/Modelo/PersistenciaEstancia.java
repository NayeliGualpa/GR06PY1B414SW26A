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


public class PersistenciaEstancia {
        
        private String RUTA_ARCHIVO = "src/main/resources/archivos/estancias.txt"; //Archivo donde se obtendrá y guardará la información
        private File estanciasArchivo;
        
    // Asociación: Una PersistenciaEstancia almacena muchas estancias (*)
    private ArrayList<Estancia> estancias;
    
    public PersistenciaEstancia(){
            this.estancias = new ArrayList<>();
            this.estanciasArchivo = new File(RUTA_ARCHIVO);
    }
    
    // Guardar, buscar, actualizar, eliminar y listar estancias
    public void guardarEstancia(Estancia e){
        estancias.add(e);
        
        escribirArchivo();
    }

    public Estancia buscarEstancia(int id){
        for(Estancia e : estancias){
            if(e.getIdEstancia()==id){
                return e;
            }
        }
        return null;
    }

    public void actualizarEstancia(Estancia e){
        for(int i=0;i<estancias.size();i++){
            if(estancias.get(i)
                    .getIdEstancia()
                    ==e.getIdEstancia()){
                estancias.set(i,e);
            }
        }
        
        escribirArchivo();
    }

    public void eliminarEstancia(int id){
        for(int i=0;i<estancias.size();i++){
            if(estancias.get(i)
                    .getIdEstancia()==id){
                estancias.remove(i);
            }
         }
        
        escribirArchivo();
    }

    public ArrayList<Estancia> listarEstancias(){
        return estancias;
    }
    
    public void guardarEstancias(){
            try{
                        BufferedReader br = new BufferedReader(new FileReader(estanciasArchivo));
                        String linea;
                        while((linea = br.readLine()) != null){
                                String[] informacion = linea.split(";");
                                String[] fechaInicio = informacion[1].split("-");
                                String[] fechaFin = informacion[2].split("-");
                                LocalDate fechaIngreso = LocalDate.of(Integer.parseInt(fechaInicio[0]), Integer.parseInt(fechaInicio[1]), Integer.parseInt(fechaInicio[2])); //YYYY-MM-DD
                                LocalDate fechaSalida = LocalDate.of(Integer.parseInt(fechaFin[0]), Integer.parseInt(fechaFin[1]), Integer.parseInt(fechaFin[2]));
                                Reserva reserva = null;
                                for(Estancia estancia : estancias){
                                        if(estancia.getReserva().getIdReserva() == Integer.parseInt(informacion[4])){
                                                reserva = estancia.getReserva();
                                                break;
                                        }
                                }
                                //Orden id;fechaIngreso;fechaSalida;estado;reservaId;multasId
                                estancias.add(new Estancia(Integer.parseInt(informacion[0]), fechaIngreso, fechaSalida, informacion[3], reserva));
                                int i = 5; //Indice ID multas
                                while(informacion[i] != null){
                                        
                                }
                        }
                }catch(IOException ex){
                        JOptionPane.showMessageDialog(null, "Error al leer el archivo de estancias" + ex.getMessage(), "Error Archivo", 0);
                }
    }
    
    public void escribirArchivo(){
            try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter(estanciasArchivo));
                        for(Estancia estancia : estancias){
                                //Orden id;fechaIngreso;fechaSalida;estado;reservaId;multasId
                                bw.append(estancia.getIdEstancia() + ";" + estancia.getFechaIngresoReal() + ";" + estancia.getFechaSalidaReal() + ";" + estancia.getEstado() + ";" + estancia.getReserva().getIdReserva());
                                for(Multa multa : estancia.getMultas()){
                                        bw.append(";" + multa.getIdMulta());
                                }
                                bw.newLine();
                        }
                        
                }catch(IOException ex){
                        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de estancias: " + ex.getMessage(), "Error Archivo", 0);
                }
    }
}



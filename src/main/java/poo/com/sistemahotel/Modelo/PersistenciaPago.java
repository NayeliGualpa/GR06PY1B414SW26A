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
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersistenciaPago {
        
        private String RUTA_ARCHIVO = "src/main/resources/archivos/pagos.txt"; //Archivo donde se obtendrá y guardará la información
        private File pagosArchivo;
        
    // Asociación:Una PersistenciaPago almacena muchos pagos (*)
    private ArrayList<Pago> pagos;

    public PersistenciaPago(){
            this.pagos = new ArrayList<>();
            this.pagosArchivo = new File(RUTA_ARCHIVO);
    }
    
    // Guardar, Buscar, Actualizar, Eliminar, Listar
    public void guardarPago(Pago p){
        pagos.add(p);
        
        escribirArchivo();
    }

    public Pago buscarPago(int id){
        for(Pago p:pagos){
            if(p.getIdPago()==id){
                return p;
            }
        }
        return null;
    }

    public void actualizarPago(Pago p){
        for(int i=0;i<pagos.size();i++){
            if(pagos.get(i)
                    .getIdPago()==p.getIdPago()){
                pagos.set(i,p);
            }
        }
        
        escribirArchivo();
    }

    public void eliminarPago(int id){
        for(int i=0;i<pagos.size();i++){
            if(pagos.get(i)
                    .getIdPago()==id){
                pagos.remove(i);
            }
        }
        
        escribirArchivo();
    }

    public ArrayList<Pago> listarPagos(){
        return pagos;
    }
    
    public void guardarPagos(){
           try {

                        if (pagos == null) {
                                return;
                        }
                        BufferedReader br = new BufferedReader(new FileReader(pagosArchivo));
                        String linea;
                        while ((linea = br.readLine()) != null) {
                                String[] informacion = linea.split(";");
                                String[] fechaLinea = informacion[1].split("-"); //Formato YYYY-MM-DD
                                LocalDate fecha = LocalDate.of(Integer.parseInt(fechaLinea[0]), Integer.parseInt(fechaLinea[1]), Integer.parseInt(fechaLinea[2]));
                                Reserva reservaIngresar = null;
                                for(Pago pago : pagos){
                                        //Si encuentra la reserva por su id entonces lo guarda
                                        if(pago.getReserva().getIdReserva() == Integer.parseInt(informacion[4])){
                                                reservaIngresar = pago.getReserva();
                                                break;
                                        }
                                }
                                //Orden id;fecha;monto;metodo;reservaId
                                pagos.add(new Pago(Integer.parseInt(informacion[0]), fecha, Double.parseDouble(informacion[2]), informacion[3], reservaIngresar));
                        }
                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al leer el archivo de pagos" + ex.getMessage(), "Error Archivo", 0);
                } 
    }
    
    public void escribirArchivo(){
            try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(pagosArchivo));
                        for (Pago pago : pagos) {
                                //Orden id;fecha;monto;metodo;reservaId
                                bw.append(pago.getIdPago() + ";" + pago.getFechaPago() + ";" + pago.getMonto() + ";" + pago.getMetodoPago() + ";" + pago.getReserva().getIdReserva());
                                bw.newLine();
                        }
                        bw.close();

                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de pagos: " + ex.getMessage(), "Error Archivo", 0);
                }
    }
    
}



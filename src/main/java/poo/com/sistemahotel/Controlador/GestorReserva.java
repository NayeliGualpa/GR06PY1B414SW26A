/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Controlador;

import javax.swing.JOptionPane;
import poo.com.sistemahotel.Modelo.Habitacion;
import poo.com.sistemahotel.Modelo.PersistenciaReserva;
import poo.com.sistemahotel.Modelo.Reserva;
import poo.com.sistemahotel.Modelo.ValidadorReserva;

/**
 *
 * @author manue
 */
public class GestorReserva {
        PersistenciaReserva persistenciaReserva;
        ValidadorReserva validadorReserva;
        GestorHabitacion gestorHabitacion;
        
        public GestorReserva(){
                this.persistenciaReserva = new PersistenciaReserva();
                this.validadorReserva = new ValidadorReserva();
                this.gestorHabitacion = new GestorHabitacion();
        }
        
        public void registrarReserva(Reserva reserva){
                if(validadorReserva.validarReserva(reserva)){
                        persistenciaReserva.guardarReserva(reserva);
                }
        }
        
        public Reserva buscarReserva(int id){
                Reserva reserva = null;
                if(validadorReserva.validarId(id)){
                        reserva = buscarReserva(id);
                        if(reserva == null){
                                JOptionPane.showMessageDialog(null, "No existe la reserva", "Error Reserva", 0);
                        }
                }
                return reserva;
        }
        
        public void cancelarReserva(Reserva reserva){
                if(validadorReserva.validarReserva(reserva)){
                        persistenciaReserva.eliminarReserva(reserva.getIdReserva());
                }
        }
        
        public boolean verificarReservaActiva(Reserva reserva){
                if(validadorReserva.validarReserva(reserva)){
                        if(reserva.getEstado().equalsIgnoreCase("activa")){
                                return true;
                        }
                }
                return false;
        }
        
        public boolean verificarDisponibilidadHabitacion(Habitacion habitacion){
                if(gestorHabitacion.verificarDisponibilidad(habitacion)){
                        return true;
                }
                return false;
        }
}

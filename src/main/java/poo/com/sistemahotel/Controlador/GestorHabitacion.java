/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Controlador;

import poo.com.sistemahotel.Modelo.Habitacion;
import poo.com.sistemahotel.Modelo.PersistenciaHabitacion;
import poo.com.sistemahotel.Modelo.ValidadorHabitacion;

/**
 *
 * @author manue
 */
public class GestorHabitacion {

        private ValidadorHabitacion validadorHabitacion;
        private PersistenciaHabitacion persistenciaHabitacion;
        private static GestorHabitacion instanciaHabitacion;
        
        private GestorHabitacion(){
                this.validadorHabitacion = new ValidadorHabitacion();
                this.persistenciaHabitacion = new PersistenciaHabitacion();
        }
        
        public static GestorHabitacion getInstanciaHabitacion(){
                if(instanciaHabitacion == null){
                        instanciaHabitacion = new GestorHabitacion();
                }
                return instanciaHabitacion;
        }
        
        public boolean verificarDisponibilidad(Habitacion habitacion) {
                if(validadorHabitacion.validarHabitacion(habitacion)){
                        if(habitacion.getEstado().equalsIgnoreCase("disponible")){
                                return true;
                        }
                }
                return false;
        }
        
        public void cambiarEstadoHabitacion(Habitacion habitacion, String estado){
                if(validadorHabitacion.validarHabitacion(habitacion) && validadorHabitacion.validarEstado(estado)){
                        //Modificar la habitación
                        habitacion.setEstado(estado);
                        //Agregar la actualización al archivo
                        persistenciaHabitacion.actualizarHabitacion(habitacion);
                }
        }
        
        public Habitacion buscarHabitacion(int id){
                if(validadorHabitacion.validarNumero(id)){
                        return persistenciaHabitacion.buscarHabitacion(id);
                }
                return null;
        }

        public PersistenciaHabitacion getPersistenciaHabitacion() {
                return persistenciaHabitacion;
        }

        public void setPersistenciaHabitacion(PersistenciaHabitacion persistenciaHabitacion) {
                this.persistenciaHabitacion = persistenciaHabitacion;
        }
        
        
}

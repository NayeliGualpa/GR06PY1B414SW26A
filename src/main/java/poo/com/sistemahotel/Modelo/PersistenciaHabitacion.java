/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.util.ArrayList;
public class PersistenciaHabitacion {
      // Asociación
    // Una PersistenciaHabitacion almacena muchas habitaciones (*)
    private ArrayList<Habitacion> habitaciones =
            new ArrayList<>();
    
    // Guardar, Buscar, Actualizar, Eliminar y Listar Habitaciones
    public void guardarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }
  
public Habitacion buscarHabitacion(int id) {
    for(Habitacion h : habitaciones){
        if(h.getNumero() == id){
            return h;
        }
    }
    return null;
}

    public void actualizarHabitacion(Habitacion h) {
        for(int i=0;i<habitaciones.size();i++){
            if(habitaciones.get(i).getNumero()
                    == h.getNumero()){
                habitaciones.set(i,h);
            }
        }
    }

    public void eliminarHabitacion(int id) {
        for(int i=0;i<habitaciones.size();i++){
            if(habitaciones.get(i).getNumero()
                    == id){
                habitaciones.remove(i);
            }
        }
    }

    public ArrayList<Habitacion> listarHabitaciones() {
        return habitaciones;
    }
   
}
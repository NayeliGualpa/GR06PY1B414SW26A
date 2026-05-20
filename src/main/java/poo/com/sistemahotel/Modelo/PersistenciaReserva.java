/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.util.ArrayList;
public class PersistenciaReserva {
    // Asociación: Una PersistenciaReserva almacena muchas reservas (*)
    private ArrayList<Reserva> reservas =
            new ArrayList<>();
    // Guardar, buscar, actualizar, eliminar y listar reservas
    public void guardarReserva(Reserva r){
        reservas.add(r);
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
    }

    public void eliminarReserva(int id){
        for(int i=0;i<reservas.size();i++){
            if(reservas.get(i)
                    .getIdReserva()==id){
                reservas.remove(i);
             }
        }
    }

    public ArrayList<Reserva> listarReservas(){
        return reservas;
    }

   
}


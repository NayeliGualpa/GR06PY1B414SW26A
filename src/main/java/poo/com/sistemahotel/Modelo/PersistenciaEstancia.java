/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.util.ArrayList;
public class PersistenciaEstancia {
    // Asociación: Una PersistenciaEstancia almacena muchas estancias (*)
    private ArrayList<Estancia> estancias =
            new ArrayList<>();
    // Guardar, buscar, actualizar, eliminar y listar estancias
    public void guardarEstancia(Estancia e){
        estancias.add(e);
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
    }

    public void eliminarEstancia(int id){
        for(int i=0;i<estancias.size();i++){
            if(estancias.get(i)
                    .getIdEstancia()==id){
                estancias.remove(i);
            }
         }
    }

    public ArrayList<Estancia> listarEstancias(){
        return estancias;
    }
}



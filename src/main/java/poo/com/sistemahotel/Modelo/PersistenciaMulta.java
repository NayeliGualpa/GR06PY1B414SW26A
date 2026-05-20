/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.util.ArrayList;
public class PersistenciaMulta {
    // Asociación: Una PersistenciaMulta almacena muchas multas (*)
    private ArrayList<Multa> multas=
            new ArrayList<>();

       // Guardar, Buscar, Actualizar, Eliminar y Listar Multas
    public void guardarMulta(Multa m){
        multas.add(m);
    }

    public Multa buscarMulta(int id){
        for(Multa m:multas){
            if(m.getIdMulta()==id){
                return m;
            }
        }
        return null;
    }

    public void actualizarMulta(Multa m){
        for(int i=0;i<multas.size();i++){
            if(multas.get(i)
                    .getIdMulta()==m.getIdMulta()){
                multas.set(i,m);
            }
        }
    }

    public void eliminarMulta(int id){
        for(int i=0;i<multas.size();i++){
            if(multas.get(i)
                    .getIdMulta()==id){
                multas.remove(i);
            }
        }
    }

    public ArrayList<Multa> listarMultas(){
        return multas;
    }
}


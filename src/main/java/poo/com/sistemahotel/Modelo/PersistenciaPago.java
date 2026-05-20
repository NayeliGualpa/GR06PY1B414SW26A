/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.util.ArrayList;
public class PersistenciaPago {
    // Asociación:Una PersistenciaPago almacena muchos pagos (*)
    private ArrayList<Pago> pagos=
            new ArrayList<>();

    // Guardar, Buscar, Actualizar, Eliminar, Listar
    public void guardarPago(Pago p){
        pagos.add(p);
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
    }

    public void eliminarPago(int id){
        for(int i=0;i<pagos.size();i++){
            if(pagos.get(i)
                    .getIdPago()==id){
                pagos.remove(i);
            }
        }
    }

    public ArrayList<Pago> listarPagos(){
        return pagos;
    }
}



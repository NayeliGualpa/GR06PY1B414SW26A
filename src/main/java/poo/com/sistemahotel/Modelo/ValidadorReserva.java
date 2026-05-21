/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.time.LocalDate;

public class ValidadorReserva {

    // + validarFechaReserva(fechaReserva: LocalDateTime): boolean
    public boolean validarFechaReserva(LocalDate fechaReserva) {
        return fechaReserva != null;
    }

    // + validarFechaEntradaPrevista(fechaEntradaPrevista: LocalDateTime): boolean
    public boolean validarFechaEntradaPrevista(LocalDate fechaEntradaPrevista) {
        return fechaEntradaPrevista != null;
    }

    // + validarFechaSalidaPrevista(fechaSalidaPrevista: LocalDateTime): boolean
    public boolean validarFechaSalidaPrevista(LocalDate fechaSalidaPrevista) {
        return fechaSalidaPrevista != null;
    }

    // + validarEstado(estado: String): boolean
    public boolean validarEstado(String estado) {
        return estado != null && !estado.isEmpty();
    }
    
    public boolean validarId(int id){
            return id >= 0;
    }

    // + validarReserva(r: Reserva): boolean
    public boolean validarReserva(Reserva r) {
        return validarFechaReserva(r.getFechaReserva())
                && validarFechaEntradaPrevista(r.getFechaEntradaPrevista())
                && validarFechaSalidaPrevista(r.getFechaSalidaPrevista())
                && validarEstado(r.getEstado())
                && validarId(r.getIdReserva());
    }
}
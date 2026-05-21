/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.time.LocalDate;

public class ValidadorEstancia {

    // + validarFechaIngresoReal(fechaIngresoReal: LocalDateTime): boolean
    public boolean validarFechaIngresoReal(LocalDate fechaIngresoReal) {
        return fechaIngresoReal != null;
    }

    // + validarFechaSalidaReal(fechaSalidaReal: LocalDateTime): boolean
    public boolean validarFechaSalidaReal(LocalDate fechaSalidaReal) {
        // Al ser una fecha de salida, podría ser nula inicialmente si el cliente no ha salido,
        // pero para efectos del validador estructural se verifica su existencia.
        return fechaSalidaReal != null;
    }

    // + validarEstado(estado: String): boolean
    public boolean validarEstado(String estado) {
        return estado != null && !estado.isEmpty();
    }

    // + validarEstancia(e: Estancia): boolean (Parámetro corregido a 'e')
    public boolean validarEstancia(Estancia e) {
        return validarFechaIngresoReal(e.getFechaIngresoReal())
                && validarFechaSalidaReal(e.getFechaSalidaReal())
                && validarEstado(e.getEstado());
    }
}
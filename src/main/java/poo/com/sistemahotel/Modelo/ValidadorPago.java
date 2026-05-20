/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.util.Date;

public class ValidadorPago {

    // + validarFechaPago(fechaPago: Date): boolean
    public boolean validarFechaPago(Date fechaPago) {
        return fechaPago != null;
    }

    // + validarMonto(monto: double): boolean
    public boolean validarMonto(double monto) {
        return monto > 0;
    }

    // + validarMetodoPago(metodoPago: String): boolean
    public boolean validarMetodoPago(String metodoPago) {
        return metodoPago != null && !metodoPago.isEmpty();
    }

    // + validarPago(p: Pago): boolean
    public boolean validarPago(Pago p) {
        return validarFechaPago(p.getFechaPago()) // Agregado a la validación
                && validarMonto(p.getMonto())
                && validarMetodoPago(p.getMetodoPago());
    }
}


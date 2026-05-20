/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

public class ValidadorMulta {

    // + validarMotivo(motivo: String): boolean
    public boolean validarMotivo(String motivo) {
        return motivo != null && !motivo.isEmpty();
    }

    // + validarMonto(monto: double): boolean
    public boolean validarMonto(double monto) {
        return monto > 0;
    }

    // + validarEstado(estado: String): boolean (Agregado según el diagrama)
    public boolean validarEstado(String estado) {
        return estado != null && !estado.isEmpty();
    }

    // + validarMulta(m: Multa): boolean (Parámetro corregido a 'm')
    public boolean validarMulta(Multa m) {
        return validarMotivo(m.getMotivo())
                && validarMonto(m.getMonto())
                && validarEstado(m.getEstado()); // Incluido en la validación conjunta
    }
}

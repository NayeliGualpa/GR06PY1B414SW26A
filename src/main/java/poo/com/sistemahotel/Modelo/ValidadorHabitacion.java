/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

public class ValidadorHabitacion {

    public boolean validarNumero(int numero) {
        return numero > 0;
    }

    public boolean validarTipo(String tipo) {
        return tipo != null && !tipo.isEmpty();
    }

    // Corregido el nombre del método y del parámetro según la imagen
    public boolean validarPrecioPorNoche(double precioPorNoche) {
        return precioPorNoche > 0;
    }

    public boolean validarEstado(String estado) {
        return estado != null && !estado.isEmpty();
    }

    // Corregido el parámetro a 'h' y adaptado a los nombres exactos del diagrama
    public boolean validarHabitacion(Habitacion h) {
        return validarNumero(h.getNumero())
                && validarPrecioPorNoche(h.getPrecioPorNoche()) // Nombre actualizado
                && validarTipo(h.getTipo())
                && validarEstado(h.getEstado());
    }
}


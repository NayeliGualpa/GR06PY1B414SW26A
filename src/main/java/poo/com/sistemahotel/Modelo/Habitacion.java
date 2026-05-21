/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.util.ArrayList;

public class Habitacion {
        // Atributos

        private int numero;
        private String tipo;
        private double precioPorNoche;
        private String estado;
        private ArrayList<Reserva> reservas;

        // Metodo de Constructor
        public Habitacion(int numero, String tipo, double precioPorNoche, String estado) {
                this.numero = numero;
                this.tipo = tipo;
                this.precioPorNoche = precioPorNoche;
                this.estado = estado;
                this.reservas = new ArrayList<>();
        }

        // Metodo de Getters y Setters
        public int getNumero() {
                return numero;
        }

        public void setNumero(int numero) {
                this.numero = numero;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public double getPrecioPorNoche() {
                return precioPorNoche;
        }

        public void setPrecioPorNoche(double precioPorNoche) {
                this.precioPorNoche = precioPorNoche;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public ArrayList<Reserva> getReservas() {
                return reservas;
        }

        public void setReservas(ArrayList<Reserva> reservas) {
                this.reservas = reservas;
        }

}

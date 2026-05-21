/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.time.LocalDate;

public class Pago {
        // Atributos

        private int idPago;
        private LocalDate fechaPago;
        private double monto;
        private String metodoPago;
        private Reserva reserva;

        // Metodo deConstructor
        public Pago(int idPago, LocalDate fechaPago, double monto, String metodoPago, Reserva reserva) {
                this.idPago = idPago;
                this.fechaPago = fechaPago;
                this.monto = monto;
                this.metodoPago = metodoPago;
                this.reserva = reserva;
        }

        // Metodo de Getters y Setters
        public int getIdPago() {
                return idPago;
        }

        public void setIdPago(int idPago) {
                this.idPago = idPago;
        }

        public LocalDate getFechaPago() {
                return fechaPago;
        }

        public void setFechaPago(LocalDate fechaPago) {
                this.fechaPago = fechaPago;
        }

        public double getMonto() {
                return monto;
        }

        public void setMonto(double monto) {
                this.monto = monto;
        }

        public String getMetodoPago() {
                return metodoPago;
        }

        public void setMetodoPago(String metodoPago) {
                this.metodoPago = metodoPago;
        }

        public Reserva getReserva() {
                return reserva;
        }

        public void setReserva(Reserva reserva) {
                this.reserva = reserva;
        }

}

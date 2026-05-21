/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.time.LocalDate;

public class Reserva {
        // Atributos

        private int idReserva;
        private LocalDate fechaReserva;
        private LocalDate fechaEntradaPrevista;
        private LocalDate fechaSalidaPrevista;
        private String estado;
        private Pago pagoAsociado;

        // Método de Constructor
        public Reserva(int idReserva, LocalDate fechaReserva, LocalDate fechaEntradaPrevista,
                LocalDate fechaSalidaPrevista, String estado) {
                this.idReserva = idReserva;
                this.fechaReserva = fechaReserva;
                this.fechaEntradaPrevista = fechaEntradaPrevista;
                this.fechaSalidaPrevista = fechaSalidaPrevista;
                this.estado = estado;
        }

        public Reserva(int idReserva, LocalDate fechaReserva, LocalDate fechaEntradaPrevista,
                LocalDate fechaSalidaPrevista, String estado, Pago pago) {
                this.idReserva = idReserva;
                this.fechaReserva = fechaReserva;
                this.fechaEntradaPrevista = fechaEntradaPrevista;
                this.fechaSalidaPrevista = fechaSalidaPrevista;
                this.estado = estado;
                this.pagoAsociado = pago;
        }

        // Método de Getters y Setters
        public int getIdReserva() {
                return idReserva;
        }

        public void setIdReserva(int idReserva) {
                this.idReserva = idReserva;
        }

        public LocalDate getFechaReserva() {
                return fechaReserva;
        }

        public void setFechaReserva(LocalDate fechaReserva) {
                this.fechaReserva = fechaReserva;
        }

        public LocalDate getFechaEntradaPrevista() {
                return fechaEntradaPrevista;
        }

        public void setFechaEntradaPrevista(LocalDate fechaEntradaPrevista) {
                this.fechaEntradaPrevista = fechaEntradaPrevista;
        }

        public LocalDate getFechaSalidaPrevista() {
                return fechaSalidaPrevista;
        }

        public void setFechaSalidaPrevista(LocalDate fechaSalidaPrevista) {
                this.fechaSalidaPrevista = fechaSalidaPrevista;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public Pago getPagoAsociado() {
                return pagoAsociado;
        }

        public void setPagoAsociado(Pago pagoAsociado) {
                this.pagoAsociado = pagoAsociado;
        }

}

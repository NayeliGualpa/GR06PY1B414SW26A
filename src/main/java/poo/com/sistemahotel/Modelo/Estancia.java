/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estancia {
        // Atributos

        private int idEstancia;
        private LocalDate fechaIngresoReal;
        private LocalDate fechaSalidaReal;
        private String estado;
        private Reserva reserva;
        private ArrayList<Multa> multas;

        // Metodo de Constructor
        public Estancia(int idEstancia, LocalDate fechaIngresoReal, LocalDate fechaSalidaReal, String estado, Reserva reserva) {
                this.idEstancia = idEstancia;
                this.fechaIngresoReal = fechaIngresoReal;
                this.fechaSalidaReal = fechaSalidaReal;
                this.estado = estado;
                this.reserva = reserva;
                this.multas = new ArrayList<>();
        }

        // Metodo de Getters y Setters
        public int getIdEstancia() {
                return idEstancia;
        }

        public void setIdEstancia(int idEstancia) {
                this.idEstancia = idEstancia;
        }

        public LocalDate getFechaIngresoReal() {
                return fechaIngresoReal;
        }

        public void setFechaIngresoReal(LocalDate fechaIngresoReal) {
                this.fechaIngresoReal = fechaIngresoReal;
        }

        public LocalDate getFechaSalidaReal() {
                return fechaSalidaReal;
        }

        public void setFechaSalidaReal(LocalDate fechaSalidaReal) {
                this.fechaSalidaReal = fechaSalidaReal;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public Reserva getReserva() {
                return reserva;
        }

        public void setReserva(Reserva reserva) {
                this.reserva = reserva;
        }

        public ArrayList<Multa> getMultas() {
                return multas;
        }

        public void setMultas(ArrayList<Multa> multas) {
                this.multas = multas;
        }

        
}

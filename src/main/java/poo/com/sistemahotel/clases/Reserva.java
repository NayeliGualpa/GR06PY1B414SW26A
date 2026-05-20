/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.clases;

import java.time.LocalDateTime;
public class Reserva {
    // Atributos
    private int idReserva;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaEntradaPrevista;
    private LocalDateTime fechaSalidaPrevista;
    private String estado;

    // Método de Constructor
    public Reserva(int idReserva, LocalDateTime fechaReserva, LocalDateTime fechaEntradaPrevista,
         LocalDateTime fechaSalidaPrevista, String estado){
        this.idReserva=idReserva;
        this.fechaReserva=fechaReserva;
        this.fechaEntradaPrevista=fechaEntradaPrevista;
        this.fechaSalidaPrevista=fechaSalidaPrevista;
        this.estado=estado;
    }

    // Método de Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public LocalDateTime getFechaEntradaPrevista() {
        return fechaEntradaPrevista;
    }
    public void setFechaEntradaPrevista(LocalDateTime fechaEntradaPrevista) {
        this.fechaEntradaPrevista = fechaEntradaPrevista;
    }
    public LocalDateTime getFechaSalidaPrevista() {
        return fechaSalidaPrevista;
    }
    public void setFechaSalidaPrevista(LocalDateTime fechaSalidaPrevista) {
        this.fechaSalidaPrevista = fechaSalidaPrevista;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

     }
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.clases;

import java.time.LocalDateTime;
public class Estancia {
    // Atributos
    private int idEstancia;
    private LocalDateTime fechaIngresoReal;
    private LocalDateTime fechaSalidaReal;
    private String estado;

    // Metodo de Constructor
    public Estancia(int idEstancia, LocalDateTime fechaIngresoReal, LocalDateTime fechaSalidaReal, String estado){
        this.idEstancia=idEstancia;
        this.fechaIngresoReal=fechaIngresoReal;
        this.fechaSalidaReal=fechaSalidaReal;
        this.estado=estado;
    }

    // Metodo de Getters y Setters
    public int getIdEstancia() {
        return idEstancia;
    }
    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }
    public LocalDateTime getFechaIngresoReal() {
        return fechaIngresoReal;
    }
    public void setFechaIngresoReal(LocalDateTime fechaIngresoReal) {
        this.fechaIngresoReal = fechaIngresoReal;
    }
    public LocalDateTime getFechaSalidaReal() {
        return fechaSalidaReal;
    }
    public void setFechaSalidaReal(LocalDateTime fechaSalidaReal) {
        this.fechaSalidaReal = fechaSalidaReal;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}



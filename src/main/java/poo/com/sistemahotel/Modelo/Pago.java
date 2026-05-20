/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

import java.util.Date;
public class Pago {
    // Atributos
    private int idPago;
    private Date fechaPago;
    private double monto;
    private String metodoPago;

    // Metodo deConstructor
    public Pago(int idPago,Date fechaPago, double monto,String metodoPago){
        this.idPago=idPago;
        this.fechaPago=fechaPago;
        this.monto=monto;
        this.metodoPago=metodoPago;
    }

    // Metodo de Getters y Setters
    public int getIdPago() {
        return idPago;
    }
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    public Date getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(Date fechaPago) {
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
}



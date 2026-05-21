/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

public class Multa {
    // Atributos
    private int idMulta;
    private String motivo;
    private double monto;
    private String estado;
    private Estancia estancia;

    // Metodo deConstructor
    public Multa(int idMulta,String motivo, double monto,String estado, Estancia estancia){
        this.idMulta=idMulta;
        this.motivo=motivo;
        this.monto=monto;
        this.estado=estado;
        this.estancia = estancia;
    }

    // Metodo deGetters y Setters
    public int getIdMulta() {
        return idMulta;
    }
    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

        public Estancia getEstancia() {
                return estancia;
        }

        public void setEstancia(Estancia estancia) {
                this.estancia = estancia;
        }
    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import poo.com.sistemahotel.Modelo.Pago;
import poo.com.sistemahotel.Modelo.Reserva;

/**
 *
 * @author manue
 */
public class GestorPago {
        private ArrayList<Pago> pagos;

        public GestorPago() {
                this.pagos = pagos;
        }

        public ArrayList<Pago> getPagos() {
                return pagos;
        }
        
        /**
         * Registrar un nuevo pago en el arreglo
         * @param nuevoPago 
         */
        public void registrarPago(Pago nuevoPago){
                pagos.add(nuevoPago);
                JOptionPane.showMessageDialog(null, "Pago agregado", "Confirmación Pago", 1);
        }
        
        /**
         * Verificar si una reserva se pagó en su totalidad
         * @param reserva
         * @return 
         */
        public Boolean verificarPagoReserva(Reserva reserva){
                Boolean pagoReserva = false;
                if(reserva.getEstado().equalsIgnoreCase("pagado")){
                        pagoReserva = true;
                }
                return pagoReserva;
        }
        
        public Boolean verificarPagoCompleto(Pago pago){
                return true;
        }
        
        /**
         * Mostrar el comprobante de pago
         * @param pago 
         */
        public void generarComprobante(Pago pago){
                JOptionPane.showMessageDialog(null, "Comprobante\nId: " + pago.getIdPago() + "\nFecha: " + pago.getFechaPago() + "\nMonto: " + pago.getMonto() + "\nMetodo de pago: " + pago.getMetodoPago(), "Comprobante", 1);
        }
}

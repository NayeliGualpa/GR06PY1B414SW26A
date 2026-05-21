/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import poo.com.sistemahotel.Modelo.Pago;
import poo.com.sistemahotel.Modelo.PersistenciaPago;
import poo.com.sistemahotel.Modelo.Reserva;
import poo.com.sistemahotel.Modelo.ValidadorPago;

/**
 *
 * @author manue
 */
public class GestorPago {
        private ValidadorPago validadorPago;
        private PersistenciaPago persistenciaPago;
        private GestorReserva gestorReserva;
        private static GestorPago instanciaPago;

        private GestorPago() {
                this.validadorPago = new ValidadorPago();
                this.persistenciaPago = new PersistenciaPago();
                this.gestorReserva = GestorReserva.getInstanciaReserva();
        }
        
        public static GestorPago getInstanciaPago(){
                if(instanciaPago == null){
                        instanciaPago = new GestorPago();
                }
                return instanciaPago;
        }

        /**
         * Registrar un nuevo pago en el archivo
         * @param nuevoPago 
         */
        public void registrarPago(Pago nuevoPago){
                if(validadorPago.validarPago(nuevoPago)){
                        if(nuevoPago != null){
                                persistenciaPago.guardarPago(nuevoPago);
                        }
                }
        }
        
        /**
         * Verificar si una reserva se pagó en su totalidad
         * @param reserva
         * @return 
         */
        public Boolean verificarPagoReserva(Reserva reserva){
                if(reserva.getEstado().equalsIgnoreCase("pagado")){
                        return true;
                }
                return false;
        }
        
        public Boolean verificarPagoCompleto(Pago pago){
                if(validadorPago.validarPago(pago)){
                        if(pago.getReserva().getEstado().equalsIgnoreCase("pagado")){
                                return true;
                        }
                }
                return false;
        }
        
        /**
         * Mostrar el comprobante de pago
         * @param pago 
         */
        public void generarComprobante(Pago pago){
                JOptionPane.showMessageDialog(null, "Comprobante\nId: " + pago.getIdPago() + "\nFecha: " + pago.getFechaPago() + "\nReserva: " + pago.getReserva().getIdReserva() + "\nMonto: " + pago.getMonto() + "\nMetodo de pago: " + pago.getMetodoPago(), "Comprobante", 1);
        }

        public PersistenciaPago getPersistenciaPago() {
                return persistenciaPago;
        }

        public void setPersistenciaPago(PersistenciaPago persistenciaPago) {
                this.persistenciaPago = persistenciaPago;
        }
        
        
}

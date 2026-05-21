/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package poo.com.sistemahotel.Modelo;

import poo.com.sistemahotel.Controlador.*;
import poo.com.sistemahotel.Vista.Login;

/**
 *
 * @author pc
 */
public class App {

    public static void main(String[] args) {
            
        // 1. INICIALIZAR LA PERSISTENCIA (Modelo)
        PersistenciaReserva pReserva = new PersistenciaReserva();
        PersistenciaMulta pMulta = new PersistenciaMulta();
        PersistenciaEstancia pEstancia = new PersistenciaEstancia();
        PersistenciaHabitacion pHabitacion = new PersistenciaHabitacion();
        PersistenciaCliente pCliente = new PersistenciaCliente();
        PersistenciaPago pPago = new PersistenciaPago();

        // 2. CARGAR DATOS DESDE EL DISCO (Se cruzan los datos como vimos antes)
         pReserva.cargarReservas();
        pEstancia.cargarEstancias();
        pHabitacion.cargarHabitaciones();
        pCliente.cargarClientes();
        pPago.cargarPagos();

        // 3. INICIALIZAR CONTROLADORES (Pasándoles sus datos ya listos)
            GestorCliente gCliente = GestorCliente.getInstanciaCliente();
            GestorHabitacion gHabitacion = GestorHabitacion.getInstanciaHabitacion();
            GestorEstancia gEstancia = GestorEstancia.getInstanciaEstancia();
            GestorReserva gReserva = GestorReserva.getInstanciaReserva();
            GestorPago gPago = GestorPago.getInstanciaPago();
            GestorMulta gMulta = GestorMulta.getInstanciaMulta();
            
            gCliente.setPersistenciaCliente(pCliente);
            gEstancia.setPersistenciaEstancia(pEstancia);
            gHabitacion.setPersistenciaHabitacion(pHabitacion);
            gPago.setPersistenciaPago(pPago);
            gReserva.setPersistenciaReserva(pReserva);
            gMulta.setPersistenciaMulta(pMulta);

        // 4. INICIALIZAR LAS VISTAS
        Login vistaPrincipal = new Login();

        
        vistaPrincipal.setVisible(true); // Arranca el programa
    }
}

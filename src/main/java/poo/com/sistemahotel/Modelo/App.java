/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package poo.com.sistemahotel.Modelo;

import java.util.ArrayList;
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
            GestorCliente gCliente = new GestorCliente();
            GestorHabitacion gHabitacion = new GestorHabitacion();
            GestorEstancia gEstancia = new GestorEstancia();
            GestorReserva gReserva = new GestorReserva();
            GestorPago gPago = new GestorPago();
            GestorMulta gMulta = new GestorMulta();

        // 4. INICIALIZAR LAS VISTAS
        Login vistaPrincipal = new Login();

        
        vistaPrincipal.setVisible(true); // Arranca el programa
    }
}

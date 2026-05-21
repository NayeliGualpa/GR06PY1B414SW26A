/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Controlador;

import javax.swing.JOptionPane;
import poo.com.sistemahotel.Modelo.Cliente;
import poo.com.sistemahotel.Modelo.PersistenciaCliente;
import poo.com.sistemahotel.Modelo.ValidadorCliente;

/**
 *
 * @author manue
 */
public class GestorCliente {

        private ValidadorCliente validadorCliente;
        private PersistenciaCliente persistenciaCliente;

        /**
         * Constructor
         */
        public GestorCliente() {
                this.validadorCliente = new ValidadorCliente();
                this.persistenciaCliente = new PersistenciaCliente();
        }

        /**
         * Registrar un nuevo cliente en el archivo
         *
         * @param nuevoCliente
         */
        public void registrarCliente(Cliente nuevoCliente) {
                if (verificarClienteExistente(nuevoCliente.getCedula())) {
                        JOptionPane.showMessageDialog(null, "El cliente ya existe", "Error Cliente", 0);
                } else {
                        //Verificar que los formatos sean correctos
                        if (validadorCliente.validarCliente(nuevoCliente)) {

                                persistenciaCliente.guardarCliente(nuevoCliente);
                        }
                }
        }

        /**
         * Buscar y retornar un cliente en base a la cedula
         *
         * @param cedula
         * @return
         */
        public Cliente buscarCliente(String cedula) {
                //Validar la cédula
                if (validadorCliente.validarCedula(cedula)) {
                        return persistenciaCliente.buscarCliente(cedula);
                } else {
                        return null;
                }
        }

        /**
         * Actualiza la información de un cliente existente
         *
         * @param nuevoCliente
         */
        public void procesarActualizacion(Cliente nuevoCliente) {
                if (validadorCliente.validarCliente(nuevoCliente)) {
                        Cliente clienteBuscado = buscarCliente(nuevoCliente.getCedula());

                        //Si el cliente existe
                        if (clienteBuscado != null) {
                                persistenciaCliente.actualizarCliente(nuevoCliente);
                                JOptionPane.showMessageDialog(null, "Información de cliente actualizada", "Confirmación Cliente", 1);
                        } else {
                                JOptionPane.showMessageDialog(null, "Cliente no existe", "Error Cliente", 0);
                        }
                }
        }

        /**
         * Verifica si un cliente existe en el arreglo
         *
         * @param cedula
         * @return
         */
        public Boolean verificarClienteExistente(String cedula) {
                Boolean clienteExiste = false;
                for (Cliente cliente : persistenciaCliente.listarClientes()) {
                        if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                                clienteExiste = true;
                                break;
                        }
                }
                return clienteExiste;
        }

        public void eliminarCliente(String cedula) {
                if (validadorCliente.validarCedula(cedula)) {
                        Cliente clienteBuscado = buscarCliente(cedula);

                        //Si el cliente existe
                        if (clienteBuscado != null) {
                                persistenciaCliente.eliminarCliente(cedula);
                                JOptionPane.showMessageDialog(null, "Clienete eliminado", "Confirmación Cliente", 1);
                        } else {
                                JOptionPane.showMessageDialog(null, "Cliente no existe", "Error Cliente", 0);
                        }
                }
        }

        public PersistenciaCliente getPersistenciaCliente() {
                return persistenciaCliente;
        }

        
}

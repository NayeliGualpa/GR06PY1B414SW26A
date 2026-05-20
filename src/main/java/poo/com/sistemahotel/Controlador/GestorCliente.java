/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import poo.com.sistemahotel.Modelo.Cliente;

/**
 *
 * @author manue
 */
public class GestorCliente {
        
        private ArrayList<Cliente> clientes;
        
        /**
         * Constructor
         */
        public GestorCliente(){
                clientes = new ArrayList<>();
        }
        
        /**
         * Registrar un nuevo cliente en el arreglo
         * @param nuevoCliente 
         */
        public void registrarCliente(Cliente nuevoCliente){
                if(verificarClienteExistente(nuevoCliente.getCedula())){
                        JOptionPane.showMessageDialog(null, "El cliente ya existe", "Error Cliente", 0);
                }else{
                        clientes.add(nuevoCliente);
                        JOptionPane.showMessageDialog(null, "Cliente ingresado", "Confirmacion Cliente", 1);
                }
        }
        
        /**
         * Buscar y retornar un cliente en base a la cedula
         * @param cedula
         * @return 
         */
        public Cliente buscarCliente(String cedula){
                Cliente clienteBuscado = new Cliente();
                for(Cliente cliente : clientes){
                        if(cliente.getCedula().equalsIgnoreCase(cedula)){
                                clienteBuscado = cliente;
                        }
                }
                
                return clienteBuscado;
        }
        
        /**
         * Actualiza la información de un cliente existente
         * @param nuevoCliente 
         */
        public void procesarActualizacion(Cliente nuevoCliente){
                Cliente clienteBuscado = buscarCliente(nuevoCliente.getCedula());
                
                //Si el cliente existe
                if(clienteBuscado != null){
                        clienteBuscado.setNombre(nuevoCliente.getNombre());
                        clienteBuscado.setApellido(nuevoCliente.getApellido());
                        clienteBuscado.setCorreo(nuevoCliente.getCorreo());
                        clienteBuscado.setDireccion(nuevoCliente.getDireccion());
                        clienteBuscado.setTelefono(nuevoCliente.getTelefono());
                        JOptionPane.showMessageDialog(null, "Información de cliente actualizada", "Confirmación Cliente", 1);
                }else{
                        JOptionPane.showMessageDialog(null, "Cliente no existe", "Error Cliente", 0);
                }
        }
        
        /**
         * Verifica si un cliente existe en el arreglo
         * @param cedula
         * @return 
         */
        public Boolean verificarClienteExistente(String cedula){
                Boolean clienteExiste = false;
                for(Cliente cliente : clientes){
                        if(cliente.getCedula().equalsIgnoreCase(cedula)){
                                clienteExiste = true;
                                break;
                        }
                }
                return clienteExiste;
        }
}

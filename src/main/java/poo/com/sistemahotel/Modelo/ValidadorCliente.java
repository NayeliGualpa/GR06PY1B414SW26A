/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Modelo;

public class ValidadorCliente {

        // + validarCedula(cedula: String): boolean
        public boolean validarCedula(String cedula) {
                return cedula != null && cedula.length() == 10;
        }

        // + validarNombre(nombre: String): boolean
        public boolean validarNombre(String nombre) {
                return nombre != null && !nombre.isEmpty();
        }

        // + validarApellido(apellido: String): boolean (Agregado)
        public boolean validarApellido(String apellido) {
                return apellido != null && !apellido.isEmpty();
        }

        // + validarTelefono(telefono: String): boolean
        public boolean validarTelefono(String telefono) {
                return telefono != null && telefono.length() == 10;
        }

        // + validarCorreo(correo: String): boolean
        public boolean validarCorreo(String correo) {
                return correo != null && correo.contains("@");
        }

        // + validarDireccion(direccion: String): boolean (Agregado)
        public boolean validarDireccion(String direccion) {
                return direccion != null && !direccion.isEmpty();
        }

        // + validarCliente(c: Cliente): boolean (Parámetro corregido a 'c')
        public boolean validarCliente(Cliente c) {
                return validarCedula(c.getCedula())
                        && validarNombre(c.getNombre())
                        && validarApellido(c.getApellido()) // Incluido en la validación
                        && validarTelefono(c.getTelefono())
                        && validarCorreo(c.getCorreo())
                        && validarDireccion(c.getDireccion()); // Incluido en la validación
        }
}

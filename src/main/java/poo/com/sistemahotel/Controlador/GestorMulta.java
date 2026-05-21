/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Controlador;

import poo.com.sistemahotel.Modelo.Estancia;
import poo.com.sistemahotel.Modelo.Habitacion;
import poo.com.sistemahotel.Modelo.Multa;
import poo.com.sistemahotel.Modelo.PersistenciaMulta;
import poo.com.sistemahotel.Modelo.ValidadorMulta;

/**
 *
 * @author manue
 */
public class GestorMulta {

        private PersistenciaMulta persistenciaMulta;
        private ValidadorMulta validadorMulta;
        private static GestorMulta instanciaMulta;

        private GestorMulta() {
                this.persistenciaMulta = new PersistenciaMulta();
                this.validadorMulta = new ValidadorMulta();
        }

        public static GestorMulta getInstanciaMulta() {
                if (instanciaMulta == null) {
                        instanciaMulta = new GestorMulta();
                }
                return instanciaMulta;
        }

        public PersistenciaMulta getPersistenciaMulta() {
                return persistenciaMulta;
        }

        public void setPersistenciaMulta(PersistenciaMulta persistenciaMulta) {
                this.persistenciaMulta = persistenciaMulta;
        }

        public Multa generarMultaPorRetraso(Estancia estancia) {
                return estancia.getMultas().get(0);

        }

        public Multa generarMultaPorDanios(Estancia estancia) {
                return estancia.getMultas().get(0);
        }

        public Boolean verificarDaniosHabitacion(Habitacion habitacion) {
                if (habitacion.getEstado().equals("daños")) {
                        return true;
                }
                return false;
        }

        public double calcularMontoMulta(Multa multa) {
                if (validadorMulta.validarMulta(multa)) {
                        return multa.getMonto();
                }
                return 0;
        }
}

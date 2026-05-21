/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.com.sistemahotel.Controlador;

import java.time.temporal.ChronoUnit;
import poo.com.sistemahotel.Modelo.Estancia;
import poo.com.sistemahotel.Modelo.PersistenciaEstancia;
import poo.com.sistemahotel.Modelo.ValidadorEstancia;

/**
 *
 * @author manue
 */
public class GestorEstancia {
        private ValidadorEstancia validadorEstancia;
        private PersistenciaEstancia persistenciaEstancia;
        private GestorMulta gestorMulta;
        private static GestorEstancia instanciaEstancia;
        
        private GestorEstancia(){
                this.validadorEstancia = new ValidadorEstancia();
                this.persistenciaEstancia = new PersistenciaEstancia();
                this.gestorMulta = GestorMulta.getInstanciaMulta();
        }
        
        public static GestorEstancia getInstanciaEstancia(){
                if(instanciaEstancia == null){
                        instanciaEstancia = new GestorEstancia();
                }
                return instanciaEstancia;
        }
        
        public void registrarIngreso(Estancia estancia){
                if(validadorEstancia.validarEstancia(estancia) && estancia != null){
                        persistenciaEstancia.guardarEstancia(estancia);
                }
        }
        
        public void finalizarEstancia(Estancia estancia){
                if(validadorEstancia.validarEstancia(estancia) && estancia != null){
                        //Si existe la estancia
                        if(persistenciaEstancia.buscarEstancia(estancia.getIdEstancia()) != null){
                                persistenciaEstancia.eliminarEstancia(estancia.getIdEstancia());
                        }
                }
        }
        
        public boolean verificarSalidaTardia(Estancia estancia){
                if(validadorEstancia.validarEstancia(estancia) && estancia != null){
                        
                }
                return false;
        }
        
        public long calcularTiempoHospedaje(Estancia estancia){
                long dias = 0;
                if(validadorEstancia.validarEstancia(estancia) && estancia != null){
                        dias = ChronoUnit.DAYS.between(estancia.getFechaIngresoReal(), estancia.getFechaSalidaReal());
                }
                return dias;
        }

        public PersistenciaEstancia getPersistenciaEstancia() {
                return persistenciaEstancia;
        }

        public void setPersistenciaEstancia(PersistenciaEstancia persistenciaEstancia) {
                this.persistenciaEstancia = persistenciaEstancia;
        }
        
        
}

package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public class Lindero extends Objeto {
    
    // Constructor
    public Lindero(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
    }
    
    
    // Métodos implementados
    @Override
    public void recibirRayoDeLuz(RayoDeLuz rayoDeLuz) {
        
        // Detener el avance del rayo de luz
        rayoDeLuz.detenerAvance();
        
        // Agregar mi posición a la trayectoria del rayo de luz
        rayoDeLuz.agregarPosicionATrayectoria(this.getPosicion());
    }
    
}
package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public abstract class CreadorDeLuz extends ObjetoGiratorio {
    
    // Relaciones
    protected RayoDeLuz rayoDeLuz;
    
    
    // Constructor
    public CreadorDeLuz(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);        
    }
    
    
    // Métodos a ser implementados
    protected abstract void crearLuz();
    
}

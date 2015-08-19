package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public abstract class ObjetoGiratorio extends Objeto {
    
    // Atributos
    protected int direccion;
    
    
    // Constructor
    public ObjetoGiratorio(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        this.direccion = 0;
    }
    
}

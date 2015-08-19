package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public abstract class ObjetoActivable extends Objeto {
    
    // Atributos
    protected boolean estaActivo;
    
    
    // Constructor
    public ObjetoActivable(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        this.estaActivo = false;
    }
    
    
    // Métodos
    public void activarme() {
        this.estaActivo = true;
    }
    
    public void desactivarme() {
        this.estaActivo = false;
    }
    
    
    // Obtenedores y Modificadores
    public boolean getEstaActivo() {
        return this.estaActivo;
    }
    
}
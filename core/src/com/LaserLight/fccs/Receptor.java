package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public class Receptor extends ObjetoActivable {
    
    // Constructor
    public Receptor(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
    }
    
    
    // Métodos implementados
    @Override
    public void recibirRayoDeLuz(RayoDeLuz rayoDeLuz) {
        
        // Este tipo de objeto no detiene el avance del rayo de luz sino que la deja pasar a través de sí mismo.
        
        // Agregar mi posición a la trayectoria del rayo de luz
        rayoDeLuz.agregarPosicionATrayectoria(this.getPosicion());
        
        // Activarme
        this.activarme();
    }
    
    @Override
    public void activarme() {
        this.estaActivo = true;
        this.getEscenario().contarReceptoresActivados();
    }
    
}
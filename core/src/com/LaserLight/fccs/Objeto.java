package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public abstract class Objeto {

	// Relaciones
        private Escenario escenario;
	private Posicion posicion;


	// Constructor
	public Objeto(Escenario escenario, Posicion posicion) {
            this.escenario = escenario;
            this.posicion = posicion;
	}


	// Métodos a implementar
	public abstract void recibirRayoDeLuz(RayoDeLuz rayoDeLuz);
        
        
        // Obtenedores y modificadores
        public Escenario getEscenario() {
            return this.escenario;
        }
        
        public Posicion getPosicion() {
            return this.posicion;
        }

}
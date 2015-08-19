package com.LaserLight.fccs;

import java.util.ArrayList;

/**
 *
 * @author suarezch
 */
public class RayoDeLuz {

	// Atributos
	private int x;
	private int y;
	private int direccion;
	private boolean avanzando;
	// Relaciones
	private Escenario escenario;
	private ArrayList<Posicion> trayectoria;


	// Constructor
	public RayoDeLuz(Escenario escenario, CreadorDeLuz creadorDeLuz, int direccion) {

            this.x = creadorDeLuz.getPosicion().getX();
            this.y = creadorDeLuz.getPosicion().getY();
            this.direccion = direccion;
            this.avanzando = true;

            this.escenario = escenario;
            this.trayectoria = new ArrayList<Posicion>();
            this.trayectoria.add(creadorDeLuz.getPosicion());

            dirigirse();
	}


	// Métodos
	private void dirigirse() {

            Objeto objetoEncontrado = null;

            do {
                    moverseUnaUnidad();

                    // Averiguar si en la nueva posición existe algún objeto
                    objetoEncontrado = this.escenario.getObjetoEnPosicion(x, y);

                    if (objetoEncontrado != null) { // Si hay objeto...
                            objetoEncontrado.recibirRayoDeLuz(this); // Este método cambia las propiedades actuales de la luz dependiendo del tipo y direccion del objeto encontrado
                    }

            } while (avanzando);
	}

	private void moverseUnaUnidad() {
            // Moverse a la siguiente unidad
            switch (this.direccion) {
                case 0: // Moverse hacia arriba una unidad
                    y++;
                    break;
                case 45: // Moverse hacia arriba y la derecha una unidad
                    y++;
                    x++;
                    break;
                case 90: // Moverse hacia la derecha una unidad
                    x++;
                    break;
                case 135: // Moverse hacia la derecha y abajo una unidad
                    x++;
                    y--;
                    break;
                case 180: // Moverse hacia abajo una unidad
                    y--;
                    break;
                case 225: // Moverse hacia abajo y la izquierda una unidad
                    y--;
                    x--;
                    break;
                case 270: // Moverse hacia la izquierda una unidad
                    x--;
                    break;
                case 315: // Moverse hacia la izquierda y arriba una unidad
                    x--;
                    y++;
                    break;
                default:
                    new Exception("Dirección no soportada");
            }
	}
        
        public void desviarDireccion(int anguloDeDesvio) {
            
        }
        
        public void agregarPosicionATrayectoria(Posicion posicion) {
            this.trayectoria.add(posicion);
        }
        
        public void detenerAvance() {
            this.avanzando = false;
        }


	// Obtenedores y Modificadores
        public int getDireccion() {
            return this.direccion;
        }
        
        

}

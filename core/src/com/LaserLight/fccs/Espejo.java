package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public class Espejo extends ObjetoGiratorio {
    
    // Constructor
    public Espejo(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        /***
         * La dirección inicial de 0° establecida en el constructor del padre ObjetoGiratorio
         * es el que permite recibir un rayo de luz en la dirección de 0°, o sea, para el
         * caso del espejo sería en la posición '/'.
         ***/
    }
    
    
    // Métodos
    @Override
    public void recibirRayoDeLuz(RayoDeLuz rayoDeLuz) {
        int direccionLuz = rayoDeLuz.getDireccion();
        int miDireccion = this.direccion;
        int anguloRelativo;
        
        /***
         * Mediante la siguiente diferencia se puede trabajar ángulos relativos, 
         * lo cual disminuye el análisis de casos de impacto de 64 a 8.
         ***/
        anguloRelativo = direccionLuz - miDireccion;        
        if (anguloRelativo > 360) {
            anguloRelativo-=360;
        } else if (anguloRelativo < 0) {
            anguloRelativo+=360;
        }
        
        // Casos de impacto
        switch (anguloRelativo) {
            case 0: case 180:
                rayoDeLuz.desviarDireccion(90);
                break;
            case 90: case 270:
                rayoDeLuz.desviarDireccion(270);
                break;
            default:
                rayoDeLuz.detenerAvance();
        }

        // Agregar mi posición a la trayectoria del rayo de luz
        rayoDeLuz.agregarPosicionATrayectoria(this.getPosicion());     
    }
    
}
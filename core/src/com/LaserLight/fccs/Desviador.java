package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public class Desviador extends ObjetoGiratorio {
    
    // Constructor
    public Desviador(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        /***
         * La dirección inicial de 0° establecida en el constructor del padre
         * ObjetoGiratorio es el que permite recibir un rayo de luz en la
         * dirección de 0°, o sea, para el caso del desviador sería en la
         * posición que recibe la luz así '|' y la desvía así '/'.
         ***/
    }
    
    
    // Métodos
    @Override
    public void recibirRayoDeLuz(RayoDeLuz rayoDeLuz) {
        int direccionLuz = rayoDeLuz.getDireccion();
        int miDireccion = this.direccion;
        int anguloDiferencia;
        
        /***
         * Mediante la siguiente diferencia se puede trabajar ángulos relativos, 
         * lo cual disminuye el análisis de casos de impacto de 64 a 8.
         ***/
        anguloDiferencia = direccionLuz - miDireccion;        
        if (anguloDiferencia > 360) {
            anguloDiferencia-=360;
        } else if (anguloDiferencia < 0) {
            anguloDiferencia+=360;
        }
        
        // Casos de impacto
        switch (anguloDiferencia) {
            case 0: 
                rayoDeLuz.desviarDireccion(45);
                break;
            case 135:
                rayoDeLuz.desviarDireccion(315);
                break;
            default:
                rayoDeLuz.detenerAvance();
        }

        // Agregar mi posición a la trayectoria del rayo de luz
        rayoDeLuz.agregarPosicionATrayectoria(this.getPosicion());     
    }

    
}
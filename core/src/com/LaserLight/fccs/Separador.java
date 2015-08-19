package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public class Separador extends CreadorDeLuz {
    
    // Constructor
    public Separador(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        /***
         * La dirección inicial de 0° establecida en el constructor del padre ObjetoGiratorio
         * es el que permite recibir un rayo de luz en la dirección de 0°, o sea, para el
         * caso del separador sería en la posición 'T'.
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
            case 0:
                // El rayo de luz recibido se desvía a su izquierda
                rayoDeLuz.desviarDireccion(270);
                // El nuevo rayo de luz creado se dirige a su derecha
                this.crearLuz();
                break;
            default:
                rayoDeLuz.detenerAvance();
        }

        // Agregar mi posición a la trayectoria del rayo de luz
        rayoDeLuz.agregarPosicionATrayectoria(this.getPosicion());     
    }
    
    @Override
    protected void crearLuz() {
        int miDireccion = this.direccion;
        int anguloRelativo = 90;
        int direccionLuz;
        
        // Pasar de dirección relativa a absoluta
        direccionLuz = miDireccion + anguloRelativo;
        if (direccionLuz > 360) {
            direccionLuz-=360;
        }
        
        // Instanciar la nueva luz
        this.rayoDeLuz = new RayoDeLuz(this.getEscenario(), this, direccionLuz);        
    }
    
}
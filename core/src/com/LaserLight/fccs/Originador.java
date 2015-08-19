package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public class Originador extends CreadorDeLuz {
    
    // Constructor
    public Originador(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        /***
         * La dirección inicial de 0° establecida en el constructor del padre ObjetoGiratorio
         * es el que dirige al rayo de luz en la dirección de 0°.
         ***/
        
        // Cuando se crea este Originador, éste crea a su vez un rayo de luz
        this.crearLuz();
    }
    
    
    // Métodos
    @Override
    public void recibirRayoDeLuz(RayoDeLuz rayoDeLuz) {
        
        // Detener el avance del rayo de luz
        rayoDeLuz.detenerAvance();

        // Agregar mi posición a la trayectoria del rayo de luz
        rayoDeLuz.agregarPosicionATrayectoria(this.getPosicion());     
    }
    
    @Override
    protected void crearLuz() {
        int miDireccion = this.direccion;
        int anguloRelativo = 0;
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
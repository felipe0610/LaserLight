package com.LaserLight.fccs;

/**
 *
 * @author suarezch
 */
public class Posicion {
    
    // Atributos
    private int x;
    private int y;
    // Relaciones
    private Objeto objeto;
    
    
    // Constructor
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    // Obtenedores y Modificadores
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public Objeto getObjeto() {
        return this.objeto;
    }
    
    public void quitarObjeto() {
        this.objeto = null;
    }
    
    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }    

}

package com.LaserLight.fccs;

import java.util.ArrayList;

/**
 *
 * @author suarezch
 */
public class Escenario {
    
    // Atributos
    private int cantidadDePosicionesEnX;
    private int cantidadDePosicionesEnY;
    // Relaciones
    private ArrayList<Posicion> listaPosicionesConObjetos;
    private ArrayList<Objeto> listaObjetosParaPosicionar;
    
    
    // Constructor
    public Escenario(int cantidadDePosicionesEnX, int cantidadDePosicionesEnY, ArrayList<ArrayList<Object>> listaDistribucion) {
        this.cantidadDePosicionesEnX = cantidadDePosicionesEnX;
        this.cantidadDePosicionesEnY = cantidadDePosicionesEnY;
        this.listaPosicionesConObjetos = new ArrayList<Posicion>();
        this.listaObjetosParaPosicionar = new ArrayList<Objeto>();

        // listaPosicionesConObjetos


        // listaObjetosParaPosicionar

    }
    
    
    // Métodos
    public Posicion crearPosicion(int x, int y) {

        Posicion posicion;

        // Primero comprobar si ya existe una posición con esa coordenada


        return null;
    }

    public Objeto getObjetoEnPosicion(int x, int y) {
        
        for (Posicion posicion: this.listaPosicionesConObjetos) {
            if (posicion.getX() == x && posicion.getY() == y) {
                return posicion.getObjeto();
            }
        }
        
        return null;
    }
    
    public void contarReceptoresActivados() {
        
        int cantidadDeReceptores = 0;
        int cantidadDeReceptoresActivados = 0;
        Objeto objeto;
        Receptor receptor;
        
        // Contar cuántos receptores hay en el escenario y cuántos están activos
        for (Posicion posicion: listaPosicionesConObjetos) {
            objeto = posicion.getObjeto();
            if (objeto instanceof Receptor) {
                receptor = (Receptor)(ObjetoActivable)objeto;
                cantidadDeReceptores++;
                if (receptor.getEstaActivo()) {
                    cantidadDeReceptoresActivados++;
                }
            }
        }
        
        // Si todos los receptores que hay están activos
        escenarioGanado();        
    }

    private void escenarioGanado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

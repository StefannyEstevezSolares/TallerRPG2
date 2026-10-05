
//Creamos una interfaz separada , para poder implementarla acorde a las especificaciones de cada personaje
//nos permite no obligar a personaje que todos los personajes mejoren.
package com.mycompany.tallerrpg2;


public interface Mejorable {
    
    void subirNivel();
    
    default void mostrarMensajeNivel(int nivel){
    
    System.out.println("¡Se subió al nivel: " + nivel + "!");
    
    }
    
}

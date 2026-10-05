//al principio me parecía una exageración crear una interface para una sola acción, pero también
//funciona como un contrato que se puede agregar a las clases que deseemos, para que sea obligatorio para ellos crear el cómo van a ejutar el método de la interfaz.

package com.mycompany.tallerrpg2;

public interface Curable {
    
    double CURACION_BASE = 25.0;
    
    void curar();
    
    
}
